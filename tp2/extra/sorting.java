package tp2.extra;

import java.util.Arrays;

public class sorting {
    public static void main(String[] args) {
        
        int[] arreglito1 = {5,3,6,8,4,2,7,9};
        int[] arreglito2 = {9,1,8,2,5,6,4,7};

        System.out.println("Selection sort con arreglito1: "+ Arrays.toString(arreglito1));
        //selectionSort(arreglito1);
        System.out.println(Arrays.toString(arreglito1));

        System.out.println("\nbubble sort con arreglito1: "+ Arrays.toString(arreglito1));
        //bubbleSort(arreglito1);
        System.out.println(Arrays.toString(arreglito1));

        System.out.println("\nbubble sort mejorado con arreglito1: "+ Arrays.toString(arreglito1));
        bubbleSortMejorado(arreglito1);
        System.out.println(Arrays.toString(arreglito1));
    }

    /**
     * repaso final desalg
     * 1/7 busqueda secuencial - fuerza bruta O(n)
     */
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

    public static void bubbleSort(int[] arr){
        int i, j, aux;
        for (i=0; i < arr.length-1; i++) {
            for (j=0; j < arr.length-1-i; j++) {
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
            for(int j=0; j<arr.lengthz-1; j++) {
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

    
}
