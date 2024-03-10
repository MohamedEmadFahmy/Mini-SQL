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
        Tuple tuple = new Tuple(htblColNameValue, this.primaryKeyName);
        // Object primaryKey = tuple.getPrimaryKey();
        if (pagesList.isEmpty()) {
            Page page = new Page(htblColNameType, this.primaryKeyName);
            page.addTuple(tuple);
            pagesList.add(page);
            return;
        }

        Tuple OverflowTuple = null;
        for (int i = 0; i < pagesList.size(); i++) {

            // System.out.println(this);

            Page currentPage = pagesList.elementAt(i);

            if (currentPage.isEmpty()) {
                currentPage.addTuple(tuple);
                return;
            }

            if (tuple.compareTo(currentPage.getMin()) < 0) {
                OverflowTuple = currentPage.addTuple(tuple);
            } else if ((tuple.compareTo(currentPage.getMin()) > 0) && (tuple
                    .compareTo(currentPage.getMax()) < 0)) {
                OverflowTuple = currentPage.addTuple(tuple);
            } else if (tuple.compareTo(currentPage.getMax()) > 0) {
                if (i + 1 >= pagesList.size()) { // check if we are at the last page
                    OverflowTuple = currentPage.addTuple(tuple);
                    if (OverflowTuple != null) {
                        Page newPage = new Page(htblColNameType, this.primaryKeyName);
                        newPage.addTuple(OverflowTuple);
                        pagesList.add(newPage);
                        return;
                    }
                } else {
                    Page nextPage = pagesList.elementAt(i + 1); // out of bounds
                    if (nextPage.isEmpty()) {
                        nextPage.addTuple(tuple);
                        return;
                    }

                    if ((tuple.compareTo(nextPage.getMin()) > 0)
                            && (tuple.compareTo(currentPage.getMax()) < 0)) {
                        OverflowTuple = nextPage.addTuple(tuple);
                    } else if (tuple.compareTo(nextPage.getMin()) < 0) {
                        OverflowTuple = currentPage.addTuple(tuple);
                    }
                }
            }
        }
        if (OverflowTuple != null) {
            // Page page = new Page(htblColNameType, this.primaryKeyName);
            // pagesList.add(page);
            insertTuple(OverflowTuple.colNameVal);
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

    public void updateTuple(String strClusteringKeyValue, Hashtable<String, Object> htblColNameValue)
            throws DBAppException {
        Tuple tuple = new Tuple(htblColNameValue, strClusteringKeyValue);
        for (int i = 0; i < pagesList.size(); i++) {
            Page currentPage = pagesList.elementAt(i);
            if (tuple.compareTo(currentPage.getMin()) >= -1 && tuple.compareTo(currentPage.getMin()) <= 1) {
                currentPage.updateTuple(strClusteringKeyValue, htblColNameValue);
                return;
            }
        }
    }

    public void createIndex(String strTableName,
            String strColName,
            String strIndexName) throws DBAppException {

    }

    public void addPage(String strTableName, Hashtable<String, Object> htblColNameValue) throws DBAppException {

    }

    public String toString() {
        String result = "";
        result += strTableName + " Table \n\n\n";
        for (int i = 0; i < pagesList.size(); i++) {
            result += "Page " + (i + 1) + ":\n";
            result += "-------------------------------\n";
            result += pagesList.elementAt(i).toString() + "\n";
            result += "-------------------------------\n";
        }

        return result;
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
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws DBAppException {

        // Integer x = 3;
        // Integer y = 5;
        // System.out.println(x.compareTo(y));

        String strTableName = "Student";
        Hashtable<String, String> htblColNameType = new Hashtable<String, String>();
        htblColNameType.put("id", "java.lang.Integer");
        htblColNameType.put("name", "java.lang.String");
        htblColNameType.put("gpa", "java.lang.double");
        Table myTable = new Table(strTableName, "id", htblColNameType);

        // for (int i = 50; i >= 0; i--) {
        // Hashtable<String, Object> htblColNameValue = new Hashtable<>();
        // htblColNameValue.put("id", i);
        // htblColNameValue.put("name", "Moski no " + i);
        // htblColNameValue.put("gpa", 3.5);
        // myTable.insertTuple(htblColNameValue);
        // }
        for (int i = 50; i >= 43; i--) {
            Hashtable<String, Object> htblColNameValue = new Hashtable<>();
            htblColNameValue.put("id", i);
            htblColNameValue.put("name", "Moski no " + i);
            htblColNameValue.put("gpa", 3.5);
            myTable.insertTuple(htblColNameValue);
            System.out.println(myTable);
        }

        // Page firstPage = myTable.pagesList.firstElement();

        // System.out.println(myTable.pagesList.firstElement().size());
        // System.out.println(firstPage);

    }
}
