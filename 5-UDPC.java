import java.util.*;
import java.net.*;

public class UDPC{
	public static void main(String[] args) throws Exception{
		DatagramSocket clientSocket=new DatagramSocket();
		InetAddress IPAddress=InetAddress.getByName("localhost");
		byte[] sendData=new byte[1024];
		byte[] receiveData=new byte[1024];
		
		System.out.println("Enter the string in lowercase so that it is received from Server in uppercase");
		Scanner sc=new Scanner(System.in);
		String sentence=sc.nextLine();
		sendData=sentence.getBytes();
		DatagramPacket sendPacket=new DatagramPacket(sendData,sendData.length,IPAddress,9876);
		clientSocket.send(sendPacket);
		
		DatagramPacket receivePacket=new DatagramPacket(receiveData, receiveData.length);
		clientSocket.receive(receivePacket);
		String modifiedSentence=new String(receivePacket.getData());
		System.out.println("Modified string from server: "+modifiedSentence);
		clientSocket.close();
	}
}

/*
Output:

java UDPS
Server is ready for connection
RECEIVED: pruthvi

java UDPC
Enter the string in lowercase so that it is received from Server in uppercase
pruthvi
Modified string from server: PRUTHVI
*/
