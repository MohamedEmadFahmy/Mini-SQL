package com.halberdski.engine;

/** * @author Wael Abouelsaadat */

import java.util.Iterator;
import java.util.Vector;

import com.halberdski.model.Metadata;
import com.halberdski.model.Table;
import com.halberdski.model.Tuple;
import com.halberdski.resources.utility;
import com.halberdski.exceptions.DBAppException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Hashtable;

public class DBApp {

	public DBApp() {
		init();
	}

	// this does whatever initialization you would like
	// or leave it empty if there is no code you want to
	// execute at application startup
	public void init() {
	}

	// following method creates one table only
	// strClusteringKeyColumn is the name of the column that will be the primary
	// key and the clustering column as well. The data type of that column will
	// be passed in htblColNameType
	// htblColNameValue will have the column name as key and the data
	// type as value
	public void createTable(String strTableName, String strClusteringKeyColumn,
			Hashtable<String, String> htblColNameType) throws DBAppException {
		if (Metadata.tableExists(strTableName)) {
			throw new DBAppException("Table " + strTableName + " already exists!");
		}
		if (!htblColNameType.containsKey(strClusteringKeyColumn)) {
			throw new DBAppException("Hashtable must include primary key!");
		}

		if (strClusteringKeyColumn.trim().length() == 0) {
			throw new DBAppException("You must specify a primary key!");
		}
		if (htblColNameType.isEmpty()) {
			throw new DBAppException("Table columns can not be empty");
		}

		Table myTable = new Table(strTableName, strClusteringKeyColumn, htblColNameType);
		myTable.saveTable();
		Metadata.addTable(strTableName, strClusteringKeyColumn, htblColNameType);
		System.out.println("Created Table: " + strTableName);
	}

	// following method creates a B+tree index
	public void createIndex(String strTableName,
			String strColName,
			String strIndexName) throws DBAppException {

		if (!Metadata.tableExists(strTableName)) {
			throw new DBAppException("Table " + strTableName + " does not exist!");

		}
		if (!Metadata.tableHasColumn(strTableName, strColName)) {
			throw new DBAppException("Column " + strColName + " does not exist in Table " + strTableName);
		}
		if (Metadata.tableHasIndexOnColumn(strTableName, strColName)) {
			throw new DBAppException("Column " + strColName + " in Table " + strTableName + " is already indexed");

		}
		if (Metadata.indexExists(strIndexName)) {
			throw new DBAppException("Index " + strIndexName + " already exists in Database ");
		}

		Metadata.addIndex(strTableName, strColName, strIndexName);

		Table table = Table.loadTable(strTableName);

		table.createIndex(strColName, strIndexName);

		System.out
				.println("Index (" + strIndexName + ") created on Table (" + strTableName + ") on Column (" + strColName
						+ ")");
	}

	// following method inserts one row only.
	// htblColNameValue must include a value for the primary key
	// DONE
	public void insertIntoTable(String strTableName,
			Hashtable<String, Object> htblColNameValue) throws DBAppException {

		if (!Metadata.tableExists(strTableName)) {
			throw new DBAppException("Table " + strTableName + " does not exist!");
		}
		if (!Metadata.validInsert(strTableName, htblColNameValue)) {
			throw new DBAppException("Not the correct format for insert!");
		}

		Table table = Table.loadTable(strTableName);
		table.insert(htblColNameValue);
	}

	// following method updates one row only
	// htblColNameValue holds the key and new value
	// htblColNameValue will not include clustering key as column name
	// strClusteringKeyValue is the value to look for to find the row to update.
	// DONE
	public void updateTable(String strTableName,
			String strClusteringKeyValue,
			Hashtable<String, Object> htblColNameValue) throws DBAppException {

		if (!Metadata.tableExists(strTableName)) {
			throw new DBAppException("Table " + strTableName + " does not exist!");
		}
		if (htblColNameValue.containsKey(Metadata.getPrimaryKeyName(strTableName))) {
			throw new DBAppException("Primary key cannot be updated");
		}

		// Check if primary key value violates metadata
		String primaryKeyName = Metadata.getPrimaryKeyName(strTableName);
		String primaryKeyType = Metadata.getColumnType(strTableName, primaryKeyName);

		Object primaryKeyValue = null;

		switch (primaryKeyType) {
			case "java.lang.Integer":
				try {
					primaryKeyValue = Integer.parseInt(strClusteringKeyValue);
				} catch (NumberFormatException e) {
					throw new DBAppException("Primary key value must be an integer");
				}
				break;
			case "java.lang.Double":
				try {
					primaryKeyValue = Double.parseDouble(strClusteringKeyValue);
				} catch (NumberFormatException e) {
					throw new DBAppException("Primary key value must be a double");
				}
				break;
			case "java.lang.String":
				if (strClusteringKeyValue.trim().length() == 0) {
					throw new DBAppException("Primary key value must be a non-empty string");
				}
				primaryKeyValue = strClusteringKeyValue;
				break;

			default:
				throw new DBAppException("Primary key value must be an integer, double, or string");
		}

		if (!Metadata.validColumnNamesAndTypes(strTableName, htblColNameValue)) {
			throw new DBAppException("Invalid column names or types!");
		}

		Table table = Table.loadTable(strTableName);

		table.updateTuple(primaryKeyValue, htblColNameValue);
	}

	// following method could be used to delete one or more rows.
	// htblColNameValue holds the key and value. This will be used in search
	// to identify which rows/tuples to delete.
	// htblColNameValue enteries are ANDED together
	// DONE
	public void deleteFromTable(String strTableName,
			Hashtable<String, Object> htblColNameValue) throws DBAppException {
		// System.out.println("test1");
		if (!Metadata.tableExists(strTableName)) {
			throw new DBAppException("Table " + strTableName + " does not exist!");
		}

		if (!Metadata.validColumnNamesAndTypes(strTableName, htblColNameValue)) {
			throw new DBAppException("Invalid column names or types!");
		}

		Table table = Table.loadTable(strTableName);
		// System.out.println("test2");
		table.delete(strTableName, htblColNameValue);
	}

	// DONE
	@SuppressWarnings("rawtypes")
	public Iterator selectFromTable(SQLTerm[] arrSQLTerms,
			String[] strarrOperators) throws DBAppException {

		if (arrSQLTerms == null || strarrOperators == null) {
			throw new DBAppException("Error: Null SQL Terms array or Operators array");

		}
		// can only select from one table at a time if (arrSQLTerms.length == 0) {
		if (arrSQLTerms.length == 0) {
			throw new DBAppException("Error: No Sql Terms detected");
		}

		String tableName = arrSQLTerms[0]._strTableName;

		for (SQLTerm sqlTerm : arrSQLTerms) {
			if (!sqlTerm._strTableName.equals(tableName)) {
				throw new DBAppException("Error: Can only select from one table at a time");
			}
		}

		if (!Metadata.tableExists(tableName)) {
			throw new DBAppException("Table " + tableName + " does not exist!");
		}
		if (arrSQLTerms.length != strarrOperators.length + 1) {
			throw new DBAppException("Invalid number of operators/Sql Terms");
		}

		String[] operators = { "=", "!=", "<", "<=", ">", ">=" };

		// Convert the array to a Vector
		Vector<String> validOperators = new Vector<>(Arrays.asList(operators));

		for (SQLTerm sqlTerm : arrSQLTerms) {
			Hashtable<String, Object> htblColNameValue = new Hashtable<String, Object>();
			htblColNameValue.put(sqlTerm._strColumnName, sqlTerm._objValue);
			if (!Metadata.validColumnNamesAndTypes(tableName, htblColNameValue)) {
				throw new DBAppException("Invalid column name or type!");
			}
			if (!validOperators.contains(sqlTerm._strOperator)) {
				throw new DBAppException("Invalid operator: " + sqlTerm._strOperator);
			}
		}
		// System.out.println(htblColNameValue);
		// System.out.println(Metadata.validColumnNamesAndTypes(tableName,
		// htblColNameValue));

		Table table = Table.loadTable(tableName);
		return table.selectTuple(arrSQLTerms, strarrOperators);
	}

	public static void printTable(String strTableName) {
		if (!Metadata.tableExists(strTableName)) {
			System.out.println("Table " + strTableName + " does not exist!");
			return;
		}
		Table myTable = Table.loadTable(strTableName);
		System.out.println(myTable);
	}

	public static void logTable(String strTableName) {
		if (!Metadata.tableExists(strTableName)) {
			System.out.println("Table " + strTableName + " does not exist!");
			return;
		}

		Table myTable = Table.loadTable(strTableName);
		String tableString = myTable.toString();

		try (FileWriter writer = new FileWriter("output.txt")) {
			writer.write(tableString);
			System.out.println("Table " + strTableName + " logged successfully to output.txt");
		} catch (IOException e) {
			System.err.println("Error writing to output.txt: " + e.getMessage());
		}
	}

	@SuppressWarnings("rawtypes")
	protected void bulkInsertIntoTable(String tableName, int startNum, int endNum) throws DBAppException {
		Vector<Integer> nums = new Vector<>();
		for (int i = startNum; i <= endNum; i++) {
			nums.add(i);

		}
		Collections.shuffle(nums);

		System.out.println(nums);

		for (int i : nums) {
			Hashtable<String, Object> htblColNameValue = new Hashtable<>();
			htblColNameValue.put("id", i);
			htblColNameValue.put("name", "Moski no " + i);
			htblColNameValue.put("gpa", 3.5);
			// System.out.println("Before inserting" + htblColNameValue);
			this.insertIntoTable(tableName, htblColNameValue);
		}
		printTable(tableName);
		Iterator iterator = this.selectFromTable(
				new SQLTerm[] { new SQLTerm(tableName, "id", ">", 0) },
				new String[] {});

		while (iterator.hasNext()) {
			Tuple currentTuple = (Tuple) iterator.next();
			nums.remove(currentTuple.getPrimaryKey());
		}

		if (nums.isEmpty()) {
			System.out.println("All numbers inserted");
		} else {
			System.out.println("These numbers not inserted");
			System.out.println(nums);
		}
	}

	public static void main(String[] args) {

		try {
			DBApp dbApp = new DBApp();

			utility.clearDatabaseSystem();

			String strTableName = "Student";
			Hashtable<String, String> htblColNameType = new Hashtable<String, String>();
			htblColNameType.put("id", "java.lang.Integer");
			htblColNameType.put("name", "java.lang.String");
			htblColNameType.put("gpa", "java.lang.Double");
			dbApp.createTable(strTableName, "id", htblColNameType);

			String strTableName2 = "Student2";
			Hashtable<String, String> htblColNameType2 = new Hashtable<String, String>();
			htblColNameType2.put("id", "java.lang.Integer");
			htblColNameType2.put("name", "java.lang.String");
			htblColNameType2.put("gpa", "java.lang.Double");
			dbApp.createTable(strTableName2, "id", htblColNameType2);

			System.out.println(Metadata.getAllTables());

			// dbApp.createIndex("Student2", "id", "index2");

			// String strTableName = "Employee";
			// Hashtable<String, String> htblColNameType = new Hashtable<>();
			// dbApp.createTable(strTableName, "id", htblColNameType);

			// String strTableName = "Student";
			// Hashtable<String, String> htblColNameType = new Hashtable<String, String>();
			// htblColNameType.put("id", "java.lang.Integer");
			// htblColNameType.put("name", "java.lang.String");
			// htblColNameType.put("gpa", "java.lang.Double");
			// dbApp.createTable(strTableName, "id", htblColNameType);

			// ---------------------Employee Table--------------------------
			// String strTableName = "Employee";
			// Hashtable<String, String> htblColNameType = new Hashtable<>();
			// htblColNameType.put("id", "java.lang.Integer");
			// htblColNameType.put("name", "java.lang.String");
			// htblColNameType.put("gpa", "java.lang.Double");
			// dbApp.createTable(strTableName, "id", htblColNameType);
			// -------------------------------------------------------------

			// printTable("Employee");
			// printTable("o");

			// String strTableName = "allNumsTable";
			// Hashtable<String, String> htblColNameType = new Hashtable<String, String>();
			// htblColNameType.put("id", "java.lang.Integer");
			// htblColNameType.put("age", "java.lang.Integer");
			// htblColNameType.put("height", "java.lang.Integer");
			// dbApp.createTable(strTableName, "id", htblColNameType);

			// Hashtable<String, Object> htblColNameValue = new Hashtable<String, Object>();
			// htblColNameValue.put("id", 1.5);
			// htblColNameValue.put("id", 20);
			// htblColNameValue.put("id", 180);
			// dbApp.insertIntoTable("allNumsTable", htblColNameValue);
			// ------------------------SELECT TESTING-------------------------//

			// dbApp.createIndex("Student", "id", "index");
			// for (int i = 1; i <= 20; i++) {
			// Hashtable<String, Object> htblColNameValue = new Hashtable<>();
			// htblColNameValue.put("id", i);
			// htblColNameValue.put("name", "Moski no " + i);
			// htblColNameValue.put("gpa", 3.5);
			// dbApp.insertIntoTable("Student", htblColNameValue);
			// }
			// dbApp.printTable("Student");
			// SQLTerm[] sqlArray = {
			// new SQLTerm("Student", "id", "=", 2),
			// new SQLTerm("Student", "id", "=", 15) };
			// String[] ops = { "AND" };
			// SQLTerm[] sqlArray2 = {};

			// Iterator iterator = dbApp.selectFromTable(sqlArray, ops);

			// // <= 7 1,2,3,4,5,6,7
			// // <= 5 1,2,3,4,5

			// while (iterator.hasNext()) {
			// System.out.println(iterator.next());
			// }

			// ----------------- Delete Table Testing ---------------------\\

			// for (int i = 1; i <= 20; i++) {
			// Hashtable<String, Object> htblColNameValue = new Hashtable<>();
			// htblColNameValue.put("id", i);
			// htblColNameValue.put("name", "Moski no " + i);
			// if (i > 6) {
			// htblColNameValue.put("gpa", 3.5);
			// } else {
			// htblColNameValue.put("gpa", 2.5);
			// }
			// dbApp.insertIntoTable("Student", htblColNameValue);
			// }
			// dbApp.createIndex("Student", "gpa", "index");
			// Hashtable<String, Object> htblTuplesToDelete = new Hashtable<>();
			// // htblTuplesToDelete.put("id", 6);
			// // htblTuplesToDelete.put("name", "Moski no " + "6");
			// htblTuplesToDelete.put("gpa", 3.5);
			// dbApp.printTable("Student");
			// dbApp.deleteFromTable("Student", htblTuplesToDelete);
			// dbApp.printTable("Student");

			// ----------------- Update Table Testing ---------------------\\

			// for (int i = 1; i <= 20; i++) {
			// Hashtable<String, Object> htblColNameValue = new Hashtable<>();
			// htblColNameValue.put("id", i);
			// htblColNameValue.put("name", "Moski no " + i);
			// if (i > 6) {
			// htblColNameValue.put("gpa", 3.5);
			// } else {
			// htblColNameValue.put("gpa", 2.5);
			// }
			// dbApp.insertIntoTable("Student", htblColNameValue);
			// }
			// dbApp.createIndex("Student", "gpa", "index");
			// Hashtable<String, Object> htblUpdatedTuple = new Hashtable<>();
			// // htblUpdatedTuple.put("id", 7);
			// htblUpdatedTuple.put("gpa", 6.0);
			// htblUpdatedTuple.put("name", "Updated");
			// dbApp.updateTable("Student", "6", htblUpdatedTuple);
			// dbApp.printTable("Student");

			// ----------------- Insert Table Testing ---------------------\\

			// for (int i = 1; i <= 20; i++) {
			// Hashtable<String, Object> htblColNameValue = new Hashtable<>();
			// htblColNameValue.put("id", i);
			// htblColNameValue.put("name", "Moski no " + i);
			// if (i > 6) {
			// htblColNameValue.put("gpa", 3.5);
			// } else {
			// htblColNameValue.put("gpa", 2.5);
			// }
			// if (i != 7) {
			// dbApp.insertIntoTable("Student", htblColNameValue);
			// }
			// }
			// dbApp.createIndex("Student", "gpa", "index");
			// Hashtable<String, Object> htblTupleToInsert = new Hashtable<>();
			// htblTupleToInsert.put("id", 7);
			// htblTupleToInsert.put("gpa", 6.0);
			// htblTupleToInsert.put("name", "Abso");
			// dbApp.insertIntoTable("Student", htblTupleToInsert);
			// dbApp.printTable("Student");
			// System.out.println("valid insert: " + Metadata.validInsert("Student",
			// htblTupleToInsert));
			// System.out.println("valid ColNameType: " +
			// Metadata.validColumnNamesAndTypes("Student", htblTupleToInsert));

		} catch (Exception exp) {
			exp.printStackTrace();
		}
	}
}