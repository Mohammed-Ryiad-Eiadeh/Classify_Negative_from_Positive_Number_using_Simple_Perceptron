package DataSet.org;

import java.util.HashMap;
import java.util.SplittableRandom;

public class DataSpliterator {
    private final HashMap<Integer, Double> trainSet;
    private final HashMap<Integer, Double> testSet;

    public DataSpliterator(HashMap<Integer, Double> dataSet, float trainPortion, int seed) {
        trainSet = new HashMap<>();
        int trainingSamples = (int) (dataSet.size() * trainPortion);
        SplittableRandom rand = new SplittableRandom(seed);
        for (int i = 0; i < trainingSamples; i++) {
            int random = rand.nextInt(dataSet.size());
            int key = dataSet.keySet().toArray(Integer[]::new)[random];
            trainSet.put(key, dataSet.get(key));
            dataSet.remove(key);
        }
        testSet = new HashMap<>(dataSet);
    }

    public HashMap<Integer, Double> getTrainSet() {
        return trainSet;
    }

    public HashMap<Integer, Double> getTestSet() {
        return testSet;
    }
}
