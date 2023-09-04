package activity;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Triangulo_De_Sierpinsiki {
    private static int iterations = 0;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Triángulo de Sierpinski");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawSierpinskiTriangle(g, iterations, getWidth() / 2, getHeight(), getHeight() / 2);
            }
        };

        JButton increaseButton = new JButton("Aumentar Iteraciones");
        increaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iterations++;
                panel.repaint();
            }
        });

        frame.setLayout(new BorderLayout());
        frame.add(panel, BorderLayout.CENTER);
        frame.add(increaseButton, BorderLayout.SOUTH);
        frame.setSize(800, 600);
        frame.setVisible(true);
    }

    public static void drawSierpinskiTriangle(Graphics g, int n, int x, int y, int size) {
        if (n == 0) {
            int[] xPoints = {x, x - size, x + size};
            int[] yPoints = {y, y - size, y - size};
            g.drawPolygon(xPoints, yPoints, 3);
        } else {
            int newSize = size / 2;
            drawSierpinskiTriangle(g, n - 1, x, y, newSize);
            drawSierpinskiTriangle(g, n - 1, x - newSize, y - newSize, newSize);
            drawSierpinskiTriangle(g, n - 1, x + newSize, y - newSize, newSize);
        }
    }
}
