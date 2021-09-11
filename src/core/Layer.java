package core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Layer {

    /**
     * Rede neural pai - à qual esta camada pertence
     */
    private NeuralNetwork parentNetwork;


    /**
     * Coleção de neurônios nesta camada
     */
    protected List<Neuron> neurons;


    /**
     * Nome da camada
     */
    private String label;

    /**
     * Cria uma instância de camada vazia
     */
    public Layer() {
        neurons = new ArrayList<>();
    }


    /**
     * Cria uma instância de camada vazia para um número especificado de neurônios
     *
     * @param neuronsCount o número de neurônios nesta camada
     */
    public Layer(int neuronsCount) {
        neurons = new ArrayList<>(neuronsCount);
        for (int n = 1 ; n <= neuronsCount ; n++){
            Neuron neuron = new Neuron();
            neurons.add(neuron);
        }
    }


    /**
     * Referencia da camada
     *
     * @param parent parent network
     */
    public final void setParentNetwork(NeuralNetwork parent) {
        this.parentNetwork = parent;
    }

    public final NeuralNetwork getParentNetwork() {
        return this.parentNetwork;
    }

    /**
     * Retorna a matriz de neurônios nesta camada como matriz
     *
     * @return array of neurons in this layer
     */
    public final List<Neuron> getNeurons() {
        return Collections.unmodifiableList(neurons);
    }

    /**
     * Adds specified neuron to this layer
     *
     * @param neuron neuron to add
     */
    public final void addNeuron(Neuron neuron) {
        // evita a adição de neurônios nulos
        Objects.requireNonNull(neuron, "Neuron cant be null!");

        // definir a camada pai do neurônio para esta camada
        neuron.setParentLayer(this);

        // adicione um novo neurônio no final da matriz
        neurons.add(neuron);
    }

    /**
     * Adiciona neurônio especificado a esta camada, na posição de índice especificada
     * <p>
     * Lança IllegalArgumentException se o neurônio for nulo ou o índice for
     * illegal value (index<0 or index>neuronsCount)
     *
     * @param neuron neurônio para adicionar
     * @param index  posição de índice em que o neurônio deve ser adicionado
     */
    public final void addNeuron(int index, Neuron neuron) {
        // evitar a adição de neurônios nulos
        if (neuron == null) {
            throw new IllegalArgumentException("Neuron cant be null!");
        }

        // adicione neurônio a esta camada
        neurons.add(index, neuron);

        // definir a camada pai do neurônio para esta camada
        neuron.setParentLayer(this);
    }

    /**
     * Define (substitui) o neurônio na posição especificada na camada
     *
     * @param index  posição de índice para definir / substituir
     * @param neuron novo objeto Neuron para definir
     */
    public final void setNeuron(int index, Neuron neuron) {
        // garantinr que o neuronio não pe nulo
        Objects.requireNonNull(neuron, "Neuron can't be null!");

        // novo neuronio no incex especificicado
        neurons.set(index, neuron);

        // referencia da rede
        neuron.setParentLayer(this);
    }

    /**
     * Remove o neuronio da camada
     *
     * @param neuron neuron a remover
     */
    public final void removeNeuron(Neuron neuron) {
        int index = indexOf(neuron);
        removeNeuronAt(index);
    }

    /**
     * Remove neurônio na posição de índice especificada nesta camada
     *
     * @param index posição do neurônio para remover
     */
    public final void removeNeuronAt(int index) {
        Neuron neuron = neurons.get(index);
        neuron.setParentLayer(null);
        neurons.remove(index);
    }

    /**
     * Remove todos os neuronios
     */
    public final void removeAllNeurons() {
        neurons.clear();
    }

    /**
     * Retorna o neuronio de uma certa posição
     *
     * @param index neuron index position
     * @return neuron at specified index position
     */
    public Neuron getNeuronAt(int index) {
        return neurons.get(index);
    }

    /**
     * Retornar a posicao do neuronio
     *
     * @param neuron neuron object
     * @return index posicao especificada
     */
    public int indexOf(Neuron neuron) {
        return neurons.indexOf(neuron);
    }

    /**
     * Returns numero de neuronios na camada
     *
     * @return number of neurons in this layer
     */
    public int getNeuronsCount() {
        return neurons.size();
    }


    /**
     * Get layer label
     *
     * @return layer label
     */
    public String getLabel() {
        return label;
    }

    /**
     * Set layer label
     *
     * @param label layer label to set
     */
    public void setLabel(String label) {
        this.label = label;
    }

    //Ta vazio?
    public boolean isEmpty() {
        return neurons.isEmpty();
    }

}
