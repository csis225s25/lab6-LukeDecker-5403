import java.awt.*;
import javax.swing.*;

/**
 * This program creates an Artistic Masterpiece called "Geometry IDK" on an GUI (Graphical User Interface).
 * @author Luke Decker
 * @Version 3/7/2025
 */
class ArtProjectPanel extends JPanel {
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Sets background color
        g.setColor(Color.PINK);
        g.fillRect(0, 0, getWidth(), getHeight());

        // Draws filled rectangle
        g.setColor(Color.RED);
        g.fillRect(50, 50, 150, 100);

        // Draws oval 
        g.setColor(Color.BLUE);
        g.drawOval(250, 50, 100, 150);

        // Draws filled oval
        g.setColor(Color.GREEN);
        g.fillOval(100, 200, 120, 80);

        // Draws arc
        g.setColor(Color.ORANGE);
        g.fillArc(300, 250, 150, 150, 0, 180);

        // Draws X
        g.setColor(Color.BLACK);
        g.drawLine(50, 300, 200, 400);
        g.drawLine(200, 300, 50, 400);
    }
}

public class ArtProject implements Runnable {
    @Override
    public void run() {
        JFrame frame = new JFrame("Geometry Idk");
        frame.setPreferredSize(new Dimension(500, 500));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new ArtProjectPanel();
        frame.add(panel);

        frame.pack();
        frame.setVisible(true);

        
        frame.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                panel.repaint();
            }
        });
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new ArtProject());
    }
}
