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

    public void AddTupleToPage(Hashtable<String, Object> htblColNameValue) {
        TupleCount += 1;

    }

    public void RemoveTupleFromPage(Hashtable<String, Object> htblColNameValue) {

    }

    public void UpdateTuple(String strTableName, String strClusteringKeyValue,
            Hashtable<String, Object> htblColNameValue) {

    }

    CheckPageFull(){
        
    }

    // ReturnTuple();
    // toString();

}
