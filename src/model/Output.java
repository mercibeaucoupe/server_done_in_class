package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Output {
	
	public static void main(String[] args) {
		
		File file = new File("txt/outgoing.txt");
		clientConnectOut("10.1.1.169", 3000, file, "HELLO");
	}

	public static FileOutputStream createReadyFile(File file) {
		try {
		    FileOutputStream outputStream = new FileOutputStream(file);
		    return outputStream;
		} catch (IOException ex) {
			System.out.println("URL was unreachable, Try again!");
		}
		return null;
	}
	
    public static void clientConnectOut(String ipAddress, int portNo, File file, String message) {
    	
        try {
    	    Socket toServer = new Socket(ipAddress, portNo);
    	    toServer.getOutputStream();
    	    FileOutputStream fileWritter = createReadyFile(file);
    	    char[] charMessage = message.toCharArray();
    	    for (char character : charMessage) {
    	    	byte sendableMessage = (byte) character;
    	        fileWritter.write(sendableMessage);
    	    }
    	    fileWritter.close();
            toServer.close();
        } catch (IOException e) {
        	System.out.println("Ip Address was unreachable, Try Again!");
        }
    	
    }
}
