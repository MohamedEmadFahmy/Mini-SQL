package model;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import engine.DBApp;
import engine.SQLTerm;
import exceptions.DBAppException;

@SuppressWarnings("unused")
public class Table implements Serializable {
    private String strTableName;
    private String primaryKeyName;
    private Hashtable<String, String> htblColNameType;
    private List<String> indexedColumns;
    private Vector<String> pagesList;

    public Table(String strTableName, String primaryKeyName, Hashtable<String, String> htblColNameType) {
        this.strTableName = strTableName;
        this.primaryKeyName = primaryKeyName;
        this.htblColNameType = htblColNameType;
        this.indexedColumns = new ArrayList<String>();
        this.pagesList = new Vector<String>();
    }

    public String getStrTableName() {
        return strTableName;
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

    public void insertTuple(Hashtable<String, Object> htblColNameValue)// plan is on figma
            throws DBAppException, IOException, ClassNotFoundException {
        Tuple tuple = new Tuple(htblColNameValue, this.primaryKeyName);

        if (pagesList.isEmpty()) {
            Page page = new Page(htblColNameType, this.primaryKeyName);
            page.addTuple(tuple);
            // System.out.println("inserted, 0");
            pagesList.add(this.strTableName + "" + 0);
            page.serializePage(this.strTableName + "" + 0);
            return;
        }

        int insertedpage = 0;
        Tuple OverflowTuple = null;
        for (int i = 0; i < pagesList.size(); i++) {
            // System.out.println("insert loop: " + i);
            String currentPageName = pagesList.elementAt(i);
            Page currentPage = Page.deserializePage(currentPageName);

            if (currentPage.isEmpty()) {
                currentPage.addTuple(tuple);
                currentPage.serializePage(currentPageName);
                return;
            }

            if (tuple.compareTo(currentPage.getMin(), primaryKeyName) == -1) {
                OverflowTuple = currentPage.addTuple(tuple);
                currentPage.serializePage(currentPageName);
                insertedpage = i;
                // System.out.println("loop:" + i + ", inserted, 1");
                break;
            }

            if ((tuple.compareTo(currentPage.getMin(), primaryKeyName) == 1)
                    && (tuple.compareTo(currentPage.getMax(), primaryKeyName) == -1)) {
                OverflowTuple = currentPage.addTuple(tuple);
                currentPage.serializePage(currentPageName);
                insertedpage = i;
                // System.out.println("loop:" + i + ", inserted, 2");
                break;
            }

            if (i == pagesList.size() - 1) { // @final page
                // System.out.println("entered third insert");
                OverflowTuple = currentPage.addTuple(tuple);
                currentPage.serializePage(currentPageName);
                insertedpage = i;
                // System.out.println("loop:" + i + ", inserted, 3");
                break;
            }
            // System.out.println("loop:" + i + ",No insert, next page");
        }

        // System.out.println("page size: " + pagesList.size());
        // System.out.println("reached Overflow loop, i= " + insertedpage);
        for (int i = insertedpage; i < pagesList.size(); i++) {
            // System.out.println("Overflow loop: " + i);

            if (OverflowTuple == null) {
                // System.out.println("No overflow");
                return;
            }

            String currentPageName = pagesList.elementAt(i);
            Page currentPage = Page.deserializePage(currentPageName);

            OverflowTuple = currentPage.addTuple(OverflowTuple);
            // System.out.println("inserted overflow, 0");
            currentPage.serializePage(currentPageName);

            if ((OverflowTuple != null) && (i == pagesList.size() - 1)) {
                Page page = new Page(htblColNameType, this.primaryKeyName);
                page.addTuple(OverflowTuple);
                // System.out.println("inserted overflow, 1");
                pagesList.add(this.strTableName + "" + (i + 1));
                page.serializePage(this.strTableName + "" + (i + 1));
                return;
            }

        }

    }

    public void deleteTuple(String strTableName, Hashtable<String, Object> htblColNameValue)
            throws DBAppException, ClassNotFoundException, IOException {
        for (int i = 0; i < pagesList.size(); i++) {
            String currentPageName = pagesList.elementAt(i);
            Page currentPage = Page.deserializePage(currentPageName);
            if (currentPage.deleteTuple(htblColNameValue)) {
                pagesList.remove(i); // delete serialized file
            }
            currentPage.serializePage(currentPageName);
        }
    }

    @SuppressWarnings("rawtypes")
    public Iterator selectTuple(SQLTerm[] arrSQLTerms, String[] strarrOperators)
            throws DBAppException, ClassNotFoundException, IOException {

        Vector<Vector<Tuple>> result = new Vector<Vector<Tuple>>();

        for (SQLTerm term : arrSQLTerms) {// iterat on sql terms
            String columnName = term._strColumnName;
            String operator = term._strOperator;
            Object value = term._objValue;
            Vector<Tuple> tuples = new Vector<Tuple>();
            Vector<Tuple> termResult = new Vector<Tuple>();
            if (indexedColumns.contains(columnName)) {
                Vector<String> pagesInIndex = new Vector<String>();// get the pages from indexing - TODO after index
                for (int i = 0; i < pagesInIndex.size(); i++) { // iterate search on pages
                    Page indexPage = Page.deserializePage(pagesInIndex.get(i));
                    tuples = indexPage.selectTuple(columnName, operator, value);
                    termResult.addAll(tuples);
                }
            } else {
                for (int i = 0; i < pagesList.size(); i++) {// iterate search on unindexed pages
                    Page page = Page.deserializePage(pagesList.get(i));
                    tuples = page.selectTuple(columnName, operator, value);
                    // -------> serialization not needed because the pages are unchanged
                    termResult.addAll(tuples);
                }
            }
            result.add(termResult);
            termResult.clear();
        }

        Vector<Tuple> finalResult = combineResults(result, strarrOperators);
        return finalResult.iterator();
    }

    private Vector<Tuple> combineResults(Vector<Vector<Tuple>> termResults, String[] strarrOperators)
            throws DBAppException {
        Vector<Tuple> finalResult = new Vector<Tuple>();
        if (termResults.size() == 1) {
            return termResults.elementAt(0);
        }
        if (termResults.isEmpty()) {
            return finalResult;
        }

        finalResult.addAll(termResults.get(0));
        Vector<Tuple> operatorResult = new Vector<Tuple>();
        String operator;

        for (int i = 0; i < strarrOperators.length; i++) {
            operator = strarrOperators[i];
            Vector<Tuple> currentTermResult = termResults.get(i + 1);
            operatorResult.clear();
            if (operator == "AND") {
                for (int j = 0; j < finalResult.size(); j++) {
                    if (currentTermResult.contains(finalResult.get(j))) {
                        operatorResult.add(finalResult.get(j));
                    }
                }
            } else if (operator == "OR") {
                operatorResult.addAll(finalResult);
                for (int j = 0; j < currentTermResult.size(); j++) {
                    if (!finalResult.contains(currentTermResult.get(j))) {
                        operatorResult.add(currentTermResult.get(j));
                    }
                }
            } else if (operator == "XOR") {
                for (int j = 0; j < currentTermResult.size(); j++) {
                    if (!finalResult.contains(currentTermResult.get(j))) {
                        operatorResult.add(currentTermResult.get(j));
                    }
                }
                for (int k = 0; k < finalResult.size(); k++) {
                    if (!currentTermResult.contains(finalResult.get(k))) {
                        operatorResult.add(finalResult.get(k));
                    }
                }
            } else {
                throw new DBAppException("Invalid Operator");// invalid operator
            }
            finalResult = operatorResult;
        }

        return finalResult;
    }

    public void updateTuple(String strClusteringKeyValue, Hashtable<String, Object> htblColNameValue)
            throws DBAppException, ClassNotFoundException, IOException {
        Tuple tuple = new Tuple(htblColNameValue, strClusteringKeyValue);
        for (int i = 0; i < pagesList.size(); i++) {
            String currentPageName = pagesList.elementAt(i);
            Page currentPage = Page.deserializePage(currentPageName);
            if (tuple.compareTo(currentPage.getMin(), tuple.getPrimaryKeyName()) >= -1
                    && tuple.compareTo(currentPage.getMin(),
                            tuple.getPrimaryKeyName()) <= 1) {
                currentPage.updateTuple(strClusteringKeyValue, htblColNameValue);
                currentPage.serializePage(currentPageName);
                return;
            }
        }
    }

    public void createIndex(String strTableName,
            String strColName,
            String strIndexName) throws DBAppException {

    }

    public String toString() {
        String result = "";
        result += strTableName + " Table \n\n\n";
        for (int i = 0; i < pagesList.size(); i++) {
            result += "Page " + (i + 1) + ":\n";
            result += "-------------------------------\n";
            Page currentPage = null;
            try {
                currentPage = Page.deserializePage(pagesList.elementAt(i));
            } catch (ClassNotFoundException | IOException e) {
                // TODO Auto-generated catch block
                result += "Error reading page at index + " + i + "\n";
            }
            result += currentPage.toString() + "\n";
            result += "-------------------------------\n";
        }

        return result;
    }

    public void serializeTable() {
        // Store table on disk
        try {
            FileOutputStream fileOut = new FileOutputStream(
                    "./src/resources/Serialized_Tables/" + this.getStrTableName() + ".class");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this);
            out.close();
            fileOut.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static Table deserializeTable(String strTableName) {
        Table myTable = null;
        // Load table from disk
        try {
            FileInputStream fileIn = new FileInputStream(
                    "./src/resources/Serialized_Tables/" + strTableName + ".class");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            myTable = (Table) in.readObject();
            in.close();
            fileIn.close();

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return myTable;
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

    public static void main(String[] args) throws DBAppException, ClassNotFoundException, IOException {

        // Integer x = 3;
        // Integer y = 5;
        // System.out.println(x.compareTo(y));

        String strTableName = "Student";
        Hashtable<String, String> htblColNameType = new Hashtable<String, String>();
        htblColNameType.put("id", "java.lang.Integer");
        htblColNameType.put("name", "java.lang.String");
        htblColNameType.put("gpa", "java.lang.double");
        Table myTable = new Table(strTableName, "id", htblColNameType);

        // for (int i = 1; i <= 10; i++) {
        // Hashtable<String, Object> htblColNameValue = new Hashtable<>();
        // htblColNameValue.put("id", i);
        // htblColNameValue.put("name", "Moski no " + i);
        // htblColNameValue.put("gpa", 3.5);
        // myTable.insertTupleAttempt(htblColNameValue);
        // }
        // System.out.println(myTable);

        // --------------DOESNT WORK--------------
        // for (int i = 50; i >= 1; i--) {
        // Hashtable<String, Object> htblColNameValue = new Hashtable<>();
        // htblColNameValue.put("id", i);
        // htblColNameValue.put("name", "Moski no " + i);
        // htblColNameValue.put("gpa", 3.5);
        // myTable.insertTupleAttempt(htblColNameValue);
        // }

        int x = 50;
        Integer[] array = new Integer[x];

        for (int i = 0; i < x; i++) {
            array[i] = i + 1;
        }
        List<Integer> list = Arrays.asList(array);

        // Shuffle the list
        Collections.shuffle(list);

        // Convert back to array if necessary
        list.toArray(array);
        // System.out.println(Arrays.toString(array));

        for (int i = 0; i < array.length; i++) {
            int num = array[i];
            Hashtable<String, Object> htblColNameValue = new Hashtable<>();
            htblColNameValue.put("id", num);
            htblColNameValue.put("name", "Moski no " + num);
            htblColNameValue.put("gpa", 3.5);
            myTable.insertTuple(htblColNameValue);
        }
        System.out.println(myTable);

        // Page firstPage = myTable.pagesList.firstElement();

        // System.out.println(myTable.pagesList.firstElement().size());
        // System.out.println(firstPage);

    }
}
