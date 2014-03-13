package edu.upc.eetac.dsa.mdelgado.ejerciciosesenciales12al15;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ejercicio14 {
	
	public static void main( String[] argumentos ) throws IOException
    {
		try{
			Socket cliente = new Socket("127.0.0.1", 5000);
			DataOutputStream salida = new DataOutputStream(cliente.getOutputStream());
			DataInputStream entrada = new DataInputStream(cliente.getInputStream());
			salida.writeUTF("0");
			String hora = entrada.readUTF();
			System.out.println(hora);
			
		}catch(Exception e){
			e.printStackTrace();
		}
    }
}

