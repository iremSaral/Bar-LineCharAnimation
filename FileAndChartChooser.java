package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import javax.swing.JFileChooser;
import java.io.File;

public class FileAndChartChooser {

    String fileType;
    String chartType;

    public VBox fileTypeChooser() {
        //Creating the menu button to choose the file
        MenuButton fileChooser;

        fileChooser = new MenuButton("Choose the file type");

        fileChooser.setStyle("-fx-background-color: purple");
        fileChooser.setTextFill(Color.WHITE);
        fileChooser.setFont(Font.font(15));

        //Creating the file options and adding in menu button
        MenuItem fileChooserItem1 = new MenuItem(".xml file");
        MenuItem fileChooserItem2 = new MenuItem(".txt file");
        fileChooser.getItems().addAll(fileChooserItem1, fileChooserItem2);
        EventHandler<ActionEvent> eventxml = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {

                //decompose xml
                fileType = "xml";

                chartChooser();
                //bar veya line chart seçimi için gönderilcek
            }
        };
        fileChooserItem1.setOnAction(eventxml);

        EventHandler<ActionEvent> eventtxt = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                fileType = "txt";
                chartChooser();

                //bar veya line chart seçimi yapılması için diğer metoda gönderilcek
            }
        };

        fileChooserItem2.setOnAction(eventtxt);
        VBox vBoxForFiles = new VBox();
        vBoxForFiles.getChildren().add(fileChooser);

        return vBoxForFiles;
    }

    public VBox chartChooser() {
        //Creating the chart options
        MenuItem chartChooserItem1 = new MenuItem("Bar Chart");
        MenuItem chartChooserItem2 = new MenuItem("Line Chart");
        //Creating the menu button to choose the chart type and adding them in it
        MenuButton chartChooser = new MenuButton("Choose the chart type", null, chartChooserItem1, chartChooserItem2);
        chartChooser.setStyle("-fx-background-color: purple");
        chartChooser.setTextFill(Color.WHITE);
        chartChooser.setFont(Font.font(15));

        EventHandler<ActionEvent> eventForBar = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {

                //Bar chart çizdirme
                chartType = "bar";

            }
        };
        chartChooserItem1.setOnAction(eventForBar);

        EventHandler<ActionEvent> eventForLine = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {

                //Line chart çizdirme
                chartType = "line";

            }
        };
        chartChooserItem2.setOnAction(eventForLine);
        chartChooser.setTranslateX(150.0);
        VBox vBoxForCharts = new VBox();
        vBoxForCharts.getChildren().add(chartChooser);
        return vBoxForCharts;

    }

    public String getFileName() {

        JFileChooser fileChooser = new JFileChooser();
        File selectedFile = null;
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = fileChooser.showOpenDialog(fileChooser.getParent());
        if (result == JFileChooser.APPROVE_OPTION) {
            selectedFile = fileChooser.getSelectedFile();
            //System.out.println("Selected file: " + selectedFile.getAbsolutePath());

        }
        return selectedFile.getAbsolutePath();
    }

}
