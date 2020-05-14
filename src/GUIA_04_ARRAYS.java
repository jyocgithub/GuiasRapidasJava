import java.util.Random;

public class GUIA_04_ARRAYS {


    public static void main(String[] args) {

        // =======================================
        // ARRAYS
        // =======================================
        
        /*
         * CREAR UN ARRAY VACIO
         */
        int[] unArray = new int[4];

        /*
         * CREAR UN ARRAY CON CONTENIDO
         */
        String[] otroArray = {"Eva", "Ana", "Olga", "Luis"};

        /*
         * OBTENER EL TAMAÑO DE UN ARRAY
         */
        int tamano = unArray.length;

        /*
         * PATRON MODELO PARA RECORRER UN ARRAY
         */
        // En cada vuelta de bucle, aparece miArray[i]
        // que representará cada uno de los elementos del array
        // ¿Que hacer con el? Lo que se pida, en cada caso

//        for (int i = 0; i < unArray.length; i++) {
//            unArray[i]
//        }



        /*
         * CREAR UN ARRAY AL TROCEAR UNA CADENA
         */
        String   cadena = "Scotty, mas potencia!";
        String[] trozos = cadena.split(" ");



        /*
         * EJERCICIO: Mostrar todos los elementos de un array
         */
        int[] miArray = {3,5,6,9};
        for (int i = 0; i < miArray.length; i++) {
            System.out.println(miArray[i]);
        }

        /*
         * EJERCICIO: Contar todos los elementos de un array
         */
        int contador = 0;
        for (int i = 0; i < unArray.length; i++) {
            if (unArray[i] % 2 == 0) {
                contador++;
            }
        }

        /*
         * EJERCICIO: Sumar todos los elementos de un array
         */
        int sumador = 0;
        for (int i = 0; i < unArray.length; i++) {
            sumador = sumador + unArray[i];
        }

        /*
         * EJERCICIO: Rellenar todos los elementos de un array con valores al azar
         */
        Random azar = new Random();
        for (int i = 0; i < unArray.length; i++) {
            unArray[i] = azar.nextInt(20);
        }

        /*
         * Ordenar  por burbuja  (version más simple), cuando el array contiene int
         */
        int[] datos = {4, 1, 8, 36, 0, 33, 11, 43};
        for (int i = 0; i < datos.length - 1; i++) {
            for (int j = 0; j < datos.length - 1; j++) {
                if (datos[j] > datos[j + 1]) {
                    int aux = datos[j + 1];
                    datos[j + 1] = datos[j];
                    datos[j] = aux;
                }
            }
        }

        /*
         * Ordenar por burbuja  (version más simple), cuando el array contiene String
         * (o de cualquier objeto)
         */
        String[] palabras = {"pera", "uva", "higo", "fresa"};
        for (int i = 0; i < palabras.length - 1; i++) {
            for (int j = 0; j < palabras.length - 1; j++) {
                if (palabras[j].compareTo(palabras[j + 1]) > 0) {
                    String aux = palabras[j + 1];
                    palabras[j + 1] = palabras[j];
                    palabras[j] = aux;
                }
            }
        }

        

        // =======================================
        // MATRICES
        // =======================================

        /*
         * CREAR UNA MATRIZ VACIA
         */
        int[][] matrizvacia = new int[3][4]; //crea matriz 3x4 posiciones int

        /*
         * CREAR UNA MATRIZ CON CONTENIDO
         */
        int[][] matrizconchicha = {{4, 1, 8, 36}, {6,4,21,8}};


        /*
         * PATRON MODELO PARA RECORRER UNA MATRIZ
         */
        // En cada vuelta de matriz, aparece matriz[f][c]
        // que representará cada uno de los elementos de la matriz
        // ¿Que hacer con el? Lo que se pida, en cada caso

//        int[][] matriz = {{4, 1, 8, 36}, {4, 1, 8, 36}};
//        for (int f = 0; f < matriz.length; f++) {
//            for (int c = 0; c < matriz[0].length; c++) {
//                matriz[f][c]
//            }
//        }

        /*
         * EJERCICIO: Mostrar todos los elementos de una matriz
         */
        int[][] matriz1 = {{4, 1, 8, 36}, {6,4,21,8}};
        for (int f = 0; f < matriz1.length; f++) {
            for (int c = 0; c < matriz1[0].length; c++) {
                System.out.print(matriz1[f][c]);
                System.out.print("\t");
            }
            System.out.println("");  
        }

        /*
         * EJERCICIO: Sumar cada una de las filas de una matriz
         */
        int[][] matriz2 = {{4, 1, 8, 36}, {6,4,21,8}};
        int suma = 0;
        for (int f = 0; f < matriz2.length; f++) {
            for (int c = 0; c < matriz2[0].length; c++) {
                suma = suma + matriz2[f][c];
            }
            System.out.println("la suma de la fila " + f + " es " + suma);
            suma = 0; // SUPERIMPORTANTE volver a poner el sumador a 0 antes de recorrer una nueva fila
        }


    }
}
