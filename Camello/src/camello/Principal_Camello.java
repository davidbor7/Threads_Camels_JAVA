package camello;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Principal_Camello {

	static boolean final_carrera = false; 
	static int distancia = 0;
	static int numero_camellos = 0;

	public static void main(String[] args) throws IOException
	{

		numero_camellos = 0;
		distancia = 0;

		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

		do {

			System.out.println("Introduce el numero de camellos: ");

			try 
			{
				numero_camellos = Integer.parseInt(buffer.readLine());
				
			}catch (NumberFormatException e)
			{
				System.out.println("No has introducido un número, introduce un caracter correcto.");
				System.out.println();
			}

			if( numero_camellos < 2 || numero_camellos > 10)
			{
				System.out.println("Número de camellos válidos: 2 - 10");
				System.out.println();
			}


		}while(numero_camellos < 2 || numero_camellos > 10);


		do {

			System.out.println("Introduce la distancia: ");

			try 
			{
				distancia = Integer.parseInt(buffer.readLine());

			}catch (NumberFormatException e)
			{
				System.out.println("No has introducido un número, introduce un caracter correcto.");
				System.out.println();
			}

			if( distancia < 10 || distancia > 50)
			{
				System.out.println("Distancia válida: 10 - 50");
				System.out.println();
			}

		}while(distancia < 10 || distancia > 50);


		System.out.println("Pulsa intro para comenzar la carrera: ");
		buffer.readLine();	


		// Crear un hilo por cada camello e iniciar la carrera

		for(int i = 0; i < numero_camellos; i++)
		{
			new Thread(new HiloCamello(i+1, new Camello())).start();
		}

		buffer.close();
		
	}

}




