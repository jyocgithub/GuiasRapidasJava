import java.util.*;
import java.io.*;

public class GUIA_14_FICHEROS {


    public static void main(String[] args) {

    }

    // =======================================
    //     FICHEROS DE TEXTO (JAVA)
    // =======================================


    /**
     * CREAR FICHERO  (DE TEXTO o BINARIO)  VACÍO
     */
    public static boolean crearFicheroVacio(String nombreFichero) { //nombre de fichero se pasa como parametro o
        File archivo = new File(nombreFichero);                     //se crea el fichero .dat en el mismo método

        try {
            if (archivo.exists()) {
                System.out.println("Ya existia el fichero. Borrelo si desea crearlo desde cero.");

            } else {
                if (archivo.createNewFile()) {
                    System.out.println("Archivo " + nombreFichero + " Creado.");
                } else {
                    System.out.println("El archivo ya existe");
                }
            }
            return true;
        } catch (Exception e) {
            System.out.println("El archivo no se ha creado correctamente");
        }
        return false;
    }

    /**
     * FICHERO TEXTO : ESCRIBIENDO PERO SIN AÑADIR AL FINAL
     */
    public static void escribirFicheroTexto() {
        PrintWriter pw = null;

        try {
            pw = new PrintWriter("textos.txt");
            pw.println("hola jaja estamos a " + 5 + " grados");
            pw.println("fin de fichefo aqui");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            pw.close();
        }
    }

    /**
     * FICHERO TEXTO : ESCRIBIR AÑADIENDO AL FINAL
     */
    public static void anadirFicheroTexto() {
        BufferedWriter bw = null;

        try {
            bw = new BufferedWriter(new FileWriter("textos.txt", true));
            bw.write("probando escritura\n");
            bw.newLine();

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                bw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * FICHERO TEXTO : LEER
     */
    public static void leerFicheroTexto() {
        File archivo = new File("textos.txt");

        if (archivo.exists()) {
            BufferedReader br = null;
            try {
                br = new BufferedReader(new FileReader(archivo));

                String linea = br.readLine();
                while (linea != null) {
                    System.out.println(linea);

                    linea = br.readLine();
                }

            } catch (IOException ex) {
                ex.printStackTrace();
            } finally {
                try {
                    br.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }


    // =============================================
    //      FICHEROS BINARIOS SIN OBJETOS (JAVA)
    // =============================================

    /**
     * FICHERO BINARIO SIN OBJETOS : ESCRIBIR SIN AÑADIR AL FINAL
     */
    public void escribirFicheroBinario() {
        String nombreFichero = "archivo.dat";
        DataOutputStream escribir = null;

        try {
            //true a continuación del nombreFichero indica que se añaden datos al archivo
            //sin true se añadirán datos desde cero cada vez que se ejecute el método
            escribir = new DataOutputStream(new FileOutputStream(nombreFichero));

            String unString = "cadena guardada";
            double unNumero = 55.3;

            escribir.writeUTF(unString);
            escribir.writeDouble(unNumero);

            for (int i = 0; i < 5; i++) {
                escribir.writeInt(i);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (escribir != null) {
                    escribir.close();
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    /**
     * FICHERO BINARIO SIN OBJETOS : ESCRIBIR AÑADIENDO AL FINAL
     */
    public void anadirFicheroBinario() {
        String nombreFichero = "archivo.dat";
        DataOutputStream escribir = null;

        try {
            //true a continuación del nombreFichero indica que se añaden datos al archivo
            //sin true se añadirán datos desde cero cada vez que se ejecute el método
            escribir = new DataOutputStream(new FileOutputStream(nombreFichero, true));

            String unString = "cadena guardada";
            double unNumero = 55.3;

            escribir.writeUTF(unString);
            escribir.writeDouble(unNumero);

            for (int i = 0; i < 5; i++) {
                escribir.writeInt(i);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (escribir != null) {
                    escribir.close();
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    /**
     * FICHERO BINARIO SIN OBJETOS : LEER
     */
    public void leerFicheroBinario() {
        String nombreFichero = "archivo.dat";
        DataInputStream leer = null;

        try {
            leer = new DataInputStream(new FileInputStream(nombreFichero));

            String algo = leer.readUTF();
            double num = leer.readDouble();
            System.out.println("Lectura binario: " + algo + num);

            while (true) {
                int i = leer.readInt();
            }

        } catch (EOFException e) {
            System.out.println("Fin de fichero");    //catch alcanzado al acabar de leer el fichero
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (leer != null) {
                    leer.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    // =============================================
    //      FICHEROS BINARIOS-OBJETOS (JAVA)
    // =============================================

    /**
     * FICHERO BINARIO-OBJETOS : ESCRIBIR SIN AÑADIR AL FINAL
     */
    public void escribirFicheroBinarioObjetos() {
        String nombreFichero = "archivo.dat";
        ObjectOutputStream escribir = null;

        try {
            //true a continuación del nombreFichero indica que se añaden datos al archivo
            //sin true se añadirán datos desde cero cada vez que se ejecute el método
            escribir = new ObjectOutputStream(new FileOutputStream(nombreFichero, true));

            ArrayList<Avioneta> aviones = new ArrayList<>();

            // se supone que el arraylist anterior estaba ya creado y lleno de objetos Avioneta

            for (int i = 0; i < 5; i++) {
                escribir.writeObject( aviones.get(i) );
            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (escribir != null) {
                    escribir.close();
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    /**
     *
     * FICHERO BINARIO SIN OBJETOS : ESCRIBIR AÑADIENDO AL FINAL : NO SE PUEDE DE MODO BASICO
     *
     */

    /**
     * FICHERO BINARIO-OBJETOS : LEER
     */
    public void leerFicheroBinarioObjetos() {
        String nombreFichero = "archivo.dat";
        ObjectInputStream leer = null;

        try {
            leer = new ObjectInputStream(new FileInputStream(nombreFichero));


            // creamos una lista nueva para rellenarla con lo que se lea
            ArrayList<Avioneta> nuevosaviones = new ArrayList<>();
            nuevosaviones.add(new Avioneta());

            while(true){
                Avioneta av = (Avioneta) leer.readObject();
                nuevosaviones.add(av);
            }

        } catch (EOFException e) {
            System.out.println("Fin de fichero");     //catch alcanzado al acabar de leer el fichero
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException ex) {   //catch arrojado por la lectura del obejto
            ex.printStackTrace();
        } finally {
            try {
                if (leer != null) {
                    leer.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}

//Clases auxiliares para los ejemplos
class Avioneta {

    private String nombre;
    private int nummotores;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNummotores() {
        return nummotores;
    }

    public void setNummotores(int nummotores) {
        this.nummotores = nummotores;
    }

}




class Cliente {
    private String nombre;
    private String cif;
}



class Concepto{
    private String descripcion;
    private int importe;
}


class Factura{
    private int idFactura;

    // Cliente es una relacion de Agregacion con la clase Factura
    // pues una factura esta compuesta de un cliente
    // Pero el Cliente puede existir independientemente de que exista la factura
    private Cliente cliente;
    // Concepto es una relacion de Composicion con la clase Factura
    // pues una factura esta compuesta de Conceptos
    // Pero los Conceptos NO tiene sentido que existan si no existe la factura
    private Concepto[] conceptos;

}





