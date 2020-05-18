package utilidades;

import java.io.*;
import java.nio.file.Files;
import java.util.*;


/*

#######################################################################################
############################  GUIA DE CONTENIDOS ######################################
#######################################################################################
#                                                                                     #
# FICHEROS  (JAVA)                                                                    #
# ################                                                                    #
#    - escribirTextoEnFichero  (String texto, String nombrefichero, String pathdelfichero)                                          #
#    - leerTextoDeFichero (String nombrefichero, String pathdelfichero)                                         #
#    - leerLineasDeFichero  (String nombrefichero, String pathdelfichero)                                      #
#    - escribirBytearrayEnFichero (byte[] contenido, String nombrefichero, String pathdelfichero)                                      #
#    - leerBytearrayDeFichero (String nombrefichero, String pathdelfichero)                                     #
#    - hermanosQueSonCarpetas  (File origen)                                          #
#                                                                                     #
###################################### (fin) ##########################################

 */

/**
 * JYOCUtilsJavaFiles
 * <p>
 * Utilidades para leer y escribir ficheros binarios y de texto en Java
 *
 * @author Iñaki Martin
 * @version 2
 */
public class JYOCUtilsJavaFiles {

    /**
     * escribirTextoEnFichero
     *
     * Escribe un String en un fichero de texto.
     * El String puede contener varias lineas concartenadas, aunque es un unico String y se guarda en una única linea
     *
     * @param texto            String que se desea escribir
     * @param nombrefichero    nombre del fichero a crear
     * @param pathdelfichero   directorio del fichero a crear, si es null se toma el propio directorio del proyecto
     */
    public static void escribirTextoEnFichero(String texto, String nombrefichero, String pathdelfichero) {
        if (pathdelfichero == null) {
            pathdelfichero = "./";
        }
        File fichero = new File(pathdelfichero, nombrefichero);
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(fichero);
            pw.println(texto);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            pw.close();
        }
    }

    /**
     * leerTextoDeFichero
     *
     * lee un fochero con varias lineas de texto, concatena las lineas en un unico String y devuelve dicho String
     *
     * @param nombrefichero    nombre del fichero a leer
     * @param pathdelfichero   directorio del fichero a leer, si es null se toma el propio directorio del proyecto
     * @return el contenido del fichero como un unico String
     */
    public static String leerTextoDeFichero(String nombrefichero, String pathdelfichero) {
        if (pathdelfichero == null) {
            pathdelfichero = "./";
        }
        File fichero = new File(pathdelfichero, nombrefichero);
        BufferedReader br = null;
        FileReader fr = null;
        String textoentero = "";
        try {
            fr = new FileReader(fichero);
            br = new BufferedReader(fr);
            String linea = br.readLine();
            while (linea != null) {
                textoentero = textoentero + linea + "\n";
                linea = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return textoentero;
    }

    /**
     * leerLineasDeFichero
     *
     * lee un fichero con varias lineas de texto, y devuevle la lineas en una lista de Strings
     *
     * @param nombrefichero    nombre del fichero a leer
     * @param pathdelfichero   directorio del fichero a leer, si es null se toma el propio directorio del proyecto
     * @return el contenido del fichero como una lista de Strings
     */
    public static List<String> leerLineasDeFichero(String nombrefichero, String pathdelfichero) {
        if (pathdelfichero == null) {
            pathdelfichero = "./";
        }
        List<String> resultado = new ArrayList<>();
        File fichero = new File(pathdelfichero, nombrefichero);
        BufferedReader br = null;
        FileReader fr = null;
        try {
            fr = new FileReader(fichero);
            br = new BufferedReader(fr);
            String linea = br.readLine();
            while (linea != null) {
                resultado.add(linea);
                linea = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    /**
     * escribirBytearrayEnFichero
     *
     * Escribe un array de bytes en un fichero binario
     *
     * @param contenido        array de bytes que se desea escribir
     * @param nombrefichero    nombre del fichero a crear
     * @param pathdelfichero   directorio del fichero a crear, si es null se toma el propio directorio del proyecto
     */
    public static void escribirBytearrayEnFichero(byte[] contenido, String nombrefichero, String pathdelfichero) {
        if (pathdelfichero == null) {
            pathdelfichero = "./";
        }
        File fichero = new File(pathdelfichero, nombrefichero);

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(fichero);
            fos.write(contenido);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * leerBytearrayDeFichero
     *
     * lee un array de bytes guardado en un fichero binario
     *
     * @param nombrefichero    nombre del fichero a leer
     * @param pathdelfichero   directorio del fichero a leer, si es null se toma el propio directorio del proyecto
     * @return el byte[] leido del fichero
     */
    public static byte[] leerBytearrayDeFichero(String nombrefichero, String pathdelfichero) {
        if (pathdelfichero == null) {
            pathdelfichero = "./";
        }
        File fichero = new File(pathdelfichero, nombrefichero);
        byte[] ficheroenbytes;
        try {
            ficheroenbytes = Files.readAllBytes(fichero.toPath());
            return ficheroenbytes;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * carpetasHermanasMias
     * <p>
     * Devuelve una List de File, con los
     * hermanos de la carpeta actual que tambien
     * son carpetas
     *
     * @param origen Objeto File que representa el directorio actual
     * @return List de File, con los hermanos de la carpeta actual que tambien son
     * carpetas
     */
    public List<File> carpetasHermanasMias(File origen) {
        File padre = origen.getParentFile();
        File[] hermandad = padre.listFiles();
        List<File> hermanosValidos = new ArrayList<>();
        for (File f : hermandad) {
            if (f.isDirectory()) {
                hermanosValidos.add(f);
            }
        }
        return hermanosValidos;
    }

}
