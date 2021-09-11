package core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Neuron {

    /**
     * Parent layer do neuron
     */
    protected Layer parentLayer;
    /**
     * Coleção de Connections de entrada do Neuron (conexões para este Neuron)
     */
    protected List<Connection> inputConnections;
    /**
     * Coleção de Connections de saída do Neuron (conexões deste para outro
     * Neuron)
     */
    protected List<Connection> outConnections;

    /**
     * Representa a entrada total para este neurônio recebida da função de entrada. (Somatória)
     */
    protected double totalInput = 0;

    /**
     * Neuron output
     */
    protected double output = 0;

    /**
     * Erro (delta) para este neuron
     */
    protected transient double delta = 0;

    /**
     * Neuron's label
     */
    private String label;

    /**
     * Construtor neuron inicializando as listas de conections de entrada e de saida
     */
    public Neuron() {
        this.inputConnections = new ArrayList<>();
        this.outConnections = new ArrayList<>();
    }

    /**
     * Define a entrada do neurônio
     *
     * @param input valor de entrada para definir
     */
    public void setInput(double input) {
        this.totalInput = input;
    }

    /**
     * Retorna a entrada somatória
     *
     * @return somatória input
     */
    public double getNetInput() {
        return this.totalInput;
    }

    /**
     * Retorna a saída do neurônio
     *
     * @return saída do neurônio
     */
    public double getOutput() {
        return this.output;
    }

    /**
     * Retorna verdadeiro se houver conexões de entrada para este neurônio, falso
     * por outro lado
     *
     * @return true se houver conexão de entrada, false caso contrário
     */

    public boolean hasInputConnections() {
        return (inputConnections.size() > 0);
    }


    /**
     * Verifique a conexão com o neurônio
     *
     * @param neuron conexão do Neuron a ser verificada
     * @return true se houver conexão de saída, false caso contrário
     */

    public boolean hasOutputConnectionTo(Neuron toNeuron) {
        for (Connection connection : outConnections) {
            if (connection.getToNeuron() == toNeuron) {
                return true;
            }
        }
        return false;
    }

    /**
     * Verifique a conexão do neurônio
     *
     * @param neuron conexão do Neuron a ser verificada
     * @return true se houver conexão de entrada, false caso contrário
     */

    public boolean hasInputConnectionFrom(Neuron neuron) {
        for (Connection connection : inputConnections) {
            if (connection.getFromNeuron() == neuron) {
                return true;
            }
        }
        return false;
    }


    /**
     * Adiciona a conexão de entrada especificada
     *
     * @param connection input connection para adicionar
     */

    public void addInputConnection(Connection connection) {
        // check whether connection is  null
        if (connection == null) {
            throw new IllegalArgumentException("Attempt to add null connection to neuron!");
        }

        // make sure that connection instance is pointing to this neuron
        if (connection.getToNeuron() != this) {
            throw new IllegalArgumentException("Cannot add input connection - bad toNeuron specified!");
        }

        // if it already has connection from same neuron do nothing
        if (this.hasInputConnectionFrom(connection.getFromNeuron())) {
            return;
        }

        this.inputConnections.add(connection);

        Neuron fromNeuron = connection.getFromNeuron();
        fromNeuron.addOutputConnection(connection);
    }

    /**
     * Adiciona conexão de entrada do neurônio especificado.
     *
     * @param fromNeuron neuron para conectar a partir do neuron selecionado
     */

    public void addInputConnection(Neuron fromNeuron) {
        Connection connection = new Connection(fromNeuron, this);
        this.addInputConnection(connection);
    }

    /**
     * Adiciona conexão de entrada com o peso determinado, de determinado neurônio
     *
     * @param fromNeuron neuron para conectar a partir do neuronio selecionado
     * @param weightVal  valor peso da connection
     */

    public void addInputConnection(Neuron fromNeuron, double weightVal) {
        Connection connection = new Connection(fromNeuron, this, weightVal); //Alinhar
        this.addInputConnection(connection);
    }


    /**
     * Adiciona a conexão de saída especificada
     *
     * @param connection adicionar Connection de saída
     */

    protected void addOutputConnection(Connection connection) {
        // First do some checks
        // check whether connection is  null
        if (connection == null) {
            throw new IllegalArgumentException("Attempt to add null connection to neuron!");
        }

        // make sure that connection instance is pointing to this neuron
        if (connection.getFromNeuron() != this) {
            throw new IllegalArgumentException("Cannot add output connection - bad fromNeuron specified!");
        }

        // if this neuron is already connected to neuron specified in connection do nothing
        if (this.hasOutputConnectionTo(connection.getToNeuron())) {
            return;
        }

        // Now we can safely add new connection
        this.outConnections.add(connection);
    }


    /**
     * Define a referência à camada pai para este neurônio (camada na qual o neurônio
     * está localizado)
     *
     * @param referência pai na camada em que a célula está localizada
     */
    public void setParentLayer(Layer parent) {
        this.parentLayer = parent;
    }

    /**
     * Retorna a referência à camada pai para este neurônio
     *
     * @return camada pai para este neurônio
     */
    public Layer getParentLayer() {
        return this.parentLayer;
    }

    /**
     * Retorna o vetor de pesos das conexões de entrada
     *
     * @return pondera vetor de conexões de entrada
     */
    public Weight[] getWeights() {
        Weight[] weights = new Weight[inputConnections.size()];
        for (int i = 0; i < inputConnections.size(); i++) {
            weights[i] = inputConnections.get(i).getWeight();
        }
        return weights;
    }


    /**
     * Retorna delta (erro) para este neurônio. Isso é usado por retropropagação
     * regras de aprendizagem.
     *
     * @return erro para este neurônio que é definido pela regra de aprendizagem
     */
    public double getDelta() {
        return delta;
    }


    /**
     * Define delta para este neurônio. Isso é usado pelo aprendizado de retropropagação
     * as regras.
     *
     * @param delta neuron delta
     */
    public void setDelta(double delta) {
        this.delta = delta;
    }

    /**
     * Sets this neuron output
     *
     * @param output value to set
     */
    public void setOutput(double output) {
        this.output = output;
    }


    /**
     * Define esta saída de neurônio
     * <p>
     * valor de saída @param para definir
     */
    public void initializeWeights(double value) {
        for (Connection connection : this.inputConnections) {
            connection.getWeight().setValue(value);
        }
    }

    /**
     * Returns conexões de entrada deste neuronio
     *
     * @return input connections of this neuron
     */
    public final List<Connection> getInputConnections() {
        return Collections.unmodifiableList(inputConnections);
    }

    /**
     * Etiqueta de retorno para este neurônio
     * <p>
     * etiqueta @return para este neurônio
     */
    public String getLabel() {
        return label;
    }

    /**
     * Define o rótulo para este neurônio
     *
     * @param label neuron label para definir
     */
    public void setLabel(String label) {
        this.label = label;
    }

}

