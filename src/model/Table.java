package model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Vector;

import javax.swing.text.html.HTMLDocument.Iterator;

import engine.DBApp;
import engine.SQLTerm;
import exceptions.DBAppException;

public class Table {
    String strTableName;
    String strClusteringKeyColumn;
    Hashtable<String, String> htblColNameType;
    List<String> indexedColumns;
    Vector<Page> pages;

    public Table(String strTableName, String strClusteringKeyColumn, Hashtable<String, String> htblColNameType) {
        this.strTableName = strTableName;
        this.strClusteringKeyColumn = strClusteringKeyColumn;
        this.htblColNameType = htblColNameType;
        this.indexedColumns = new ArrayList<String>();
        this.pages = new Vector<Page>();
    }

    public static void addTable(String strTableName, String strClusteringKeyColumn,
            Hashtable<String, String> htblColNameType) {

        addMetaData(strTableName, strClusteringKeyColumn, htblColNameType);

        // Update table names arraylist with table names from metadata file
        DBApp.updateMetaDataFile();
    }

    private static void addMetaData(String strTableName, String strClusteringKeyColumn,
            Hashtable<String, String> htblColNameType) {
        StringBuilder contentBuilder = new StringBuilder();

        htblColNameType.forEach((key, value) -> {
            String tableName = strTableName;
            String colName = key;
            String colDataType = value;
            String isClusteringKey = key.equals(strClusteringKeyColumn) ? "True" : "False";
            String indexName = "null";
            String indexType = "null";

            // System.out.println(String.format("%s,%s,%s,%s,%s,%s\n", tableName, colName,
            // colDataType, isClusteringKey,
            // indexName, indexType));

            contentBuilder.append(String.format("%s,%s,%s,%s,%s,%s\n", tableName, colName, colDataType, isClusteringKey,
                    indexName, indexType));
        });

        writeFile("metadata.txt", contentBuilder.toString());
    }

    public static void writeFile(String filePath, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(content);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    public void insertTuple(String strTableName, Hashtable<String, Object> htblColNameValue)
            throws DBAppException {

    }

    public void deleteTuple(String strTableName, Hashtable<String, Object> htblColNameValue)
            throws DBAppException {

    }

    public Iterator selectTuple(SQLTerm[] arrSQLTerms, String[] strarrOperators)
            throws DBAppException {
        return null;
    }

    public void updateTuple(String strTableName, String strClusteringKeyValue,
            Hashtable<String, Object> htblColNameValue) throws DBAppException {

    }

    public void createIndex(String strTableName,
            String strColName,
            String strIndexName) throws DBAppException {

    }

    public void addPage(String strTableName, Hashtable<String, Object> htblColNameValue) throws DBAppException {

    }

    public String toString() {
        return "";
    }

    // public static void readFile(String filePath) {
    // try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
    // String line;
    // while ((line = reader.readLine()) != null) {
    // System.out.println(line);
    // }
    // } catch (IOException e) {
    // System.err.println("Error reading file: " + e.getMessage());
    // }
    // }

    // @SuppressWarnings({ "rawtypes", "unchecked" })
    // public static void main(String[] args) {
    // // String strTableName = "Student";
    // // Hashtable htblColNameType = new Hashtable();
    // // htblColNameType.put("id", "java.lang.Integer");
    // // htblColNameType.put("name", "java.lang.String");
    // // htblColNameType.put("gpa", "java.lang.double");
    // // Table myTable = new Table(strTableName, "id", htblColNameType);
    // }
}
