/**
 * @author Francisco Javier Gutierrez Gallego
 * @author Gina Andrea Ramirez Guerrero
 * @author Pedro Zuñeda Diego
 * @author Santiago Valderrama Flores
 */
package TerraRental.Vista;

import TerraRental.Controlador.Cliente;
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

public class VisualizarVehiculosGUI extends JFrame {

    public VisualizarVehiculosGUI(Cliente clienteActual, ArrayList<Vehiculo> vehiculos) {
        setTitle("Vehículos Disponibles");
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

        // Agregar más columnas según sea necesario

        // Llenar la tabla con los datos de los vehículos
        for (Vehiculo vehiculo : vehiculos) {
            model.addRow(new Object[]{vehiculo.getMarca(), vehiculo.getModelo(), vehiculo.getCategoria(),vehiculo.getCambio(), vehiculo.getTipo(), vehiculo.getMatricula(), vehiculo.getPrecio() + "€"});
        }

        // Crear una tabla con el modelo de tabla
        JTable table = new JTable(model);



        // Agregar la tabla a un panel con desplazamiento para que se pueda desplazar si hay muchos vehículos
        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        // Crear un panel para el cuadro de texto y el botón
        JPanel panel = new JPanel();
        JTextField textField = new JTextField(20); // Cuadro de texto
        JLabel label = new JLabel("Introduce matrícula: "); // Texto al lado del cuadro de texto
        JButton button = new JButton("Reservar"); // Botón
        panel.add(label);
        panel.add(textField);
        panel.add(button);

        // Manejar el evento del botón
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean check = false;


                    String matricula = textField.getText();
                for (Vehiculo vehiculo : vehiculos){
                    if(vehiculo.getMatricula().equals(matricula)){
                        check = true;
                        break;
                    }
                    check = false;
                }
                if(e.getSource() == button && Objects.equals(matricula, "") || !check){
                    JOptionPane.showMessageDialog(null, "No ha introducido ninguna matricula o no existe");
                }else {
                    new SelectDateUI(clienteActual, matricula);
                    dispose();
                }
            }
        });

        getContentPane().add(panel, BorderLayout.SOUTH); // Agregar el panel al sur del BorderLayout


        setLocationRelativeTo(null);
        setVisible(true);
    }
}
