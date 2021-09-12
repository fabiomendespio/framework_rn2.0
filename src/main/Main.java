package main;

import core.*;
import network.Mlp;
import network.Perceptron;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        //Perceptron
//        NeuralNetwork nn = new Perceptron(0.1, 1, 0);
//        nn.setStructure("input", 1, 2);
//        nn.setStructure("output", 1, 1);
//        double sample[] = {0, 1};
////        double sample2[] = {1, 0};
//        ArrayList<double[]> list = new ArrayList<>();
//        list.add(0, sample);
////        list.add(1, sample2);
////        list.add(2, sample3);
//        nn.setInputValues(list);
//        nn.connectNeuronIncludingWeigth(0);
//        nn.training();
//        nn.save("rede.rn");
//        NeuralNetwork teste = NeuralNetwork.load("rede.rn");
//        double sample3[] = {0, 1};
//        ArrayList<double[]> list2 = new ArrayList<>();
//        list2.add(0, sample3);
//        teste.setInputValues(list2);
//        teste.start();


        //MLP
        NeuralNetwork nn2 = new Mlp(0.1, 0, 0);
        nn2.setStructure("input", 1, 3);
        nn2.setStructure("hidden", 1, 2);
        nn2.setStructure("output", 1, 1);
        double sample3[] = {0, 1, 0};
        double sample4[] = {1, 0};
        ArrayList<double[]> list2 = new ArrayList<>();
        list2.add(0, sample3);
        list2.add(1, sample4);
        nn2.setInputValues(list2);
        nn2.connectNeuronIncludingWeigth(1);
        nn2.start();
    }
}
