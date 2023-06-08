package sample;

import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.VBox;

public class LineChart extends Chart {

    public LineChart(String title, String xAxisLabel) {
        super(title, xAxisLabel);
    }

    public javafx.scene.chart.LineChart<String, Number> createBasicLineChart() {
        //Create basic BarChart
        final NumberAxis numberAxis = new NumberAxis();//value
        final CategoryAxis categoryAxis = new CategoryAxis();//Country
        numberAxis.setLabel(xAxisLabel);
        categoryAxis.setLabel("Country");
        final javafx.scene.chart.LineChart<String, Number> lineChart = new javafx.scene.chart.LineChart<String, Number>(categoryAxis, numberAxis);
        lineChart.setTitle(title);
        numberAxis.setAnimated(false);
        categoryAxis.setAnimated(false);
        return lineChart;
    }

    public VBox drawLineChart(Line line, int year) {
        javafx.scene.chart.LineChart lineChart = createBasicLineChart();
        for (int i = 0; i < line.categoryList.size(); i++) {
            XYChart.Series series = new XYChart.Series();
            series.setName(line.categoryList.get(i));
            for (int j = 0; j < line.groupLine.size(); j++) {
                if (line.groupLine.get(j).category.equals(line.categoryList.get(i)) && line.groupLine.get(j).year == year) {
                    series.getData().add(new XYChart.Data(line.groupLine.get(j).country, line.groupLine.get(j).value));

                }

            }
            lineChart.getData().add(series);
        }
        VBox vBox = new VBox();
        vBox.getChildren().addAll(lineChart);
        return vBox;

    }
}
