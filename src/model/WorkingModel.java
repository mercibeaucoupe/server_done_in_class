package model;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class WorkingModel {

	
	public static void server() {
		try {
			ServerSocket serverSocket = new ServerSocket(4000);
			Socket socket = serverSocket.accept();
			InputStream in = new FileInputStream("txt/outgoing.txt");
			OutputStream out = socket.getOutputStream();
			copy(in, out);
			out.close();
			in.close();
			socket.close();
			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void client() {
		try {
		    Socket socket = new Socket("localhost", 4000);
		    InputStream in = socket.getInputStream();
		    OutputStream out = new FileOutputStream("txt/incoming.txt");
		    copy(in, out);
		    in.close();
		    out.close();
		    socket.close();
		}
	}
	
	public static void copy(InputStream in, OutputStream out) {
		byte[] byteArr = new byte[16 * 1024];
		int length = 0;
		while ((len = in.read(byteArr)) != -1) {
			out.write(byteArr, 0, length);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
