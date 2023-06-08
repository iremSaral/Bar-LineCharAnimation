package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        BarChart b2 = new BarChart("Population", "Value");
        LineChart l = new LineChart("Population", "Value");
        AnimatedChart animate = new AnimatedChart();
        FileAndChartChooser fileAndChartChooser = new FileAndChartChooser();
        Buttons buttonMaking = new Buttons();
        //For adding buttons to the scene creating buttons and calls the maker methods
        Button mainPlayButton = buttonMaking.playButtonMaker();
        Button mainStopButton = buttonMaking.stopButtonMaker();
        Button mainRestartButton = buttonMaking.restartButtonMaker();
        //For adding menus to the scene creating menus and calls the maker methods
        VBox vMainBoxFile = fileAndChartChooser.fileTypeChooser();
        VBox vMainBoxChart = fileAndChartChooser.chartChooser();
        //Creating root node and adding buttons and menus in it
        Pane root = new Pane();
        // root.setStyle("-fx-background-color: white ");
        root.getChildren().addAll(mainPlayButton, mainStopButton, mainRestartButton, vMainBoxChart, vMainBoxFile);
        vMainBoxChart.setLayoutX(100);
        vMainBoxChart.setLayoutY(500);
        vMainBoxFile.setLayoutX(50);
        vMainBoxFile.setLayoutY(500);

        EventHandler<ActionEvent> eventPlay = e -> {
            if (fileAndChartChooser.fileType.equals("xml")) {
                XmlFile xmlFile = new XmlFile();

                try {
                    xmlFile.decomposeXML();
                    animate.year=xmlFile.yearList.get(0);

                } catch (ParserConfigurationException | IOException | SAXException parserConfigurationException) {
                    parserConfigurationException.printStackTrace();
                }

                Bar bar = new Bar(xmlFile.countryList, xmlFile.categoryList, xmlFile.valueList, xmlFile.yearList);
                Line line = new Line(xmlFile.countryList, xmlFile.categoryList, xmlFile.valueList, xmlFile.yearList);
                if (fileAndChartChooser.chartType.equals("bar")) {

                    root.getChildren().addAll(animate.barchartAnimate(b2, bar));

                } else {


                    root.getChildren().add(animate.linechartAnimate(l, line));

                }
            } else {
                TxtFile txtFile = new TxtFile();
                txtFile.decompose_txt();
                animate.year=txtFile.yearList.get(0);
                Bar bar = new Bar(txtFile.nameList, txtFile.categoryList, txtFile.valueList, txtFile.yearList);
                Line line = new Line(txtFile.nameList, txtFile.categoryList, txtFile.valueList, txtFile.yearList);
                if (fileAndChartChooser.chartType.equals("bar")) {

                    root.getChildren().add(animate.barchartAnimate(b2, bar));


                } else {


                    root.getChildren().add(animate.linechartAnimate(l, line));

                }
            }

        };
//stop butonu başarısız.
        EventHandler<ActionEvent> eventStop = e -> {
            //animasyondaki stop kısmına gitcek
            //  buttonMaking.stop = "stop";
            //    System.out.println(buttonMaking.stop);
        };
        //when button pressed
        mainPlayButton.setOnAction(eventPlay);
        mainStopButton.setOnAction(eventStop);

        //Creating a scene setting it on the stage and showing them
        primaryStage.setTitle("Group43");
        primaryStage.setScene(new Scene(root, 1400, 600));
        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }
}
