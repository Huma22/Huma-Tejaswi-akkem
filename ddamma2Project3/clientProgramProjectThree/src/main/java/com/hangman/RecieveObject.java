package com.hangman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.net.Socket;

import com.hangman.main.WordGuess;

public class RecieveObject implements Runnable{

	
	private Socket socket;
	private WordGuess wordGuess;
	private BufferedReader ois;
	
	public RecieveObject(Socket socket, WordGuess wordGuess){
		this.socket=socket;
		this.wordGuess=wordGuess;

		try {
			ois=new BufferedReader(
			       new InputStreamReader(
			               socket.getInputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			
			System.out.println(ois.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
