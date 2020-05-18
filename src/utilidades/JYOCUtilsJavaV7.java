package utilidades;

import java.io.*;
//import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.regex.Pattern;

/*

#######################################################################################
############################  GUIA DE CONTENIDOS ######################################
#######################################################################################
#                                                                                     #
# CONVERSIONES BYTE[] OBJECT (JAVA)                                                   #
# #################################                                                   #
#    - byteArrayToObject                   (byte[] array)                             #
#    - objetoToByteArray                   (Object objeto)                            #
#                                                                                     #
# CONVERSIONES BINARIO DECIMAL HEXADECIMAL                                            #
# ########################################                                            #
#     - deBinarioADecimal      (String numeroBinario)                                 #
#     - deHexadecimalADecimal  (String numeroBinario)                                 #
#     - deDecimalABinario      (int numerodecimal)                                    #
#     - deDecimalAHexadecimal  (int numerodecimal)                                    #
#                                                                                     #
# STRING (JAVA)                                                                       #
# #############                                                                       #
#     - indiceDeEnesimaOcurrencia  (String origen, String busqueda, int ocurrencia    #
#     - validarRegEx               ( String expresionregular, String valor)           #
#                                                                                     #
###################################### (fin) ##########################################

 */

public class JYOCUtilsJavaV7 {

    /**
     * objetoToByteArray
     * <p>
     * Convierte un objeto en un array de bytes, por ejemplo, para envio por sockets o guarda en fichero
     * Recordar que exige que la clase que genera el objeto sea SERIALIZABLE
     *
     * @param objeto objeto que deseamos convertir
     * @return un array de bytes fruto del objeto convertido.
     */
    public static byte[] objetoToByteArray(Object objeto) {
        ByteArrayOutputStream baos;
        ObjectOutputStream oos = null;
        try {
            // Escribimos el objeto en un ByteArrayOutpuStream, y de ahi lo convertimos en byte[]
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            oos.writeObject(objeto);
            oos.flush();
            byte[] array = baos.toByteArray(); // convertimos el objeto escrito en el byte[]
            return array;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        return null; // si se llega aqui es por que hubo un error...
    }

    /**
     * byteArrayToObject
     * <p>
     * Convierte un array de bytes en un objeto, por ejemplo, para envio por sockets o guarda en fichero
     * Recordar que exige que la clase que se genera a partit del objeto sea SERIALIZABLE
     *
     * @param array array de bytes a convertir
     * @return un objeto Object convertido desde el parametro. Normalmente necesitará un casting al tipo real del objeto
     */
    public static Object byteArrayToObject(byte[] array) {
        ByteArrayInputStream byteStream;
        ObjectInputStream ois = null;
        try {
            // Leemos el byte[] de un ByteArrayInpuStream, y de ahi lo convertimos en Object
            byteStream = new ByteArrayInputStream(array);
            ois = new ObjectInputStream(byteStream);
            Object objetoLeido = ois.readObject();
            return objetoLeido;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        return null; // si se llega aqui es por que hubo un error...
    }


    /**
     * ***************************************************************************
     * ******* CONVERSIONES DE SISTEMA NUMERICO (JAVA) *************
     * ***************************************************************************
     */

    public static int deBinarioADecimal(String numeroBinario) {
        return Integer.parseInt(numeroBinario, 2);
    }

    public static int deHexadecimalADecimal(String numeroBinario) {
        return Integer.parseInt(numeroBinario, 16);
    }

    public static String deDecimalABinario(int numerodecimal) {
        return Integer.toBinaryString(numerodecimal);
    }

    public static String deDecimalAHexadecimal(int numerodecimal) {
        return Integer.toHexString(numerodecimal);
    }

    /**
     * ***************************************************************************
     * ************ STRING (JAVA) **************
     * ***************************************************************************
     */


    /**
     * indiceDeEnesimaOcurrencia
     * <p>
     * Devuelve la posision de una cadena en otra, en su enésima aparición
     *
     * @param origen     Cadena donde buscar
     * @param busqueda   Cadena que se busca
     * @param ocurrencia numero de ocurrencia buscada
     * @return la posision de la enésima aparición de la cadena buscada. o -1 si
     * algun parametro es incorrecto
     */
    public static int indiceDeEnesimaOcurrencia(String origen, String busqueda, int ocurrencia) {
        int pos = -1;
        if (origen == null || busqueda == null || ocurrencia < 1) {
            return -1;
        }
        do {
            pos = origen.indexOf(busqueda, pos + 1);
        } while (ocurrencia-- > 0 && pos != -1);

        return pos;
    }

    /**
     * validarRegEx
     * Valida una xexpresion regular usando Pattern, pero sin compilar la expresion
     *
     * @param expresionregular expresion regular que comprueba el valor
     * @param valor     valor que se  quiere comprobar
     * @return true si el valor cumple la expresion regular dada
     */
    public static boolean validarRegEx(String expresionregular, String valor) {
        // return valor.matches(expresionregular);  // otra forma
        return Pattern.matches(expresionregular, valor);
    }


    // por si alguien quiere probar los metodos previos .......
    public static void main(String[] args) throws IOException {
        // LocalDate to LocalDateTime
        LocalDate localDate = LocalDate.parse("21/11/2020",DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalDateTime localDateTime1 = localDate.atStartOfDay();
        System.out.println(localDateTime1);

        // LocalDateTime to LocalDate
        LocalDateTime localDateTime4 = LocalDateTime.parse("22/03/2001", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalDateTime localDateTime3 = LocalDateTime.now();
        LocalDate localDate2 = localDateTime4.toLocalDate();
        System.out.println(localDate2);

    }




}
