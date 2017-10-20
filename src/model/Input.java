package model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Input {
	
	
	public static void main(String[] args) {
		try {
		    reader(new Socket("10.1.1.169", 3000));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
     public static void reader(Socket socket) {
    	 int count = 0;
    	 try {
    	     InputStream in = socket.getInputStream();
    	     char[] characterHolder = new char[16 * 1024];
    	     int[] messageInt = new int[16 * 1024];
    	     byte[] messageByte = new byte[16 * 1024];
    	     while (count <= characterHolder.length) {
    		     messageInt[count++] = in.read();
    	     }
    	     int secondCount = 0;
    	     for (int num : messageInt) {
    	    	 byte holder = (byte) num;
    	    	 char finalHolder = (char) holder;
    	    	 characterHolder[secondCount++] = finalHolder;
    	     }
             
    	     File outFile = new File("txt/Incomingmessage.txt");
    	     FileOutputStream outting = new FileOutputStream(outFile);
    	     for (byte temp : messageByte) {
    	         outting.write(temp);
    	     }
    	     in.close();
    	     outting.close();
    	     socket.close();
    	     
    	 } catch (IOException e) {
    		 System.out.println("Cannot Find the Port.");
    	 }
     }
}
