package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.io.FileNotFoundException;

public class Buttons {

    public Button playButtonMaker() throws FileNotFoundException {
        //Creating the button
        Button playButton = new Button();
        playButton.setText("Play");
        playButton.setFont(Font.font(15));
        playButton.setStyle("-fx-background-color: purple");
        playButton.setTextFill(Color.WHITE);

        playButton.setTranslateX(1200.0);
        playButton.setTranslateY(500);
        //returns the button to the main for show on the screen
        return playButton;
    }

    public Button stopButtonMaker() throws FileNotFoundException {
        //Creating the button
        Button stopButton = new Button();
        stopButton.setText("Stop");
        stopButton.setFont(Font.font(15));
        stopButton.setStyle("-fx-background-color: purple");
        stopButton.setTextFill(Color.WHITE);

        stopButton.setTranslateX(1260);
        stopButton.setTranslateY(500);
        //returns the button to the main for show on the screen
        return stopButton;
    }

    public Button restartButtonMaker() throws FileNotFoundException {
        //Creating the button
        Button restartButton = new Button();
        restartButton.setText("Restart");
        restartButton.setFont(Font.font(15));
        restartButton.setStyle("-fx-background-color: purple");
        restartButton.setTextFill(Color.WHITE);
        //Setting the event that occurs when this button worked
        EventHandler<ActionEvent> eventRestart = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                // System.out.println(12);
                //animasyondaki tekrar başlatma kısmına gitcek
            }
        };
        //when button pressed
        restartButton.setOnAction(eventRestart);
        restartButton.setTranslateX(1320.0);
        restartButton.setTranslateY(500);
        //returns the button to the main for show on the screen
        return restartButton;
    }
}
