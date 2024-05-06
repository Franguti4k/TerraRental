package TerraRental.Controlador;

import TerraRental.Vista.Menus;

import java.text.ParseException;
import java.util.ArrayList;

/**
 * @author Francisco Javier Gutierrez Gallego
 * @author Gina Andrea Ramirez Guerrero
 * @author Pedro Zuñeda Diego
 * @author Santiago Valderrama Flores
 */
public class Gerente extends Usuario implements Menus {

    /**
     * Constructor
     *
     * @param dni           DNI del usuario
     * @param nombre        Nombre del usuario
     * @param password      Contraseña del usuario
     * @param pistaPassword Pista de la contraseña del usuario
     */
    public Gerente(String dni, String nombre, String password, String pistaPassword) {
        super(dni, nombre, password);
    }


    /**
     * Metodo Metodo toArchivoString que devuelve un string con los datos del gerente
     * @return Devuelve un string con los datos del gerente
     */
    public String toArchivoString() {


        // Devuelve una cadena con el formato DNI,nombre,password,pistaPassword y con los vehiculos reservados preparados anteriormente
        return getDNI() + "," + getNombre() + "," +  getPassword();
    }

    /**
     * Método estático para crear un objeto Gerente a partir de un String.
     * Este método recibe una cadena de texto que contiene los datos del gerente y crea un objeto Gerente.
     * El formato esperado para el String debe ser: DNI,nombre,password,pistaPassword
     * @param linea La cadena de texto que contiene los datos del gerente.
     * @return Un objeto Gerente creado a partir de la cadena de texto proporcionada.
     * @throws ParseException Si ocurre un error al analizar la cadena de texto.
     */
    public static Gerente fromString(String linea) throws ParseException {
        String[] partes = linea.split(",");
        String DNI = partes[0];
        String nombre = partes[1];
        String password = partes[2];
        String pistaPassword = partes[3];

        return new Gerente(DNI, nombre, password, pistaPassword);
    }

    // Método para añadir un vehículo a la flota
    public void agregarVehiculo(Vehiculo vehiculo) {
        TerraRental.getInstance().getVehiculos().add(vehiculo);
    }

    // Método para retirar un vehículo de la flota
    public void retirarVehiculo(Vehiculo vehiculo) {
        TerraRental.getInstance().getVehiculos().remove(vehiculo);
    }

    @Override
    public void Menu(ArrayList<Cliente> Clientes, ArrayList<Vehiculo> Vehiculos,ArrayList<Gerente> Gerentes) {

    }
}
