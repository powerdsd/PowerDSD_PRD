/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package powerdsd.util;

/**
 *
 * @author W.Wong
 */
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Pattern;

public class Funciones {

    /*
     public static boolean esFecha(CharSequence date) {
		 
     // some regular expression
     String time = "(\\s(([01]?\\d)|(2[0123]))[:](([012345]\\d)|(60))"
     + "[:](([012345]\\d)|(60)))?"; // with a space before, zero or one time
		 
     // no check for leap years (Schaltjahr)
     // and 31.02.2006 will also be correct
     String day = "(([12]\\d)|(3[01])|(0?[1-9]))"; // 01 up to 31
     String month = "((1[012])|(0\\d))"; // 01 up to 12
     String year = "\\d{4}";
		 
     // define here all date format
     ArrayList<Pattern> patterns = new ArrayList<Pattern>();
     patterns.add(Pattern.compile(day + "[-.]" + month + "[-.]" + year + time));
     patterns.add(Pattern.compile(year + "-" + month + "-" + day + time));
     // here you can add more date formats if you want
		 
     // check dates
     for (Pattern p : patterns)
     if (p.matcher(date).matches())
     return true;
		 
     return false;
		 
     }
		  
     */
    public static String fechaDB(Date date) {
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
        String fecha = sdf.format(date);
        return fecha;
    }

    public static boolean esFecha(String fechax) {
        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
            Date fecha = formatoFecha.parse(fechax);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static String fechaActualString() {

        Calendar c = new GregorianCalendar();
        String diaX, mesX, annioX;
        int dia, mes;

        dia = c.get(Calendar.DATE);
        if (dia < 10) {
            diaX = "0" + Integer.toString(dia);
        } else {
            diaX = Integer.toString(dia);
        }

        mes = c.get(Calendar.MONTH) + 1;
        if (mes < 10) {
            mesX = "0" + Integer.toString(mes);
        } else {
            mesX = Integer.toString(mes);
        }

        annioX = Integer.toString(c.get(Calendar.YEAR));

        return annioX + "-" + mesX + "-" + diaX;
    }

    public static String fechaActualInicial() {

        Calendar c = new GregorianCalendar();
        String diaX, mesX, annioX;
        int dia, mes;

        dia = c.get(Calendar.DATE);
        if (dia < 10) {
            diaX = "0" + Integer.toString(dia);
        } else {
            diaX = Integer.toString(dia);
        }

        mes = c.get(Calendar.MONTH) + 1;
        if (mes < 10) {
            mesX = "0" + Integer.toString(mes);
        } else {
            mesX = Integer.toString(mes);
        }

        annioX = Integer.toString(c.get(Calendar.YEAR));

        return diaX + "/" + mesX + "/" + annioX;
    }

    public static int horaActual() {
        // Ambas instanciaciones son v�lidas
        Calendar calendario = new GregorianCalendar();
        //Calendar calendario = Calendar.getInstance();

        int hora, minutos, segundos;

        hora = calendario.get(Calendar.HOUR_OF_DAY);
        //minutos = calendario.get(Calendar.MINUTE);
        //segundos = calendario.get(Calendar.SECOND);

        return hora;
    }

    public static int minutosActual() {
        // Ambas instanciaciones son v�lidas
        Calendar calendario = new GregorianCalendar();
        //Calendar calendario = Calendar.getInstance();

        int hora, minutos, segundos;

        //hora =calendario.get(Calendar.HOUR_OF_DAY);
        minutos = calendario.get(Calendar.MINUTE);
        //segundos = calendario.get(Calendar.SECOND);

        return minutos;
    }

    public static String cambiaFormatoFecha(String fecha) {
        /* String fechax = "";
         String dia,mes,anho;
			   
         if(fecha.equals("") == false && fecha != null){
         dia = fecha.substring(0,2);
         mes = fecha.substring(3,5);
         anho = fecha.substring(6,10);
         fechax = anho+"-"+mes+"-"+dia;
         }
         return fechax;*/
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        try {
            Date _fecha = dateFormat.parse(fecha);

            dateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd");
            return dateFormat.format(_fecha);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static String formatoHora(int hora) {
        String horax = "";

        switch (hora) {
            case 0:
                horax = "12 am";
                break;
            case 1:
                horax = "1 am";
                break;
            case 6:
                horax = "6 am";
                break;
            case 7:
                horax = "7 am";
                break;
            case 8:
                horax = "8 am";
                break;
            case 9:
                horax = "9 am";
                break;
            case 10:
                horax = "10 am";
                break;
            case 11:
                horax = "11 am";
                break;
            case 12:
                horax = "12 m";
                break;
            case 13:
                horax = "1 pm";
                break;
            case 14:
                horax = "2 pm";
                break;
            case 15:
                horax = "3 pm";
                break;
            case 16:
                horax = "4 pm";
                break;
            case 17:
                horax = "5 pm";
                break;
            case 18:
                horax = "6 pm";
                break;
            case 19:
                horax = "7 pm";
                break;
            case 20:
                horax = "8 pm";
                break;
            case 21:
                horax = "9 pm";
                break;
            case 22:
                horax = "10 pm";
                break;
            case 23:
                horax = "11 pm";
                break;
            default:
                horax = "";
        };

        return horax;
    }

    public static boolean isNumeric(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
}
