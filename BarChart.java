package sample;

import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class BarChart extends Chart {

    public BarChart(String title, String xAxisLabel) {
        super(title, xAxisLabel);
    }

    public javafx.scene.chart.BarChart createBasicBarChart() {
        //Create basic BarChart
        final NumberAxis numberAxis = new NumberAxis();//value
        final CategoryAxis categoryAxis = new CategoryAxis();//Country
        numberAxis.setLabel(xAxisLabel);
        categoryAxis.setLabel("Country");
        final javafx.scene.chart.BarChart<String, Integer> barChart = new javafx.scene.chart.BarChart(categoryAxis, numberAxis);
        barChart.setCategoryGap(0.0);
        barChart.setBarGap(0.0);
        barChart.setTitle(title);
        numberAxis.setAnimated(false);
        categoryAxis.setAnimated(false);
        return barChart;
    }

    public VBox drawBarChart(Bar bar, int year) {

        final javafx.scene.chart.BarChart barChart = createBasicBarChart();//BarChart ekranı olusturur
        Label lbl = new Label();
        for (int k = 0; k < bar.categoryList.size(); k++) {

            XYChart.Series series = new XYChart.Series();
            series.setName(bar.categoryList.get(k));

            for (int j = 0; j < bar.groupBar.size(); j++) {
                if (bar.groupBar.get(j).category.equals(bar.categoryList.get(k)) && bar.groupBar.get(j).year == year) {
                    series.getData().add(new XYChart.Data(bar.groupBar.get(j).country, bar.groupBar.get(j).value));

                }
            }
            barChart.getData().addAll(series);
        }

        VBox vBox = new VBox();
        vBox.getChildren().addAll(barChart);
        return vBox;
}
}
