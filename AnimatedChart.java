package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.util.Collections;

public class AnimatedChart {

    private StackPane pane = new StackPane();
    public int year;
    private Text text = new Text();

    public Pane linechartAnimate(LineChart lineChart, Line line) {
        pane.getChildren().clear();

        EventHandler<ActionEvent> handler = e -> {
            pane.getChildren().clear();

            if (line.yearList.contains(year)) {
                text.setText(String.valueOf(year));

                pane.getChildren().addAll(lineChart.drawLineChart(line, year), text);

                pane.setLayoutX(100);
                pane.setPrefSize(1200, 500);
                //   System.out.println(year);

                this.year++;
            }


        };


        Timeline animation = new Timeline(new KeyFrame(Duration.millis(100), handler));
        animation.setAutoReverse(true);
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();


        return pane;

    }


    public StackPane barchartAnimate(BarChart barChart, Bar bar) {
        pane.getChildren().clear();
        EventHandler<ActionEvent> handler = e -> {

            pane.getChildren().clear();
            if (bar.yearList.contains(year)) {
                Collections.sort(bar.groupBar);
                text.setText(String.valueOf(year));

                pane.getChildren().addAll(barChart.drawBarChart(bar, year), text);
                pane.setLayoutX(100);

                pane.setPrefSize(1200, 500);
                year++;
            }
        };
        Timeline animation = new Timeline(new KeyFrame(Duration.millis(100), handler));

        animation.setAutoReverse(true);
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();

        return pane;

    }
}
