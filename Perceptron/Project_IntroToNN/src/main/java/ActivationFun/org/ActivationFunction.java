package ActivationFun.org;

import java.io.Serializable;
import java.util.function.DoubleUnaryOperator;

public enum ActivationFunction implements DoubleUnaryOperator, Serializable {
    Sigmoid, Relu, HardLim, PureLine;

    /**
     * Applies this activation function to the given operand.
     * @param operand the input value wp+b
     * @return the operator result
     */
    @Override
    public double applyAsDouble(double operand) {
        return switch (this) {
            case Sigmoid -> (1 / (1 + Math.pow(Math.E, -operand))) > 0.5 ? 1 : 0;
            case Relu -> Math.max(operand, 0) > 0 ? 1 : 0;
            case HardLim -> operand >= 0 ? 1 : 0;
            case PureLine -> operand > 0 ? 1 : 0;
        };
    }
}
