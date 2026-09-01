package tp2.extra;

import java.util.Arrays;

public class sorting {
    public static void main(String[] args) {
        
        int[] arreglito1 = {5,3,6,8,4,2,7,9};
        int[] arreglito2 = {9,1,8,2,5,6,4,7};
        int[] sorted = {1,2,3,4,5,6,7,8,9,10,12,13,14,15,16};
        int[] sortedNoFive = {1,2,3,4,6,7,8,9,10,12,13,14,15,16};

        System.out.println("Selection sort con arreglito1: "+ Arrays.toString(arreglito1));
        //selectionSort(arreglito1);
        System.out.println(Arrays.toString(arreglito1));

        System.out.println("\nbubble sort con arreglito1: "+ Arrays.toString(arreglito1));
        //bubbleSort(arreglito1);
        System.out.println(Arrays.toString(arreglito1));

        System.out.println("\nbubble sort mejorado con arreglito1: "+ Arrays.toString(arreglito1));
        //bubbleSortMejorado(arreglito1);
        System.out.println(Arrays.toString(arreglito1));

        System.out.println("\nbinary search con sorted 1~16: "+ Arrays.toString(sorted));
        System.out.println(binarySearch(sorted, 5));

        System.out.println("\nbinary search recursiva con sortedNoFive 1~16: "+ Arrays.toString(sorted));
        System.out.println(binarySearchRecursive(sorted, 5));
    }

    // 1/7 busqueda secuencial - fuerza bruta O(n)
    public static int search(int[] arr, int elem) {
        int pos = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == elem) {
                System.out.println("Elemento encontrado en la posición: " + i);
                pos = i;
            }
        }
        System.out.println("Elemento no encontrado");
        return pos;
    }

    public static int binarySearch(int[] arr, int elem) {
        int ini = 0, res = -1, n = arr.length-1;
        //int n = arr.length-1;
        //int res = -1;
        while( ini <= n ) {
            int medio = (ini + n) / 2;
            if (elem == arr[medio]) {
                res = medio;
                ini = n +1;
            } else {
                if (elem < arr[medio]) {
                    n = medio - 1;
                } else {
                    ini = medio + 1;
                }
            }
        }
        return res;
    }

    public static int binarySearchRecursive(int[] arr, int elem) {
        return binarySearchRecursive(arr, 0, arr.length-1, elem);
    }
    
    private static int binarySearchRecursive(int[] arr, int ini, int fin, int elem) {
        int res;
        // boolean rta; cambiado por res para devolver la pos del elem deseada
        int medio = (ini+fin)/2;
        if (ini > fin) {
            res = -1;
            // return false o res = -1 pero ya inicializada de esa forma...
            // update: si no ponemos nada sigue la recursion, con res = -1 corta simil ini = fin + 1
        } else {
            if (arr[medio] == elem) {
                // return true, este seria el caso base...
                res = medio;
            } else {
                if (arr[medio] < elem) {
                    res = binarySearchRecursive(arr, medio+1, fin, elem);
                } else {
                    res = binarySearchRecursive(arr, ini, medio-1, elem);
                }
            }
        }
        return res;
    }

    public static void bubbleSort(int[] arr){
        int i, j, aux,n = arr.length;
        for (i=0; i < n-1; i++) {
            for (j=0; j < n-1-i; j++) {
                if (arr[j] > arr[j+1]) {
                    aux = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = aux;
                }
            }
        }
    }

    public static void bubbleSortMejorado(int[] arr) {
        int aux, i=0;
        boolean sorted = false;
        while(i < arr.length && !sorted) {
            sorted = true;
            for(int j=0; j<arr.length-1; j++) {
                if (arr[j] > arr[j+1]) {
                    sorted = false;
                    aux      = arr[j];
                    arr[j]   = arr[j+1];
                    arr[j+1] = aux;
                }
            }
            i++;
        }
    }
    
    public static void selectionSort(int[] arr) {
        int i, j, min, aux;
        for (i = 0; i < arr.length - 1; i++) { // equivalente al apunte longitud(a)-2
            min = i;
            for (j = i + 1; j < arr.length; j++) { // longitud(a)-1
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            // intercambio
            aux = arr[i];
            arr[i] = arr[min];
            arr[min] = aux;
        }
    }

    public static void insertionSort(int[] arr) {
        int i, j, aux, n = arr.length;
        for (i=1; i<n; i++) {
            aux = arr[i];
            j = i;
            while (j > 0 && aux < arr[j-1]) {
                arr[j] = arr[j-1];
                j = j-1;
            }
            arr[j] = aux;
        }
    }


    // promocion/libre creo (no los vi en finales)
    public static void mergeSort(int[] arr) {
        int[] arregloTemp = new int[arr.length];
        mergeSort(arr, arregloTemp, 0, arr.length-1);
    }

    private static void mergeSort(int[] arr, int[] temp, int izq, int der) {
        int centro, aux;
        if (izq < der) {
            centro = arr.length/2;
            mergeSort(arr, temp, izq, centro);
            mergeSort(arr, temp, centro+1, der);
            mezclar(arr, temp, izq, centro+1, der);
        }
    } 

    private static void mezclar(int[] arr, int[] temp, int posIzq, int posDer, int posFin) {
        int finIzq, posAux, numElementos, i;
        finIzq = posDer -1;
        posAux = posIzq;
        numElementos = posFin - posDer + 1;
        while (posIzq <= finIzq && posDer <= posFin) {
            if (arr[posIzq] < arr[posDer]) {
                // complete!!
            }
        }
    }
    

    
}
