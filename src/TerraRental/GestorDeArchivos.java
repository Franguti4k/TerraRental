package TerraRental;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class GestorDeArchivos {
    //Ruta de los archivos (pongo final para que no se puedan modificar)
    private  static final String ARCHIVO_CLIENTES = "Clientes.txt";
    private static final  String ARCHIVO_VEHICULOS = "Vehiculos.txt";

    /**
     * Metodo guardarClientes que guarda los clientes en un archivo
     * @param clientes ArrayList de clientes
     */
    public static void guardarClientes(ArrayList<Cliente> clientes){
        try (PrintWriter out = new PrintWriter((new FileWriter(ARCHIVO_CLIENTES)))) {
            for (Cliente cliente : clientes){
                out.println(cliente.toArchivoString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo que cargaClientes que carga los clientes de un archivo
     * @return devuelve un ArrayList de clientes
     */
    public static ArrayList<Cliente> CargarClientes() {
        //creamos un ArrayList de clientes
        ArrayList<Cliente> clientes = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(ARCHIVO_CLIENTES))){
            //Mientras haya siguiente linea lo añadimos al ArrayList
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                clientes.add(Cliente.fromString(linea));
            }
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return clientes;
    }

    /**
     * Metodo para guardar los vehiculos en un archivo
     * @param vehiculos ArrayList de vehiculos
     */
    public static void guardarVehiculos(ArrayList<Vehiculo> vehiculos) {
        try (PrintWriter out = new PrintWriter(new FileWriter(ARCHIVO_VEHICULOS))){
            for(Vehiculo vehiculo : vehiculos){
                out.println(vehiculo.toArchivoString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo cargarVehiculos que carga los vehiculos de un archivo
     * @return devuelve un ArrayList de vehiculos
     */
    public  static ArrayList<Vehiculo> cargarVehiculos(){
        ArrayList<Vehiculo> vehiculos = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(ARCHIVO_VEHICULOS))){
            while (scanner.hasNextLine()){
                String linea = scanner.nextLine();
                vehiculos.add(Vehiculo.fromString(linea));
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return vehiculos;
    }
}



