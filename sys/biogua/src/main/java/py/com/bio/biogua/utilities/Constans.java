/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.bio.biogua.utilities;

/**
 *
 * @author acrajovi
 */
public class Constans {

    /* PARAMETROS GENERALES */
    public static final String PG_GENERIC_PASS = "GENERIC_PASS";
    public static final String PG_TIEMPO_MAX_INACTIVIDAD = "TIEMPO_MAX_INACTIVIDAD";

    /* FORMATOS DE FECHAS */
    public static final String FORMATO_FECHA_DDMMYYYY_1 = "dd/MM/yyyy";
    public static final String FORMATO_FECHA_DDMMYYYY_2 = "dd-MM-yyyy";
    public static final String FORMATO_FECHA_YYYYMMDD_1 = "yyyy/MM/dd";
    public static final String FORMATO_FECHA_YYYYMMDD_2 = "yyyy-MM-dd";
    public static final String FORMATO_HORA_HH_MM = "HH:mm";

    /*ESTADOS_PERSONAS*/
    public static final int COD_ESTADO_PERSONA_ACTIVO = 1;

    /**
     * Retorna el link de la pagina de BIO
     *
     * @return
     */
    public static String getLinkBio() {
        return "http://www.bio.com.py";
    }

    public static String thiss() {
        return "C:\\BIO\\";
    }

    public static String getclas() {
        return "bio.key";
    }

    public static String getDirectorioDescargas() {
        return "c:\\BIO\\BIOKAA\\Descargas\\";
    }

    public static String getDirectorioDescargaInformesVentas() {
        return "c:\\BIO\\BIOKAA\\Descargas\\Ventas\\";
    }

    public static String getDirectorioDescargaInformesCompras() {
        return "c:\\BIO\\BIOKAA\\Descargas\\Compras\\";
    }

    public static String getCaracterTab() {
        return "\u0009";
    }

    public static final String USUARIO_ANONIMO = "anonymousUser";

}
