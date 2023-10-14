package DataSet.org;

import java.util.ArrayList;
import java.util.HashMap;

public class DataProvenance {
    private final HashMap<Integer, Double> data;

    public DataProvenance(HashMap<Integer, Double> data) {
        this.data = data;
    }

    public void showDataSet() {
        var list = new ArrayList<Class_Values>();
        System.out.println(data.keySet().toArray(Integer[]::new)[0]);
        for (int x : data.keySet().toArray(Integer[]::new)) {
            if (x <= 0) {
                list.add(new Class_Values(0, x));
            } else {
                list.add(new Class_Values(1, x));
            }
        }
        System.out.println("So here are our dataset :");
        list.forEach(i -> System.out.println("value " + i.value + " belongs to class " + i.classLabel));
        System.out.println();
        System.out.println("So we have " + list.stream().map(i -> i.classLabel).distinct().count() + " classes and they are :");
        list.stream().map(i -> i.classLabel).distinct().forEach(Class -> System.out.println("Class : " + Class));
    }

    record Class_Values(double classLabel, double value) { }
}
