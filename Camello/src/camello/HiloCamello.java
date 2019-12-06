package camello;

import java.util.Random;


public class HiloCamello implements Runnable
{

	int nombre;
	boolean llave_ganador_ranking = false;
	static boolean fin = false;
	int posiciones_con_respecto_lider;
	Camello camello_hiloCamello;
	static int posicion_lider = 0;;
	int posiciones_avanzadas = 0;
	int avance = 0;		

	public HiloCamello(int n, Camello c)
	{
		nombre = n;	
		camello_hiloCamello = c;

	}

	@Override
	public void run() 
	{
		while(fin == false)
		{
			mueve_camello();			
		}
				
		if(fin && llave_ganador_ranking == false)
		{
			System.out.println("El Camello " + nombre + " a " + (Principal_Camello.distancia - camello_hiloCamello.damePosicionActual()) + " posiciones.");
		}
	}
	

	public synchronized void mueve_camello()
	{
		
		avance = tirada_dados();	
		posiciones_avanzadas =  camello_hiloCamello.avanzarCamello(avance);
		System.out.println( "Camello "+ nombre + " avanza " + avance + " y lleva " + camello_hiloCamello.damePosicionActual() + " posiciones.");
		
		if(camello_hiloCamello.damePosicionActual() >= Principal_Camello.distancia)
		{					
			fin = true;
			llave_ganador_ranking = true;
			
			try //NOS ASEGURAMOS QUE SIEMPRE EL RANKING SALGA AL FINAL
			{			
				Thread.sleep(500);			
				System.out.println("-----------FIN DE LA CARRERA-----------");		
				System.out.println("***GANADOR DE LA CARRERA: CAMELLO " + nombre +" ***");
				
				
			} catch (InterruptedException e) 
			{
				e.printStackTrace();
			}			
		}
							
		try 
		{
			Thread.sleep(3000);				
			
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

