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
}
