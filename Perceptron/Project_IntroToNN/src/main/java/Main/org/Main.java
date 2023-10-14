package Main.org;

import ActivationFun.org.ActivationFunction;
import DataSet.org.DataProvenance;
import DataSet.org.DataSet;
import DataSet.org.DataSpliterator;
import PerceptronModel.org.Perceptron;

public class Main {
    public static void main(String[] args) {
        // Load the dataset and display it
        var data = new DataSet();
        var dataSet = data.getDataSet();
        new DataProvenance(dataSet).showDataSet();
        System.out.println();

        // Splitting the data into train-test datasets
        var dataSpliterator = new DataSpliterator(dataSet, 0.6f, 12345);
        var trainSet = dataSpliterator.getTrainSet();
        var testSet = dataSpliterator.getTestSet();

        // Construct single_input-Output_layer MLP
        var model = new Perceptron(0.1,
                0.1,
                ActivationFunction.HardLim,
                0.1,
                20);

        // Train the model
        model.train(trainSet);

        // Validate the model
        var validation = model.getValidationAccuracy(trainSet, 0.5f, 12345);
        System.out.println("\nThe validation accuracy is : " + validation);

        // Test the model
        var testing = model.test(testSet);
        System.out.println("\nThe testing accuracy is : " + testing);
    }
}
