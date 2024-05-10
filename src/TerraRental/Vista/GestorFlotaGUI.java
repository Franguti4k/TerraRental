package TerraRental.Vista;

import TerraRental.Controlador.TerraRental;
import TerraRental.Controlador.Gerente;
import TerraRental.Controlador.Vehiculo;
import TerraRental.Modelo.Cambio;
import TerraRental.Modelo.Categoria;
import TerraRental.Modelo.Tipo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
/**
 * @author Francisco Javier Gutierrez Gallego
 * @author Gina Andrea Ramirez Guerrero
 * @author Santiago Valderrama Flores
 */
public class GestorFlotaGUI extends JFrame {
    private final JButton btnCerrar;
    private final JButton btnAnadirVehiculo;
    private final JButton btnRetirarVehiculo;

    public GestorFlotaGUI(ArrayList<Vehiculo> vehiculos, Gerente gerente){
        setTitle("Gestor de Flota");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear botón "Añadir vehículo"
        btnAnadirVehiculo = new JButton("Añadir vehículo");
        btnAnadirVehiculo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    JTextField categoriaField = new JTextField();
                    JTextField marcaField = new JTextField();
                    JTextField modeloField = new JTextField();
                    JTextField precioField = new JTextField();
                    JTextField tipoField = new JTextField();
                    JTextField cambioField = new JTextField();
                    JTextField litrosField = new JTextField();
                    JTextField caballosField = new JTextField();
                    JTextField colorField = new JTextField();
                    JTextField kilometrajeField = new JTextField();
                    JTextField matriculaField = new JTextField();

                    JPanel panel = new JPanel(new GridLayout(11, 2));
                    panel.add(new JLabel("Categoría del vehículo:"));
                    panel.add(categoriaField);
                    panel.add(new JLabel("Marca del vehículo:"));
                    panel.add(marcaField);
                    panel.add(new JLabel("Modelo del vehículo:"));
                    panel.add(modeloField);
                    panel.add(new JLabel("Precio del vehículo:"));
                    panel.add(precioField);
                    panel.add(new JLabel("Tipo del vehículo:"));
                    panel.add(tipoField);
                    panel.add(new JLabel("Cambio del vehículo:"));
                    panel.add(cambioField);
                    panel.add(new JLabel("Litros del vehículo:"));
                    panel.add(litrosField);
                    panel.add(new JLabel("Caballos del vehículo:"));
                    panel.add(caballosField);
                    panel.add(new JLabel("Color del vehículo:"));
                    panel.add(colorField);
                    panel.add(new JLabel("Kilometraje del vehículo:"));
                    panel.add(kilometrajeField);
                    panel.add(new JLabel("Matrícula del vehículo:"));
                    panel.add(matriculaField);

                    int result = JOptionPane.showConfirmDialog(null, panel, "Añadir vehículo", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                    if (result == JOptionPane.OK_OPTION) {
                        Categoria categoria = Categoria.valueOf(categoriaField.getText());
                        String marca = marcaField.getText();
                        String modelo = modeloField.getText();
                        int precio = Integer.parseInt(precioField.getText());
                        Tipo tipo = Tipo.valueOf(tipoField.getText());
                        Cambio cambio = Cambio.valueOf(cambioField.getText());
                        int litros = Integer.parseInt(litrosField.getText());
                        int caballos = Integer.parseInt(caballosField.getText());
                        String color = colorField.getText();
                        double kilometraje = Double.parseDouble(kilometrajeField.getText());
                        String matricula = matriculaField.getText();

                        Vehiculo nuevoVehiculo = new Vehiculo(categoria, marca, modelo, precio, tipo, cambio, litros, caballos, color, kilometraje, matricula);
                        gerente.agregarVehiculo(nuevoVehiculo);
                        JOptionPane.showMessageDialog(null, "Vehículo añadido", "Añadir vehículo", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "ERROR\n" + ex.getMessage(), "Añadir vehículo", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Crear botón "Retirar vehículo"
        btnRetirarVehiculo = new JButton("Retirar vehículo");
        btnRetirarVehiculo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String matricula = JOptionPane.showInputDialog("Introduce la matrícula del coche a borrar");
                    if (matricula != null) {
                        Vehiculo vehiculoARetirar = Vehiculo.buscarPorMatricula(matricula, vehiculos);
                        if (vehiculoARetirar != null) {
                            gerente.retirarVehiculo(vehiculoARetirar);
                            JOptionPane.showMessageDialog(null, "Vehículo retirado", "Retirar vehículo", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "ERROR\nNo se encontró ningún vehículo con la matrícula proporcionada.", "Retirar vehículo", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "ERROR\nUn campo está vacío.", "Retirar vehículo", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        // Botón para cerrar la aplicación
        btnCerrar = new JButton("Cerrar");
        btnCerrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Cierra la ventana
            }
        });

        // Crear panel para colocar los botones
        JPanel panelBotones = new JPanel();
        panelBotones.add(btnAnadirVehiculo);
        panelBotones.add(btnRetirarVehiculo);
        panelBotones.add(btnCerrar);

        // Agregar el panel al contenido de la ventana
        getContentPane().add(panelBotones, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
        setVisible(true); // Hacer visible la ventana
    }

}
