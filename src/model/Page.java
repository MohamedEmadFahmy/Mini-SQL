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
    private Vector<Tuple> Tuples;
    private int tupleCount;
    private int maxTupleCount;
    private String clusteringKey;
    private Hashtable<String, String> colNameType;
    private List<String> indexedColumns;
    private Object min;
    private Object max;
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

    public void addTuple(Tuple tuple, Object strClusteringKey) throws DBAppException {
        Tuples.add(tuple);
        Tuples.sort(null);
    }
    // don't need to check if the page is full as that would be done in the Tables
    // method

    public boolean deleteTupleFromPage(Tuple x, String strClusteringKey) {
        for (int i = 0; i < this.Tuples.size(); i++) {
            Tuple tuple = this.Tuples.get(i);
            if (tuple.colNameVal.get(strClusteringKey).equals(x.colNameVal.get(strClusteringKey))) {
                this.Tuples.remove(i);
                tupleCount -= 1;
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

    public boolean isPageFull() {

        return tupleCount == maxTupleCount;
    }

    public Boolean isPageEmpty() {
        return tupleCount == 0;
    }

    public boolean CheckPageFull() {
        return tupleCount == maxTupleCount;
    }

    public boolean checkPageEmpty() {
        return tupleCount == 0;
    }

    // }

    @Override
    public String toString() {
        return "Page [Tuples=" + Tuples + ", Tuple Count=" + tupleCount + ", Clustering Key=" + clusteringKey
                + ", Column Name/Types=" + colNameType + ", Indexed Columns=" + indexedColumns + "]";
    }

    public static void main(String[] args) {
        Hashtable<Integer, String> ht = new Hashtable<>();
        ht.put(1, "Mohamed");
        System.out.println(ht.get(2));
    }
}
