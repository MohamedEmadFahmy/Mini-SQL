package engine;

/** * @author Wael Abouelsaadat */

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import model.Table;
import exceptions.DBAppException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashSet;
import java.util.Hashtable;

public class DBApp {
	static Set<String> tableNames;

	public DBApp() {
		tableNames = new HashSet<String>();
		init();
	}

	// this does whatever initialization you would like
	// or leave it empty if there is no code you want to
	// execute at application startup
	public void init() {

		updateMetaDataFile();

		// deleteMetaDataFile();
		// System.out.println(tableNames);
	}

	public static void updateMetaDataFile() {
		tableNames = new HashSet<String>();
		String filePath = "metadata.csv";
		File file = new File(filePath);

		if (file.exists()) {
			// Read all table names in metadata file
			try {
				// Read all lines from the file
				List<String> lines = Files.readAllLines(file.toPath());

				// Process each line
				for (String line : lines) {
					// Do something with each line
					String[] splittedLine = line.split(",");
					// System.out.println(splittedLine[0]);
					tableNames.add(splittedLine[0]);
				}
			} catch (IOException e) {
				System.err.println("Error reading file: " + e.getMessage());
			}
		} else {
			System.out.println("File does not exist.");
		}
	}

	// following method creates one table only
	// strClusteringKeyColumn is the name of the column that will be the primary
	// key and the clustering column as well. The data type of that column will
	// be passed in htblColNameType
	// htblColNameValue will have the column name as key and the data
	// type as value
	public void createTable(String strTableName, String strClusteringKeyColumn,
			Hashtable<String, String> htblColNameType) throws DBAppException {
		if (tableNames.contains(strTableName)) {
			throw new DBAppException("Table " + strTableName + " already exists!");
		} else {
			@SuppressWarnings("unused")
			Table myTable = new Table(strTableName, strClusteringKeyColumn, htblColNameType);
			Table.addTable(strTableName, strClusteringKeyColumn, htblColNameType);
		}

		// throw new DBAppException("not implemented yet");
	}

	// following method creates a B+tree index
	public void createIndex(String strTableName,
			String strColName,
			String strIndexName) throws DBAppException {

		// Update metadata file
		String filePath = "metadata.csv";
		File file = new File(filePath);

		// Read all lines in the file and modify them
		try {
			// Read all lines from the file
			List<String> lines = Files.readAllLines(file.toPath());

			// Process each line
			for (int i = 0; i < lines.size(); i++) {
				String line = lines.get(i);
				String[] splittedLine = line.split(",");

				// Check if the line corresponds to the given table and column
				if (splittedLine[0].equals(strTableName) && splittedLine[1].equals(strColName)) {
					String columnDataType = splittedLine[2];
					String isPrimaryKey = splittedLine[3];

					// Modify the line with the new index information
					lines.set(i, strTableName + "," + strColName + "," + columnDataType + "," + isPrimaryKey
							+ strIndexName + ",B+tree");
					break; // No need to continue looping
				}
			}

			// Write the modified lines back to the file
			Files.write(file.toPath(), lines);
		} catch (IOException e) {
			// System.err.println("Error reading/writing file: " + e.getMessage());
			throw new DBAppException("Error reading/writing file: " + e.getMessage());
		}

		Table table = Table.loadTable(strTableName);

		table.createIndex(strColName, strIndexName);
	}

	// following method inserts one row only.
	// htblColNameValue must include a value for the primary key
	public void insertIntoTable(String strTableName,
			Hashtable<String, Object> htblColNameValue) throws DBAppException {

		throw new DBAppException("not implemented yet");
	}

	// following method updates one row only
	// htblColNameValue holds the key and new value
	// htblColNameValue will not include clustering key as column name
	// strClusteringKeyValue is the value to look for to find the row to update.
	public void updateTable(String strTableName,
			String strClusteringKeyValue,
			Hashtable<String, Object> htblColNameValue) throws DBAppException {

		throw new DBAppException("not implemented yet");
	}

	// following method could be used to delete one or more rows.
	// htblColNameValue holds the key and value. This will be used in search
	// to identify which rows/tuples to delete.
	// htblColNameValue enteries are ANDED together
	public void deleteFromTable(String strTableName,
			Hashtable<String, Object> htblColNameValue) throws DBAppException {

		throw new DBAppException("not implemented yet");
	}

	@SuppressWarnings("rawtypes")
	public Iterator selectFromTable(SQLTerm[] arrSQLTerms,
			String[] strarrOperators) throws DBAppException, ClassNotFoundException, IOException {
		String tableName = arrSQLTerms[0]._strTableName;// can only select from one table at a time
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