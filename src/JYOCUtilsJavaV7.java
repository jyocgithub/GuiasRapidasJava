
import java.io.*;
//import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.TimeZone;
import java.util.regex.Pattern;

/*

#######################################################################################
############################  GUIA DE CONTENIDOS ######################################
#######################################################################################
#                                                                                     #
# SCANNER SIMPLIFICADO                                                                #
# ####################                                                                #
#     - leerInt     (String mensaje)                                                  #
#     - leerDouble  (String mensaje)                                                  #
#     - leerString  (String mensaje)                                                  #
#                                                                                     #
# DATE (JAVA)                                                                         #
# ###########                                                                         #
#    - hoyEnDate                   ()                                                 #
#    - dateToString                (Date fechaEnDate, String formato)                 #
#    - stringToDate                (String fechaEnString)                             #
#    - calendarToString            (Calendar fechaEnCalendar, String formato)         #
#    - stringToCalenda             (String fechaEnString)                             #
#    - dateUTILtoSQL               (java.util.Date fechaEnUtil                        #
#    - dateSQLtoUTIL               (java.sql.Date fechaEnSql)                         #
#    - hoy_enStringParaMySQL       ()                                                 #
#    - dateUtil_enStringParaMySQL  (java.util.Date fecha)                             #
#    - diferenciaEnDiasEntreDates  (Date fechaMayor, Date fechaMenor)                 #
#    - diferenciaEnAnosEntreDates  (Date fechaMayor, Date fechaMenor)                 #
#    - diferenciaEnMinutosEntreDates  (Date fechaMayor, Date fechaMenor)              #
#    - milisegundosConFormato         (long milisegundos, String formato)             #
#                                                                                     #
# FICHEROS  (JAVA)                                                                    #
# ################                                                                    #
#    - hermanosQueSonCarpetas  (File origen)                                          #
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
     * ***************************************************************************
     * ******* SCANNER SIMPLIFICADO *************
     * ***************************************************************************
     */

    /**
     * leerInt Lee con scanner un numero int, precio envio de un mensaje a usuario
     *
     * @param mensaje se muestra al usuario antes de que este escribe el valor
     *                pedido
     * @return el valor int que el usuario introduce por teclado
     */
    public static int leerInt(String mensaje) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.println(mensaje);
                int numero = sc.nextInt();
                return numero;
            } catch (NumberFormatException ex) {
                System.out.println("Debe indicar un valor numerico entero");
            }
        }
    }

    /**
     * leerDouble Lee con scanner un numero double, precio envio de un mensaje a
     * usuario
     *
     * @param mensaje se muestra al usuario antes de que este escribe el valor
     *                pedido
     * @return el valor double que el usuario introduce por teclado
     */
    public static double leerDouble(String mensaje) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.println(mensaje);
                double numero = sc.nextDouble();
                return numero;
            } catch (NumberFormatException ex) {
                System.out.println("Debe indicar un valor numerico entero");
            }
        }
    }

    /**
     * leerString Lee con scanner un string, precio envio de un mensaje a usuario
     *
     * @param mensaje se muestra al usuario antes de que este escribe el valor
     *                pedido
     * @return el valor String que el usuario introduce por teclado
     */
    public static String leerString(String mensaje) {
        Scanner sc = new Scanner(System.in);
        System.out.println(mensaje);
        String res = sc.nextLine();
        return res;
    }

    /**
     * ***************************************************************************
     * ************ DATE (JAVA) **************
     * ***************************************************************************
     */
    /**
     * hoyEnDate
     *
     * @return la fecha actual en formato DATE
     */
    public static Date hoyEnDate() {
        Calendar cc = Calendar.getInstance();
        Date hoyEnDate = cc.getTime();
        return hoyEnDate;
//        return Calendar.getInstance().getTime();

    }

    /**
     * dateToString
     * <p>
     * convertir de un Date de java.util a STRING, con un formato
     *
     * @param fechaEnDate Objeto Date de la fecha a cambiar
     * @param formato     formato, como p.e. "dd/MM/yyyy" Si se idica null, se usa
     *                    por defecto "dd/MM/yyyy"
     * @return fecha en string en dicho formato, por ejemplo, "12/22/2016", o null
     * si la fecha del parametro es null
     */
    public static String dateToString(Date fechaEnDate, String formato) {
        if (fechaEnDate == null) {
            return null;
        }
        if (formato == null) {
            formato = "dd/MM/yyyy";
        }
        SimpleDateFormat miFormato = new SimpleDateFormat(formato);
        String fechaEnString = miFormato.format(fechaEnDate);
        return fechaEnString;
    }

    /**
     * stringToDate
     * <p>
     * Convierte un String en un util.Date
     *
     * @param fechaEnString Objeto String de la fecha a cambiar
     * @param formato       formato, como p.e. "dd/MM/yyyy" Si se idica null, se usa
     *                      por defecto "dd/MM/yyyy"
     * @return fecha en formato java.util o null si la fecha del parametro es null
     */
    public static Date stringToDate(String fechaEnString, String formato) {
        if (fechaEnString == null) {
            return null;
        }
        if (formato == null) {
            formato = "dd/MM/yyyy";
        }
        Date fechaenjava = null;
        SimpleDateFormat miFormato2 = new SimpleDateFormat(formato);
        try {
            fechaenjava = miFormato2.parse(fechaEnString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return fechaenjava;
    }

    /**
     * calendarToString
     * <p>
     * convertir de un Calendar a STRING, con un formato
     *
     * @param fechaEnCalendar Objeto Calendar de la fecha a cambiar
     * @param formato         formato, como p.e. "dd/MM/yyyy" Si se idica null, se usa
     *                        por defecto "dd/MM/yyyy"
     * @return fecha en string en dicho formato, por ejemplo, "12/22/2016", o null
     * si la fecha del parametro es null
     */
    public static String calendarToString(Calendar fechaEnCalendar, String formato) {
        if (fechaEnCalendar == null) {
            return null;
        }
        if (formato == null) {
            formato = "dd/MM/yyyy";
        }

        java.util.Date fechaEnDate = fechaEnCalendar.getTime();
        SimpleDateFormat miFormato = new SimpleDateFormat(formato);
        String fechaEnString = miFormato.format(fechaEnDate);
        return fechaEnString;
    }

    /**
     * stringToCalendar
     * <p>
     * Convierte un String en un Calendar
     *
     * @param fechaEnString Objeto String de la fecha a cambiar
     * @param formato       Formato, como p.e. "dd/MM/yyyy" Si se idica null, se usa
     *                      por defecto "dd/MM/yyyy"
     * @return fecha en formato Calendar o null si la fecha del parametro es null
     */
    public static Calendar stringToCalendar(String fechaEnString, String formato) {
        if (fechaEnString == null) {
            return null;
        }
        if (formato == null) {
            formato = "dd/MM/yyyy";
        }

        SimpleDateFormat miFormato2 = new SimpleDateFormat(formato);
        Date fechaenjava = null;
        try {
            fechaenjava = miFormato2.parse(fechaEnString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fechaenjava);
        return calendar;
    }


    public static String localdateToString(LocalDate fechaEnlocaldate, String formato) {
        if (fechaEnlocaldate == null) {
            return null;
        }
        if (formato == null) {
            formato = "dd/MM/yyyy";
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formato);
        String fechaenstring = fechaEnlocaldate.format(formatter);
        return fechaenstring;
    }


    public static LocalDate stringToLocaldate(String fechaEnString, String formato) {
        if (fechaEnString == null) {
            return null;
        }
        if (formato == null) {
            formato = "dd/MM/yyyy";
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formato);
        LocalDate localdate = LocalDate.parse(fechaEnString, formatter);
        return localdate;
    }

    /**
     * dateUTILtoSQL
     * <p>
     * convertir de un Date de java.util a u Date de Sql
     *
     * @param fechaEnUtil Objeto Date de la fecha a cambiar, com oDate de UTIL
     * @return fecha en Date, como Date de SQL, o null si la fecha del parametro es
     * null
     */
    public static java.sql.Date dateUTILtoSQL(java.util.Date fechaEnUtil) {
        if (fechaEnUtil == null) {
            return null;
        }
        java.sql.Date fechaEnSql = null;
        fechaEnSql = new java.sql.Date(fechaEnUtil.getTime());
        return fechaEnSql;
    }

    /**
     * dateSQLtoUTIL
     * <p>
     * convertir de un Date de java.util a u Date de Sql
     *
     * @param fechaEnSql Objeto Date de la fecha a cambiar, com oDate de SQL
     * @return fecha en UTIL , COMO Date de UTIL, o null si la fecha del parametro
     * es null
     */
    public static java.util.Date dateSQLtoUTIL(java.sql.Date fechaEnSql) {
        if (fechaEnSql == null) {
            return null;
        }
        java.util.Date fechaEnUtil = null;
        // opcion 1, la mas correcta
        fechaEnUtil = new java.util.Date(fechaEnSql.getTime());
        // opcion 2, la mas simple, con casting implícito, que NO HACE FALTA HACER
        // TRANSFORMACION
        // fechaEnUtil = fechaEnSql;
        return fechaEnUtil;
    }

    /**
     * hoy_enStringParaMySQL
     * <p>
     * Conseguir el String del dia de hoy para una query de MySql
     *
     * @return fecha de hoy com STRING para consulas MYSQL
     */
    public static String hoy_enStringParaMySQL() {
        Calendar cc = Calendar.getInstance();
        Date hoyEnDate = cc.getTime();
        SimpleDateFormat miFormato = new SimpleDateFormat("dd/MM/yyyy");
        String hoyEnString = miFormato.format(hoyEnDate);
        return "STR_TO_DATE('" + hoyEnString + "','%d/%m/%Y')";
    }

    /**
     * dateUtil_enStringParaMySQL
     * <p>
     * Conseguir el String del dia que se pasa por parametro para una query de MySql
     *
     * @return fecha de hoy com STRING para consulas MYSQL, o null si la fecha del
     * parametro es null
     */

    public static String dateUtil_enStringParaMySQL(java.util.Date fecha) {
        if (fecha == null) {
            return null;
        }
        String hoyEnStringSql = null;
        SimpleDateFormat miFormato = new SimpleDateFormat("dd/MM/yyyy");
        String hoyEnString = miFormato.format(fecha);
        hoyEnStringSql = "STR_TO_DATE('" + hoyEnString + "','%d/%m/%Y')";
        return hoyEnStringSql;
    }

    /**
     * diferenciaEnDiasEntreDates
     * <p>
     * devuelve el numero de dias existente entre dos date
     *
     * @param fechaMayor
     * @param fechaMenor
     * @return dias de diferencia como un int, o -1 si alguna fecha de los
     * parametros es null o la fecha menor no es menor que la mayor
     */

    public static int diferenciaEnDiasEntreDates(Date fechaMayor, Date fechaMenor) {
        if (fechaMayor == null || fechaMenor == null || fechaMayor.getTime() < fechaMenor.getTime()) {
            return -1;
        }
        long diferenciaEnMilisegs = fechaMayor.getTime() - fechaMenor.getTime();
        long dias = diferenciaEnMilisegs / (1000 * 60 * 60 * 24);
        return (int) dias;
    }

    /**
     * diferenciaEnAnosEntreDates
     * <p>
     * devuelve el numero de años existente entre dos date
     *
     * @param fechaMayor
     * @param fechaMenor
     * @return años de diferencia como un int, o -1 si alguna fecha de los
     * parametros es null o la fecha menor no es menor que la mayor
     */
    public static int diferenciaEnAnosEntreDates(Date fechaMayor, Date fechaMenor) {
        if (fechaMayor == null || fechaMenor == null || fechaMayor.getTime() < fechaMenor.getTime()) {
            return -1;
        }
        long diferenciaEnMilisegs = fechaMayor.getTime() - fechaMenor.getTime();
        long dias = diferenciaEnMilisegs / (1000 * 60 * 60 * 24);
        return (int) (dias / 356) - 1;
    }

    /**
     * diferenciaEnMinutosEntreDates
     * <p>
     * devuelve el numero de minutos existente entre dos date,
     *
     * @param fechaMayor
     * @param fechaMenor
     * @return minutos de diferencia como un int, o -1 si alguna fecha de los
     * parametros es null o la fecha menor no es menor que la mayor
     */
    public static int diferenciaEnMinutosEntreDates(Date fechaMayor, Date fechaMenor) {
        if (fechaMayor == null || fechaMenor == null || fechaMayor.getTime() < fechaMenor.getTime()) {
            return -1;
        }
        long diferenciaEnMilisegs = fechaMayor.getTime() - fechaMenor.getTime();
        long minutos = diferenciaEnMilisegs / (1000 * 60);
        return (int) minutos;
    }

    /*
     * edadEnAnios <p> devuelve un int que representa el numero de años enteros
     * desde una edad dada hasta hoy
     *
     * @param anonacimiento date con la fecha de nacimiento
     *
     * @return int con la edad en anios, o -1 si la fecha del parametro es null
     */
    public static int edadEnAnios(Date anonacimiento) {
        if (anonacimiento == null) {
            return -1;
        }

        Date hoyEnDate = Calendar.getInstance().getTime();

        Calendar a = Calendar.getInstance();
        a.setTime(anonacimiento);
        Calendar b = Calendar.getInstance();
        b.setTime(hoyEnDate);

        int diff = b.get(Calendar.YEAR) - a.get(Calendar.YEAR);
        if (a.get(Calendar.MONTH) > b.get(Calendar.MONTH) || (a.get(Calendar.MONTH) == b.get(Calendar.MONTH)
                && a.get(Calendar.DAY_OF_MONTH) > b.get(Calendar.DAY_OF_MONTH))) {
            diff--;
        }
        return diff;
    }

    /**
     * milisegundosConFormato
     * <p>
     * devuelve un Stroing que representa un numero de milisegundos, segun un
     * formato establecido del orden de las fechas
     *
     * @param milisegundos milisegundos a calcular
     * @param formato      String que representa el formato de salida. Ejepmlos:
     *                     "dd-MM-yy" , "mm:ss"
     * @return String con la fecha formateada
     */
    public static String milisegundosConFormato(long milisegundos, String formato) {
        Date date = new Date(milisegundos);
        DateFormat formatter = new SimpleDateFormat(formato);
        formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
        return formatter.format(date);
    }

    /**
     * ***************************************************************************
     * ************ FICHEROS (JAVA) **************
     * ***************************************************************************
     */

    /**
     * hermanosQueSonCarpetas
     * <p>
     * Devuelve una List de File, con los
     * hermanos de la carpeta actual que tambien
     * son carpetas
     *
     * @param origen Objeto File que representa el directorio actual
     * @return List de File, con los hermanos de la carpeta actual que tambien son
     * carpetas
     */
    public List<File> hermanosQueSonCarpetas(File origen) {
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
     * @param expresion expresion regular que comprueba el valor
     * @param valor     valor que se  quiere comprobar
     * @return true si el valor cumple la expresion regular dada
     */
    public static boolean validarRegEx(String expresionregular, String valor) {
//		return valor.matches(expresionregular);  // otra forma
        return Pattern.matches(expresionregular, valor);
    }


    // por si alguien quiere probar los metodos previos .......
    public static void main(String[] args) throws IOException {


        String ano = "1992";
        Calendar c =stringToCalendar(ano,"yyyy");
        System.out.println(c);
        String s = calendarToString(c,"yyyy");
        System.out.println(s);





    }

}
