package view;

import model.*;
import controller.*;
import javax.swing.*;
import java.awt.event.ActionListener;

public class ControlPanel extends JPanel {
    public JButton startButton;
    public JButton stopButton;
    public JButton saveButton;
    public JButton loadButton;
    public JButton clearButton;
    public JButton randomButton;

    private static final String START = "Start";
    private static final String STOP = "Stop";
    private static final String SAVE = "Save";
    private static final String LOAD = "Load";
    private static final String CLEAR = "Clear";
    private static final String RANDOM = "Random";


    public ControlPanel() {
        startButton = new JButton(START);
        stopButton = new JButton(STOP);
        saveButton = new JButton(SAVE);
        loadButton = new JButton(LOAD);
        clearButton = new JButton(CLEAR);
        randomButton = new JButton(RANDOM);

        add(startButton);
        add(stopButton);
        add(saveButton);
        add(loadButton);
        add(clearButton);
        add(randomButton);
    }

    public void addControlListener(ActionListener listener) {
        startButton.addActionListener(listener);
        stopButton.addActionListener(listener);
        saveButton.addActionListener(listener);
        loadButton.addActionListener(listener);
        clearButton.addActionListener(listener);
        randomButton.addActionListener(listener);

    }
}
