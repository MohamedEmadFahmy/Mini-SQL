package model;

import java.util.Hashtable;
import java.util.Vector;

public class Page {
    Vector[] Tuples;
    int TupleCount;
    String ClusteringKey;
    Hashtable<String, String> ColNameType;
    Vector[] indexedColumns;

    public Page(Vector[] tuples, int tupleCount, String clusteringKey, Hashtable<String, String> colNameType,
            Vector[] indexedColumns) {
        Tuples = tuples;
        TupleCount = tupleCount;
        ClusteringKey = clusteringKey;
        ColNameType = colNameType;
        this.indexedColumns = indexedColumns;
    }

}
