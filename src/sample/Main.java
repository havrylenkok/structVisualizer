package sample;

import javafx.animation.*;
import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.sql.Time;

public class Main extends Application {
    public static final double W = 200; // canvas dimension
    public static final double H = 200;

    public  static final double D = 20; // diameter

    @Override
    public void start(Stage primaryStage) throws Exception{
//        final DoubleProperty x = new SimpleDoubleProperty();
//        final DoubleProperty y = new SimpleDoubleProperty();
//
//        Timeline timeline = new Timeline(
//                new KeyFrame(Duration.seconds(0),
//                        new KeyValue(x, 0),
//                        new KeyValue(y, 0)
//                        ),
//                new KeyFrame(Duration.seconds(3),
//                        new KeyValue(x, W - D),
//                        new KeyValue(y, H - D)
//                )
//        );
//        timeline.setAutoReverse(true);
//        timeline.setCycleCount(Timeline.INDEFINITE);
//
//        final Canvas canvas = new Canvas(W, H);
//        AnimationTimer timer = new AnimationTimer() {
//            @Override
//            public void handle(long now) {
//                GraphicsContext gc = canvas.getGraphicsContext2D();
//                gc.setFill(Color.CORNSILK);
//                gc.fillRect(0, 0, W, H);
//                gc.setFill(Color.FORESTGREEN);
//                gc.fillOval(
//                        x.doubleValue(),
//                        y.doubleValue(),
//                        D,
//                        D
//                );
//            }
//        };
//
//        primaryStage.setScene(
//                new Scene(
//                        new Group(
//                                canvas
//                        )
//                )
//        );
//        primaryStage.show();
//        timer.start();
//        timeline.play();



        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root));
        primaryStage.setMinWidth(820);
        primaryStage.setMinHeight(620);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
