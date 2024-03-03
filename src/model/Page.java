package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Vector;

import exceptions.DBAppException;

public class Page {
    Vector<Tuple> Tuples;
    int TupleCount;
    String ClusteringKey;
    Hashtable<String, String> ColNameType;
    List<String> indexedColumns;
    // private static final long serialVersionUID = -4544542885377264750L;
    int maxTuples = 0;
    Object min;
    Object max;

    public Page(String clusteringKey, Hashtable<String, String> colNameType) {
        TupleCount = 0;
        ClusteringKey = clusteringKey;
        ColNameType = colNameType;
        this.indexedColumns = new ArrayList<String>();

        // retrieving maxtuples

        try {
            BufferedReader reader = new BufferedReader(new FileReader("resources/DBApp.config"));
            String line;

            while ((line = reader.readLine()) != null) {
                if (line.startsWith("MaximumRowsCountinPage")) {
                    maxTuples = Integer.parseInt(line.split("=")[1].trim());
                    break;
                }
            }
            reader.close();

        } catch (Exception e) {
            // Handle exceptions, e.g., file not found or format error
            e.printStackTrace();
        }

    }

    public Tuple AddTupleToPage(Tuple htblColNameValue) { // returns overflow
                                                          // tuple, null if no
                                                          // overflow
        Object primaryKey = null;
        if (htblColNameValue.colNameVal.containsKey(ClusteringKey)) {
            primaryKey = htblColNameValue.colNameVal.get(ClusteringKey);
        }
        for (int i = 0; i < TupleCount; i++) {
            if (Tuples.elementAt(i).colNameVal.get(ClusteringKey).equals(primaryKey)) {
                System.out.println("Primary Key already in use");
                return null;
            }
        }
        Tuples.add(htblColNameValue);
        TupleCount += 1;
        if (TupleCount > maxTuples) {
            TupleCount -= 1;
            return Tuples.remove(maxTuples);
        }
        return null;
    }

    // I created this helper method to check if for all keys in htblX the
    // corresponding values in htblX & htblY are equal
    private static boolean hasMatchingValues(Hashtable<String, Object> criteria,
            Tuple tuple) {
        for (String key : criteria.keySet()) {
            if (!tuple.colNameVal.containsKey(key) || !criteria.get(key).equals(tuple.colNameVal.get(key))) {
                return false;
            }
        }
        return true;
    }

    public boolean deleteTupleFromPage(Hashtable<String, Object> x) {
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
                TupleCount -= 1;
            }
            if (this.Tuples.isEmpty()) {
                return true;
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

    public void updatePage(String oldPrimaryKey, Hashtable<String, Object> newValues)
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

    public Tuple getTuple(int index) {
        if (index >= 0 && index < Tuples.size()) {
            return this.Tuples.get(index);
        } else {
            return null; // Index out of bounds, return null
        }
    }

    public boolean CheckPageFull() {
        return TupleCount == maxTuples;
    }

    public boolean checkPageEmpty() {
        return TupleCount == 0;
    }

    // }

    @Override
    public String toString() {
        return "Page [Tuples=" + Tuples + ", TupleCount=" + TupleCount + ", ClusteringKey=" + ClusteringKey
                + ", ColNameType=" + ColNameType + ", indexedColumns=" + indexedColumns + "]";
    }

    public static void main(String[] args) {
        Hashtable<Integer, String> ht = new Hashtable<>();
        ht.put(1, "Mohamed");
        System.out.println(ht.get(2));
    }
}
