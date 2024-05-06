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
                    Categoria categoria = Categoria.valueOf(JOptionPane.showInputDialog("Introduce la categoría del vehículo"));
                    String marca = JOptionPane.showInputDialog("Introduce la marca del vehículo");
                    String modelo = JOptionPane.showInputDialog("Introduce el modelo del vehículo");
                    int precio = Integer.parseInt(JOptionPane.showInputDialog("Introduce el precio del vehículo"));
                    Tipo tipo = Tipo.valueOf(JOptionPane.showInputDialog("Introduce el tipo del vehículo"));
                    Cambio cambio = Cambio.valueOf(JOptionPane.showInputDialog("Introduce el cambio del vehículo"));
                    int litros = Integer.parseInt(JOptionPane.showInputDialog("Introduce los litros del vehículo"));
                    int caballos = Integer.parseInt(JOptionPane.showInputDialog("Introduce los caballos del vehículo"));
                    String color = JOptionPane.showInputDialog("Introduce el color del vehículo");
                    double kilometraje = Double.parseDouble(JOptionPane.showInputDialog("Introduce el kilometraje del vehículo"));
                    String matricula = JOptionPane.showInputDialog("Introduce la matrícula del vehículo");

                    Vehiculo nuevoVehiculo = new Vehiculo(categoria, marca, modelo, precio, tipo, cambio, litros, caballos, color, kilometraje, matricula);
                    gerente.agregarVehiculo(nuevoVehiculo);
                    JOptionPane.showMessageDialog(null, "Vehículo añadido", "Añadir vehículo", JOptionPane.INFORMATION_MESSAGE);
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
