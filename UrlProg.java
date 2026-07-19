import java.net.*;
import java.io.*;
import java.util.Scanner;
public class UrlProg{
    public static void main(String[] args) throws Exception{
        //input the url from the user
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter the URL from which you need content: ");
        String urlString = keyboard.nextLine();
        // String to check the whether the url starts with http://
        String st = urlString.substring(0,4);
        //placing http:// if not present
        if(!(st.equals("http")||(st+urlString.charAt(4)).equals("https"))){
            urlString = "http://"+urlString;
        }
        // creating an object of URL class
        URL theURL = new URL(urlString);
        // establishing the connection
        URLConnection theConn= theURL.openConnection();
        // checking if there is content
        int contentLen = theConn.getContentLength();
        int c;
        //display the content
        if (contentLen!=0)
        {
            InputStream urlInput = theConn.getInputStream();
            while (((c=urlInput.read())!=-1))
            {
                System.out.print((char)c);
            }
            urlInput.close();
        }
        else
            System.out.println("Sorry. No Content");
    }
}
