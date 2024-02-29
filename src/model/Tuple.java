package model;

import java.util.Hashtable;

public class Tuple implements Comparable {
    Hashtable<String, Object> colNameVal;
    Object primaryKey;

    public Tuple(Hashtable<String, Object> colNameVal, Object primaryKey) {
        this.colNameVal = colNameVal;
        this.primaryKey = primaryKey;
    }

    @Override
    public int compareTo(Object o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
}
