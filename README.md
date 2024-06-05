# Quick Sort secuencial y concurrente
Este repositorio contiene un algoritmo Quick Sort ascendente secuencial y otro concurrente como parte de un informe para un trabajo práctico de la materia Programación Concurrente de la
carrera de Licenciatura en Sistemas de la Universidad Nacional de Lanús (UNLa). Los códigos no son de mi propiedad, sino que a partir de ellos fui haciendo comentarios que me permitan
entenderlo mejor, a excepción del test ya que lo diseñé en base a las consignas que se me pide realizar en el trabajo práctico, como por ejemplo tomar el tiempo que demora cada versión
del algoritmo en ordenar el mismo vector de determinada cantidad de elementos.

*El algoritmo secuencial lo obtuve de*: **https://www.baeldung.com/java-quicksort**

*El algoritmo concurrente lo obtuve de*: **https://www.blogcyberini.com/2018/09/quicksort-paralelo-em-java-fork-join.html#quicksortfj_main**

El algoritmo Quick Sort subido consiste en la versión que toma como pivote al último elemento del vector. De esta forma, el algoritmo recorre los elementos de izquierda a derecha comparando
el valor de cada uno contra el del pivote para lograr que los menores o iguales a él queden a la izquierda del pivote y los mayores a la derecha. Una vez terminado el recorrido, el pivote
es intercambiado de posición a la que le corresponde en el arreglo. 
Este proceso se repite recursivamente por cada subarreglo, donde uno abarca desde el inicio del vector hasta la posiciónanterior al pivote, y el otro desde la posición posterior al pivote
hasta el final del vector. En esta sección es donde puede entrar en juego la concurrencia, ya que en vez de utilizar la recursividad directamente con el hilo que está ejecutando el
programa (forma secuencial), lanzamos dos hilos nuevos: uno se encargará del subarreglo izquierdo y el otro del subarreglo derecho.
El ordenamiento continúa hasta que todos los elementos se encuentren en su índice correcto.

Como mencioné anteriormente, en los tests se imprime por consola las tres versiones del vector (original, ordenado de forma secuencial y ordenado de forma concurrente) y el tiempo que
demoró tanto el secuencial como el concurrente expresado en microsegundos.

**Muchas gracias por interesarte en mi repositorio y leer acerca de él**.

*¡Saludos!*
