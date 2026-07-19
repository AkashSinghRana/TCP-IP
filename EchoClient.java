import java.io.*;
import java.net.*;
public class EchoClient{
	public static void main(String[] args) throws IOException{
		//initializing a socket link object  and printwriter object as null
		Socket link = null;
		PrintWriter output = null;
		BufferedReader input = null;
		// creating the link object which uses machine IP address
		try{
			link = new Socket("127.0.0.1", 50000);
			output = new PrintWriter(link.getOutputStream(), true);
			input = new BufferedReader(new InputStreamReader(link.getInputStream()));
		}
		//catch exception
		catch(UnknownHostException e)
		{
			System.out.println("Unknown Host");
			System.exit(1);
		}
		catch (IOException e){
			System.out.println("Cannot connect to host");
			System.exit(1);
		}
		// send and retrieve data
		BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
		String usrInput;
		while ((usrInput = stdIn.readLine())!=null){
			output.println(usrInput);
			System.out.println("echo: " + input.readLine());
		}
		output.close();
		input.close();
		stdIn.close();
		link.close();
	}
}
