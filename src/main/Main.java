package main;

import core.*;
import network.Mlp;
import network.Perceptron;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        //Perceptron
//        NeuralNetwork nn = new Perceptron(0.1, 1, 0);
//        nn.setStructure("input", 1, 4);
//        nn.setStructure("output", 1, 1);
//        double sample[] = {0, 1, 0, 0};
//        double sample2[] = {1, 0, 1, 0};
////        double sample3[] = {0, 0, 0};
//        ArrayList<double[]> list = new ArrayList<>();
//        list.add(0, sample);
//        list.add(1, sample2);
////        list.add(2, sample3);
//        nn.setInputValues(list);
//        nn.connectNeuronIncludingWeigth(0); //Todo verificar os pesos
////        double[][] weightInput = {{0.5, 1.5}, {0.4, 0.7}, {0.2, 0.8}};
////        double[][] weightHidden = {{0.3, 0.2}, {0.1, 0.5}};
////        nn.setInputWeights(weightInput);
////        nn.setHiddenWeights(weightHidden);
////        nn.sigmoidFunction();
//        nn.start();

        //MLP
        NeuralNetwork nn2 = new Mlp(0.1, 0, 0);
        nn2.setStructure("input", 1, 2);
        nn2.setStructure("hidden", 1, 2);
        nn2.setStructure("output", 1, 1);
        double sample3[] = {0, 1};
        double sample4[] = {1, 0};
        ArrayList<double[]> list2 = new ArrayList<>();
        list2.add(0, sample3);
        list2.add(1, sample4);
        nn2.setInputValues(list2);
        //Todo classificação dos pesos
//        weightInput = [(x1w1= 0.5, x1w2= 1.5), (x2w3= 0.4, x2w4= 0.7), (x3w5= 0.2, x3w6= 0.8)];
//        weightHidden = [(x4w7= 0.3, x4w8= 0.2), (x5w9= 0.1, x5w10= 0.5)];
        nn2.connectNeuronIncludingWeigth(1);
        nn2.start();

    }
}
