package com.hangman.main;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
  
// Server class
public class Server extends Application{
    public static void main(String[] args)
    {
        launch(args);
    }
  
   

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		FXMLLoader loader= new FXMLLoader(Server.class.getResource("/fxml/ServerView.fxml"));
		AnchorPane pane= loader.load();
		ServerController contr= loader.getController();
		contr.setMain(this);
		Scene scene = new Scene(pane);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}