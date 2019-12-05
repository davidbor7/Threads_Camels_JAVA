package camello;

import java.util.Random;


public class HiloCamello implements Runnable
{

	int nombre;
	boolean fin = false;
	Camello camello_hiloCamello;
	static int posicion_lider;
	
	int posiciones_avanzadas = 0;
	int avance = 0;

	public HiloCamello(int n, Camello c)
	{
		nombre = n;	
		camello_hiloCamello = c;

	}

	@Override
	public void run() {

		

		while(!fin)
		{
			if(Principal_Camello.final_carrera == false)
			{
				mueve_camello();
			}
			else 
			{
				fin = false;
			}
							
		}
	}
	

	public synchronized void mueve_camello()
	{
		
		avance = tirada_dados();	
		
		camello_hiloCamello.avanzarCamello(avance);
				
		
		System.out.println( "Camello número "+ nombre + " avanza " + avance + " y lleva " + camello_hiloCamello.damePosicionActual() + " posiciones. A " + (posicion_lider - posiciones_avanzadas) + " posiciones del líder");

		
		if (camello_hiloCamello.damePosicionActual() >= posicion_lider) 
		{
			
			posicion_lider = camello_hiloCamello.damePosicionActual();
			
		}
		
		if(posicion_lider >= Principal_Camello.distancia)
		{
			Principal_Camello.final_carrera = true;
			System.out.println("FIN DE LA CARRERA");
			System.exit(0);
									
		}	
		
		try 
		{

			Thread.sleep(1000);
			
		} catch (InterruptedException e) 
		
		{
			e.printStackTrace();
		}
		
		
	}
	
	
	public int tirada_dados() 
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

