package com.hangman.main;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

import com.hangman.main.WordGuess;

public class SendObject implements Runnable {

	
	private Socket socket;
	private WordGuess wordGuess;
	private ObjectOutputStream oos;
	public SendObject(Socket socket, WordGuess wordGuess){
		
		this.socket=socket;
		this.wordGuess=wordGuess;
		
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			oos= new ObjectOutputStream(socket.getOutputStream());

			oos.writeObject(wordGuess);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

}
