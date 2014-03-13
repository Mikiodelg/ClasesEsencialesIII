package edu.upc.eetac.dsa.mdelgado.ejerciciosesenciales12al15;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ejercicio15 {
	public static String recibido="";
	public static String recibidovector [] = new String [10];
	public static Socket cliente;
	
	public static void main( String[] argumentos ) throws IOException
   
	{
		try{
			
			Socket cliente = new Socket("127.0.0.1", 5000);
			DataOutputStream salida = new DataOutputStream(cliente.getOutputStream());
			DataInputStream entrada = new DataInputStream(cliente.getInputStream());
			salida.writeUTF("PLAY RUBEN");
			
			while (true){
				recibido = entrada.readUTF(); 
				System.out.println("Recibido: " + recibido);
				
			recibidovector = recibido.split(" ");
				
				if (recibidovector[0].equals("WAIT")){
					if (recibidovector[1].equals("FOR")){
						System.out.println(recibido + ": Esperando al otro jugador");
					}
					else{
						System.out.println("Esperando Apuesta");
					}
				}
				else if (recibidovector[0].equals("VERSUS")){
					System.out.println("Soy: RUBEN - " + "Rival: "+ recibidovector[1]);
				}
				else if (recibidovector[0].equals("YOUR")){
					salida.writeUTF("MY BET 0 5");
					System.out.println("MY BET 0 5");
				}
				else if (recibidovector[0].equals("BET")){
					System.out.println("Apuesta de " + recibidovector[2] + " de " + recibidovector[4] + " monedas");
				}
				else if (recibidovector[0].equals("WINNER")){
					System.out.println("WINNER: "+ recibidovector[1]);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
    }
}

