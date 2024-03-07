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
    String primaryKeyName;
    Hashtable<String, String> htblColNameType;
    List<String> indexedColumns;
    Vector<Page> pagesList;

    public Table(String strTableName, String primaryKeyName, Hashtable<String, String> htblColNameType) {
        this.strTableName = strTableName;
        this.primaryKeyName = primaryKeyName;
        this.htblColNameType = htblColNameType;
        this.indexedColumns = new ArrayList<String>();
        this.pagesList = new Vector<Page>();
    }

    public static void addTable(String strTableName, String primaryKeyName,
            Hashtable<String, String> htblColNameType) {

        addMetaData(strTableName, primaryKeyName, htblColNameType);

        // Update table names arraylist with table names from metadata file
        DBApp.updateMetaDataFile();
    }

    private static void addMetaData(String strTableName, String primaryKeyName,
            Hashtable<String, String> htblColNameType) {
        StringBuilder contentBuilder = new StringBuilder();

        htblColNameType.forEach((key, value) -> {
            String tableName = strTableName;
            String colName = key;
            String colDataType = value;
            String isClusteringKey = key.equals(primaryKeyName) ? "True" : "False";
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

    public void insertTuple(Hashtable<String, Object> htblColNameValue)
            throws DBAppException {
        Tuple tuple = new Tuple(htblColNameValue, primaryKeyName);
        Object primaryKey = tuple.getPrimaryKey();
        if (pagesList.isEmpty()) {
            Page page = new Page(htblColNameType, primaryKeyName);
            page.addTuple(tuple);
            pagesList.add(page);
        } else {
            Tuple OverflowTuple = null;
            for (int i = 0; i < pagesList.size(); i++) {
                Page currentPage = pagesList.elementAt(i);
                if (tuple.compareTo(currentPage.getMin()) == -1) {
                    OverflowTuple = currentPage.addTuple(tuple);
                } else if ((tuple.compareTo(currentPage.getMin()) == 1) && (tuple
                        .compareTo(currentPage.getMax()) == -1)) {
                    OverflowTuple = currentPage.addTuple(tuple);
                } else if (tuple.compareTo(currentPage.getMax()) == 1) {
                    Page nextPage = pagesList.elementAt(i + 1); // out of bounds
                    if (nextPage == null) {
                        OverflowTuple = currentPage.addTuple(tuple);
                    } else if ((tuple.compareTo(nextPage.getMin()) == 1)
                            && (tuple.compareTo(currentPage.getMax()) == -1)) {
                        OverflowTuple = nextPage.addTuple(tuple);
                    } else if (tuple.compareTo(nextPage.getMin()) == -1) {
                        OverflowTuple = currentPage.addTuple(tuple);
                    }
                }
            }
            if (OverflowTuple != null) {
                insertTuple(tuple.colNameVal);
            }
        }

    }

    public void deleteTuple(String strTableName, Hashtable<String, Object> htblColNameValue)
            throws DBAppException {
        for (int i = 0; i < pagesList.size(); i++) {
            Page currentPage = pagesList.get(i);
            if (currentPage.deleteTuple(htblColNameValue)) {
                pagesList.remove(i);
            }
        }
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
    public static void main(String[] args) {

        Integer x = 3;
        Integer y = 5;
        System.out.println(x.compareTo(y));
    }

}
