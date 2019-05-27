package Application.Run;

import Application.models.Offer;
import Application.models.User;
import Application.shop_database.shop;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	
    @Override
    public void start(Stage primaryStage) throws Exception{
    	uzupelnibaze(); //do testowania
        Parent root = FXMLLoader.load(getClass().getResource("../views/LogInView.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
    void uzupelnibaze() { 
    	shop baza = new shop();
       	User efgh = new User();
       	efgh.insertUser("Jan", "Kowalski", "96010112345", "Superuser", "Haslo");
       	Offer oferta = new  Offer();
       	oferta.insertOffer("Telefon", "Nokia",100);
    }
}

