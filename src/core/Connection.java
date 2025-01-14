package core;

import java.io.Serializable;
import java.util.Objects;

public class Connection implements Serializable {

    protected Neuron fromNeuron;
    protected Neuron toNeuron;
    protected Weight weight;

    public Connection(Neuron fromNeuron, Neuron toNeuron) {

        if (fromNeuron == null) {
            throw new IllegalArgumentException("From neuron in connection cant be null !");
        } else {
            this.fromNeuron = fromNeuron;
        }

        if (toNeuron == null) {
            throw new IllegalArgumentException("To neuron in connection cant be null!");
        } else {
            this.toNeuron = toNeuron;
        }

        this.weight = new Weight();
    }


    public Connection(Neuron fromNeuron, Neuron toNeuron, Weight weight) {
        this(fromNeuron, toNeuron);

        if (weight == null) {
            throw new IllegalArgumentException("Connection Weight cant be null!");
        } else {
            this.weight = weight;
        }

    }


    public Connection(Neuron fromNeuron, Neuron toNeuron, double weightVal) {
        this(fromNeuron, toNeuron, new Weight(weightVal));
    }

    public final Weight getWeight() {
        return this.weight;
    }


    public final void setWeight(Weight weight) {
        if (weight == null) {
            throw new IllegalArgumentException("Connection Weight cant be null!");
        } else {
            this.weight = weight;
        }
    }


    public double getInput() {
        return fromNeuron.getOutput();
    }


    public final double getWeightedInput() {
        return fromNeuron.getOutput() * weight.value;
    }


    public final Neuron getFromNeuron() {
        return fromNeuron;
    }


    public final Neuron getToNeuron() {
        return toNeuron;
    }


}
