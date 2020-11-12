package ru.geekbrains.lesson7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class About extends JFrame {

    private static final int WINDOW_WIDTH = 200;
    private static final int WINDOW_HEIGHT = 120;

    private MainWindow mainWindow;

    About(MainWindow mainWindow) {

        JLabel label = new JLabel("Это игра \"Крестики-нолики\"");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        this.mainWindow = mainWindow;
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        Rectangle gameWindowBounds = mainWindow.getBounds();
        int posX = (int) gameWindowBounds.getCenterX() - WINDOW_WIDTH / 2;
        int posY = (int) gameWindowBounds.getCenterY() - WINDOW_HEIGHT / 2;
        setLocation(posX, posY);
        setResizable(false);
        setTitle("About");

        JButton btnOK = new JButton("OK");
        btnOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });


        add(label,BorderLayout.CENTER);
        add(btnOK, BorderLayout.SOUTH);
    }

}
