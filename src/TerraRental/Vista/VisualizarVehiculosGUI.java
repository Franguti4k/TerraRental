package TerraRental.Vista;

import TerraRental.Controlador.Admin;
import TerraRental.Controlador.Vehiculo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class VisualizarVehiculosGUI extends JFrame {

    public VisualizarVehiculosGUI(ArrayList<Vehiculo> vehiculos) {
        setTitle("Vehículos Disponibles");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 400);


        // Crear un modelo de tabla para los vehículos
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Marca");
        model.addColumn("Modelo");
        model.addColumn("Categoría");
        model.addColumn("Reserva");

        // Agregar más columnas según sea necesario

        // Llenar la tabla con los datos de los vehículos
        for (Vehiculo vehiculo : vehiculos) {
            model.addRow(new Object[]{vehiculo.getMarca(), vehiculo.getModelo(), vehiculo.getCategoria()});
        }

        // Crear una tabla con el modelo de tabla
        JTable table = new JTable(model);

        // Crear una columna de botones para la reserva
        TableColumn reservarColumn = table.getColumnModel().getColumn(3);
        reservarColumn.setCellRenderer(new ButtonRenderer());
        reservarColumn.setCellEditor(new ButtonEditor(new JCheckBox()));

        // Agregar la tabla a un panel con desplazamiento para que se pueda desplazar si hay muchos vehículos
        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
