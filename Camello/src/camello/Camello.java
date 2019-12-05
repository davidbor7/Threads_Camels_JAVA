package camello;


public class Camello
{

	int nombre;
	int posicion_actual;

	public Camello()
	{
		nombre = 0;
		posicion_actual = 0;
	}

	public Camello(int n, int p)
	{

		nombre = n;
		posicion_actual = p;
	}

	public int dameNombre()
	{
		return this.nombre;
	}

	public void estableceNombre(int n)
	{
		nombre = n;
	}

	public int damePosicionActual()
	{
		return posicion_actual;
	}

	public void ponPosicionActual(int p )
	{
		posicion_actual = p;
	}
	
	public int avanzarCamello(int a)
	{
		posicion_actual += a;
		return posicion_actual;
	}

}
