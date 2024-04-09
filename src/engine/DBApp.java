package engine;

/** * @author Wael Abouelsaadat */

import java.util.Iterator;
import java.util.Vector;

import model.Metadata;
import model.Table;
import exceptions.DBAppException;

import java.io.IOException;
import java.util.Arrays;
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

		Table myTable = new Table(strTableName, strClusteringKeyColumn, htblColNameType);
		myTable.saveTable();
		Metadata.addTable(strTableName, strClusteringKeyColumn, htblColNameType);
	}

	// following method creates a B+tree index
	public void createIndex(String strTableName,
			String strColName,
			String strIndexName) throws DBAppException {

		if (!Metadata.tableExists(strTableName)) {
			throw new DBAppException("Table " + strTableName + " does not exist!");

		}
		if (!Metadata.tableHasColumn(strTableName, strColName)) {
			throw new DBAppException("Column " + strColName + " does not exist in table " + strTableName);
		}
		if (!Metadata.tableHasIndexOnColumn(strTableName, strColName)) {
			throw new DBAppException("Column " + strColName + " is already indexed in table " + strTableName);

		}
		if (!Metadata.indexExists(strIndexName)) {
			throw new DBAppException("Index " + strIndexName + " already exists in Database ");
		}

		Metadata.addIndex(strTableName, strColName, strIndexName);

		Table table = Table.loadTable(strTableName);

		table.createIndex(strColName, strIndexName);
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
			throw new DBAppException("Incompatible data types for values");
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
		if (htblColNameValue.contains(Metadata.getPrimaryKeyName(strTableName))) {
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

		if (!Metadata.compatibleTypes(strTableName, htblColNameValue)) {
			throw new DBAppException("Incompatible data types for values");
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
		if (!Metadata.tableExists(strTableName)) {
			throw new DBAppException("Table " + strTableName + " does not exist!");
		}

		if (!Metadata.compatibleTypes(strTableName, htblColNameValue)) {
			throw new DBAppException("Incompatible data types for values");
		}

		Table table = Table.loadTable(strTableName);
		table.delete(strTableName, htblColNameValue);
	}

	// DONE
	@SuppressWarnings("rawtypes")
	public Iterator selectFromTable(SQLTerm[] arrSQLTerms,
			String[] strarrOperators) throws DBAppException, ClassNotFoundException, IOException {
		// can only select from one table at a time
		String tableName = arrSQLTerms[0]._strTableName;

		if (!Metadata.tableExists(tableName)) {
			throw new DBAppException("Table " + tableName + " does not exist!");

		}

		Hashtable<String, Object> htblColNameValue = new Hashtable<String, Object>();
		String[] operators = { "=", "!=", "<", "<=", ">", ">=" };

		// Convert the array to a Vector
		Vector<String> validOperators = new Vector<>(Arrays.asList(operators));

		for (SQLTerm sqlTerm : arrSQLTerms) {
			htblColNameValue.put(sqlTerm._strColumnName, sqlTerm._objValue);
			if (!validOperators.contains(sqlTerm._strOperator)) {
				throw new DBAppException("Invalid operator: " + sqlTerm._strOperator);
			}
		}

		if (!Metadata.compatibleTypes(tableName, htblColNameValue)) {
			throw new DBAppException("Incompatible data types for values");
		}

		Table table = Table.loadTable(tableName);
		Iterator iterator = table.selectTuple(arrSQLTerms, strarrOperators);
		return iterator;
	}

	public static void main(String[] args) {

		try {
			DBApp dbApp = new DBApp();

			// ---------------------Employee Table--------------------------
			// String strTableName = "Employee";
			// Hashtable htblColNameType = new Hashtable();
			// htblColNameType.put("id", "java.lang.Integer");
			// htblColNameType.put("name", "java.lang.String");
			// htblColNameType.put("gpa", "java.lang.double");
			// dbApp.createTable(strTableName, "id", htblColNameType);
			// -------------------------------------------------------------

			// ---------------------Student Table--------------------------
			// String strTableName = "Student";
			// Hashtable htblColNameType = new Hashtable();
			// htblColNameType.put("id", "java.lang.Integer");
			// htblColNameType.put("name", "java.lang.String");
			// htblColNameType.put("gpa", "java.lang.double");
			// dbApp.createTable(strTableName, "id", htblColNameType);
			// ------------------------------------------------------------

			// dbApp.createIndex(strTableName, "gpa", "gpaIndex");

			// Hashtable htblColNameValue = new Hashtable();
			// htblColNameValue.put("id", new Integer(2343432));
			// htblColNameValue.put("name", new String("Ahmed Noor"));
			// htblColNameValue.put("gpa", new Double(0.95));
			// dbApp.insertIntoTable(strTableName, htblColNameValue);

			// htblColNameValue.clear();
			// htblColNameValue.put("id", new Integer(453455));
			// htblColNameValue.put("name", new String("Ahmed Noor"));
			// htblColNameValue.put("gpa", new Double(0.95));
			// dbApp.insertIntoTable(strTableName, htblColNameValue);

			// htblColNameValue.clear();
			// htblColNameValue.put("id", new Integer(5674567));
			// htblColNameValue.put("name", new String("Dalia Noor"));
			// htblColNameValue.put("gpa", new Double(1.25));
			// dbApp.insertIntoTable(strTableName, htblColNameValue);

			// htblColNameValue.clear();
			// htblColNameValue.put("id", new Integer(23498));
			// htblColNameValue.put("name", new String("John Noor"));
			// htblColNameValue.put("gpa", new Double(1.5));
			// dbApp.insertIntoTable(strTableName, htblColNameValue);

			// htblColNameValue.clear();
			// htblColNameValue.put("id", new Integer(78452));
			// htblColNameValue.put("name", new String("Zaky Noor"));
			// htblColNameValue.put("gpa", new Double(0.88));
			// dbApp.insertIntoTable(strTableName, htblColNameValue);

			// SQLTerm[] arrSQLTerms;
			// arrSQLTerms = new SQLTerm[2];
			// arrSQLTerms[0]._strTableName = "Student";
			// arrSQLTerms[0]._strColumnName = "name";
			// arrSQLTerms[0]._strOperator = "=";
			// arrSQLTerms[0]._objValue = "John Noor";

			// arrSQLTerms[1]._strTableName = "Student";
			// arrSQLTerms[1]._strColumnName = "gpa";
			// arrSQLTerms[1]._strOperator = "=";
			// arrSQLTerms[1]._objValue = new Double(1.5);

			// String[] strarrOperators = new String[1];
			// strarrOperators[0] = "OR";
			// // select * from Student where name = "John Noor" or gpa = 1.5;
			// Iterator resultSet = dbApp.selectFromTable(arrSQLTerms, strarrOperators);

			// MOSKI SHIT
			// String strTableName = "Employee";
			// Hashtable<String, String> htblColNameType = new Hashtable<String, String>();
			// htblColNameType.put("id", "java.lang.Integer");
			// htblColNameType.put("name", "java.lang.String");
			// htblColNameType.put("gpa", "java.lang.double");

			// Table table = new Table(strTableName, "id", htblColNameType);

			// System.out.println(table);
			// System.out.println(table.getStrTableName());

			// table.serializeTable();

			// System.out.println("---------------");

			// Table deserialized = Table.loadTable("Employee");
			// System.out.println(deserialized);
			// System.out.println(deserialized.getStrTableName());

			String strTableName = "Student";
			Hashtable<String, String> htblColNameType = new Hashtable<String, String>();
			htblColNameType.put("id", "java.lang.Integer");
			htblColNameType.put("name", "java.lang.String");
			htblColNameType.put("gpa", "java.lang.double");
			dbApp.createTable(strTableName, "id", htblColNameType);

			// for (int i = 1; i <= 10; i++) {
			// Hashtable<String, Object> htblColNameValue = new Hashtable<>();
			// htblColNameValue.put("id", i);
			// htblColNameValue.put("name", "Moski no " + i);
			// htblColNameValue.put("gpa", 3.5);
			// dbApp.insertIntoTable(strTableName, htblColNameValue);
			// }
			// System.out.println(myTable);

		} catch (Exception exp) {
			exp.printStackTrace();
		}
	}

}