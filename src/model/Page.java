package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.security.cert.TrustAnchor;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Vector;

import exceptions.DBAppException;

public class Page {
    Vector<Hashtable<String, Object>> Tuples;
    int TupleCount;
    String ClusteringKey;
    Hashtable<String, String> ColNameType;
    List<String> indexedColumns;
    private static final long serialVersionUID = -4544542885377264750L;
    Object min;
    Object max;

    public Page(String clusteringKey, Hashtable<String, String> colNameType) {
        TupleCount = 0;
        ClusteringKey = clusteringKey;
        ColNameType = colNameType;
        this.indexedColumns = new ArrayList<String>();
    }

    public Hashtable<String, Object> AddTupleToPage(Hashtable<String, Object> htblColNameValue) { //returns overflow tuple, null if no overflow
        TupleCount += 1;
        Object primaryKey;
        for(int i=0; i<htblColNameValue.size();i++ ){
            if(ClusteringKey==htblColNameValue)
        } 
        Tuples.add(htblColNameValue);
        return null;
    }// don't need to check if the page is full as that would be done in the Tables
     // method

    public boolean deleteTupleFromPage(Hashtable<String, Object> x, String strClusteringKey) {
        for (int i = 0; i < this.Tuples.size(); i++) {
            Hashtable<String, Object> tuple = this.Tuples.get(i);
            if (tuple.get(strClusteringKey).equals(x.get(strClusteringKey))) {
                this.Tuples.remove(i);
                if (this.Tuples.isEmpty()) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    public void updatePage(String strClusteringKeyValue, Hashtable<String, Object> htblColNameValue)
            throws DBAppException {
        for (int i = 0; i < Tuples.size(); i++) {
            Hashtable<String, Object> tuple = Tuples.get(i);
            if (tuple.contains(strClusteringKeyValue)) {
                if (tuple.get(strClusteringKeyValue).equals(strClusteringKeyValue)) {
                    for (String colName : htblColNameValue.keySet()) {
                        tuple.put(colName, htblColNameValue.get(colName));
                    }
                    return;
                }
            }
        }
        throw new DBAppException("Tuple not found in the page.");
    }

    public Hashtable<String, Object> getTuple(int index) {
        if (index >= 0 && index < Tuples.size()) {
            return Tuples.get(index);
        } else {
            return null; // Index out of bounds, return null
        }
    }

    public boolean CheckPageFull() {
        int maxTuples = 0;

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

        return TupleCount == maxTuples;
    }

    public Boolean checkPageEmpty() {
        return TupleCount == 0;
    }

    // public Tuple ReturnTuple(){

    // }

    @Override
    public String toString() {
        return "Page [Tuples=" + Tuples + ", TupleCount=" + TupleCount + ", ClusteringKey=" + ClusteringKey
                + ", ColNameType=" + ColNameType + ", indexedColumns=" + indexedColumns + "]";
    }

}
