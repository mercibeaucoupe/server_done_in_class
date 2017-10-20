package runner;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import model.Input;
import model.Output;

public class Runner {

	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(3000);
		    
		    System.out.println("Waiting for Connection...");

		    server.accept().getInputStream();
		    
		    server.close();
		    
		} catch (IOException e) {
			System.out.println("Many problems");
		}

	}

}
