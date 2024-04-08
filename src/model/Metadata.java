package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;
import java.util.Vector;

import exceptions.DBAppException;

public class Metadata {
    private static Hashtable<String, Hashtable<String, Hashtable<String, String>>> ht = new Hashtable<String, Hashtable<String, Hashtable<String, String>>>();

    private static String filePathToMetadata = "metadata.csv";

    /*
     * 
     * DONE:
     * addTable
     * tableExists
     * tableHasColumn
     * tableHasIndexOnColumn
     * getIndexName
     * 
     *
     * 
     * TODO:
     * compatibleInsert
     * compatibleDelete
     * compatibleUpdate
     */

    public static void addTable(String strTableName, String primaryKeyName,
            Hashtable<String, String> htblColNameType) {

        // readMetadata();

        Hashtable<String, Hashtable<String, String>> table = new Hashtable<String, Hashtable<String, String>>();

        for (Map.Entry<String, String> entry : htblColNameType.entrySet()) {
            String columnName = entry.getKey();
            String columnType = entry.getValue();

            Hashtable<String, String> columnAttributes = new Hashtable<String, String>();
            columnAttributes.put("columnType", columnType);
            columnAttributes.put("clusteringKey", columnName.equals(primaryKeyName) ? "True" : "False");
            columnAttributes.put("indexName", "null");
            columnAttributes.put("indexType", "null");

            table.put(columnName, columnAttributes);
        }

        ht.put(strTableName, table);
        // saveMetadata();
    }

    public static boolean tableExists(String tableName) {
        return ht.containsKey(tableName);
    }

    public static void saveMetadata() {
        String content = "";

        // Vector<String> tables = new Vector<String>();
        // Vector<String> columns = new Vector<String>();
        // Vector<String> attributes = new Vector<String>();

        for (Map.Entry<String, Hashtable<String, Hashtable<String, String>>> tableEntry : Metadata.ht.entrySet()) {
            String tableName = tableEntry.getKey();
            // tables.add(tableName);
            Hashtable<String, Hashtable<String, String>> columnHashtable = tableEntry.getValue();
            for (Map.Entry<String, Hashtable<String, String>> columnEntry : columnHashtable.entrySet()) {
                String columnName = columnEntry.getKey();
                // columns.add("(" + tableName + "," + columnName + ")");
                Hashtable<String, String> attributeHashtable = columnEntry.getValue();

                String columnType = attributeHashtable.get("columnType");
                String clusteringKey = attributeHashtable.get("clusteringKey");
                String indexName = attributeHashtable.get("indexName");
                String indexType = attributeHashtable.get("indexType");

                String attributesString = "," + columnType + "," + clusteringKey + "," + indexName + "," + indexType;
                // attributes.add("(" + tableName + "," + columnName + "," + attributesString +
                // ")");

                String metadataRow = tableName + "," + columnName + attributesString;
                // System.out.println(metadataRow);
                content += metadataRow + "\n";
            }
        }
        if (content.length() > 0 && content.endsWith("\n")) {
            content = content.substring(0, content.length() - 1);
        }

        // System.out.println(tables);
        // System.out.println(columns);
        // System.out.println(attributes);

        // // Write to metadata.csv file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(Metadata.filePathToMetadata, false))) {
            writer.write(content);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    public static void readMetadata() {
        // Load the metadata from the file
        ht.clear();

        try (BufferedReader reader = new BufferedReader(new FileReader(Metadata.filePathToMetadata))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 6) {
                    String tableName = parts[0];
                    String columnName = parts[1];
                    String columnType = parts[2];
                    String clusteringKey = parts[3];
                    String indexName = parts[4];
                    String indexType = parts[5];

                    // Create a hashtable to store column attributes
                    Hashtable<String, String> columnAttributes = new Hashtable<>();
                    columnAttributes.put("columnType", columnType);
                    columnAttributes.put("clusteringKey", clusteringKey);
                    columnAttributes.put("indexName", indexName);
                    columnAttributes.put("indexType", indexType);

                    // Get the columns hashtable for the current table or create a new one if it
                    // doesn't exist
                    Hashtable<String, Hashtable<String, String>> columns = ht.getOrDefault(tableName,
                            new Hashtable<String, Hashtable<String, String>>());

                    // Put the column attributes into the columns hashtable
                    columns.put(columnName, columnAttributes);

                    // Put the updated columns hashtable back into the ht hashtable
                    ht.put(tableName, columns);

                } else {
                    System.err.println("Invalid metadata line: " + line);
                    // throw new Exception("Invalid Metadata Line: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading metadata file: " + e.getMessage());
        }
    }

    public static boolean tableHasColumn(String tableName, String columnName) {
        return ht.get(tableName).containsKey(columnName);
    }

    public static boolean tableHasIndexOnColumn(String tableName, String columnName) {
        return !ht.get(tableName).get(columnName).get("indexType").equals("null");
    }

    public static String getIndexName(String tableName, String columnName) {
        return ht.get(tableName).get(columnName).get("indexName");
    }

    public static void main(String[] args) throws DBAppException {
        // Hashtable<String, String> idAttributes = new Hashtable<>();
        // idAttributes.put("columnType", "java.lang.Integer");
        // idAttributes.put("clusteringKey", "True");
        // idAttributes.put("indexName", "IDIndex");
        // idAttributes.put("indexType", "B+Tree");

        // Hashtable<String, String> nameAttributes = new Hashtable<>();
        // nameAttributes.put("columnType", "java.lang.String");
        // nameAttributes.put("clusteringKey", "False");
        // nameAttributes.put("indexName", "null");
        // nameAttributes.put("indexType", "null");

        // Hashtable<String, String> numberAttributes = new Hashtable<>();
        // numberAttributes.put("columnType", "java.lang.Integer");
        // numberAttributes.put("clusteringKey", "False");
        // numberAttributes.put("indexName", "NumberIndex");
        // numberAttributes.put("indexType", "B+Tree");

        // Hashtable<String, String> specializationAttributes = new Hashtable<>();
        // specializationAttributes.put("columnType", "java.lang.String");
        // specializationAttributes.put("clusteringKey", "False");
        // specializationAttributes.put("indexName", "SpecIndex");
        // specializationAttributes.put("indexType", "B+Tree");

        // Hashtable<String, String> addressAttributes = new Hashtable<>();
        // addressAttributes.put("columnType", "java.lang.String");
        // addressAttributes.put("clusteringKey", "False");
        // addressAttributes.put("indexName", "AddrIndex");
        // addressAttributes.put("indexType", "B+Tree");

        // Hashtable<String, Hashtable<String, String>> studentColumns = new
        // Hashtable<>();
        // studentColumns.put("id", idAttributes);
        // studentColumns.put("name", nameAttributes);
        // studentColumns.put("number", numberAttributes);
        // studentColumns.put("specialization", specializationAttributes);
        // studentColumns.put("address", addressAttributes);
        // Metadata.ht.put("CityShop", studentColumns);

        // readMetadata();

        // saveMetadata();

        // String strTableName = "Student";
        // Hashtable<String, String> htblColNameType = new Hashtable<String, String>();
        // htblColNameType.put("id", "java.lang.Integer");
        // htblColNameType.put("name", "java.lang.String");
        // htblColNameType.put("gpa", "java.lang.Double");

        readMetadata();
        // if (tableExists(strTableName)) {
        // throw new DBAppException("Table " + strTableName + " already exists");
        // }
        // addTable(strTableName, "id", htblColNameType);

        // System.out.println(tableHasColumn("Student", "name"));
        // System.out.println(tableHasColumn("Student", "moski"));

        System.out.println(tableHasIndexOnColumn("Student", "id"));
        System.out.println(tableHasIndexOnColumn("Student", "age"));
    }
}
