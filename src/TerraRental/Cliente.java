package TerraRental;
/**
 * @author Francisco Javier Gutierrez Gallego
 * @author Gina Andrea Ramirez Guerrero
 * @author Pedro Zuñeda Diego
 * @author Santiago Valderrama Flores
 */
public class Cliente extends Usuario{

   private Vehiculo vehiculoAlquilado;


    /**
     * Constructor de Cliente
     * @param DNI DNI del cliente
     * @param nombre Nombre del cliente
     * @param password contraseña del cliente
     * @param pistaPassword Pista de la contraseña del cliente
     * @param vehiculoAlquilado vehiculo alquilado por el cliente
     */
    public Cliente(String DNI, String nombre, String password, String pistaPassword, Vehiculo vehiculoAlquilado) {
        super(DNI, nombre, password, pistaPassword);
        this.vehiculoAlquilado = vehiculoAlquilado;
    }

    /**
     * Metodo Metodo toArchivoString que devuelve un string con los datos del cliente
     * @return Devuelve un string con los datos del cliente
     */
    public String toArchivoString() {
        // Convierte los libros reservados en una cadena
        String reservados = "";

            Vehiculo vehiculo = vehiculoAlquilado;
            // Convierte cada libro en una cadena con el formato ISBN|Título|Autor
            String vehiculoInfo = vehiculo.getCategoria() + "|" + vehiculo.getMarca() + "|" + vehiculo.getModelo() + "|" + vehiculo.getMatricula();

            // Añade el libro a la cadena de reservados
            reservados += vehiculoInfo;

        // Devuelve una cadena con el formato DNI,nombre,password,pistaPassword y con los libros reservados preparados anteriormente
        return getDNI() + "," + getNombre() + "," + getPistaPassword() + "," + getPistaPassword() + "," + reservados;
    }

    /**
     * Metodo fromString que crea un cliente a partir de una linea del archivo de clientes
     * @param linea Linea de texto
     * @return Devuelve un usuario
     */
    public static Cliente fromString(String linea) {
        // Divide la línea por comas y crea un cliente con los datos
        String[] partes = linea.split(",");
        Cliente cliente;
        if (partes.length > 4 && !partes[4].isEmpty()) {
            cliente = new Cliente(partes[0], partes[1], partes[2], partes[3], null);
            String[] reserva = partes[4].split(";");

            for (String alquilado : reserva) {
                String[] detallesVehiculo = alquilado.split("\\|");
                Categoria categoria = Categoria.valueOf(detallesVehiculo[0]);
                int precio = Integer.parseInt(detallesVehiculo[3]);
                Tipo tipo = Tipo.valueOf(detallesVehiculo[4]);
                Cambio cambio = Cambio.valueOf(detallesVehiculo[5]);
                int litros = Integer.parseInt(detallesVehiculo[6]);
                int caballos = Integer.parseInt(detallesVehiculo[7]);
                double kilometraje = Double.parseDouble(detallesVehiculo[9]);
                cliente.vehiculoAlquilado = new Vehiculo(categoria, detallesVehiculo[1], detallesVehiculo[2], precio,tipo,cambio,litros,caballos,detallesVehiculo[8],kilometraje,detallesVehiculo[10]);
            }
        } else {
            cliente = new Cliente(partes[0], partes[1], partes[2], partes[3], null);
        }
        return cliente;
    }


}
