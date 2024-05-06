package TerraRental.Controlador;


import TerraRental.Vista.Menus;

import java.util.ArrayList;
/**
 * @author Francisco Javier Gutierrez Gallego
 * @author Gina Andrea Ramirez Guerrero
 * @author Pedro Zuñeda Diego
 * @author Santiago Valderrama Flores
 */
public class Admin extends Usuario implements Menus {
    private static  Admin instance;
    private ArrayList<Vehiculo> vehiculos;
    private ArrayList<Cliente> clientes;
    private ArrayList<Gerente> gerentes;

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
     * get de gerentes
     * @return devuelve la lista de gerentes
     */
    public ArrayList<Gerente> getGerentes() {
        return gerentes;
    }

    /**
     * set de gerentes
     * @param gerentes ArrayList de clientes
     */
    public void setGerentes(ArrayList<Gerente> gerentes) {
        this.gerentes = gerentes;
    }

    /**
     * Metodo para inicializar el sistema
     * Carga los clientes y vehiculos de los archivos
     */
    public void inicializarSistema(){
        setClientes(GestorDeArchivos.CargarClientes());
        setVehiculos(GestorDeArchivos.cargarVehiculos());
        setGerentes(GestorDeArchivos.CargarGerentes());
    }

    /**
     * Metodo para añadir un usuario
     * @param DNI DNI del usuario
     * @param nombre Nombre del usuario
     * @param password Contraseña del usuario
     * @param pistaPassword Pista de la contraseña del usuario
     * @param fechaNac Fecha de nacimiento
     * @param fechaCad Fecha de caducidad del carnet
     * @param Usuarios ArrayList de usuarios de la biblioteca
     */
    public void addUsuario(String DNI, String nombre, String password, String pistaPassword, Fecha fechaNac, Fecha fechaCad, ArrayList<Cliente> Usuarios) throws DNIInvalidoException, UsuarioYaExisteException {
        // Validar el DNI
        if (!Cliente.validarDNI(DNI)) {
            throw new DNIInvalidoException("El DNI introducido no es válido.");
        }
        // Comprobar si el usuario ya existe
        for (Cliente usuario : Usuarios) {
            if (usuario.getDNI().equals(DNI)) {
                throw new UsuarioYaExisteException("Un usuario con este DNI ya existe.");
            }
        }
        // Crear un nuevo usuario y agregarlo a la lista
        Cliente nuevoUsuario = new Cliente(DNI, nombre, password, pistaPassword, fechaNac, fechaCad, null);
        Usuarios.add(nuevoUsuario);
    }



    /**
     * Excepcion para cuando el DNI no es valido
     */
    public static class DNIInvalidoException extends Exception {
        public DNIInvalidoException(String mensaje) {
            super(mensaje);
        }
    }

    public static class ContraseñaNoCoincideException extends Exception {
        public ContraseñaNoCoincideException (String mensaje) {
            super(mensaje);
        }
    }

    /**
     * Excepcion para cuando el usuario ya existe
     */
    public static class UsuarioYaExisteException extends Exception {
        public UsuarioYaExisteException(String mensaje) {
            super(mensaje);
        }
    }

    /**
     * Excepcion para cuando hay campos vacios
     */
    public static class CamposVaciosException extends Exception {
        public CamposVaciosException(String mensaje) {
            super(mensaje);
        }
    }

    /**
     * Metodo que muestra el menu de administrador
     * @param Clientes ArrayList de clientes
     * @param Vehiculos ArrayList de Vehiculos
     * @param Vehiculos ArrayList de Gerentes
     */
    @Override
    public void Menu(ArrayList<Cliente> Clientes, ArrayList<Vehiculo> Vehiculos, ArrayList<Gerente> Gerentes) {

    }

}
