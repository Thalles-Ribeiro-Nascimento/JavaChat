package javaChat;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.net.InetAddress;
import java.util.Scanner;
import java.io.PrintStream;

public class Cliente {
	public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {
		String ip = InetAddress.getLocalHost().getHostAddress();
	
		Socket client = new Socket(ip, 1330);
		System.out.println("Conectado ao Servidor");
		
		Scanner in = new Scanner(System.in);
		
		PrintStream out = new PrintStream(client.getOutputStream());
		
		Scanner server_response = new Scanner(client.getInputStream());
		
		while(in.hasNextLine()) {
			out.println(in.nextLine());
			System.out.println(client.getLocalAddress().getHostName()+": "+server_response.nextLine());
		}
	
		server_response.close();
		in.close();
		client.close();
	}

}
