public class GUIA_06_STRINGS {


    public static void main(String[] args) {

        // =======================================
        // CONVERSIONES    INT - STRING
        // =======================================

        /*
         * CONVERTIR un INT en un STRING
         */
        String ss = "53";
        int num1 = Integer.parseInt(ss);
        int num2 = Integer.parseInt("323");   // sin usar una variable previamente

        // existen Double.parseDouble(), Short.parseShort(), etc...

        /*
         * CONVERTIR un STRING en un INT
         */

        // este es el modo "didacticamente apropiado"
        int num = 2347;
        String cade1 = String.valueOf(num);

        // y este es el truqui que todos los mortales usamos
        String cade2 = num + "";


        // =======================================
        // STRINGS: METODOS
        // =======================================

        // posiciones:   012345679012345678901
        String cadena = "Scotty, mas potencia!";



        /*
         * TAMAÑO DE UNA CADENA
         */
        int tam = cadena.length();  // tam vale 22

        /*
         * EXTRAER UN CHAR DE UNA CADENA
         */
        char c = cadena.charAt(5);  // c valdría 'y'

        /*
         * EXTRAER UN TROZO DE UNA CADENA
         * Si tiene un solo parametro es desde dichas posicion hasta el final
         * Si tiene dos parámetros, el primero es INCLUIDO y el segundo es EXCLUIDO
         */
        String tt1 = cadena.substring(3);    // tt1 vale "tty, mas potencia!"
        String tt2 = cadena.substring(1, 5);  // tt2 vale "cott"

        /*
         * COMPARAR CADENAS
         */
        String cad1 = "Hola";
        String cad2 = "HOLA";
        if (cad1.equals(cad2)) {        // en este caso es falso
            //...
        }

        /*
         * VER SI UNA CADENA CONTIENE ALGO
         */
        if (cadena.contains("poten")) {  // en este caso es cierto
            // ...
        }


        /*
         * CONVERTIR A MAYUSCULAS o MINUSCULAS
         */
        String cadenaMayus = cadena.toUpperCase();
        String cadenaMinus = cadena.toLowerCase();


        /*
         * SABER EN QUE POSICION ESTA UNA SUBCADENA
         */
        int pos = cadena.indexOf("tty");


        /*
         * CREAR UN ARRAY AL TROCEAR UNA CADENA
         */
        String[] trozos = cadena.split(" ");


        /*
         * REEMPLAZA EN UNA CADENA UN ELEMENTO POR OTRO
         */
        String origen = "una frase que mas que frase es frasecilla";
        String nuevacadena = origen.replace("frase", "cosa");   // nueva vale "una cosa que mas que cosa es cosacilla"


        /*
        /*
         * EJERCICIO: Extraer y mostrar uno a uno los chars de una cadena
         */
        for (int i = 0; i < cadena.length(); i++) {
            char ch = cadena.charAt(i);
            System.out.println(ch);
        }

        /*
         * EJERCICIO: Muestra una cadena partida en dos mitades
         */
        int puntomedio = cadena.length() / 2;  // supongamos que tiene un numero par de caracteres
        System.out.println(cadena.substring(1, puntomedio));
        System.out.println(cadena.substring(puntomedio));


    }
}
