package utils;

import java.util.ArrayList;

public class Data {

    //Dados iniciais
    private ArrayList<double[]> samplesValues;
    private ArrayList<Double> initWeightsValues;
    private double learningRateValue;
    private double predictValue;
    private double biasValue;
    private String typeName;
    private int numberLayer;
    private int numberneuron;
    //Dados de execução do treinamento
    //Feedfoward
    private ArrayList<Double> inputsValues;
    private ArrayList<Double> weightsInputValue;
    private double sumValue;
    private double outputValue;
    private boolean predictStatus;
    //Backpropagation
    private double errorValue;
    private ArrayList<Double> deltaWeightsValues;
    private ArrayList<Double> newWeightsValues;
    private double deltaBias;
    private double newBias;

    public ArrayList<double[]> getSamplesValues() {
        return samplesValues;
    }

    public void setSamplesValues(ArrayList<double[]> samplesValues) {
        this.samplesValues = samplesValues;
    }

    public ArrayList<Double> getInitWeightsValues() {
        return initWeightsValues;
    }

    public void setInitWeightsValues(ArrayList<Double> initWeightsValues) {
        this.initWeightsValues = initWeightsValues;
    }

    public double getLearningRateValue() {
        return learningRateValue;
    }

    public void setLearningRateValue(double learningRateValue) {
        this.learningRateValue = learningRateValue;
    }

    public double getPredictValue() {
        return predictValue;
    }

    public void setPredictValue(double predictValue) {
        this.predictValue = predictValue;
    }

    public double getBiasValue() {
        return biasValue;
    }

    public void setBiasValue(double biasValue) {
        this.biasValue = biasValue;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public int getNumberLayer() {
        return numberLayer;
    }

    public void setNumberLayer(int numberLayer) {
        this.numberLayer = numberLayer;
    }

    public int getNumberneuron() {
        return numberneuron;
    }

    public void setNumberneuron(int numberneuron) {
        this.numberneuron = numberneuron;
    }

    public ArrayList<Double> getInputsValues() {
        return inputsValues;
    }

    public void setInputsValues(ArrayList<Double> inputsValues) {
        this.inputsValues = inputsValues;
    }

    public ArrayList<Double> getWeightsInputValue() {
        return weightsInputValue;
    }

    public void setWeightsInputValue(ArrayList<Double> weightsInputValue) {
        this.weightsInputValue = weightsInputValue;
    }

    public double getSumValue() {
        return sumValue;
    }

    public void setSumValue(double sumValue) {
        this.sumValue = sumValue;
    }

    public double getOutputValue() {
        return outputValue;
    }

    public void setOutputValue(double outputValue) {
        this.outputValue = outputValue;
    }

    public boolean isPredictStatus() {
        return predictStatus;
    }

    public void setPredictStatus(boolean predictStatus) {
        this.predictStatus = predictStatus;
    }

    public double getErrorValue() {
        return errorValue;
    }

    public void setErrorValue(double errorValue) {
        this.errorValue = errorValue;
    }

    public ArrayList<Double> getDeltaWeightsValues() {
        return deltaWeightsValues;
    }

    public void setDeltaWeightsValues(ArrayList<Double> deltaWeightsValues) {
        this.deltaWeightsValues = deltaWeightsValues;
    }

    public ArrayList<Double> getNewWeightsValues() {
        return newWeightsValues;
    }

    public void setNewWeightsValues(ArrayList<Double> newWeightsValues) {
        this.newWeightsValues = newWeightsValues;
    }

    public double getDeltaBias() {
        return deltaBias;
    }

    public void setDeltaBias(double deltaBias) {
        this.deltaBias = deltaBias;
    }

    public double getNewBias() {
        return newBias;
    }

    public void setNewBias(double newBias) {
        this.newBias = newBias;
    }

    @Override
    public String toString() {
        return "Data{" +
                "samplesValues=" + samplesValues +
                ", initWeightsValues=" + initWeightsValues +
                ", learningRateValue=" + learningRateValue +
                ", predictValue=" + predictValue +
                ", biasValue=" + biasValue +
                ", typeName='" + typeName + '\'' +
                ", numberLayer=" + numberLayer +
                ", numberneuron=" + numberneuron +
                ", inputsValues=" + inputsValues +
                ", weightsInputValue=" + weightsInputValue +
                ", sumValue=" + sumValue +
                ", outputValue=" + outputValue +
                ", predictStatus=" + predictStatus +
                ", errorValue=" + errorValue +
                ", deltaWeightsValues=" + deltaWeightsValues +
                ", newWeightsValues=" + newWeightsValues +
                ", deltaBias=" + deltaBias +
                ", newBias=" + newBias +
                '}';
    }
}