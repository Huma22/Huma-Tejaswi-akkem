package com.hangman;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import com.hangman.controller.CategoryController;
import com.hangman.controller.GameController;
import com.hangman.controller.LostController;
import com.hangman.controller.MainController;
import com.hangman.controller.WonGameController;
import com.hangman.main.WordGuess;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
  
// Client class
public class Main extends Application{
    private Socket socket;
    // driver code
    public static void main(String[] args)
    {
    	launch(args);
    }

	private Stage primaryStage;
	private ObjectInputStream os;
	private PrintWriter out;

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		this.primaryStage= primaryStage;
		setConnection();
		mainWindow(os,out);
	}
	
	public void mainWindow(ObjectInputStream os,PrintWriter out) throws IOException{
		FXMLLoader loader= new FXMLLoader(Main.class.getResource("/fxml/MainScreen.fxml"));
		AnchorPane pane= loader.load();
		MainController contr= loader.getController();
		contr.setMain(this,os,out);
		Scene scene= new Scene(pane);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public void endGameWindow(ObjectInputStream os,PrintWriter out,WordGuess wordGuess) throws IOException{
		System.out.println("Openieninsin");
		FXMLLoader loader= new FXMLLoader(Main.class.getResource("/fxml/GameWin.fxml"));
		AnchorPane pane= loader.load();
		WonGameController contr= loader.getController();
		contr.setMain(this,os,out,wordGuess);
		Scene scene= new Scene(pane);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public void categoryWindow(ObjectInputStream os,PrintWriter out, WordGuess wordGuess) throws IOException{
		
		FXMLLoader loader = new FXMLLoader(Main.class.getResource("/fxml/CategoryScreen.fxml"));
		AnchorPane pane= loader.load();
		CategoryController contr= loader.getController();
		contr.setMain(this,socket,os,out,wordGuess);
		Scene scene= new Scene(pane);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public void gameWindow(WordGuess guess, ObjectInputStream os,PrintWriter out) throws IOException{
		FXMLLoader loader = new FXMLLoader(Main.class.getResource("/fxml/GameScreen.fxml"));
		AnchorPane pane= loader.load();
		GameController contr= loader.getController();
		contr.setMain(this,socket,guess,os,out);
		Scene scene= new Scene(pane);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

	public void setConnection(){
	    // establish a connection by providing host and port
        // number
    	
        try  {
        	socket = new Socket("localhost", 1234);
        	
     			

   			 this.os = new ObjectInputStream(socket.getInputStream());
   			this.out = new PrintWriter(
   			            socket.getOutputStream(), true);
   			
   	
     		
            // writing to server
//            PrintWriter out = new PrintWriter(
//                socket.getOutputStream(), true);
//            // reading from server
//            BufferedReader in
//                = new BufferedReader(new InputStreamReader(
//                    socket.getInputStream()));
//            System.out.println(in.readLine());
            
            // object of scanner class
//            Scanner sc = new Scanner(System.in);
//            String line = null;
//  
//            while (!"exit".equalsIgnoreCase(line)) {
//                
//                // reading from user
//                line = sc.nextLine();
//  
//                // sending the user input to server
//                out.println(line);
//                out.flush();
//  
//                // displaying server reply
//                System.out.println("Server replied "
//                                   + in.readLine());
//            }
//            
            // closing the scanner object
//            sc.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
	}

	public void quitGame() {
		primaryStage.close();
		// TODO Auto-generated method stub
		
	}
}