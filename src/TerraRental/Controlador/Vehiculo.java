package TerraRental.Controlador;

import TerraRental.Modelo.Cambio;
import TerraRental.Modelo.Categoria;
import TerraRental.Modelo.Tipo;

import java.util.ArrayList;

/**
 * @author Francisco Javier Gutierrez Gallego
 * @author Gina Andrea Ramirez Guerrero
 * @author Pedro Zuñeda Diego
 * @author Santiago Valderrama Flores
 */
public class Vehiculo {
    private Categoria categoria;
    private String marca;
    private String modelo;
    private int precio;
    private Tipo tipo;
    private Cambio cambio;
    private int litros;
    private int caballos;
    private String color;
    private double kilometraje;
    private String matricula;

    /**
     * Constructor de Vehiculo
     * @param categoria categoria del vehiculo
     * @param marca marca del vehiculo
     * @param modelo modelo del vehiculo
     * @param precio precio del vehiculo
     * @param tipo tipo del vehiculo
     * @param cambio cambio del vehiculo
     * @param litros litros del vehiculo
     * @param caballos caballos del vehiculo
     * @param color color del vehiculo
     * @param kilometraje kilometraje del vehiculo
     * @param matricula matricula del vehiculo
     */
    public Vehiculo(Categoria categoria, String marca, String modelo, int precio, Tipo tipo, Cambio cambio, int litros, int caballos, String color, double kilometraje, String matricula) {
        this.categoria = categoria;
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        this.tipo = tipo;
        this.cambio = cambio;
        this.litros = litros;
        this.caballos = caballos;
        this.color = color;
        this.kilometraje = kilometraje;
        this.matricula = matricula;
    }


    /**
     * get de categoria
     * @return devuelve la categoria
     */
    public Categoria getCategoria() {
        return categoria;
    }

    /**
     * set de categoria
     * @param categoria recibe la categoria
     */
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    /**
     * get de marca
     * @return devuelve la marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * set de marca
     * @param marca recibe la marca
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * get de modelo
     * @return devuelve el modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * set de modelo
     * @param modelo recibe el modelo
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * get de precio
     * @return devuelve el precio
     */
    public int getPrecio() {
        return precio;
    }

    /**
     * set de precio
     * @param precio recibe el precio
     */
    public void setPrecio(int precio) {
        this.precio = precio;
    }

    /**
     * get de tipo
     * @return devuelve el tipo
     */
    public Tipo getTipo() { return tipo; }

    /**
     * set de tipo
     * @param tipo recibe el tipo
     */
    public void setTipo(Tipo tipo) { this.tipo = tipo; }

    /**
     * get de cambio
     * @return devuelve el cambio
     */
    public Cambio getCambio() { return cambio; }

    /**
     * set de cambio
     * @param cambio recibe el cambio
     */
    public void setCambio(Cambio cambio) { this.cambio = cambio; }

    /**
     * get de litros
     * @return devuelve los litros
     */
    public int getLitros() {
        return litros;
    }

    /**
     * set de litros
     * @param litros recibe los litros
     */
    public void setLitros(int litros) {
        this.litros = litros;
    }

    /**
     * get de caballos
     * @return devuelve los caballos
     */
    public int getCaballos() {
        return caballos;
    }

    /**
     * set de caballos
     * @param caballos recibe los caballos
     */
    public void setCaballos(int caballos) {
        this.caballos = caballos;
    }

    /**
     * get color
     * @return devuelve el color
     */
    public String getColor() {
        return color;
    }

    /**
     * set color
     * @param color recibe el color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * get kilometraje
     * @return devuelve el kilometraje
     */
    public double getKilometraje() { return kilometraje; }

    /**
     * set kilometraje
     * @param kilometraje recibe el kilometraje
     */
    public void setKilometraje(double kilometraje) { this.kilometraje = kilometraje; }

    /**
     * get de matricula
     * @return devuelve la matricula
     */
    public String getMatricula() { return matricula; }

    /**
     * set de matricula
     * @param matricula recibe la matricula
     */
    public void setMatricula(String matricula) { this.matricula = matricula; }

    /**
     * Busca un vehículo por matrícula.
     * @param matricula la matrícula a buscar
     * @return el vehículo correspondiente a la matrícula, o null si no se encuentra
     */
    public static Vehiculo buscarPorMatricula(String matricula, ArrayList<Vehiculo> vehiculos) {
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getMatricula().equals(matricula)) {
                return vehiculo;
            }
        }
        return null; // Si no se encuentra la matrícula
    }

    /**
     * Metodo toString que devuelve una cadena con los atributos del libro
     * @return devuelve una cadena con los atributos del libro
     */
    public String toArchivoString(){ return categoria + "," + marca + "," + modelo + "," + precio + "," + tipo + "," + cambio + "," + litros + "," + caballos + "," + color + "," + kilometraje + "," + matricula; }

    /**
     * Metodo fromString que recibe una cadena y devuelve un vehiculo
     * @param linea cadena con los atributos del vehiculo
     * @return devuelve un vehiculo
     */
    public static Vehiculo fromString(String linea) {
        String[] partes = linea.split(",");
        Categoria categoria = Categoria.valueOf(partes[0]);
        String marca = partes[1];
        String modelo = partes[2];
        int precio = Integer.parseInt(partes[3]);
        Tipo tipo = Tipo.valueOf(partes[4]);
        Cambio cambio = Cambio.valueOf(partes[5]);
        int litros = Integer.parseInt(partes[6]);
        int caballos = Integer.parseInt(partes[7]);
        String color = partes[8];
        double kilometraje = Double.parseDouble(partes[9]);
        String matricula = partes[10];
        return new Vehiculo(categoria, marca, modelo, precio, tipo, cambio, litros, caballos, color, kilometraje, matricula);
    }

}
