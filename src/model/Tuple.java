package model;

import java.io.Serializable;
import java.util.Hashtable;
import java.util.Map;

public class Tuple implements Comparable<Tuple>, Serializable {
    Hashtable<String, Object> colNameVal;
    private String primaryKeyName;
    private Object primaryKey;

    public Tuple(Hashtable<String, Object> colNameVal, String primaryKeyName) {
        this.colNameVal = colNameVal;

        this.primaryKeyName = primaryKeyName;

        for (Map.Entry<String, Object> entry : colNameVal.entrySet()) {

            String key = entry.getKey();

            if (key.equals(primaryKeyName)) {
                primaryKey = entry.getValue();
            }
        }
    }

    public Object getPrimaryKey() {
        return primaryKey;
    }

    @Override
    public int compareTo(Tuple o) {
        if (primaryKey instanceof String) {
            return ((String) this.primaryKey).compareTo(((String) o.primaryKey));
        }
        if (primaryKey instanceof Integer) {
            return ((Integer) this.primaryKey).compareTo((Integer) o.primaryKey);

        }
        if (primaryKey instanceof Double) {
            return ((Double) this.primaryKey).compareTo((Double) o.primaryKey);
        }

        return 0;
    }

    public boolean equals(Tuple t) {
        for (String key : t.colNameVal.keySet()) {
            if (!this.colNameVal.containsKey(key) || !t.colNameVal.get(key).equals(this.colNameVal.get(key))) {
                return false;
            }
        }
        for (String key : this.colNameVal.keySet()) {
            if (!t.colNameVal.containsKey(key) || !this.colNameVal.get(key).equals(t.colNameVal.get(key))) {
                return false;
            }
        }
        return t.primaryKey.equals(this.primaryKey) && this.primaryKeyName.equals(t.primaryKeyName);
    }

    public boolean matchesCriteria(Hashtable<String, Object> criteria) {
        for (String key : criteria.keySet()) {
            if (!this.colNameVal.containsKey(key) || !criteria.get(key).equals(this.colNameVal.get(key))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        String result = "";
        result += primaryKey;

        for (Map.Entry<String, Object> entry : colNameVal.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();

            if (!key.equals(primaryKeyName)) {
                result += "," + value;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Hashtable<String, Object> ht = new Hashtable<>();
        ht.put("id", 1);
        ht.put("age", 15);
        ht.put("name", "moski");
        String primaryKey = "id";

        Tuple tuple = new Tuple(ht, primaryKey);

        // System.out.println(tuple.primaryKey);

        System.out.println(tuple);
    }
}
