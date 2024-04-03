package TerraRental;

import java.util.ArrayList;

/**
 * @author Francisco Javier Gutierrez Gallego
 * @author Gina Andrea Ramirez Guerrero
 * @author Pedro Zuñeda Diego
 * @author Santiago Valderrama Flores
 */
public class Main {

    /**
     * Metodo main
     * @param args argumentos del metodo main
     */
    public static void main(String[] args) {
        Admin.getInstance().inicializarSistema();
        new TerraRentalGUI();
    }

}