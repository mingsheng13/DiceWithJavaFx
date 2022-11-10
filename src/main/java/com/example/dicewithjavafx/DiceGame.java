package com.example.dicewithjavafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;

public class DiceGame extends Application {
    Dice d1 = new Dice("Dice 1");
    Dice d2 = new Dice("Dice 2");
//    Dice d3 = new Dice("Dice 3");

    @Override
    public void start(Stage stage) throws IOException {
        //initialise game
        Game game = new Game(d1,d2);
//        game.addPlayer(d3);
        game.rollAllDices();

        //scoreboard(top)
        Font font = Font.loadFont(new FileInputStream("src/font/MinecraftRegular-Bmg3.otf"),20);
        Text p1 = new Text(d1.toString());
        p1.setFont(font);

        Text p2 = new Text(d2.toString());
        p2.setFont(font);

//        Text p3 = new Text(d3.toString());
//        p3.setFont(font);

        VBox scoreboard = new VBox(p1, p2); //add p3 here

        //button(centre)
        FileInputStream input = new FileInputStream("src/pics/dice.png");
        ImageView imgView = new ImageView((new Image(input)));
        imgView.setFitHeight(50);
        imgView.setFitWidth(50);
        Button rollButton = new Button("Roll Dice", imgView);
        rollButton.setFont(font);

        //status(bottom)
        Text status = new Text(game.getWinStatus());
        status.setFont(font);

        Text lastWin = new Text("Attempts since last win: "+ game.getLastWin());
        lastWin.setFont(font);

        Button exitButton = new Button("Exit");
        exitButton.setFont(font);
        VBox stats = new VBox(status, lastWin);
        HBox bottom = new HBox(stats, exitButton);
        bottom.setSpacing(50);

        //button actions
        rollButton.setOnAction(e ->
        {
            game.rollAllDices();
            p1.setText(d1.toString());
            p2.setText(d2.toString());
//            p3.setText(d3.toString());

            status.setText(game.getWinStatus());
            lastWin.setText("Attempts since last win: "+ game.getLastWin());
        });

        exitButton.setOnAction(e -> stage.close());

        //setting the scene
        BorderPane pane = new BorderPane();
        pane.setTop(scoreboard);
        pane.setCenter(rollButton);
        pane.setBottom(bottom);
        Scene scene = new Scene(pane, 480, 240);
        stage.setTitle("Dice game");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}