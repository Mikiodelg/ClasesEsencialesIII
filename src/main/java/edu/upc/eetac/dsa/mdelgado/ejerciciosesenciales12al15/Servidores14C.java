package edu.upc.eetac.dsa.mdelgado.ejerciciosesenciales12al15;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Servidores14C extends Thread{
	
	private Socket cliente;
	private static DataOutputStream salida;
	private static DataInputStream entrada;
	private static SimpleDateFormat sdf1;
	private static SimpleDateFormat sdf2;
	private static int codigo;
	
	public Servidores14C(Socket cliente)
	{
		this.cliente=cliente;
	}
	
	public void run(){
		try{
			entrada = new DataInputStream(cliente.getInputStream());
			codigo = Integer.valueOf(entrada.readUTF());
			
			switch (codigo){
			
			case 0:
				sdf1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
				String date1 = sdf1.format(new Date());
				salida = new DataOutputStream(cliente.getOutputStream());
				salida.flush();
				entrada = new DataInputStream(cliente.getInputStream());
				System.out.println(date1);
				salida.writeUTF(date1);
			break;
			
			case 1:
				sdf2 = new SimpleDateFormat("E,d MMM, HH:mm:ss");
				String date2 = sdf2.format(new Date());
				//[día de la semana], [día del mes] de [mes], [hora]: [minutos]:[segundos]
				salida = new DataOutputStream(cliente.getOutputStream());
				salida.flush();
				entrada = new DataInputStream(cliente.getInputStream());
				System.out.println(date2);
				salida.writeUTF(date2);
				break;
			}
		}
		catch(Exception e){}
		
	}
}

