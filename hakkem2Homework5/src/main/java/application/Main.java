package application;

import java.io.IOException;
import application.controller.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	private Stage primaryStage;

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		this.primaryStage= primaryStage;
		openMainWindow();
		
	}

	private void openMainWindow() {
		// TODO Auto-generated method stub
		try {
			FXMLLoader loader= new FXMLLoader(Main.class.getResource("view/MainWindowView.fxml"));
			BorderPane pane= loader.load();
			MainController contr= loader.getController();
			contr.setMain(this);
			Scene scene= new Scene(pane);
			scene.getStylesheets().add("css/MainStyle.css");
			primaryStage.setScene(scene);
			///Type your name here below
			primaryStage.setTitle("Huma Tejaswi Akkem Homework 5");
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
