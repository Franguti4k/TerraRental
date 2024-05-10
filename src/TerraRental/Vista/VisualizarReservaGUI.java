package TerraRental.Vista;

import TerraRental.Controlador.Cliente;
import TerraRental.Controlador.Reserva;
import TerraRental.Controlador.TerraRental;
import TerraRental.Controlador.Vehiculo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

/**
 * @author Francisco Javier Gutierrez Gallego
 * @author Gina Andrea Ramirez Guerrero
 * @author Santiago Valderrama Flores
 */

public class VisualizarReservaGUI extends JFrame {
    private Cliente clienteActual;

    public VisualizarReservaGUI(Cliente clienteActual) {
        this.clienteActual = clienteActual;

        setTitle("Reserva actual");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 400);


        // Crear un modelo de tabla para los vehículos
        DefaultTableModel model = new DefaultTableModel()
        {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Todas las celdas son no editables
                return false;
            }
        };

        model.addColumn("Marca");
        model.addColumn("Modelo");
        model.addColumn("Categoría");
        model.addColumn("Cambio");
        model.addColumn("Tipo");
        model.addColumn("Matricula");
        model.addColumn("Precio");
        model.addColumn("DIA INICIO");
        model.addColumn("MES INICIO");
        model.addColumn("AÑO INICIO");
        model.addColumn("DIA FINAL");
        model.addColumn("MES FINAL");
        model.addColumn("AÑO FINAL");

        // Agregar más columnas según sea necesario

        // Llenar la tabla con los datos de los vehículos
        for (Reserva reserva : clienteActual.getReservas()) {
            model.addRow(new Object[]{reserva.getVehiculoReserva().getMarca(),
                    reserva.getVehiculoReserva().getModelo(), reserva.getVehiculoReserva().getCategoria(),
                    reserva.getVehiculoReserva().getCambio(), reserva.getVehiculoReserva().getTipo(),
                    reserva.getVehiculoReserva().getMatricula(), reserva.getVehiculoReserva().getPrecio() + "€",
                    reserva.getFechaInicio().getDia(), reserva.getFechaInicio().getMes(), reserva.getFechaInicio().getAnyo(),
                    reserva.getFechaFinal().getDia(), reserva.getFechaFinal().getMes(), reserva.getFechaFinal().getAnyo()});
        }

        // Crea una tabla con el modelo de tabla
        JTable table = new JTable(model);

        // Agregar la tabla a un panel con desplazamiento para que se pueda desplazar si hay muchos vehículos
        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        JPanel panel = new JPanel();
        JTextField textField = new JTextField(20); // Cuadro de texto
        JLabel label = new JLabel("Introduce matrícula: "); // Texto al lado del cuadro de texto
        JButton btnDevolverVehiculo = new JButton("Devolver"); // Botón
        panel.add(label);
        panel.add(textField);
        panel.add(btnDevolverVehiculo);

        // Manejar el evento del botón
        btnDevolverVehiculo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String matricula = textField.getText();
                if(e.getSource() == btnDevolverVehiculo && Objects.equals(matricula, "")){
                    JOptionPane.showMessageDialog(null, "No ha introducido ninguna matricula");
                }else {
                    TerraRental.getInstance().devolverVehiculo(clienteActual, matricula);
                    JOptionPane.showMessageDialog(null, "Vehiculo devuelto correctamente");
                    dispose();
                }
            }
        });

        getContentPane().add(panel, BorderLayout.SOUTH); // Agregar el panel al sur del BorderLayout


        setLocationRelativeTo(null);
        setVisible(true);
    }
}
