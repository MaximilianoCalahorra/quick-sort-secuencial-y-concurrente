package datos;

///Clase QuickSortSecuencial:
public class QuickSortSecuencial
{
	//Quick Sort:
	public void quickSort(int arr[], int begin, int end)
	{
		//Realizamos el algoritmo solo si la posición indicada como inicio del vector es anterior a la indicada como última:
	    if(begin < end)
	    {
	        int partitionIndex = partition(arr, begin, end); //Obtenemos el índice de partición del vector.

	        quickSort(arr, begin, partitionIndex - 1); //Recursividad con el subarreglo izquierdo del pivote.
	        quickSort(arr, partitionIndex + 1, end); //Recursividad con el subarreglo derecho del pivote.
	    }
	}
	
	//Partición:
	private int partition(int arr[], int begin, int end)
	{
	    int pivot = arr[end]; //Definimos el valor del elemento pivote, el cual va a ser, en este caso, el valor del último elemento del vector.
	    int i = (begin - 1); //Definimos un iterador 'i' que tiene el entero anterior a 'begin' como valor.

	    //Recorremos todos los elementos del vector menos el último (el pivote):
	    for(int j = begin; j < end; j++) 
	    {
	    	//Si el valor del vector en la posición 'j' es menor o igual al valor del pivote:
	        if(arr[j] <= pivot)
	        {
	            i++; //Incrementamos 'i'.

	            //Permutamos:
	            int swapTemp = arr[i]; //Una variale temporal almacena el valor del vector en la posición 'i'.
	            arr[i] = arr[j]; //En la posición 'i' almacenamos el valor de la posición 'j'.
	            arr[j] = swapTemp; //En la posición 'j' almacenamos el valor de la variable temporal.
	        }
	    }

	    //Ubicamos al pivote en la posición que corresponde:
	    int swapTemp = arr[i + 1]; //Una variable temporal almacena el valor del vector en la posición 'i + 1', la posición donde debe ir el pivote.
	    arr[i + 1] = arr[end]; //En la posición 'i + 1' almacenamos el valor del pivote.
	    arr[end] = swapTemp; //En la última posición del vector almacenamos el valor de la variable temporal.

	    return i + 1; //Retornamos 'i + 1', es decir, la posición del pivote.
	    //Es decir, al final de este proceso, los elementos menores o iguales al pivote se encuentran a su izquierda y los mayores a él a su derecha.
	}
}
