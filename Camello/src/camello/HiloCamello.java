package camello;

import java.util.Random;


public class HiloCamello implements Runnable
{

	private int nombre;
	private boolean llave_ganador_ranking = false;
	private static boolean fin = false;
	private Camello camello_hiloCamello;
	private int avance = 0;
	private static int [] posiciones_camellos = new int [10];

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

		posiciones_camellos[nombre - 1] = camello_hiloCamello.avanzarCamello(avance);

		System.out.println( "Camello "+ nombre + " avanza " + avance + " y lleva " + camello_hiloCamello.damePosicionActual() + " posiciones." + "A " + (dame_posiscion_mas_alta() - camello_hiloCamello.damePosicionActual()) + " posiciones del líder.");

		if(camello_hiloCamello.damePosicionActual() >= Principal_Camello.distancia)
		{					
			fin = true;
			llave_ganador_ranking = true;

			try //NOS ASEGURAMOS QUE SIEMPRE EL RANKING SALGA AL FINAL
			{			
				Thread.sleep(500);			
				System.err.println("-----------FIN DE LA CARRERA-----------");		
				System.err.println("***GANADOR DE LA CARRERA: CAMELLO " + nombre +" ***");				

			} catch (InterruptedException e) 
			{
				e.printStackTrace();
			}			
		}

		try 
		{
			Thread.sleep(1000);							
		} catch (InterruptedException e) 

		{
			e.printStackTrace();
		}
	}

	public int dame_posiscion_mas_alta() 
	{
		int mayor = 0;
		
		for (int i = 0; i < posiciones_camellos.length; i++) 
		{
			if (posiciones_camellos[i] > mayor) 
			{
				mayor = posiciones_camellos[i];
			}
		}
		return mayor;
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
