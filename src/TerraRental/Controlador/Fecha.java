package TerraRental.Controlador;

public class Fecha {
    private int dia;
    private int mes;
    private int anyo;

    /**
     * Constructor de la clase Fecha
     * @param dia
     * @param mes
     * @param anyo
     */
    public Fecha(int dia, int mes, int anyo) {
        this.dia = dia;
        this.mes = mes;
        this.anyo = anyo;
    }

    /**
     * get de dia
     * @return devuelve el dia
     */
    public int getDia() { return dia; }

    /**
     * set de dia
     * @param dia recibe un dia
     */
    public void setDia(int dia) { this.dia = dia; }

    /**
     * get de mes
     * @return devuelve el mes
     */
    public int getMes() { return mes; }

    /**
     * set de mes
     * @param mes recibe un mes
     */
    public void setMes(int mes) { this.mes = mes; }

    /**
     * get de año
     * @return devuelve el año
     */
    public int getAnyo() { return anyo; }

    /**
     * set de año
     * @param anyo recibe un año
     */
    public void setAnyo(int anyo) { this.anyo = anyo; }

    public static int diasEnMes(int mes, int anyo) {
        if (mes <= 7) {
            if (mes % 2 == 1)
                return 31;

            else if (mes != 2)
                return 30;

            else if (anyo % 400 != 0)
               return 29;

            else
               return 28;

        } else {
            if (mes % 2 == 1)
                return 30;

            else
                return 31;
        }
    }

    public static boolean fechaValida(int dia, int mes, int anyo) {

        if (anyo < 0 || mes < 1 || mes > 12 || dia < 1 || dia > diasEnMes(mes, anyo))
            return false;
        else return true;
    }

    public boolean isGreaterThan(Fecha f) {
        if (this.anyo <= f.anyo) return false;
        else if (this.mes <= f.mes) return false;
        else return this.dia > f.dia;
    }
    public static class fechaNoValidaException extends Exception {
        public fechaNoValidaException (String mensaje) {super(mensaje);}
    }
}
