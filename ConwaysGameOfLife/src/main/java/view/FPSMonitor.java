package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FPSMonitor extends JPanel {

    private static final int TARGET_FPS = 60;
    private static final int FRAME_TIME_MS = 1000 / TARGET_FPS;

    private long lastUpdateTime = System.currentTimeMillis();
    private int frameCount = 0;
    private double fps = 0.0;

    public FPSMonitor() {
        Timer timer = new Timer(FRAME_TIME_MS, e -> {
            // Repaint the panel to simulate frame update
            repaint();
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        frameCount++;

        long currentTime = System.currentTimeMillis();
        if (currentTime - lastUpdateTime >= 1000) { // Update FPS every second
            fps = frameCount * 1000.0 / (currentTime - lastUpdateTime);
            frameCount = 0;
            lastUpdateTime = currentTime;
        }

        // Draw FPS on the panel
        g.setColor(Color.WHITE);
        g.drawString(String.format("FPS: %.2f", fps), 10, 20);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("FPS Monitor");
        FPSMonitor fpsMonitor = new FPSMonitor();
        frame.add(fpsMonitor);
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
