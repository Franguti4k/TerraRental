package TerraRental.Vista;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

// Clase para renderizar los botones en la tabla
public class ButtonRenderer extends JButton implements TableCellRenderer {

    // Constructor
    public ButtonRenderer() {
        setOpaque(true);
    }

    // Método para renderizar el botón
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (isSelected) {
            setForeground(table.getSelectionForeground());
            setBackground(table.getSelectionBackground());
        } else {
            setForeground(table.getForeground());
            setBackground(UIManager.getColor("Button.background"));
        }
        setText((value == null) ? "" : value.toString());
        return this;
    }
}
