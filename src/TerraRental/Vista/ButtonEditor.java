package TerraRental.Vista;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Clase para la edición de los botones en la tabla
public class ButtonEditor extends DefaultCellEditor {
    protected JButton button;

    // Constructor
    public ButtonEditor(JCheckBox checkBox) {
        super(checkBox);
        button = new JButton();
        button.setOpaque(true);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fireEditingStopped();
            }
        });
    }

    // Método para obtener el componente editor
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        if (isSelected) {
            button.setForeground(table.getSelectionForeground());
            button.setBackground(table.getSelectionBackground());
        } else {
            button.setForeground(table.getForeground());
            button.setBackground(table.getBackground());
        }
        button.setText((value == null) ? "" : value.toString());
        return button;
    }

    // Método para obtener el valor del componente editor
    @Override
    public Object getCellEditorValue() {
        return button.getText();
    }
}
