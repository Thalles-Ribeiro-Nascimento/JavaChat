package javaChat;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class Servidor_Chat {
	private ServerSocket server; // Atributo do tipo ServerSocket
	
	// Construtor da classe e que instancia um objeto da classe ServerSocket
	public Servidor_Chat(int porta) throws IOException{
		this.server = new ServerSocket(porta);// instancia Objeto da classe ServerSocket
	} 
	
	
//	Método principal para iniciar
	public void start() {
		try {
			
			System.out.println("Servidor rodando!!");
			System.out.println("Aguardando novas conexões...");
			
			Socket client = this.server.accept();	
			System.out.println(client.getLocalAddress().getHostName()+" conectado!");
			
			Scanner in = new Scanner(client.getInputStream());
			Scanner in_server = new Scanner(System.in);
			
			PrintStream out_server = new PrintStream(client.getOutputStream());
			
			while(in.hasNextLine()) {
				System.out.println(client.getLocalAddress().getHostName()+": "+in.nextLine());
				out_server.println(in_server.nextLine());
			}
			
			in_server.close();
			in.close();
			this.server.close();
		
		}catch (Exception e) {
			e.getStackTrace();
		}
	}
	
		
	public static void main(String[] args) {
		
		try {
			Servidor_Chat server = new Servidor_Chat(1330);
			server.start();
			
		}catch(IOException e){
			System.out.println("Erro " +e);
		}
	}
	

}

