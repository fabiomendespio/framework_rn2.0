package core;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NeuralNetwork {

    private List<Layer> layers;

    protected double[] outputBuffer;

    private List<Neuron> inputNeurons;

    private List<Neuron> outputNeurons;

    private String label = "";

    private Layer input;


    public NeuralNetwork() {
        this.layers = new ArrayList<>();
        this.inputNeurons = new ArrayList<>();
        this.outputNeurons = new ArrayList<>();
    }


    public void addLayer(Layer layer) {

        // In case of null throw exception to prevent adding null layers
        if (layer == null) {
            throw new IllegalArgumentException("Layer cant be null!");
        }

        // set parent network for added layer
        layer.setParentNetwork(this);

        // add layer to layers collection
        layers.add(layer);

    }


    public void addLayer(int index, Layer layer) {

        // in case of null value throw exception to prevent adding null layers
        if (layer == null) {
            throw new IllegalArgumentException("Layer cant be null!");
        }

        // if layer position is negative also throw exception
        if (index < 0) {
            throw new IllegalArgumentException("Layer index cannot be negative: " + index);
        }

        // set parent network for added layer
        layer.setParentNetwork(this);

        // add layer to layers collection at specified position
        layers.add(index, layer);
    }


    public void removeLayer(Layer layer) {

        if (!layers.remove(layer)) {
            throw new RuntimeException("Layer not in Neural n/w");
        }
    }


    public void removeLayerAt(int index) {
        Layer layer = layers.get(index);
        layers.remove(index);
    }


    public List<Layer> getLayers() {
        return Collections.unmodifiableList(this.layers);
    }


    public Layer getLayerAt(int index) {
        return layers.get(index);
    }


    public int indexOf(Layer layer) {
        return layers.indexOf(layer);
    }


    public int getLayersCount() {
        return layers.size();
    }


    public void setInput(double... inputVector) {
        if (inputVector.length != inputNeurons.size()) {
            System.out.println("Input vector size does not match network input dimension!");
        }

        int idx = 0;
        for (Neuron neuron : this.inputNeurons) {
            neuron.setInput(inputVector[idx]); // set input to the corresponding neuron
            idx++;
        }
    }


//    public double[] getOutput() {
//        int i = 0;
//        for (Neuron c : outputNeurons) {
//            outputBuffer[i] = c.getOutput();
//            i++;
//        }
//
//        return outputBuffer;
//    }


    public List<Neuron> getInputNeurons() {
        return this.inputNeurons;
    }

    public int getInputsCount() {
        return this.inputNeurons.size();
    }


    public void setInputNeurons(List<Neuron> inputNeurons) {
        for (Neuron neuron : inputNeurons) {
            this.inputNeurons.add(neuron);
        }
    }

    public List<Neuron> getOutputNeurons() {
        return this.outputNeurons;
    }

    public int getOutputsCount() {
        return this.outputNeurons.size();
    }


    /*
    public void setOutputNeurons(List<Neuron> outputNeurons) {
        for (Neuron neuron : outputNeurons) {
            this.outputNeurons.add(neuron);
        }
        this.outputBuffer = new double[outputNeurons.size()];
    } */


    public void setOutputLabels(String[] labels) {
        for (int i = 0; i < outputNeurons.size(); i++) {
            outputNeurons.get(i).setLabel(labels[i]);
        }
    }

    public String[] getOutputLabels() {
        String[] labels = new String[outputNeurons.size()];
        for (int i = 0; i < outputNeurons.size(); i++) {
            labels[i] = outputNeurons.get(i).getLabel();
        }
        return labels;
    }

    public Double[] getWeights() {
        List<Double> weights = new ArrayList();
        for (Layer layer : layers) {
            for (Neuron neuron : layer.getNeurons()) {
                for (Connection conn : neuron.getInputConnections()) {
                    weights.add(conn.getWeight().getValue());
                }
            }
        }

        return weights.toArray(new Double[weights.size()]);
    }

    public void setWeights(double[] weights) {
        int i = 0;
        for (Layer layer : layers) {
            for (Neuron neuron : layer.getNeurons()) {
                for (Connection conn : neuron.getInputConnections()) {
                    conn.getWeight().setValue(weights[i]);
                    i++;
                }
            }
        }
    }

    public boolean isEmpty() {
        return layers.isEmpty();
    }

    public void createConnection(Neuron fromNeuron, Neuron toNeuron, double weightVal) {
        //  Connection connection = new Connection(fromNeuron, toNeuron, weightVal);
        toNeuron.addInputConnection(fromNeuron, weightVal);
    }

    @Override
    public String toString() {
        if (label != null) {
            return label;
        }

        return super.toString();
    }


    public String getLabel() {
        return label;
    }


    public void setLabel(String label) {
        this.label = label;
    }

    //TODO

    public void setStructure(String type, int nLayer, int nNeuron) {


    }

    public void setInputValues(ArrayList inputValues) {
        ArrayList<double[]> samples = inputValues;
        System.out.println("Valores da camada de entrada: ");
        for (int i = 0; i < input.getNeuronsCount(); i++) {
            input.getNeurons().get(i).setInput(samples.get(0)[i]); //Exemplo apenas da primeira amostra
            System.out.println(input.getNeurons().get(i).getNetInput());
        }
    }

    public void setInputWeights(double[][] inputWeights) {

    }

    public void setHiddenWeights(double[][] hiddenWeights) {

    }

    public void setActivationFunction(Type t) {

    }

    public void sigmoidFunction(){

    }

    public void start() {

    }


    public void connectNeuronIncludingWeigth(int weigthValue) {
    }
}
