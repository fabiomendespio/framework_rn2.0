package utils;

import core.NeuralNetwork;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Graph {
    public List<Double> value;


    public Graph(List<Double> value) {
        this.value = value;
    }

    public double getMinValue() {
        double minValue = Double.MAX_VALUE;
        for (Double value : value) {
            minValue = Math.min(minValue, value);
        }
        return minValue;
    }

    public double getMaxValue() {
        double maxValue = Double.MIN_VALUE;
        for (Double value : value) {
            maxValue = Math.max(maxValue, value);
        }
        return maxValue;
    }

    public void Image() {
        BufferedImage report = new BufferedImage(800, 600, BufferedImage.TYPE_INT_RGB);
        Graphics2D render = (Graphics2D) report.getGraphics();

        // fundo da imagem
        render.setColor(Color.GRAY);
        render.fillRect(0,0,report.getWidth(), report.getHeight());

        // qquadrado branco
        render.setColor(Color.WHITE);
        render.fillRect(50, 50, report.getWidth() - 100, report.getHeight() - 100);

        // grade de linhas em x
        for (int i = 0; i < 10 + 1; i++) {
            if (value.size() > 0) {
                render.setColor(Color.lightGray);
                render.drawLine( 50, report.getHeight() - (((i * (report.getHeight() - 100)) / 10) + 50), report.getWidth() - 50, report.getHeight() - (((i * (report.getHeight() - 100)) / 10) + 50));
                  // escrevendo os numeros
//                render.setColor(Color.BLACK);
//                String yLabel = ((int) ((getMinValue() + (getMaxValue() - getMinValue()) * ((i * 1.0) / 10)) * 100)) / 100 + "";
//                FontMetrics metrics = render.getFontMetrics();
//                int labelWidth = metrics.stringWidth(yLabel);
//                render.drawString(yLabel, 50 - labelWidth - 5, report.getHeight() - ((i * (report.getHeight() - 75)) / 10 + 50) + (metrics.getHeight() / 2) - 3);
            }
        }

        // grade de linhas em y
        for (int i = 0; i < value.size(); i++) {
            if (value.size() > 1) {
                if ((i % ((int) ((value.size() / 20.0)) + 1)) == 0) {
                    render.setColor(Color.lightGray);
                    render.drawLine(i * (report.getWidth() - 100) / (value.size() - 1) + 50,  report.getHeight() - 50 , i * (report.getWidth() - 100) / (value.size() - 1) + 50, 50);
                    // escrevendo os numeros
//                    render.setColor(Color.BLACK);
//                    String xLabel = i + "";
//                    FontMetrics metrics = render.getFontMetrics();
//                    int labelWidth = metrics.stringWidth(xLabel);
//                    render.drawString(xLabel, i * (report.getWidth() - 100) / (value.size() - 1) + 50 - labelWidth / 2, report.getHeight() - 50 + metrics.getHeight() + 3);
                }
            }
        }

        // desenhando os eixos
        render.setColor(Color.BLACK);
        render.drawLine(50, report.getHeight() - 50, 50, 50); //eixo Y
        render.drawLine(50, report.getHeight() - 50, report.getWidth() - 50, report.getHeight() - 50); //eixo X

        // escala da imagem
        double xScale = ((double) report.getWidth() - 100) / (value.size() - 1);
        double yScale = ((double) report.getHeight() - 100) / (getMaxValue() - getMinValue());

        // array de pontos do grafico
        List<Point> Points = new ArrayList<>();
        for (int i = 0; i < value.size(); i++) {
            Points.add(new Point((int) (i * xScale + 50), (int) ((getMaxValue() - value.get(i)) * yScale + 50)));
        }

        // desenhando os pontos
        render.setColor(Color.RED);
        for (int i = 0; i < Points.size(); i++) {
            render.fillOval(Points.get(i).x - 5/2, Points.get(i).y - 5/2, 5, 5);
        }

        // desenhando as linhas entre os pontos
        render.setColor(Color.BLUE);
        for (int i = 0; i < Points.size() - 1; i++) {
            render.drawLine(Points.get(i).x, Points.get(i).y, Points.get(i + 1).x, Points.get(i + 1).y);
        }

        // salvando a imagem
        try {
            ImageIO.write(report, "PNG", new File("graph.png"));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    // metodo para gerar o grafico
    public static NeuralNetwork createGraph() {
        List<Double> value = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            value.add(random.nextDouble() * 20);
        }
        Graph graph = new Graph(value);
        graph.Image();
        return null;
    }
}
