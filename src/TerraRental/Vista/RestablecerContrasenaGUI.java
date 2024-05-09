package TerraRental.Vista;

import TerraRental.Controlador.Cliente;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.Timer;

public class RestablecerContrasenaGUI extends JFrame {
    private JTextField campoEmail;
    private JTextField campoCodigo;
    private JPasswordField campoContrasena;
    private JPasswordField campoConfirmarContrasena;
    private JButton botonRestablecer;
    private JButton botonEnviarCodigo;
    private ArrayList<Cliente> usuarios;
    private int codigoRandom;

    public RestablecerContrasenaGUI(ArrayList<Cliente> usuarios) {
        this.usuarios = usuarios;


        setSize(800, 600);

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        GridBagConstraints c = new GridBagConstraints();

        c.gridx = 0;
        c.gridy = 0;
        add(new JLabel("Correo electrónico:"), c);
        c.gridy = 1;
        campoEmail = new JTextField(20);
        add(campoEmail, c);

        c.gridy = 2;
        botonEnviarCodigo = new JButton("Enviar código");
        botonEnviarCodigo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = campoEmail.getText();
                enviarCodigo(email);
                voidCodeAfter(300000);
            }
        });
        add(botonEnviarCodigo, c);

        c.gridy = 4;
        add(new JLabel("Código:"), c);
        c.gridy = 5;
        campoCodigo = new JTextField(20);
        add(campoCodigo, c);

        c.gridy = 6;
        add(new JLabel("Nueva contraseña:"), c);
        c.gridy = 7;
        campoContrasena = new JPasswordField(20);
        add(campoContrasena, c);

        c.gridy = 8;
        add(new JLabel("Confirmar nueva contraseña:"), c);
        c.gridy = 9;
        campoConfirmarContrasena = new JPasswordField(20);
        add(campoConfirmarContrasena, c);

        c.gridy = 10;
        botonRestablecer = new JButton("Restablecer contraseña");
        botonRestablecer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = campoEmail.getText();
                int codigo = Integer.parseInt(campoCodigo.getText());
                String contrasena = new String(campoContrasena.getPassword());
                String confirmarContrasena = new String(campoConfirmarContrasena.getPassword());

                if (codigo != codigoRandom) {
                    JOptionPane.showMessageDialog(null, "El código no coincide.");
                    return;
                }

                if (!contrasena.equals(confirmarContrasena)) {
                    JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden.");
                    return;
                }

                Cliente cliente = Cliente.buscarUsuarioPorEmail(email, usuarios);
                if (cliente == null) {
                    JOptionPane.showMessageDialog(null, "Usuario no encontrado.");
                    return;
                }

                try {
                    cliente.cambiarPassword(cliente.getPassword(), contrasena);
                    JOptionPane.showMessageDialog(null, "Contraseña cambiada correctamente.");
                    dispose();
                } catch (Cliente.PasswordIncorrectaException ex) {
                    JOptionPane.showMessageDialog(null, "Error al cambiar la contraseña.");
                    dispose();
                }
            }
        });
        add(botonRestablecer);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void enviarCodigo(String email) {
        Random rand = new Random();
        codigoRandom = rand.nextInt(999999);

        // Configuración de la conexión al servidor de correo
        String host = "smtp.gmail.com";
        String from = "terrarentalnebrija@gmail.com";
        String pass = "mnug lduz cixd tqvm";

        Properties props = System.getProperties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", pass);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));

            message.setSubject("Código de verificación");
            message.setText("Tu código de verificación es: " + codigoRandom);

            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, pass);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
            JOptionPane.showMessageDialog(null, "Código enviado con éxito.\nCaduca en 5 minutos.");

        } catch (MessagingException me) {
            me.printStackTrace();
        }
    }

    public void voidCodeAfter (int time) {
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                JOptionPane.showMessageDialog(null, "El código ha caducado");
                timer.cancel();
                dispose();
            }
        };

        timer.schedule(timerTask, time);
    }
}
