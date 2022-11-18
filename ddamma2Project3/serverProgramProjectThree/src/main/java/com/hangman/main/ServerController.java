package com.hangman.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ServerController {
	 // ClientHandler class
	
	
	
	 @FXML
	    private TextField portField;
@FXML
private TextArea serverLog;
	    @FXML
	    private Button listenButton;

		private int port=1234;

	    @FXML
	    void startListening(ActionEvent event) {
	    	if(portField.getText().isEmpty()!=true){
	    		port= Integer.parseInt(portField.getText());
	    		MyServerThread thread= new MyServerThread();
	    		new Thread(thread).start();
	    		listenButton.setText("Server Started!");
	    		listenButton.setDisable(true);
	    	}
	    }

	
	private class MyServerThread implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			startServer(port);
		}
		
	}
    private static class ClientHandler implements Runnable {
        private final Socket clientSocket;
		private ObjectOutputStream oos;
		private BufferedReader in;
		private ServerController serverController;
        // Constructor
        public ClientHandler(Socket socket,ServerController serverController)
        {
            this.clientSocket = socket;
            this.serverController=serverController;
        }
  
        public void run()
        {

  		try {

   		   oos = new ObjectOutputStream(clientSocket.getOutputStream());
			in = new BufferedReader(
			           new InputStreamReader(
			               clientSocket.getInputStream()));

        	Game gameObject= new Game(clientSocket,oos,in,serverController);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        	
        	
//            PrintWriter out = null;
//            BufferedReader in = null;
//            try {
//                    
//                  // get the outputstream of client
//                out = new PrintWriter(
//                    clientSocket.getOutputStream(), true);
//                out.println("Hello Client Please select The categories");
//                out.println("1- USA States\n");
//                out.println("2- Food\n");
//                out.println("3- Planets\n");
//                  // get the inputstream of client
//                in = new BufferedReader(
//                    new InputStreamReader(
//                        clientSocket.getInputStream()));
//  
//                String line;
//                while ((line = in.readLine()) != null) {
//  
//                    // writing the received message from
//                    // client
//                    System.out.printf(
//                        " Sent from the client: %s\n",
//                        line);
//                    out.println(line);
//                }
//            }
//            catch (IOException e) {
//                e.printStackTrace();
//            }
//            finally {
//                try {
//                    if (out != null) {
//                        out.close();
//                    }
//                    if (in != null) {
//                        in.close();
//                        clientSocket.close();
//                    }
//                }
//                catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
        }
    }
public void startServer(int port){
	ServerSocket server = null;
	  
    try {

        // server is listening on port 1234
        server = new ServerSocket(port);
        server.setReuseAddress(true);

        // running infinite loop for getting
        // client request
        while (true) {

            // socket object to receive incoming client
            // requests
            Socket client = server.accept();

            // Displaying that new client is connected
            // to server
            logToServer("New client connected"
                               + client.getInetAddress()
                                     .getHostAddress());

            // create a new thread object
            ClientHandler clientSock
                = new ClientHandler(client,this);

            // This thread will handle the client
            // separately
            new Thread(clientSock).start();
        }
    }
    catch (IOException e) {
        e.printStackTrace();
    }
    finally {
        if (server != null) {
            try {
                server.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
public void setMain(Server server) {
	// TODO Auto-generated method stub
	serverLog.setText("");
	
}
public void logToServer(String log){
	StringBuilder s= new StringBuilder();
	s.append(serverLog.getText()+"\n");
	s.append(log);
	serverLog.setText(s.toString());
}
}
