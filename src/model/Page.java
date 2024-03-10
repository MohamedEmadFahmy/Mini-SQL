package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import exceptions.DBAppException;

public class Page {
    private Vector<Tuple> tuples;
    private int tupleCount;
    private int maxTupleCount;
    private String primaryKeyName;
    private Hashtable<String, String> colNameType;
    private List<String> indexedColumns;
    private Tuple min;
    private Tuple max;
    // private static final long serialVersionUID = -4544542885377264750L;

    public Page(Hashtable<String, String> colNameType, String primaryKeyName) {
        this.tuples = new Vector<Tuple>();
        this.tupleCount = 0;
        this.primaryKeyName = primaryKeyName;
        this.colNameType = colNameType;
        this.indexedColumns = new ArrayList<String>();

        loadMaxTuplesCount();
        min = null;
        max = null;
    }

    public Tuple getMin() {
        return min;
    }

    public Tuple getMax() {
        return max;
    }

    public void loadMaxTuplesCount() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/resources/DBApp.config"));
            String line;

            while ((line = reader.readLine()) != null) {
                if (line.startsWith("MaximumRowsCountinPage")) {
                    this.maxTupleCount = Integer.parseInt(line.split("=")[1].trim());
                    // System.out.println(this.maxTupleCount);
                    break;
                }
            }
            reader.close();
        } catch (Exception e) {
            // Handle exceptions, e.g., file not found or format error
            e.printStackTrace();
        }
    }

    public Tuple addTuple(Tuple tuple) throws DBAppException {
        // returns overflow tuple, null if no overflow

        Object primaryKey = null;

        // To be moved to DBApp using metadata or table class
        if (tuple.colNameVal.containsKey(this.primaryKeyName)) {
            primaryKey = tuple.colNameVal.get(this.primaryKeyName);
        }

        for (Tuple currentTuple : this.tuples) {
            if (currentTuple.colNameVal.get(primaryKeyName).equals(primaryKey)) {
                throw new DBAppException("Primary Key already in use");
            }
        }

        int index = locateCorrectPosition(tuple);
        tuples.insertElementAt(tuple, index);

        this.tupleCount += 1;

        Tuple overflow = null;

        if (this.tupleCount > this.maxTupleCount) {
            this.tupleCount -= 1;
            overflow = tuples.remove(this.maxTupleCount);
            // returns the last tuple
            // (not intended behavior, but it's the closest thing to an overflow tuple)
        }

        min = this.tuples.firstElement();
        max = this.tuples.lastElement();

        return overflow;
    }

    private int locateCorrectPosition(Tuple tuple) {
        // returns the correct index for the tuple in the page
        // using binary search

        int low = 0;
        int high = this.tuples.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            Tuple currentTuple = this.tuples.get(mid);

            if (currentTuple.compareTo(tuple) < 0) {
                low = mid + 1;
            } else if (currentTuple.compareTo(tuple) > 0) {
                high = mid - 1;
            } else {
                return mid;
            }
        }

        return low;
    }

    private static boolean hasMatchingValues(Hashtable<String, Object> criteria,
            Tuple tuple) {
        for (String key : criteria.keySet()) {
            if (!tuple.colNameVal.containsKey(key) || !criteria.get(key).equals(tuple.colNameVal.get(key))) {
                return false;
            }
        }
        return true;
    }

    public boolean deleteTuple(Hashtable<String, Object> x) {
        // deletes any tuple that matches the given criteria
        // returns true if the page is empty after deletion
        // updates the min and max tuples

        for (Tuple currentTuple : this.tuples) {
            if (hasMatchingValues(x, currentTuple)) {
                this.tuples.remove(currentTuple);
                this.tupleCount -= 1;
            }
        }

        this.min = this.tuples.firstElement();
        this.max = this.tuples.lastElement();

        return this.tuples.isEmpty();
    }

    public Vector<Tuple> selectTuple(Hashtable<String, Object> x) {
        Vector<Tuple> selectedTuples = new Vector<Tuple>();

        for (Tuple currentTuple : this.tuples) {
            if (hasMatchingValues(x, currentTuple)) {
                selectedTuples.add(currentTuple);
            }
        }
        return selectedTuples;
    }

    public void updateTuple(String oldPrimaryKey, Hashtable<String, Object> newValues)
            throws DBAppException {
        for (int i = 0; i < tuples.size(); i++) {
            Hashtable<String, Object> tuple = this.tuples.get(i).colNameVal;

            if (tuple.contains(oldPrimaryKey) && tuple.get(oldPrimaryKey).equals(oldPrimaryKey)) {
                for (String colName : newValues.keySet()) {
                    tuple.put(colName, newValues.get(colName));
                }
                return;
            }
        }
        throw new DBAppException("Tuple not found in the page.");
    }

    public boolean isFull() {
        return this.tupleCount == this.maxTupleCount;
    }

    public boolean isEmpty() {
        return this.tupleCount == 0;
    }

    public int size() {
        return this.tuples.size();
    }

    @Override
    public String toString() {
        String result = "    ";

        result += primaryKeyName;

        for (Map.Entry<String, String> entry : colNameType.entrySet()) {
            String key = entry.getKey();
            // Object value = entry.getValue();

            if (!key.equals(primaryKeyName)) {
                result += "    " + key;
            }
        }

        result += "\n";

        for (int i = 0; i < this.tuples.size(); i++) {
            Tuple currentTuple = this.tuples.get(i);
            result += (i + 1) + " " + currentTuple.toString();
            if (i != 0) {
                result += ",";
            }
            result += "\n";
        }

        return result;
    }

    // private static int binarySearch(int[] array, int num) {
    // int low = 0;
    // int high = array.length - 1;

    // while (low <= high) {
    // int mid = (low + high) / 2;
    // int currentElement = array[mid];

    // if (currentElement < num) {
    // low = mid + 1;
    // } else if (currentElement > num) {
    // high = mid - 1;
    // } else {
    // return mid;
    // }
    // }

    // return low;
    // }

    public static void main(String[] args) throws DBAppException {
        // Hashtable<Integer, String> ht = new Hashtable<>();
        // ht.put(1, "Mohamed");
        // System.out.println(ht.get(2));

        // int[] array = { 1, 2, 3, 7, 8, 9 };

        // System.out.println(binarySearch(array, 5));
        // System.out.println(binarySearch(array, 0));
        // System.out.println(binarySearch(array, -1));
        // System.out.println(binarySearch(array, 20));
        // Page page = new Page(new Hashtable<String, String>(), "id");

        Hashtable<String, String> htblColNameType = new Hashtable<>();
        htblColNameType.put("id", "java.lang.Integer");
        htblColNameType.put("name", "java.lang.String");
        htblColNameType.put("gpa", "java.lang.double");

        Hashtable<String, Object> htblColNameValue = new Hashtable<>();
        htblColNameValue.put("id", 2343432);
        htblColNameValue.put("name", "Ahmed Noor");
        htblColNameValue.put("gpa", 0.95);

        Page page = new Page(htblColNameType, "id");
        Tuple tuple = new Tuple(htblColNameValue, "id");
        page.addTuple(tuple);
        System.out.println(page);
        System.out.println(page.size());
    }
}
