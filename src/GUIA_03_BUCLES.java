public class GUIA_03_BUCLES {


    public static void main(String[] args) {


        // =======================================
        // WHILE SIMPLE: ESCRIBE NUMEROS DE O A 9
        // =======================================
        int x = 0;
        while (x < 10) {
            System.out.print(x);
            x++;
        }

        // =======================================
        // FOR SIMPLE: ESCRIBE NUMEROS DE O A 9
        // =======================================
        for (int j = 0; j < 10; j++) {
            System.out.print(j);
        }

        // =======================================
        // DO WHILE SIMPLE: ESCRIBE NUMEROS DE O A 9
        // =======================================
        // so while asegura pasar a menos una vez por el bucle
        int a = 0;
        do {
            System.out.print(a);
            a++;
        } while (a < 10);


        // ========================================================
        // DO WHILE SIMPLE: ESCRIBE NUMEROS DE O A 100 de 3 en 3
        // ========================================================
        for (int j = 0 ;  j <= 100 ;  j = j + 3) {
            System.out.print(j);
        }

        // =======================================
        // DOS BUCLES ANIDADOS
        // =======================================
        for (int i = 1; i <= 3; i++) {
            System.out.print("Vuelta " + a + " del bucle externo");
            for (int b = 1; b <= 3; b++) {
                System.out.print("Vuelta " + b + " de bucle interno");
            }
        }

        // =======================================
        // FOR que ESCRIBE NUMEROS DE 9 A 0
        // =======================================
        for (int j = 9; j >= 0; j--) {
            System.out.print(j);
        }

        // =================================================================
        // EJERICICIO EJEMPLO: Contar los numeros mutiplos de 3 del 1 al 100
        // =================================================================
        int contador = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0) {
                contador++;
            }
        }
        System.out.println(contador);

        // ========================================================
        // EJERICICIO EJEMPLO: Sumar los numeros del 1 al 20
        // ========================================================
        int sumador = 0;
        for (int i = 1; i <= 320; i++) {
            if (i % 3 == 0) {
                sumador = sumador + i;
            }
        }
        System.out.println(sumador);

        // ========================================================
        // EJERICICIO EJEMPLO: Escribir la tabla del 7
        // ========================================================
        for (int i = 1; i <= 10; i++) {
            System.out.println(" 7 por " + i + " es " + (i * 7));
        }






    }
}
