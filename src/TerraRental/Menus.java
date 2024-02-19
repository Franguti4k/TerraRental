package TerraRental;

import java.util.ArrayList;

/**
 * Interfaz Menus
 * Contiene el metodo Menu que se implementa en Cliente, Admin //y futuramente en los demas usuarios
 */
public interface Menus {
    void Menu(ArrayList<Cliente> Clientes, ArrayList<Vehiculo> Vehiculos);
}
