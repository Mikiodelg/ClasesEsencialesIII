package edu.upc.eetac.dsa.mdelgado.ejerciciosesenciales12al15;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class servidor14 {
	
	private static ServerSocket Servidor;
	private static int puerto=5000;
	private static DataOutputStream salida;
	private static DataInputStream entrada;
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private static String date = sdf.format(new Date());
	
	public static void main( String[] argumentos ) throws IOException
    {
		try {
			Servidor = new ServerSocket(puerto);
			Socket conexion;
			
			while (true) {
				conexion = Servidor.accept();
				Servidores14C nuevaConexion = new Servidores14C(conexion);
				nuevaConexion.start();
			}

		} catch (Exception e) {}

	}
	
}
