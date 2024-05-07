package TerraRental.Vista;

import TerraRental.Controlador.Cliente;
import TerraRental.Controlador.TerraRental;
import TerraRental.Controlador.Vehiculo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VisualizarReservaGUI extends JFrame {
    private Cliente clienteActual;

    public VisualizarReservaGUI(Cliente clienteActual) {
        this.clienteActual = clienteActual;

        setTitle("Reserva actual");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 400);


        // Crear un modelo de tabla para los vehículos
        DefaultTableModel model = new DefaultTableModel();
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

        model.addRow(new Object[]{clienteActual.getReserva().getVehiculoReserva().getMarca(),
                clienteActual.getReserva().getVehiculoReserva().getModelo(), clienteActual.getReserva().getVehiculoReserva().getCategoria(),
                clienteActual.getReserva().getVehiculoReserva().getCambio(), clienteActual.getReserva().getVehiculoReserva().getTipo(),
                clienteActual.getReserva().getVehiculoReserva().getMatricula(), clienteActual.getReserva().getVehiculoReserva().getPrecio() + "€",
                clienteActual.getReserva().getFechaInicio().getDia(), clienteActual.getReserva().getFechaInicio().getMes(), clienteActual.getReserva().getFechaInicio().getAnyo(),
                clienteActual.getReserva().getFechaFinal().getDia(), clienteActual.getReserva().getFechaFinal().getMes(), clienteActual.getReserva().getFechaFinal().getAnyo()});


        // Crea una tabla con el modelo de tabla
        JTable table = new JTable(model);

        // Agregar la tabla a un panel con desplazamiento para que se pueda desplazar si hay muchos vehículos
        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        //crea un boton para devolver el vehiculo
        JButton btnDevolverVehiculo = new JButton("Devolver");
        JPanel panel = new JPanel();
        panel.add(btnDevolverVehiculo);

        // Manejar el evento del botón
        btnDevolverVehiculo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TerraRental.getInstance().devolverVehiculo(clienteActual);
                JOptionPane.showMessageDialog(null, "Vehiculo devuelto correctamente");
                dispose();
            }
        });

        getContentPane().add(panel, BorderLayout.SOUTH); // Agregar el panel al sur del BorderLayout


        setLocationRelativeTo(null);
        setVisible(true);
    }
}
