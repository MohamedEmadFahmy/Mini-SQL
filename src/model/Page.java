package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Vector;

import exceptions.DBAppException;

public class Page {
    private Vector<Tuple> Tuples;
    private int tupleCount;
    private int maxTupleCount;
    private String clusteringKey;
    private Hashtable<String, String> colNameType;
    private List<String> indexedColumns;
    private Tuple min;
    private Tuple max;
    // private static final long serialVersionUID = -4544542885377264750L;

    public Page(String clusteringKey, Hashtable<String, String> colNameType) {
        this.tupleCount = 0;
        this.clusteringKey = clusteringKey;
        this.colNameType = colNameType;
        this.indexedColumns = new ArrayList<String>();

        loadMaxTuplesCount();
        min = null;
        max = null;
    }

    public void loadMaxTuplesCount() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("resources/DBApp.config"));
            String line;

            while ((line = reader.readLine()) != null) {
                if (line.startsWith("MaximumRowsCountinPage")) {
                    this.maxTupleCount = Integer.parseInt(line.split("=")[1].trim());
                    break;
                }
            }
            reader.close();
        } catch (Exception e) {
            // Handle exceptions, e.g., file not found or format error
            e.printStackTrace();
        }
    }

    public Tuple addTuple(Tuple htblColNameValue) {
        // returns overflow tuple, null if no overflow

        Object primaryKey = null;
        if (htblColNameValue.colNameVal.containsKey(clusteringKey)) {
            primaryKey = htblColNameValue.colNameVal.get(clusteringKey);
        }
        for (int i = 0; i < this.tupleCount; i++) {
            if (Tuples.elementAt(i).colNameVal.get(clusteringKey).equals(primaryKey)) {
                System.out.println("Primary Key already in use");
                return null;
            }
        }
        Tuples.add(htblColNameValue);
        this.tupleCount += 1;
        // min & max tuple functionality
        if (this.max.equals(null)) {
            this.max = htblColNameValue;
        } else if (htblColNameValue.compareTo(this.max) == 1) {
            this.max = htblColNameValue;
        }
        if (this.min.equals(null)) {
            this.min = htblColNameValue;
        } else if (htblColNameValue.compareTo(this.min) == -1) {
            this.min = htblColNameValue;
        }

        if (this.tupleCount > this.maxTupleCount) {
            this.tupleCount -= 1;
            return Tuples.remove(this.maxTupleCount);
        }
        return null;
    }
    // don't need to check if the page is full as that would be done in the Tables
    // method

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
        // since the pk isnt given by the user, the code will need to be completely
        // redone;
        // since the user could ask for multiple tuples to be deleted, process will
        // require n*m to loop
        // on the given hashtable and then the Tuples vector hashtables.
        Tuple currentTuple = null;
        for (int i = 0; i < this.Tuples.size(); i++) {
            currentTuple = this.Tuples.get(i);
            if (hasMatchingValues(x, currentTuple)) {
                this.Tuples.remove(i);
                this.tupleCount -= 1;
                if (currentTuple.equals(min)) { // checks if the deleted value was the min or the max
                    min = null;
                }
                if (currentTuple.equals(max)) {
                    max = null;
                }
            }
            if (this.Tuples.isEmpty()) {
                min = null;
                max = null;
                return true;
            }
        }
        // min & max functionality (here they require a loop incase one of them is
        // deleted)
        min = this.Tuples.get(0);
        max = this.Tuples.get(0);
        for (int j = 0; j < Tuples.size(); j++) {
            if (Tuples.get(j).compareTo(min) == -1) {
                min = Tuples.get(j);
            }
            if (Tuples.get(j).compareTo(max) == 1) {
                max = Tuples.get(j);
            }
        }

        return false;
    }

    // used the hasmatching values in a similar fashion to the deleteTuple method
    // assuming a similar input
    public Vector<Tuple> returnTuple(Hashtable<String, Object> x) {
        Vector<Tuple> selectedTuples = new Vector<Tuple>();
        Tuple currentTuple = null;
        for (int i = 0; i < this.Tuples.size(); i++) {
            currentTuple = this.Tuples.get(i);
            if (hasMatchingValues(x, currentTuple)) {
                selectedTuples.add(currentTuple);
            }
        }
        return selectedTuples;
    }

    public void updateTuple(String oldPrimaryKey, Hashtable<String, Object> newValues)
            throws DBAppException {
        for (int i = 0; i < Tuples.size(); i++) {
            Hashtable<String, Object> tuple = this.Tuples.get(i).colNameVal;

            if (tuple.contains(oldPrimaryKey) && tuple.get(oldPrimaryKey).equals(oldPrimaryKey)) {
                for (String colName : newValues.keySet()) {
                    tuple.put(colName, newValues.get(colName));
                }
                return;
            }
        }
        throw new DBAppException("Tuple not found in the page.");
    }

    public Tuple getTupleAtIndex(int index) {
        if (index >= 0 && index < Tuples.size()) {
            return this.Tuples.get(index);
        } else {
            return null; // Index out of bounds, return null
        }
    }

    public boolean isPageFull() {

        return this.tupleCount == this.maxTupleCount;
    }

    public boolean isPageEmpty() {
        return this.tupleCount == 0;
    }

    @Override
    public String toString() {
        return "Page [Tuples=" + Tuples + ", Tuple Count=" + this.tupleCount + ", Clustering Key=" + clusteringKey
                + ", Column Name/Types=" + colNameType + ", Indexed Columns=" + indexedColumns + "]";
    }

    public static void main(String[] args) {
        Hashtable<Integer, String> ht = new Hashtable<>();
        ht.put(1, "Mohamed");
        System.out.println(ht.get(2));
    }
}
