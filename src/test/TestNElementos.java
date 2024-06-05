package test;

import datos.QuickSortConcurrente;
import datos.QuickSortSecuencial;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;

///Clase TestNElementos:
public class TestNElementos 
{
	public static void main(String[] args) 
	{
		//Definimos la cantidad de elementos del array:
		int n = 10;
		
		//Manejamos los casos donde se intente crear un array con una cantidad negativa, con cero elementos o un elemento:
        if(n <= 1) 
        {
            System.out.println("El array está vacío o solo contiene un elemento, por lo que no tiene sentido hacer el ordenamiento.");
            return;
        }

        //Definimos un array de enteros de 'n' elementos:
        int[] arr = new int[n];
        
        //Instanciamos un 'Random' para generar enteros aleatorios:
        Random random = new Random();

        //Cargamos el array:
        for(int i = 0; i < n; i++) 
        {
        	arr[i] = random.nextInt(0, n + 1); //Cada elemento tendrá un entero aleatorio entre [0;n].
        }     
        
        //Mostramos el array original:
        System.out.println("Array original:");
        for(int i = 0; i < n; i++) 
        {
        	System.out.println(" |" + arr[i] + "| ");
        }
        
        //Hacemos copias del array para que cada versión del algoritmo ordene:
        int arrayOrdenarSecuencialmente[] = Arrays.copyOf(arr, n);
        int arrayOrdenarConcurrententemente[] = Arrays.copyOf(arr, n);
        
        //Instanciamos un 'QuickSortSecuencial' para que realice el ordenamiento:
        QuickSortSecuencial qss = new QuickSortSecuencial();
        
        //Obtenemos el tiempo en el que inicia el proceso del algoritmo:
        long tiempoInicialSecuencial = System.nanoTime();
        
        qss.quickSort(arrayOrdenarSecuencialmente, 0, n - 1); //Ordenamos el array cargado previamente con el algoritmo Quick Sort de forma concurrente.
        
        //Obtenemos el tiempo en el que finaliza el proceso del algoritmo:
        long tiempoFinalSecuencial = System.nanoTime() - tiempoInicialSecuencial;
        
        //Mostramos el array ordenado de forma secuencial:
        System.out.println("\n\nArray ordenado secuencialmente:");
        for(int i = 0; i < n; i++) 
        {
        	System.out.println(" |" + arrayOrdenarSecuencialmente[i] + "| ");
        }
        
        //Instanciamos un grupo de subprocesos de bifurcación/unión:
        @SuppressWarnings("resource")
		ForkJoinPool pool = new ForkJoinPool();
        
        //Instanciamos un 'QuickSortConcurrente' para que realice el ordenamiento:
        QuickSortConcurrente qsc = new QuickSortConcurrente(arrayOrdenarConcurrententemente);
        
        //Obtenemos el tiempo en el que inicia el proceso del algoritmo:
        long tiempoInicialConcurrente = System.nanoTime();
        
        //Realizamos el ordenamiento usando el grupo de subprocesos:
        pool.invoke(qsc);
        
        //Obtenemos el tiempo en el que finaliza el proceso del algoritmo:
        long tiempoFinalConcurrente = System.nanoTime() - tiempoInicialConcurrente;
        
        //Mostramos el array ordenado de forma concurrente:
        System.out.println("\n\nArray ordenado concurrentemente:");
        for(int i = 0; i < n; i++) 
        {
        	System.out.println(" |" + arrayOrdenarConcurrententemente[i] + "| ");
        }
      
        //Mostramos el tiempo que necesitó cada algoritmo para ordenar:
        System.out.println("\n\nPara ordenar " + n + " elementos:");
        
        //Mostramos cuánto demoró el algoritmo secuencial:
        System.out.println("El algoritmo de ordenamiento Quick Sort de forma secuencial demoró: " + tiempoFinalSecuencial/1000000 + " milisegundos.");
        
        //Mostramos cuánto demoró el algoritmo concurrente:
        System.out.println("El algoritmo de ordenamiento Quick Sort de forma concurrente demoró: " + tiempoFinalConcurrente/1000000 + " milisegundos.");
	}
}
