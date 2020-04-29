public class GUIA_01_TIPOSDEDATOS {


    public static void main(String[] args) {


        // =======================================
        // CONVERSIONES    INT - STRING
        // =======================================

        /*
         * CONVERTIR un INT en un STRING
         */
        String ss = "53";
        int num1 = Integer.parseInt( ss );
        int num2 = Integer.parseInt( "323");   // sin usar una variable previamente

        // existen Double.parseDouble(), Short.parseShort(), etc...

        /*
         * CONVERTIR un STRING en un INT
         */

        // este es el modo "didacticamente apropiado"
        int num = 2347;
        String cade1 = String.valueOf (num);

        // y este es el truqui que todos los mortales usamos
        String cade2 = num+"";





    }
}
