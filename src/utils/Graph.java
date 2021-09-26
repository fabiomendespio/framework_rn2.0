import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Graph {
    private int width = 800;
    private int heigth = 400;
    private int padding = 25;
    private int labelPadding = 25;
    private Color lineColor = new Color(44, 102, 230, 180);
    private Color pointColor = new Color(100, 100, 100, 180);
    private Color gridColor = new Color(200, 200, 200, 200);
    private static final Stroke GRAPH_STROKE = new BasicStroke(2f);
    private int pointWidth = 4;
    private int numberYDivisions = 10;
    private List<Double> scores;

    public Graph(List<Double> scores) {
        this.scores = scores;
    }

    protected void paintComponent() {
        BufferedImage report = new BufferedImage(800, 600, BufferedImage.TYPE_INT_RGB);
        Graphics2D render = (Graphics2D) report.getGraphics();
        render.setColor(Color.GRAY);
        render.fillRect(0,0,report.getWidth(), report.getHeight());

        double xScale = ((double) report.getWidth() - (2 * padding) - labelPadding) / (scores.size() - 1);
        double yScale = ((double) report.getHeight() - 2 * padding - labelPadding) / (getMaxScore() - getMinScore());

        List<Point> graphPoints = new ArrayList<>();
        for (int i = 0; i < scores.size(); i++) {
            int x1 = (int) (i * xScale + padding + labelPadding);
            int y1 = (int) ((getMaxScore() - scores.get(i)) * yScale + padding);
            graphPoints.add(new Point(x1, y1));
        }

        // draw white background
        render.setColor(Color.WHITE);
        render.fillRect(padding + labelPadding, padding, report.getWidth() - (2 * padding) - labelPadding, report.getHeight() - 2 * padding - labelPadding);
        render.setColor(Color.BLACK);

        // create hatch marks and grid lines for y axis.
        for (int i = 0; i < numberYDivisions + 1; i++) {
            int x0 = padding + labelPadding;
            int x1 = pointWidth + padding + labelPadding;
            int y0 = report.getHeight() - ((i * (report.getHeight() - padding * 2 - labelPadding)) / numberYDivisions + padding + labelPadding);
            int y1 = y0;
            if (scores.size() > 0) {
                render.setColor(gridColor);
                render.drawLine(padding + labelPadding + 1 + pointWidth, y0, report.getWidth() - padding, y1);
                render.setColor(Color.BLACK);
                String yLabel = ((int) ((getMinScore() + (getMaxScore() - getMinScore()) * ((i * 1.0) / numberYDivisions)) * 100)) / 100 + "";
                FontMetrics metrics = render.getFontMetrics();
                int labelWidth = metrics.stringWidth(yLabel);
                render.drawString(yLabel, x0 - labelWidth - 5, y0 + (metrics.getHeight() / 2) - 3);
            }
            render.drawLine(x0, y0, x1, y1);
        }

        // and for x axis
        for (int i = 0; i < scores.size(); i++) {
            if (scores.size() > 1) {
                int x0 = i * (report.getWidth() - padding * 2 - labelPadding) / (scores.size() - 1) + padding + labelPadding;
                int x1 = x0;
                int y0 = report.getHeight() - padding - labelPadding;
                int y1 = y0 - pointWidth;
                if ((i % ((int) ((scores.size() / 20.0)) + 1)) == 0) {
                    render.setColor(gridColor);
                    render.drawLine(x0, report.getHeight() - padding - labelPadding - 1 - pointWidth, x1, padding);
                    render.setColor(Color.BLACK);
                    String xLabel = i + "";
                    FontMetrics metrics = render.getFontMetrics();
                    int labelWidth = metrics.stringWidth(xLabel);
                    render.drawString(xLabel, x0 - labelWidth / 2, y0 + metrics.getHeight() + 3);
                }
                render.drawLine(x0, y0, x1, y1);
            }
        }

        // create x and y axes
        render.drawLine(padding + labelPadding, report.getHeight() - padding - labelPadding, padding + labelPadding, padding);
        render.drawLine(padding + labelPadding, report.getHeight() - padding - labelPadding, report.getWidth() - padding, report.getHeight() - padding - labelPadding);

        Stroke oldStroke = render.getStroke();
        render.setColor(lineColor);
        render.setStroke(GRAPH_STROKE);
        for (int i = 0; i < graphPoints.size() - 1; i++) {
            int x1 = graphPoints.get(i).x;
            int y1 = graphPoints.get(i).y;
            int x2 = graphPoints.get(i + 1).x;
            int y2 = graphPoints.get(i + 1).y;
            render.drawLine(x1, y1, x2, y2);
        }

        render.setStroke(oldStroke);
        render.setColor(pointColor);
        for (int i = 0; i < graphPoints.size(); i++) {
            int x = graphPoints.get(i).x - pointWidth / 2;
            int y = graphPoints.get(i).y - pointWidth / 2;
            int ovalW = pointWidth;
            int ovalH = pointWidth;
            render.fillOval(x, y, ovalW, ovalH);
        }

        try {
            ImageIO.write(report, "PNG", new File("report.png"));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    private double getMinScore() {
        double minScore = Double.MAX_VALUE;
        for (Double score : scores) {
            minScore = Math.min(minScore, score);
        }
        return minScore;
    }

    private double getMaxScore() {
        double maxScore = Double.MIN_VALUE;
        for (Double score : scores) {
            maxScore = Math.max(maxScore, score);
        }
        return maxScore;
    }

    public static void createAndShowGui() {
        List<Double> scores = new ArrayList<>();
        Random random = new Random();
        int maxDataPoints = 10;
        int maxScore = 20;
        for (int i = 0; i < maxDataPoints; i++) {
            scores.add((double) random.nextDouble() * maxScore);
        }
        Graph graph = new Graph(scores);
        graph.paintComponent();
    }
}
