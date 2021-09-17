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
        //Perceptron start
//        NeuralNetwork perceptron = NeuralNetwork.load("rede-perceptron.rn");
//        double sample3[] = {0, 1};
//        ArrayList<double[]> list2 = new ArrayList<>();
//        list2.add(0, sample3);
//        perceptron.setInputValues(list2);
//        perceptron.start();


        //MLP treinamento
//        NeuralNetwork nn2 = new Mlp(0.1, 0, 0);
//        nn2.setStructure("input", 1, 2);
//        nn2.setStructure("hidden", 1, 2);
//        nn2.setStructure("output", 1, 1);
//        double sample3[] = {0, 1};
//        double sample4[] = {1, 0};
//        ArrayList<double[]> list2 = new ArrayList<>();
//        list2.add(0, sample3);
//        list2.add(1, sample4);
//        nn2.setInputValues(list2);
//        nn2.connectNeuronIncludingWeigth(1);
//        nn2.training();
//        nn2.save("rede-mlp.rn");
        //MLP start
        NeuralNetwork mlp = NeuralNetwork.load("rede-mlp.rn");
        double input[] = {0, 1};
        double input2[] = {0, 0};
        ArrayList<double[]> inputs = new ArrayList<>();
        inputs.add(0, input);
        mlp.setInputValues(inputs);
        mlp.start();

        String teste =
                "<!DOCTYPE html>" +
                        "<html lang='en'>" +
                        "<head>" +
                        "<meta charset='UTF-8'>" +
                        "<meta http-equiv='X-UA-Compatible' content='IE=edge'>" +
                        "<meta name='viewport' content='width=device-width, initial-scale=1.0'>" +
                        "<title>Document</title>" +
                        "</head>" +
                        "<body>" +
                        "<h1>Hello World!</h1>" +
                        "</body>" +
                        "</html>";
    }
}
