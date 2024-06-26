package TerraRental.Vista;

import TerraRental.Controlador.TerraRental;
import TerraRental.Controlador.Cliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * @author Francisco Javier Gutierrez Gallego
 * @author Gina Andrea Ramirez Guerrero
 * @author Santiago Valderrama Flores
 */

public class ClienteGUI extends JFrame implements ActionListener {
    private Cliente usuarioActual;
    private JButton btnReservarVehiculo,  btnVisualizarVehiculo, btnCambiarPassword, btnSalir;
    /**
     * Constructor de la clase InterfazUsuario que recibe un usuario y muestra la interfaz gráfica para el usuario
     * @param usuario el usuario
     */
    public ClienteGUI(Cliente usuario) {
        this.usuarioActual = usuario;
        // Titulo y tamaño de la ventana
        setTitle("Menú Cliente");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);

        // Creación del panel
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // JLabel de bienvenida
        JLabel lblBienvenida = new JLabel("Bienvenido, " + usuarioActual.getNombre());
        lblBienvenida.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblBienvenida.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(lblBienvenida);

        // Inicialización y configuración de los botones
        btnReservarVehiculo = new JButton("Reservar vehiculo");

        btnVisualizarVehiculo = new JButton("Ver reserva");
        btnCambiarPassword = new JButton("Cambiar Contraseña");
        btnSalir = new JButton("Salir");

        Dimension buttonSize = new Dimension(70, 50);
        btnReservarVehiculo.setPreferredSize(buttonSize);
        btnVisualizarVehiculo.setPreferredSize(buttonSize);
        btnCambiarPassword.setPreferredSize(buttonSize);
        btnSalir.setPreferredSize(buttonSize);

        btnReservarVehiculo.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnVisualizarVehiculo.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnCambiarPassword.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnSalir.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Añadimos los botones al panel
        panel.add(btnReservarVehiculo);
        panel.add(btnVisualizarVehiculo);
        panel.add(btnCambiarPassword);
        panel.add(btnSalir);

        // Añadimos los listeners a los botones
        btnReservarVehiculo.addActionListener(this);
        btnVisualizarVehiculo.addActionListener(this);
        btnCambiarPassword.addActionListener(this);
        btnSalir.addActionListener(this);

        getContentPane().add(panel);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * Método que procesa los eventos de la interfaz gráfica
     * @param e el evento
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnReservarVehiculo) {
            new VisualizarVehiculosGUI(usuarioActual, TerraRental.getInstance().getVehiculos()); // Abre la ventana para reservar un vehiculo
        } else if (e.getSource() == btnVisualizarVehiculo) {
            new VisualizarReservaGUI(usuarioActual); // Abre la ventana para ver la reserva
        } else if (e.getSource() == btnCambiarPassword) {
            new RestablecerContrasenaGUI(TerraRental.getInstance().getClientes()); // Abre la ventana para cambiar la contraseña
        } else if (e.getSource() == btnSalir) {
            dispose(); // Cierra la ventana
            new IniciarSesionGUI(); // Abre la interfaz de inicio de sesión
        }
    }


}