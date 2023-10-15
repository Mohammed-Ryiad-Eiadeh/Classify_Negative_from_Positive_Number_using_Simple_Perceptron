package DataSet.org;

import java.util.HashMap;

public class DataSet {

    public DataSet() { }

    public HashMap<Integer, Double> getDataSet() {
        HashMap<Integer, Double> dataSet = new HashMap<>();
        for (int x = -10000; x < 10000; x++) {
            if (x <= 0) {
                dataSet.put(x, 0.0);
            } else {
                dataSet.put(x, 1.0);
            }
        }
        return dataSet;
    }
}
