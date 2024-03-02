package model;

import java.util.Hashtable;

public class Tuple {
    Hashtable<String, Object> htblColNameValue;

    public Tuple(Hashtable<String, Object> htblColNameValue) {
        this.htblColNameValue = htblColNameValue;
    }
}
