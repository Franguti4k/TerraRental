package TerraRental;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * Clase que representa la interfaz gráfica para añadir un usuario
 */
public class AddUsuarioGUI extends JFrame implements ActionListener {
    private final JTextField txtDNI;
    private final JTextField txtNombre;
    private final JTextField txtPassword;
    private final JTextField txtConfirmPassword;
    private final JTextField txtFechaNacDia;
    private final JTextField txtFechaNacMes;
    private final JTextField txtFechaNacAnyo;
    private final JTextField txtFechaCadDia;
    private final JTextField txtFechaCadMes;
    private final JTextField txtFechaCadAnyo;
    private final JButton btnGuardar;
    private final JButton btnCancelar;
    private final ArrayList<Cliente> Usuarios;

    /**
     * Constructor de la clase AddUsuarioGUI que recibe un ArrayList de usuarios y muestra la interfaz gráfica para añadir un usuario
     * @param Usuarios ArrayList de clientes
     */
    public AddUsuarioGUI( ArrayList<Cliente> Usuarios) {

        this.Usuarios = Usuarios;

        // Configuración del JFrame
        setTitle("Añadir Usuario");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 280);

        // Crear y configurar JPanel con GridLayout
        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));


        // Etiquetas y campos de texto
        panel.add(new JLabel("DNI:"));
        txtDNI = new JTextField();
        panel.add(txtDNI);

        panel.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        panel.add(txtNombre);

        panel.add(new JLabel("Contraseña:"));
        txtPassword = new JTextField();
        panel.add(txtPassword);

        panel.add(new JLabel("Confirmar Contraseña:"));
        txtConfirmPassword = new JTextField();
        panel.add(txtConfirmPassword);

        panel.add(new JLabel("Dia de nacimiento:"));
        txtFechaNacDia = new JTextField();
        panel.add(txtFechaNacDia);

        panel.add(new JLabel("Mes de nacimiento:"));
        txtFechaNacMes = new JTextField();
        panel.add(txtFechaNacMes);

        panel.add(new JLabel("Año de nacimiento:"));
        txtFechaNacAnyo = new JTextField();
        panel.add(txtFechaNacAnyo);

        panel.add(new JLabel("Dia de Caducidad:"));
        txtFechaCadDia = new JTextField();
        panel.add(txtFechaCadDia);

        panel.add(new JLabel("Mes de Caducidad:"));
        txtFechaCadMes = new JTextField();
        panel.add(txtFechaCadMes);

        panel.add(new JLabel("Año de caducidad:"));
        txtFechaCadAnyo = new JTextField();
        panel.add(txtFechaCadAnyo);

        // Botones
        btnGuardar = new JButton("Guardar");
        btnCancelar = new JButton("Cancelar");

        panel.add(btnGuardar);
        panel.add(btnCancelar);

        btnGuardar.addActionListener(this);
        btnCancelar.addActionListener(this);

        add(panel);
        setVisible(true);
        setLocationRelativeTo(null);
    }

    /**
     * Método que procesa los eventos de la interfaz gráfica
     * @param e el evento
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnGuardar) {
            try {
                String DNI = txtDNI.getText();
                String nombre = txtNombre.getText();
                String password = txtPassword.getText();
                String confirmPassword = txtConfirmPassword.getText();
                int diaNacimiento = Integer.parseInt(txtFechaNacDia.getText());
                int mesNacimiento = Integer.parseInt(txtFechaNacMes.getText());
                int anioNacimiento = Integer.parseInt(txtFechaNacAnyo.getText());
                int diaCadCarnet = Integer.parseInt(txtFechaCadDia.getText());
                int mesCadCarnet = Integer.parseInt(txtFechaCadMes.getText());
                int anioCadCarnet = Integer.parseInt(txtFechaCadAnyo.getText());

                Fecha fechaNac = new Fecha(diaNacimiento, mesNacimiento, anioNacimiento);
                Fecha fechacad = new Fecha(diaCadCarnet, mesCadCarnet, anioCadCarnet);

                // Verificar que ningun campo este vacio
                if (DNI.equals("") || nombre.equals("") || password.equals("") || confirmPassword.equals("")) {
                    throw new Admin.CamposVaciosException("No puede haber campos vacios");
                } else if (confirmPassword != password){
                    throw new Admin.ContraseñaNoCoincideException ("Las contraseñas no coinciden.");
                }

                // Se crea el usuario y se guarda en el archivo de usuarios
                Admin.getInstance().addUsuario(DNI, nombre, password, confirmPassword,fechaNac, fechacad, Usuarios);
                GestorDeArchivos.guardarClientes(Usuarios);
                JOptionPane.showMessageDialog(null, "Usuario creado con éxito");
                dispose();
            } catch (Admin.CamposVaciosException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            } catch (Admin.DNIInvalidoException | Admin.UsuarioYaExisteException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            } catch (Admin.ContraseñaNoCoincideException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        } else if (e.getSource() == btnCancelar) {
            dispose();
        }
    }
}