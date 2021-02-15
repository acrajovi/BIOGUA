/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.bio.biogua.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author BIOST
 */
public class Formated {

    private SimpleDateFormat dateFormat = null;

    public Formated() {
        dateFormat = new SimpleDateFormat();
    }

    /**
     * METODO QUE DEVUELVE TRUE/FALSE SI ESTA VACIO EL OBJETO PASADO
     *
     *
     * @param obj
     * @return
     */
    public static boolean isEmpty(Object obj) {
        return obj == null || "".equals(obj) || " ".equals(obj) || "  ".equals(obj) || "   ".equals(obj);
    }
//METODO DE FORMATEO DE FECHAS

    /*metodo que recibe un string y devuelve un DATE g formateado de numero*/
    public Date getDateParse(String sDate) throws Exception {
        Date dDateFormat = null;
        dDateFormat = dateFormat.parse(sDate);
        return dDateFormat;
    }

    /*metodoq ue recibe el patron a agregar a la fecha*/
    public void setDatePattern(String sPattern) {
        dateFormat.applyPattern(sPattern);
    }

    /*metodo que recibe un tipo date y devuelve un string segun el formateo pasado en sPattern*/
    public String getDateFormat(Date dDate) throws Exception {
        String sFormat = null;
        sFormat = dateFormat.format(dDate);
        return sFormat;
    }
}
