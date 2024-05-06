package TerraRental.Vista;

import TerraRental.Controlador.Admin;
import TerraRental.Controlador.Cliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class ClienteGUI extends JFrame implements ActionListener {
    private Cliente usuarioActual;
    private JButton btnReservarVehiculo,  btnDevolverVehiculo, btnCambiarPassword, btnSalir;
    /**
     * Constructor de la clase InterfazUsuario que recibe un usuario y muestra la interfaz gráfica para el usuario
     * @param usuario el usuario
     */
    public ClienteGUI(Cliente usuario) {
        this.usuarioActual = usuario;
        // Titulo y tamaño de la ventana
        setTitle("Menú Cliente");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(210, 250);

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

        btnDevolverVehiculo = new JButton("Devolver vehiculo");
        btnCambiarPassword = new JButton("Cambiar Contraseña");
        btnSalir = new JButton("Salir");

        Dimension buttonSize = new Dimension(70, 50);
        btnReservarVehiculo.setPreferredSize(buttonSize);
        btnDevolverVehiculo.setPreferredSize(buttonSize);
        btnCambiarPassword.setPreferredSize(buttonSize);
        btnSalir.setPreferredSize(buttonSize);

        btnReservarVehiculo.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnDevolverVehiculo.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnCambiarPassword.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnSalir.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Añadimos los botones al panel
        panel.add(btnReservarVehiculo);
        panel.add(btnDevolverVehiculo);
        panel.add(btnCambiarPassword);
        panel.add(btnSalir);

        // Añadimos los listeners a los botones
        btnReservarVehiculo.addActionListener(this);
        btnDevolverVehiculo.addActionListener(this);
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
            new VisualizarVehiculosGUI(Admin.getInstance().getVehiculos()); // Abre la ventana para reservar un vehiculo
        }  /*else if (e.getSource() == btnDevolverVehiculo) {
            new DevolverLibroGUI(usuarioActual, Admin.getInstance().getVehiculos()); // Abre la ventana para devolver un vehiculo
        }*/ else if (e.getSource() == btnCambiarPassword) {
            new RestablecerContrasenaGUI(Admin.getInstance().getClientes()); // Abre la ventana para cambiar la contraseña
        } else if (e.getSource() == btnSalir) {
            dispose(); // Cierra la ventana
            new IniciarSesionGUI(); // Abre la interfaz de inicio de sesión
        }
    }


}