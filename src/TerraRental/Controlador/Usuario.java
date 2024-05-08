package TerraRental.Controlador;
/**
 * @author Francisco Javier Gutierrez Gallego
 * @author Gina Andrea Ramirez Guerrero
 * @author Pedro Zuñeda Diego
 * @author Santiago Valderrama Flores
 */
public abstract class Usuario {
    private String DNI;
    private String nombre;
    private String password;
    private String email;

    /**
     * Constructor de la clase Usuario
     * @param DNI DNI del usuario
     * @param nombre Nombre del usuario
     * @param password Contraseña del usuario
     * @param email Email del usuario
     */
    public Usuario(String DNI, String nombre, String password, String email) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.password = password;
        this.email = email;
    }
    /**
     * Metodo getDNI
     * @return devuelve el DNI del usuario
     */
    public String getDNI() {
        return DNI;
    }

    /**
     * Metodo setDNI
     * @param DNI DNI del usuario
     */
    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    /**
     * Metodo setPassword
     * @param password Contraseña del usuario
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Metodo para recuperar la contraseña en caso de que el usuario la haya olvidado
     * @param DNI
     * @param nuevaContraseña
     */


    /**
     * Metodo getNombre
     * @return devuelve el nombre del usuario
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo setNombre
     * @param nombre Nombre del usuario
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo getPassword
     * @return devuelve la contraseña del usuario
     */
    public String getPassword() {
        return password;
    }


    /**
     * Metodo ComprobarPassword
     * @param password Contraseña del usuario
     * @return devuelve true si la contraseña es correcta
     */
    public boolean ComprobarPassword(String password) {
        return this.password.equals(password);
    }

    /**
     * Metodo validarDNI
     * @param DNI DNI del usuario
     * @return devuelve true si el DNI es correcto
     */
    public static boolean validarDNI(String DNI) {
        if (DNI.length() != 9) {
            return false; // Si la longitud no es 9, no es un DNI válido.
        }
        for (int i = 0; i < 8; i++) {
            if (DNI.charAt(i) < '0' || DNI.charAt(i) > '9') {
                return false; // Si algún carácter no es un dígito, no es un DNI válido.
            }
        }
        char letra = DNI.charAt(8);
        return Character.isLetter(letra); // Devuelve true si el último carácter es una letra.
    }

    public static class chkEmailExcxeption extends Exception {
        public chkEmailExcxeption (String mensaje) { super(mensaje); }
    }

    public static boolean chkEmail (String email) {
        String[] partes = email.split("@");

        if (partes.length > 2) {
            return false;
        }

        String uEmail = partes [0];
        String dominio = partes [1];

        if (uEmail.isEmpty() || dominio.isEmpty()) return false;
        if (!dominio.contains(".")) return false;

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}


