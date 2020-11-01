/**
 * Modified DateClient so that it requests a haiku
 * from the haiku server.
 *
 * @author Gagne, Galvin, Silberschatz
 * Operating System Concepts  - Ninth Edition
 * Copyright John Wiley & Sons - 2013
 */
 
import java.net.*;
import java.io.*;

public class HaikuClient
{
	static final int PORT  = 5575;
	static final String HOST = "127.0.0.1";
	public static void main(String[] args) throws IOException {
		InputStream in = null;
		BufferedReader bin = null;
		Socket sock = null;

		try {
			sock = new Socket(HOST,PORT);

			//Send to Server
			PrintWriter pr = new PrintWriter(sock.getOutputStream());
			pr.println("Hi Server");
			pr.flush();

			//Recieved from server
			bin = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			System.out.println("Server:");
			String str = "";

			while((str = bin.readLine()) != null){
				System.out.println(str);
			}
		}
		catch (IOException ioe) {
				System.err.println(ioe);
		}
		finally {
			sock.close();
		}
	}
}
