package TerraRental.Vista;

import TerraRental.Controlador.Admin;
import TerraRental.Controlador.Vehiculo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * Clase que representa la interfaz gráfica para el menú principal desde el que se puede iniciar sesión o crear un usuario
 */
public class TerraRentalGUI extends JFrame implements ActionListener {
    private final JButton btnIniciarSesion;
    private final JButton btnCrearUsuario;
    private final JButton btnVisualizarVehiculos;
    private final JButton btnCerrar;

    /**
     * Constructor de la clase TerraRentalGUI que muestra la interfaz gráfica para el menú principal
     */
    public TerraRentalGUI() {
        // Configuración del JFrame
        setTitle("Menú Principal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);

        // Creando y configurando un JPanel con BoxLayout
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Cargar y añadir la imagen
        ImageIcon imageIcon = new ImageIcon("TerraRental_Logo.jpg");
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(imageLabel);

        // Crear botón "Visualizar Vehículos"
        btnVisualizarVehiculos = new JButton("Visualizar Vehículos");
        Dimension buttonSize = null;
        btnVisualizarVehiculos.setPreferredSize(buttonSize);
        btnVisualizarVehiculos.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnVisualizarVehiculos.addActionListener(this);



        // Creando botones y configurando su alineación
        buttonSize = new Dimension(50, 70);
        btnIniciarSesion = new JButton("Iniciar Sesión");
        btnCrearUsuario = new JButton("Crear Usuario");
        btnCerrar = new JButton("Cerrar");
        btnIniciarSesion.setPreferredSize(buttonSize);
        btnCrearUsuario.setPreferredSize(buttonSize);
        btnCerrar.setPreferredSize(buttonSize);
        btnIniciarSesion.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnCrearUsuario.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnCerrar.setAlignmentX(Component.CENTER_ALIGNMENT);

        btnIniciarSesion.addActionListener(this);
        btnCrearUsuario.addActionListener(this);
        btnCerrar.addActionListener(this);

        // Añadiendo botones al panel
        panel.add(btnIniciarSesion);
        panel.add(btnCrearUsuario);
        panel.add(btnVisualizarVehiculos);
        panel.add(btnCerrar);

        // Añadiendo el panel al JFrame
        getContentPane().add(panel);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * Método que procesa los eventos de la interfaz gráfica
     * @param e el evento
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnIniciarSesion) {
            new IniciarSesionGUI(); // Si se presiona el botón de iniciar sesión, se muestra la interfaz gráfica para iniciar sesión
        } else if (e.getSource() == btnCrearUsuario) {
            new AddUsuarioGUI(Admin.getInstance().getClientes()); // Si se presiona el botón de crear usuario, se muestra la interfaz gráfica para crear un usuario
        }
            // Manejar el evento del botón "Visualizar Vehículos"
            else if (e.getSource() == btnVisualizarVehiculos) {
                // Obtener la lista de vehículos disponibles
                ArrayList<Vehiculo> vehiculos = Admin.getInstance().getVehiculos();
                // Crear y mostrar la ventana para visualizar vehículos
                new VisualizarVehiculosGUI(vehiculos);
            }
         else if (e.getSource() == btnCerrar) {
            System.exit(0);
        }
    }
}