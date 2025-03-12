import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * This program creates an GUI (Graphical User Interface) that keeps track of how many times the mouse is clicked.
 * It also includes a reset button that resets the count variable back to 0 when clicked.
 * @author Luke Decker
 * @Version 3/7/2025
 */
public class MousePressCounter implements Runnable {
    
    private int pressCount = 0; 
    private JPanel mainPanel; 

    @Override
    public void run() {
        
        JFrame frame = new JFrame("Mouse Press Counter");
        frame.setPreferredSize(new Dimension(500, 500));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        mainPanel = new JPanel(new BorderLayout());

        
        JPanel graphicsPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                
                String text = "Mouse press count: " + pressCount;
                FontMetrics fm = g.getFontMetrics();
                int textWidth = fm.stringWidth(text);
                int textAscent = fm.getAscent();
                int x = (getWidth() - textWidth) / 2;
                int y = (getHeight() - textAscent) / 2 + textAscent;

                g.drawString(text, x, y);
            }
        };
        graphicsPanel.setBackground(Color.WHITE);
        
        //Count
        graphicsPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                pressCount++;
                graphicsPanel.repaint(); 
            }
        });

        //Reset button
        JButton resetButton = new JButton("Reset");
        resetButton.setFont(new Font("Arial", Font.BOLD, 16));
        resetButton.addActionListener(e -> {
            pressCount = 0;
            graphicsPanel.repaint(); 
        });

        
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(resetButton);

       
        mainPanel.add(graphicsPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        
        frame.add(mainPanel);

        
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new MousePressCounter());
    }
}
