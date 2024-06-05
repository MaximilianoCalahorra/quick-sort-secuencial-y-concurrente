package datos;

import java.util.concurrent.RecursiveAction;

///Clase QuickSortConcurrente:
@SuppressWarnings("serial")
public class QuickSortConcurrente extends RecursiveAction
{
	//Atributos:
	private int[] array; //Arreglo que será ordenado.
	private int inicio; //Índice de inicio.
	private int fin; //Índice de fin.
	
	//Constructores:
	//Ordena el arreglo entre los índices que se indiquen:
	public QuickSortConcurrente(int[] array, int inicio, int fin) 
	{
		this.array = array;
		this.inicio = inicio;
		this.fin = fin;
	}
	
	//Ordena el arreglo por completo:
	public QuickSortConcurrente(int[] array) 
	{
		this.array = array;
		this.inicio = 0;
		this.fin = array.length - 1;
	}
	
	//Lógica principal del programa:
	@Override
	protected void compute() 
	{
		//Condición de corte de la recursividad:
		if(inicio < fin) 
		{
			int indiceParticion = partition(array, inicio, fin); //Obtenemos la posición del pivote.
			
			//Realizamos las llamadas recursivas paralelamente con hilos para trabajar con cada subarreglo:
			invokeAll(new QuickSortConcurrente(array, inicio, indiceParticion - 1),
					  new QuickSortConcurrente(array, indiceParticion + 1, fin));

		}
	}
	
	//Partición:
	private static int partition(int[] array, int inicio, int fin) 
	{
		//El pivote será el último elemento:
		int pivote = array[fin];
		int i = inicio - 1;
		
		//Recorremos los elementos de izquierda a derecha por el arreglo buscando los menores o iguales al pivote para ubicarlos a la izquierda de él:
		for(int j = inicio; j < fin; j++) 
		{
			if(array[j] <= pivote) 
			{
				i++;
				swap(array, i, j);
			}
		}
		swap(array, i + 1, fin); //Ubicamos al pivote en su posición correcta en el arreglo.
		return i + 1; //Retornamos la posición del pivote.
	}
	
	//Método auxiliar para realizar las permutaciones de elementos:
	private static void swap(int[] array, int i, int j) 
	{
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
