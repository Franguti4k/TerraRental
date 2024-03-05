package TerraRental;

import java.util.ArrayList;

/**
 * @author Francisco Javier Gutierrez Gallego
 * @author Gina Andrea Ramirez Guerrero
 * @author Pedro Zuñeda Diego
 * @author Santiago Valderrama Flores
 */
public class Main {


    public static void main(String[] args) {
        //En pruebas
        Admin admin = new Admin(null, null);
        Fecha fecha1 = new Fecha(14,4,2002);
        Fecha fecha2 = new Fecha(31, 12, 2045);
        Fecha fecha3 = new Fecha(13,5,2004);
        Fecha fecha4 = new Fecha(23, 8, 2040);
        Cliente cliente = new Cliente("78965455455J", "Gina", "hola","hola", fecha1, fecha2,null);
        Cliente cliente2 = new Cliente("50337957L", "Francisco", "Hola_mundo","Hola_mundo", fecha3, fecha4,null);
        ArrayList<Cliente> clientes = new ArrayList<>();
        //Prueba guardar clientes
        clientes.add(cliente);
        clientes.add(cliente2);
        GestorDeArchivos.guardarClientes(clientes);
        //prueba cargar clientes
        admin.setClientes(GestorDeArchivos.CargarClientes());
        System.out.println(admin.getClientes().getFirst().getNombre() + " y " + admin.getClientes().getLast().getNombre());
    }

}