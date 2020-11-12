package ru.geekbrains.lesson7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Aleksandr Gladkov [Anticisco]
 * Date of creation: 09.11.2020
 */

public class GameMap extends JPanel {
    public static final int MODE_HVA = 0;
    public static final int MODE_HVH = 1;

    GameMap() { setBackground(Color.BLACK);  }

    void startNewGame(int mode, int fieldSizeX, int fieldSizeY, int winLength) {
        System.out.println("mode = " + mode +
                "\n fieldSizeX = " + fieldSizeX +
                "\n fieldSizeY = " + fieldSizeY +
                "\n winLength = " + winLength);

        setLayout(new GridLayout(fieldSizeX, fieldSizeY));

        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Point p = e.getLocationOnScreen();
                System.out.println("x = " + p.x + " , y = " + p.y);
            }
            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }


        });

        revalidate();
    }

}
