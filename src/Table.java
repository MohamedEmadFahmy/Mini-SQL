import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Hashtable;

public class Table {
    String strTableName;
    String strClusteringKeyColumn;
    Hashtable<String, String> htblColNameType;

    public Table(String strTableName, String strClusteringKeyColumn, Hashtable<String, String> htblColNameType) {
        this.strTableName = strTableName;
        this.strClusteringKeyColumn = strClusteringKeyColumn;
        this.htblColNameType = htblColNameType;

        addMetaData();

    }

    public void addMetaData() {
        StringBuilder contentBuilder = new StringBuilder();

        htblColNameType.forEach((key, value) -> {
            String tableName = this.strTableName;
            String colName = key;
            String colDataType = value;
            String isClusteringKey = key.equals(strClusteringKeyColumn) ? "True" : "False";
            String indexName = "null";
            String indexType = "null";

            System.out.println(String.format("%s,%s,%s,%s,%s,%s\n", tableName, colName, colDataType, isClusteringKey,
                    indexName, indexType));

            contentBuilder.append(String.format("%s,%s,%s,%s,%s,%s\n", tableName, colName, colDataType, isClusteringKey,
                    indexName, indexType));
        });

        writeFile("metadata.txt", contentBuilder.toString());
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

    public static void writeFile(String filePath, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(content);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static void main(String[] args) {
        String strTableName = "Student";
        Hashtable htblColNameType = new Hashtable();
        htblColNameType.put("id", "java.lang.Integer");
        htblColNameType.put("name", "java.lang.String");
        htblColNameType.put("gpa", "java.lang.double");
        Table myTable = new Table(strTableName, "id", htblColNameType);
    }
}
