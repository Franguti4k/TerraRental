package com.example.terrarental;
import java.util.ArrayList;
/**
 * @author Francisco Javier Gutierrez Gallego
 * @author Gina Andrea Ramirez Guerrero
 * @author Pedro Zuñeda Diego
 * @author Santiago Valderrama Flores
 */
public class Admin extends Usuario implements Menus{
    private static  Admin instance;
    private ArrayList<Vehiculo> vehiculos;
    private ArrayList<Cliente> clientes;

    /**
     * Constructor de Admin
     * @param DNI DNI de admin
     * @param password contraseña de admin
     */
    public Admin(String DNI, String password) {
        super(DNI,"", password, "");
    }

    /**
     * get de instancia
     * @return devuelve la instancia
     */
    public static Admin getInstance() {
        if(instance == null){
            instance = new Admin("admin ","adminpassword");
        }
        return instance;
    }

    /**
     * set de instancia
     * @param instance recibe la instancia
     */
    public static void setInstance(Admin instance) {
        Admin.instance = instance;
    }

    /**
     * get de vehiculos
     * @return devuelve la lista de vehiculos
     */
    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    /**
     * set de vehiculos
     * @param vehiculos ArrayList de vehiculos
     */
    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    /**
     * get de clientes
     * @return devuelve la lista de clientes
     */
    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    /**
     * set de clientes
     * @param clientes ArrayList de clientes
     */
    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    /**
     * Metodo para inicializar el sistema
     * Carga los clientes y vehiculos de los archivos
     */
    public void inicializarSistema(){
        setClientes(GestorDeArchivos.CargarClientes());
        setVehiculos(GestorDeArchivos.cargarVehiculos());
    }

    /**
     * Metodo que muestra el menu de administrador
     * @param Clientes ArrayList de clientes
     * @param Vehiculos ArrayList de Vehiculos
     */
    @Override
    public void Menu(ArrayList<Cliente> Clientes, ArrayList<Vehiculo> Vehiculos) {

    }
}
