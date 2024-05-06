package TerraRental.Controlador;

import TerraRental.Vista.ClienteGUI;
import TerraRental.Vista.Menus;

import java.text.ParseException;
import java.util.ArrayList;

/**
 * @author Francisco Javier Gutierrez Gallego
 * @author Gina Andrea Ramirez Guerrero
 * @author Pedro Zuñeda Diego
 * @author Santiago Valderrama Flores
 */
public class Cliente extends Usuario implements Menus {


    private Fecha fecha_Nacimiento;
    private Fecha cadCarnet;
    private Vehiculo vehiculoAlquilado;



    /**
     * Constructor de Cliente
     * @param DNI DNI del cliente
     * @param nombre Nombre del cliente
     * @param password contraseña del cliente
     * @param pistaPassword Pista de la contraseña del cliente
     * @param fecha_Nacimiento fecha de nacimiento
     * @param cadCarnet fecha de caducidad del carnet de conducir
     * @param vehiculoAlquilado vehiculo alquilado por el cliente
     */
    public Cliente(String DNI, String nombre, String password, String pistaPassword, Fecha fecha_Nacimiento, Fecha cadCarnet, Vehiculo vehiculoAlquilado) {
        super(DNI, nombre, password, pistaPassword);
        this.fecha_Nacimiento = fecha_Nacimiento;
        this.cadCarnet = cadCarnet;
        this.vehiculoAlquilado = vehiculoAlquilado;
    }

    /**
     * get de fecha de nacimiento
     * @return devuelve la fecha de nacimiento
     */
    public Fecha getFecha_Nacimiento() { return fecha_Nacimiento; }

    /**
     * set de fecha de nacimiento
     * @param fecha_Nacimiento recibe una fecha de nacimiento
     */
    public void setFecha_Nacimiento(Fecha fecha_Nacimiento) { this.fecha_Nacimiento = fecha_Nacimiento; }

    /**
     * Get de vehiculoAlquilado
     * @return devuelve vehiculoAlquilado
     */
    public Vehiculo getVehiculoAlquilado() {
        return vehiculoAlquilado;
    }

    /**
     * set de vehiculoAlquilado
     * @param vehiculoAlquilado recibe vehiculoAlquilado
     */
    public void setVehiculoAlquilado(Vehiculo vehiculoAlquilado) {
        this.vehiculoAlquilado = vehiculoAlquilado;
    }

    /**
     * get de cadCarnet
     * @return devuelve cadCarnet
     */
    public Fecha getCadCarnet() { return cadCarnet; }

    /**
     * set de cadCarnet
     * @param cadCarnet recibe cadCarnet
     */

    public void setCadCarnet(Fecha cadCarnet) { this.cadCarnet = cadCarnet; }



    //Implementar metodos de cliente:  Selección de categoría, Detalles del vehículo, Selección de fechas de alquiler, Reserva y pago

    /**
     * Método que cambia la contraseña del usuario actual
     * @param passwordActual La contraseña actual
     * @param passwordNueva La nueva contraseña
     */
    public void cambiarPassword(String passwordActual, String passwordNueva) throws PasswordIncorrectaException {
        if (!ComprobarPassword(passwordActual)) {
            throw new PasswordIncorrectaException("Contraseña actual incorrecta");
        }
        setPassword(passwordNueva);
        System.out.println("Contraseña cambiada correctamente");
    }

    /**
     * Excepción propia para cuando la contraseña actual es incorrecta
     */
    public class PasswordIncorrectaException extends Exception {
        public PasswordIncorrectaException(String mensaje) {
            super(mensaje);
        }
    }

    /**
     * Método que busca un usuario por su DNI
     * @param DNI DNI del usuario
     * @param Usuarios ArrayList de usuarios
     * @return El usuario encontrado o null si no se encuentra
     */
    public static Cliente buscarUsuarioPorDNI(String DNI, ArrayList<Cliente> Usuarios) {
        if (Usuarios == null) {
            return null;
        }
        for (Cliente usuario : Usuarios) {
            if (usuario.getDNI().equals(DNI)) {
                return usuario;
            }
        }
        return null;
    }


    /**
     * Metodo Metodo toArchivoString que devuelve un string con los datos del cliente
     * @return Devuelve un string con los datos del cliente
     */
    public String toArchivoString() {
        // Convierte los vehiculos reservados en una cadena
        String reservados = "";
        String fechaNac = "";
        String fechaCad = "";

        Vehiculo vehiculo = vehiculoAlquilado;
        // Convierte cada vehiculo en una cadena con el formato categoria|marca|modelo|matricula
       // String vehiculoInfo = vehiculo.getCategoria() + "," + vehiculo.getMarca() + "," + vehiculo.getModelo() + "," + vehiculo.getMatricula();

        // Añade el vehiculo a la cadena de reservados
        //reservados += vehiculoInfo;

        Fecha fecha1 = fecha_Nacimiento;
        fechaNac = fecha1.getDia() + "," + fecha1.getMes() + "," + fecha1.getAnyo();
        Fecha fecha2 = cadCarnet;
        fechaCad = fecha2.getDia() + "," + fecha2.getMes() + "," + fecha2.getAnyo();

        // Devuelve una cadena con el formato DNI,nombre,password,pistaPassword y con los vehiculos reservados preparados anteriormente
        return getDNI() + "," + getNombre() + "," +  getPassword() + "," + fechaNac + "," + fechaCad + reservados;
    }

    /**
     * Método estático para crear un objeto Cliente a partir de un String.
     * Este método recibe una cadena de texto que contiene los datos del cliente y crea un objeto Cliente.
     * El formato esperado para el String debe ser: DNI,nombre,password,pistaPassword,diaNacimiento,mesNacimiento,anioNacimiento,diaCadCarnet,mesCadCarnet,anioCadCarnet
     * @param linea La cadena de texto que contiene los datos del cliente.
     * @return Un objeto Cliente creado a partir de la cadena de texto proporcionada.
     * @throws ParseException Si ocurre un error al analizar la cadena de texto.
     */
    public static Cliente fromString(String linea) throws ParseException {
        String[] partes = linea.split(",");
        String DNI = partes[0];
        String nombre = partes[1];
        String password = partes[2];
        String pistaPassword = partes[3];
        int diaNacimiento = Integer.parseInt(partes[4]);
        int mesNacimiento = Integer.parseInt(partes[5]);
        int anioNacimiento = Integer.parseInt(partes[6]);
        int diaCadCarnet = Integer.parseInt(partes[7]);
        int mesCadCarnet = Integer.parseInt(partes[8]);
        int anioCadCarnet = Integer.parseInt(partes[9]);

        Fecha fechaNacimiento = new Fecha(diaNacimiento, mesNacimiento, anioNacimiento);
        Fecha fechaCadCarnet = new Fecha(diaCadCarnet, mesCadCarnet, anioCadCarnet);

        return new Cliente(DNI, nombre, password, pistaPassword, fechaNacimiento, fechaCadCarnet, null);
    }

    @Override
    public void Menu(ArrayList<Cliente> Clientes, ArrayList<Vehiculo> Vehiculos,ArrayList<Gerente> Gerentes) {
      new ClienteGUI(this);
    }


}
