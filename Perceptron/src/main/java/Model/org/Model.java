package Model.org;

import PerceptronModel.org.Perceptron;

import java.io.*;
import java.nio.file.Path;

public abstract class Model {

    Model() { }

    public static void exportModel(Path path, Perceptron obj) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path.toString()))) {
            objectOutputStream.writeObject(obj);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static Perceptron importModel(Path path) {
        Perceptron model = null;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path.toString()))) {
            model = (Perceptron) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return model;
    }
}
