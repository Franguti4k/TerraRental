package TerraRental;

public class Admin extends Usuario{
    /**
     * Constructor
     *
     * @param dni           DNI del usuario
     * @param nombre        Nombre del usuario
     * @param password      Contraseña del usuario
     * @param pistaPassword Pista de la contraseña del usuario
     */
    public Admin(String dni, String nombre, String password, String pistaPassword) {
        super(dni, nombre, password, pistaPassword);
    }
}
