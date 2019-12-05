package camello;

import java.util.Random;

import com.sun.media.sound.AlawCodec;


public class HiloCamello implements Runnable
{

	int nombre;
	boolean fin = false;
	int posiciones_con_respecto_lider;
	Camello camello_hiloCamello;
	int posiciones_avanzadas = 0;
	int avance = 0;
	
	
	
	

	public HiloCamello(int n, Camello c)
	{
		nombre = n;	
		camello_hiloCamello = c;

	}

	@Override
	public void run() {

		

		while(fin == false)
		{
			if(Principal_Camello.final_carrera == false)
			{
				mueve_camello();
			}
			else 
			{
				fin = true;
			}
							
		}
	}
	

	public synchronized void mueve_camello()
	{
		
		avance = tirada_dados();	
		
		System.out.println(avance);
			
		posiciones_avanzadas += avance;
		
		System.out.println("El avance total del camello " +nombre + "es: " + posiciones_avanzadas);
		
		if(Principal_Camello.posicion_lider < posiciones_avanzadas)
		{
			Principal_Camello.posicion_lider = posiciones_avanzadas;
			System.out.println("La posición máxima es" + posiciones_avanzadas);
		}
		
		
		
		
		
		
		/*
		camello_hiloCamello.avanzarCamello(avance);
		
		posiciones_con_respecto_lider = Principal_Camello.posicion_lider;
		
		posiciones_con_respecto_lider -= posiciones_avanzadas;
		
		/*
		if (camello_hiloCamello.damePosicionActual() >= Principal_Camello.posicion_lider) 
		{
			
			Principal_Camello.posicion_lider = camello_hiloCamello.damePosicionActual();
			
		}
		
		System.out.println( "Camello número "+ nombre + " avanza " + avance + " y lleva " + camello_hiloCamello.damePosicionActual() + " posiciones. A " + posiciones_con_respecto_lider + " posiciones del líder");
		
		
		if(Principal_Camello.posicion_lider >= Principal_Camello.distancia)
		{
			Principal_Camello.final_carrera = true;
			System.out.println("FIN DE LA CARRERA. Camello ganador: " + nombre);
			System.exit(0);
									
		}	
		*/
		
		
		try 
		{

			Thread.sleep(1000);
			
		} catch (InterruptedException e) 
		
		{
			e.printStackTrace();
		}
				
	}
	
	
	public synchronized int tirada_dados() 
	{

		int numeroAleatorio;
		int avance = 0;

		Random rd = new Random();

		numeroAleatorio = rd.nextInt(100); //Numero entre el 0 y 99 ambos incluidos, en total 100 números


		if (numeroAleatorio >= 0 && numeroAleatorio <= 29) 
		{
			avance = 0;
		}
		else
		{
			if (numeroAleatorio >= 30 && numeroAleatorio <= 69) 
			{
				avance = 1;
			}
			else 
			{
				if (numeroAleatorio >= 70 && numeroAleatorio <= 89)
				{
					avance = 2;
				}
				else
				{
					avance = 3;
				}
			}
		}

		return avance;
	}

}

