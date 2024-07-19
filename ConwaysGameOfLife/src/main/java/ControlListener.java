import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlListener implements ActionListener {

    private ControlPanel controlPanel;
    private Timer timer;
    private GameOfLife gameOfLife;

    ControlListener(ControlPanel controlPanel, Timer timer, ) {
        this.controlPanel = controlPanel;
        this.timer = timer;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == timer) {
            System.out.println("Timer ticked");
            gameOfLife.nextGeneration();
            gamePanel.repaint();

        } else if (e.getSource() == controlPanel.startButton) {
            System.out.println("Start button clicked");
        } else if (e.getSource() == controlPanel.stopButton) {
            System.out.println("Stop button clicked");
        } else if (e.getSource() == controlPanel.saveButton) {
            System.out.println("Save button clicked");
        } else if (e.getSource() == controlPanel.loadButton) {
            System.out.println("Load button clicked");
        } else if (e.getSource() == controlPanel.clearButton) {
            System.out.println("Clear button clicked");
        } else if (e.getSource() == controlPanel.randomButton) {
            System.out.println("Random button clicked");
        }
    }
}
