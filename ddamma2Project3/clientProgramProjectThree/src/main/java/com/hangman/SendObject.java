package com.hangman;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;

import com.hangman.main.WordGuess;

public class SendObject implements Runnable {

	
	private Socket socket;
	private String wordGuess;
	private PrintWriter oos;
	public SendObject(Socket socket, String alphabets){
		
		this.socket=socket;
		this.wordGuess=alphabets;
		
		
	}
	@Override
	public void run() {
		try {
			oos=new PrintWriter(
			          socket.getOutputStream(), true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		oos.write(wordGuess);
		
	}

}
