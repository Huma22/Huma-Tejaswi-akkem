package com.hangman.main;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import com.hangman.main.WordGuess;

public class RecieveObject implements Runnable{

	
	private Socket socket;
	private WordGuess wordGuess;
	private ObjectInputStream ois;
	
	public RecieveObject(Socket socket, WordGuess wordGuess){
		this.socket=socket;
		this.wordGuess=wordGuess;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			ois= new ObjectInputStream(socket.getInputStream());

			wordGuess=(WordGuess) ois.readObject();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
