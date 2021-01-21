package java_utilidades;
import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

/*

#######################################################################################
############################  GUIA DE CONTENIDOS ######################################
#######################################################################################
#                                                                                     #
# CONVERSIONES BYTE[] OBJECT (JAVA)                                                   #
# #################################                                                   #
#     - byteArrayToObject                   (byte[] array)                            #
#     - objetoToByteArray                   (Object objeto)                           #
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
#     - cuantasVeces               (String origen, char busqueda)                     #
#     - generarClaveAleatoria      (int tamano)                                       #
#     - posicionEnArray            (String str, String[] donde)                       #
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
     * cuantas veces
     * <p>
     * Cuenta cuantas veces aparece un char en un String
     *
     * @param origen     Cadena donde buscar
     * @param busqueda   char buscado
     * @return numero de apariciones de char en la cadena o -1 si la cadena pasada es null
     */
    public static int cuantasVeces(String origen, char busqueda) {
        int cont  = 0;
        if (origen == null ) {
            return -1;
        }

        for (int i = 0; i <origen.length() ; i++) {
            if(origen.charAt(i)== busqueda){
                cont++;
            }
        }
        // version en una sola instruccion
        //cont = origen.length() - origen.replace(busqueda+"", "").length();
        return cont;
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

    /**
     * generarClaveAleatoria
     * Crea una cadena de texto aleatoria con letras mayuscuasl minusculas y numeros, de un tamaño definido
     *
     * @param tamano tamaño de la cadena a crear
     * @return una cadena aleatoria
     */
    public static String generarClaveAleatoria(int tamano) {
        String madre ="ABCDEFGHIJKLMNOPQRSTUVWXUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
        Random azar = new Random();
        String resultado = "";
        for (int i = 0; i < tamano ; i++) {
            resultado += madre.charAt( azar.nextInt(madre.length()));
        }
        return resultado;
    }


    /**
     * posicionEnArray
     *
     * Busca una cadena en un array de Strings
     * Devuelve posicion de la cadena, o -1 si no esta
     * @param str  cadena a buscar
     * @param donde array de string donde buscar
     * @return  posicion de la cadena, o -1 si no esta
     */
    public static int posicionEnArray(String str, String[] donde) {
        int resultado = -1;
        for (int i = 0; i < donde.length && resultado == -1; i++) {
            if (donde[i].equals(str))
                resultado = i;
        }
        return resultado;
    }

//    /**
//     * convertirAJSON_ObjetoSimple
//     * Crea un json de un objeto simple, cuyas propiedades no contienen colecciones
//     * @param objeto    Objeto a convertir en JSON
//     * @return           JSON creado
//     */
//    public static String convertirAJSON_ObjetoSimple(Libro objeto) {
//        // NECESITA GRADLE O LIBRERIA  : implementation 'com.google.code.gson:gson:2.8.5'
//        // NECESITA SUSTITUIR Libro POR LA CLASE DEL OBJETO QUE CONTIENE EL JSON
//        Gson unGson = new Gson();
//        String cadenaEnFormatoGSON = unGson.toJson(objeto);
//        return cadenaEnFormatoGSON;
//    }
//
//    /**
//     * recuperarDEJSON_ObjetoSimple
//     * Crea un objeto simple a partir de un JSON previamente creado, para objetos simples,
//     * cuyas propiedades no contienen colecciones
//     *
//     * @param cadenaEnFormatoGSON  JSON a convertir
//     * @return  Object         Objeto creado desde el JSON
//     */
//    public static Libro recuperarDEJSON_ObjetoSimple(String cadenaEnFormatoGSON) {
//        // NECESITA GRADLE O LIBRERIA : implementation 'com.google.code.gson:gson:2.8.5'
//        // NECESITA SUSTITUIR Libro POR LA CLASE DEL OBJETO QUE CONTIENE EL JSON
//        Gson unGson = new Gson();
//        Libro objetoRecuperado = unGson.fromJson(cadenaEnFormatoGSON, Libro.class);
//        return objetoRecuperado;
//    }




    // por si alguien quiere probar los metodos previos .......
    public static void main(String[] args) throws IOException {

        System.out.println(generarClaveAleatoria(15));

    }





}
