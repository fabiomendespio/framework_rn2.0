package utils;

import network.Perceptron;

import java.util.ArrayList;

public class Report {
    private ArrayList<Perceptron> reports;

    public Report(ArrayList<Perceptron> reports) {
        this.reports = reports;
    }

    public ArrayList<Perceptron> getReports() {
        return reports;
    }

    public void setReports(ArrayList<Perceptron> reports) {
        this.reports = reports;
    }

    //Todo Jean - Desenvoler o front nessa função
    public static void report(ArrayList<Perceptron> r){
        r.size();

    }
}
