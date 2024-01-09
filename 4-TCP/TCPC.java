import java.util.*;
import java.net.*;
import java.io.*;

public class TCPC{
	public static void main(String[] args) throws Exception{
		
		Socket sock=new Socket("127.0.0.1",4000);
		
		System.out.println("Enter the filename");
		Scanner sc=new Scanner(System.in);
		String fname=sc.nextLine();
		
		OutputStream ostream=sock.getOutputStream();
		PrintWriter pwrite=new PrintWriter(ostream,true);
		pwrite.println(fname);
		
		InputStream istream=sock.getInputStream();
		BufferedReader socketRead=new BufferedReader(new InputStreamReader(istream));
		
		String str;
		while((str=socketRead.readLine())!=null){
			System.out.println(str);
		}
		
		sock.close();
		socketRead.close();
		pwrite.close();
	}
}


/*
Output:
$ java TCPS
Server is ready for connection
Connection is established and server is waiting for client request
Client request fulfilled

$ java TCPC
Enter the filename
sample.txt
You are genius
*/
