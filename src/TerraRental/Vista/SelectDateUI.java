package TerraRental.Vista;

import javax.swing.*;
import java.awt.*;

public class SelectDateUI extends JFrame {
    private JTextField endDay, endMon, endYear, staDay, staMon, staYear;
    private JButton btnAccept, btnCancel;

    public SelectDateUI() {
        setTitle("Seleccionar Fechas");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setVisible(true);


        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5,5,5,5);

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 3;
        mainPanel.add(new JLabel("Fecha de inicio de alquiler"), constraints);

        constraints.gridwidth = 1;
        constraints.gridy = 1;
        mainPanel.add(new JLabel("Día: "), constraints);

        constraints.gridx = 1;
        staDay = new JTextField(5);
        mainPanel.add(staDay, constraints);

        constraints.gridx = 2;

        mainPanel.add(new JLabel("Mes: "), constraints);

        constraints.gridx = 3;
        staMon = new JTextField(5);
        mainPanel.add(staMon, constraints);

        constraints.gridx = 4;

        mainPanel.add(new JLabel("Año: "), constraints);

        constraints.gridx = 5;
        staYear = new JTextField(5);
        mainPanel.add(staYear, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 3;
        mainPanel.add(new JLabel("Fecha de finalización de alquiler"), constraints);

        constraints.gridwidth = 1;
        constraints.gridy = 3;
        mainPanel.add(new JLabel("Día: "), constraints);

        constraints.gridx = 1;
        staDay = new JTextField(5);
        mainPanel.add(staDay, constraints);

        constraints.gridx = 2;

        mainPanel.add(new JLabel("Mes: "), constraints);

        constraints.gridx = 3;
        staMon = new JTextField(5);
        mainPanel.add(staMon, constraints);

        constraints.gridx = 4;

        mainPanel.add(new JLabel("Año: "), constraints);

        constraints.gridx = 5;
        staYear = new JTextField(5);
        mainPanel.add(staYear, constraints);

        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.FIRST_LINE_START;
        btnAccept = new JButton("Aceptar");
        mainPanel.add(btnAccept, constraints);

        constraints.gridx = 2;
        btnCancel = new JButton("Cancelar");
        mainPanel.add(btnCancel, constraints);

        getContentPane().add(mainPanel);
        pack();
    }
}