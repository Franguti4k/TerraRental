package TerraRental.Controlador;

import TerraRental.Modelo.Cambio;
import TerraRental.Modelo.Categoria;
import TerraRental.Modelo.Tipo;
import TerraRental.Vista.ClienteGUI;
import TerraRental.Vista.Menus;

import java.text.ParseException;
import java.util.ArrayList;

/**
 * @author Francisco Javier Gutierrez Gallego
 * @author Gina Andrea Ramirez Guerrero
 * @author Santiago Valderrama Flores
 */
public class Cliente extends Usuario implements Menus {


    private Fecha fecha_Nacimiento;
    private Fecha cadCarnet;
    private ArrayList<Reserva> reservas;
    private static Cliente clienteActual;


    /**
     * Constructor de Cliente
     *
     * @param DNI              DNI del cliente
     * @param nombre           Nombre del cliente
     * @param password         contraseña del cliente
     * @param email            E-mail del cliente
     * @param fecha_Nacimiento fecha de nacimiento
     * @param cadCarnet        fecha de caducidad del carnet de conducir
     * @param reservas          reserva realizada por el cliente por el cliente
     */
    public Cliente(String DNI, String nombre, String password, String email, Fecha fecha_Nacimiento, Fecha cadCarnet, ArrayList<Reserva> reservas) {
        super(DNI, nombre, password, email);
        this.fecha_Nacimiento = fecha_Nacimiento;
        this.cadCarnet = cadCarnet;
        this.reservas = reservas;
    }

    /**
     * Metodo para que otros metodos establezcan e identifiquen el cliente que actualmente tiene la sesion iniciada
     * @param cliente
     */
    public static void setClienteActual(Cliente cliente) {
        clienteActual = cliente;
    }


    /**
     * get de fecha de nacimiento
     *
     * @return devuelve la fecha de nacimiento
     */
    public Fecha getFecha_Nacimiento() {
        return fecha_Nacimiento;
    }

    /**
     * set de fecha de nacimiento
     *
     * @param fecha_Nacimiento recibe una fecha de nacimiento
     */
    public void setFecha_Nacimiento(Fecha fecha_Nacimiento) {
        this.fecha_Nacimiento = fecha_Nacimiento;
    }

    /**
     * Get de vehiculoAlquilado
     *
     * @return devuelve vehiculoAlquilado
     */
    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    /**
     * set de vehiculoAlquilado
     *
     * @param reservas recibe reservas
     */
    public void setReservas(ArrayList<Reserva> reservas) {
        this.reservas = reservas;
    }

    /**
     * get de cadCarnet
     *
     * @return devuelve cadCarnet
     */
    public Fecha getCadCarnet() {
        return cadCarnet;
    }

    /**
     * set de cadCarnet
     *
     * @param cadCarnet recibe cadCarnet
     */

    public void setCadCarnet(Fecha cadCarnet) {
        this.cadCarnet = cadCarnet;
    }


    //Implementar metodos de cliente:  Selección de categoría, Detalles del vehículo, Selección de fechas de alquiler, Reserva y pago

    /**
     * Método que cambia la contraseña del usuario actual
     *
     * @param passwordNueva La nueva contraseña
     */
    public void cambiarPassword(String passwordNueva) throws PasswordIncorrectaException {
        if (clienteActual == null) {
            throw new IllegalStateException("No hay ningún cliente con la sesión iniciada");
        }

        clienteActual.setPassword(passwordNueva);
        GestorDeArchivos.guardarClientes(TerraRental.getInstance().getClientes());
        System.out.println("Contraseña cambiada correctamente");
    }


    /**
     * Excepción propia para cuando la contraseña actual es incorrecta
     */
    public static class PasswordIncorrectaException extends Exception {
        public PasswordIncorrectaException(String mensaje) {
            super(mensaje);
        }
    }

    /**
     * Método que busca un usuario por su DNI
     *
     * @param DNI      DNI del usuario
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
     * Metodo que busca a un usuario por su email
     * @param email
     * @param clientes
     * @return
     */
    public static Cliente buscarUsuarioPorEmail(String email, ArrayList<Cliente> clientes) {
        for (Cliente cliente : clientes) {
            if (cliente.getEmail().equals(email)) {
                return cliente;
            }
        }
        return null;
    }



    /**
     * Metodo Metodo toArchivoString que devuelve un string con los datos del cliente
     *
     * @return Devuelve un string con los datos del cliente
     */
    public String toArchivoString() {
        // Convierte los vehiculos reservados en una cadena
        String reservados = "";
        String fechaNac = "";
        String fechaCad = "";


        ArrayList<Reserva> reserva = reservas;
        if (reserva != null) {
            for (Reserva reserva1 : reservas) {
                //Convierte cada vehiculo en una cadena con el formato categoria|marca|modelo|matricula
                String reservaInfo = reserva1.getVehiculoReserva().getCategoria() + "," + reserva1.getVehiculoReserva().getMarca() + "," + reserva1.getVehiculoReserva().getModelo()
                        + "," + reserva1.getVehiculoReserva().getPrecio() + "," + reserva1.getVehiculoReserva().getTipo() + ","
                        + reserva1.getVehiculoReserva().getCambio() + "," + reserva1.getVehiculoReserva().getLitros() + "," + reserva1.getVehiculoReserva().getCaballos()
                        + "," + reserva1.getVehiculoReserva().getColor() + "," + reserva1.getVehiculoReserva().getKilometraje() + "," + reserva1.getVehiculoReserva().getMatricula()
                        + "," + reserva1.getFechaInicio().getDia() + "," + reserva1.getFechaInicio().getMes() + "," + reserva1.getFechaInicio().getAnyo()
                        + "," + reserva1.getFechaFinal().getDia() + "," + reserva1.getFechaFinal().getMes() + "," + reserva1.getFechaFinal().getAnyo();

                reservados += reservaInfo;

            }
        }

    Fecha fecha1 = fecha_Nacimiento;
    fechaNac =fecha1.getDia()+","+fecha1.getMes()+","+fecha1.getAnyo();
    Fecha fecha2 = cadCarnet;
    fechaCad =fecha2.getDia()+","+fecha2.getMes()+","+fecha2.getAnyo();


        // Devuelve una cadena con el formato DNI,nombre,password,pistaPassword y con los vehiculos reservados preparados anteriormente
        return getDNI() + "," + getNombre() + "," +  getPassword() + "," + getEmail() + ',' + fechaNac + "," + fechaCad + "," + reservados;
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
        String email = partes [3];
        int diaNacimiento = Integer.parseInt(partes[4]);
        int mesNacimiento = Integer.parseInt(partes[5]);
        int anioNacimiento = Integer.parseInt(partes[6]);
        int diaCadCarnet = Integer.parseInt(partes[7]);
        int mesCadCarnet = Integer.parseInt(partes[8]);
        int anioCadCarnet = Integer.parseInt(partes[9]);

        Fecha fechaNacimiento = new Fecha(diaNacimiento, mesNacimiento, anioNacimiento);
        Fecha fechaCadCarnet = new Fecha(diaCadCarnet, mesCadCarnet, anioCadCarnet);

        //Si el cliente tiene coche reservado
        if (partes.length > 11){
            int i = 10;
            ArrayList<Reserva> reservas = new ArrayList<>();
            while (i!= partes.length) {
                Categoria categoria = Categoria.valueOf(partes[i]);
                i++;
                String marca = partes[i];
                i++;
                String modelo = partes[i];
                i++;
                int precio = Integer.parseInt(partes[i]);
                i++;
                Tipo tipo = Tipo.valueOf(partes[i]);
                i++;
                Cambio cambio = Cambio.valueOf(partes[i]);
                i++;
                int litros = Integer.parseInt(partes[i]);
                i++;
                int caballos = Integer.parseInt(partes[i]);
                i++;
                String color = partes[i];
                i++;
                double kilometraje = Double.parseDouble(partes[i]);
                i++;
                String matricula = partes[i];
                i++;
                Vehiculo vehiculo = new Vehiculo(categoria, marca, modelo, precio, tipo, cambio, litros, caballos, color, kilometraje, matricula);
                int diaInicio = Integer.parseInt(partes[i]);
                i++;
                int mesInicio = Integer.parseInt(partes[i]);
                i++;
                int yearInicio = Integer.parseInt(partes[i]);
                i++;
                Fecha fechaInicio = new Fecha(diaInicio, mesInicio, yearInicio);
                int diaFinal = Integer.parseInt(partes[i]);
                i++;
                int mesFinal = Integer.parseInt(partes[i]);
                i++;
                int yearFinal = Integer.parseInt(partes[i]);
                i++;
                Fecha fechaFinal = new Fecha(diaFinal, mesFinal, yearFinal);
                Reserva reserva1 = new Reserva(vehiculo, fechaInicio, fechaFinal);
                reservas.add(reserva1);
            }
                return new Cliente(DNI, nombre, password, email, fechaNacimiento, fechaCadCarnet, reservas);

        }

        return new Cliente(DNI, nombre, password, email, fechaNacimiento, fechaCadCarnet, null);
    }

    @Override
    public void Menu(ArrayList<Cliente> Clientes, ArrayList<Vehiculo> Vehiculos,ArrayList<Gerente> Gerentes) {
      new ClienteGUI(this);
    }


}
