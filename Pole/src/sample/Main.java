package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("polembf.fxml"));
        primaryStage.setTitle("Поле чудес");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);



    String host = (args.length < 1) ? null : args[0];

        try {
        Registry registry = LocateRegistry.getRegistry(1111);
        Game stub = (Game) registry.lookup("Game1");


        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
}}}
