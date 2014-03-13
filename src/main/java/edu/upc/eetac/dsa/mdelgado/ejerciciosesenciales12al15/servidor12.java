package edu.upc.eetac.dsa.mdelgado.ejerciciosesenciales12al15;

import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.net.*;
import java.io.*;

public class servidor12 {
			
	private static ServerSocket Servidor;
	private static int puerto=5000;
	private static DataOutputStream salida;
	private static DataInputStream entrada;
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private static String date = sdf.format(new Date());
			
	public static void main (String[] argumentos)throws IOException
	{
		try {
			Servidor = new ServerSocket(puerto);
			Socket conexion = Servidor.accept();
			
			salida = new DataOutputStream(conexion.getOutputStream());
			salida.flush();

			entrada = new DataInputStream(conexion.getInputStream());
			salida.writeUTF(date);

		} catch (Exception e) {
		}
		
    }
}
