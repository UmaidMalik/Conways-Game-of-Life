import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlPanel extends JPanel {
    public JButton startButton;
    public JButton stopButton;
    public JButton saveButton;
    public JButton loadButton;
    public JButton clearButton;
    public JButton randomButton;
    //
    private static final String START = "Start";
    private static final String STOP = "Stop";
    private static final String SAVE = "Save";
    private static final String LOAD = "Load";
    private static final String CLEAR = "Clear";
    private static final String RANDOM = "Random";

    //private Timer timer;
    //private GameOfLife gameOfLife;

    public ControlPanel(/*Timer timer, GameOfLife gameOfLife*/) {
        startButton = new JButton(START);
        stopButton = new JButton(STOP);
        saveButton = new JButton(SAVE);
        loadButton = new JButton(LOAD);
        clearButton = new JButton(CLEAR);
        randomButton = new JButton(RANDOM);
        //this.timer = timer;
        //this.gameOfLife = gameOfLife;
    }

    public void addControlListener(ActionListener listener) {
        startButton.addActionListener(listener);
        stopButton.addActionListener(listener);
        saveButton.addActionListener(listener);
        loadButton.addActionListener(listener);
        clearButton.addActionListener(listener);
        randomButton.addActionListener(listener);

    }

    /*
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == timer) {
            System.out.println("Timer ticked");
            gameOfLife.nextGeneration();
            repaint();
        } else if (e.getSource() == startButton) {
            System.out.println("Start button clicked");
        } else if (e.getSource() == stopButton) {
            System.out.println("Stop button clicked");
        } else if (e.getSource() == saveButton) {
            System.out.println("Save button clicked");
        } else if (e.getSource() == loadButton) {
            System.out.println("Load button clicked");
        } else if (e.getSource() == clearButton) {
            System.out.println("Clear button clicked");
        } else if (e.getSource() == randomButton) {
            System.out.println("Random button clicked");
        }
    }
     */
}
