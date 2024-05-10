package TerraRental.Vista;

import TerraRental.Controlador.Cliente;
import TerraRental.Controlador.Gerente;
import TerraRental.Controlador.Vehiculo;

import java.util.ArrayList;
/**
 * @author Francisco Javier Gutierrez Gallego
 * @author Gina Andrea Ramirez Guerrero
 * @author Santiago Valderrama Flores
 */

/**
 * Interfaz Menus
 * Contiene el metodo Menu que se implementa en Cliente, TerraRental y Gerente
 */
public interface Menus {
    void Menu(ArrayList<Cliente> Clientes, ArrayList<Vehiculo> Vehiculos, ArrayList<Gerente> Gerentes);
}