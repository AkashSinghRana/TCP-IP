import java.net.*;
import java.io.*;
import java.util.Date;
public class EchoServer{
	public static void main(String[] args) throws IOException{
		// create serverSock object
		ServerSocket serverSock = null;
		//  Instantiate server link object on a port
		try{
			serverSock = new ServerSocket(50000);
		}
		//In case connection was unsuccesful
		catch (IOException ie){
			System.out.println("Can't listen on 50000");
			System.exit(1);
		}
		// Connection is successful so we create a client socket and print out the message
		Socket link = null;
		System.out.println("Listening for connection ...");
		// accepting the connection request
		try {
			link = serverSock.accept();
		}
		catch (IOException ie){
			System.out.println("Accept failed");
			System.exit(1);
		}
		// If connection is successful so we display that the server is listening for input
		System.out.println("Connection successful");
		System.out.println("Listening for input ...");
		// we take input
		PrintWriter output = new PrintWriter(link.getOutputStream(), true);
		BufferedReader input = new BufferedReader(new InputStreamReader(link.getInputStream()));
		String inputLine;
		while ((inputLine = input.readLine())!=null){
			if(inputLine.equalsIgnoreCase("What time is it"))
			{
				output.println(new Date().toString());
			}
			System.out.println("Server: " + inputLine);
			output.println(inputLine);
			if(inputLine.equals("Bye")){
				break;
			}
		}
		output.close();
		input.close();
		link.close();
		serverSock.close();
	}
}
