package TerraRental.Vista;

import TerraRental.Controlador.Admin;
import TerraRental.Controlador.Cliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Clase que representa la interfaz gráfica para iniciar sesión
 */
public class IniciarSesionGUI extends JFrame implements ActionListener {
    private final JTextField txtDNI;
    private final JPasswordField txtPassword;
    private final JButton btnIniciarSesion;
    private final JButton btnCancelar;
    private final JButton btnRecuperarPassword;


    /**
     * Constructor de la clase IniciarSesionGUI que muestra la interfaz gráfica para iniciar sesión
     */
    public IniciarSesionGUI() {
        // Configuración del JFrame
        setTitle("Iniciar Sesión");
        setSize(420, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear y configurar JPanel con GridLayout
        JPanel panel = new JPanel(new GridLayout(2, 2, 10, 10));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));



        // Añadiendo componentes al panel
        panel.add(new JLabel("DNI:"));
        txtDNI = new JTextField();
        panel.add(txtDNI);

        panel.add(new JLabel("Contraseña:"));
        txtPassword = new JPasswordField();
        panel.add(txtPassword);

        // Botones
        btnIniciarSesion = new JButton("Iniciar Sesión");
        btnCancelar = new JButton("Cancelar");
        btnRecuperarPassword = new JButton("Recuperar Contraseña");

        panel.add(btnIniciarSesion);
        panel.add(btnCancelar);
        panel.add(btnRecuperarPassword);

        btnIniciarSesion.addActionListener(this);
        btnCancelar.addActionListener(this);
        btnRecuperarPassword.addActionListener(this);

        add(panel);
        setVisible(true);
        setLocationRelativeTo(null);
    }

    /**
     * Método que procesa los eventos de la interfaz gráfica
     * @param e el evento
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnIniciarSesion) {
            String dniIngresado = txtDNI.getText();
            String passwordIngresado = new String(txtPassword.getPassword());

            // Lógica para verificar el inicio de sesión
            if (Admin.getInstance().ComprobarPassword(passwordIngresado)) {
                // Inicio de sesión como administrador
                Admin.getInstance().Menu(Admin.getInstance().getClientes(), Admin.getInstance().getVehiculos());
                dispose();
            } else {
                Cliente usuario = Cliente.buscarUsuarioPorDNI(dniIngresado, Admin.getInstance().getClientes());
                if (usuario != null) {
                    if (usuario.ComprobarPassword(passwordIngresado)) {
                        // Inicio de sesión como usuario de la biblioteca
                        usuario.Menu(Admin.getInstance().getClientes(), Admin.getInstance().getVehiculos());
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(this, "Contraseña incorrecta.", "Error de Inicio de Sesión", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "DNI o contraseña incorrectos.", "Error de Inicio de Sesión", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else if (e.getSource() == btnCancelar) {
            dispose(); // Cierra la ventana al hacer clic en Cancelar
        }
        else if (e.getSource() == btnRecuperarPassword) {

            RestablecerContrasenaGUI ventanaRestablecer = new RestablecerContrasenaGUI(Admin.getInstance().getClientes());
            ventanaRestablecer.pack();
            ventanaRestablecer.setVisible(true);
        }
    }
}