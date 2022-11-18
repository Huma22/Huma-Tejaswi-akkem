package application.controller;

import application.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class MainController {

    @FXML
    private TextField textfield1;

    @FXML
    private TextField textfield2;

    @FXML
    private Button btn1;

    @FXML
    private Button btn2;

	private Main main;

	public void setMain(Main main) {
		// TODO Auto-generated method stub
		this.main=main;
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				String secondString=": from the center text field!";
				String firstString=textfield1.getText();
				textfield2.setText(firstString+secondString);
				btn1.setDisable(true);
				btn1.setText("pressed");
			}
		});
		btn2.setOnAction(event->{
			textfield1.clear();
			textfield2.setText("final string goes here");
			btn1.setDisable(false);
			btn1.setText("button 1");
		});
	}

}