package edu.upc.eetac.dsa.mdelgado.ejerciciosesenciales12al15;

import java.io.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.net.*;

public class ejercicio12 {

	public static void main( String[] argumentos ) throws IOException
    {
		try{
			Socket cliente = new Socket("127.0.0.1", 5000);
			DataOutputStream salida = new DataOutputStream(cliente.getOutputStream());
			DataInputStream entrada = new DataInputStream(cliente.getInputStream());
			
			String hora = entrada.readUTF();
			System.out.println(hora);
			
		}catch(Exception e){
			e.printStackTrace();
		}
    }
}
