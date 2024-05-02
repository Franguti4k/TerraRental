package TerraRental.Vista;

import TerraRental.Controlador.Cliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class RestablecerContrasenaGUI extends JFrame {
    private JTextField campoUsuario;
    private JPasswordField campoContrasena;
    private JPasswordField campoConfirmarContrasena;
    private JButton botonRestablecer;
    private ArrayList<Cliente> usuarios;

    public RestablecerContrasenaGUI(ArrayList<Cliente> usuarios) {
        this.usuarios = usuarios;

        setLayout(new GridLayout(4, 2));

        add(new JLabel("Usuario:"));
        campoUsuario = new JTextField();
        add(campoUsuario);

        add(new JLabel("Nueva contraseña:"));
        campoContrasena = new JPasswordField();
        add(campoContrasena);

        add(new JLabel("Confirmar nueva contraseña:"));
        campoConfirmarContrasena = new JPasswordField();
        add(campoConfirmarContrasena);

        botonRestablecer = new JButton("Restablecer contraseña");
        botonRestablecer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = campoUsuario.getText();
                String contrasena = new String(campoContrasena.getPassword());
                String confirmarContrasena = new String(campoConfirmarContrasena.getPassword());

                if (!contrasena.equals(confirmarContrasena)) {
                    JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden.");
                    return;
                }

                Cliente cliente = Cliente.buscarUsuarioPorDNI(usuario, usuarios);
                if (cliente == null) {
                    JOptionPane.showMessageDialog(null, "Usuario no encontrado.");
                    return;
                }

                try {
                    cliente.cambiarPassword(cliente.getPassword(), contrasena);
                    JOptionPane.showMessageDialog(null, "Contraseña cambiada correctamente.");
                } catch (Cliente.PasswordIncorrectaException ex) {
                    JOptionPane.showMessageDialog(null, "Error al cambiar la contraseña.");
                }
            }
        });
        add(botonRestablecer);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }


}
