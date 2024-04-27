package TerraRental.Controlador;
/**
 * @author Francisco Javier Gutierrez Gallego
 * @author Gina Andrea Ramirez Guerrero
 * @author Pedro Zuñeda Diego
 * @author Santiago Valderrama Flores
 */
public class Gerente extends Usuario{
    /**
     * Constructor
     *
     * @param dni           DNI del usuario
     * @param nombre        Nombre del usuario
     * @param password      Contraseña del usuario
     * @param pistaPassword Pista de la contraseña del usuario
     */
    public Gerente(String dni, String nombre, String password, String pistaPassword) {
        super(dni, nombre, password, pistaPassword);
    }
}
