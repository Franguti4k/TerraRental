package TerraRental;

public class Vehiculo {
    private Categoria categoria;
    private String marca;
    private String modelo;
    private int precio;
    private int litros;
    private int caballos;
    private String color;
    private int kilometraje;

    public Vehiculo() {}

    public Vehiculo(Categoria categoria, String marca, String modelo, int precio, int litros, int caballos, String color, int kilometraje) {
        this.categoria = categoria;
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        this.litros = litros;
        this.caballos = caballos;
        this.color = color;
        this.kilometraje = kilometraje;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getLitros() {
        return litros;
    }

    public void setLitros(int litros) {
        this.litros = litros;
    }

    public int getCaballos() {
        return caballos;
    }

    public void setCaballos(int caballos) {
        this.caballos = caballos;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(int kilometraje) {
        this.kilometraje = kilometraje;
    }

}
