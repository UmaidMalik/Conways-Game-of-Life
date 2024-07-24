package view;

import javax.swing.*;
import java.awt.event.ActionListener;

public class ControlPanel extends JPanel {
    public JButton startButton;
    public JButton stopButton;
    public JButton saveButton;
    public JButton loadButton;
    public JButton clearButton;
    public JButton stepOverButton;
    public JButton gridLinesButton;
    // we need speed up, speed down, show the generation count, and show the current speed
    // display x and y coordinates of the mouse pointer
    // toggle grid lines


    private static final String START = "Start";
    private static final String STOP = "Stop";
    private static final String SAVE = "Save";
    private static final String LOAD = "Load";
    private static final String CLEAR = "Clear";
    private static final String STEP_OVER = "Step Over";
    private static final String GRID_LINES = "Grid Lines";



    public ControlPanel() {
        // create GUI components
        startButton = new JButton(START);
        stopButton = new JButton(STOP);
        saveButton = new JButton(SAVE);
        loadButton = new JButton(LOAD);
        clearButton = new JButton(CLEAR);
        stepOverButton = new JButton(STEP_OVER);
        gridLinesButton = new JButton(GRID_LINES);


        // add components to container
        add(startButton);
        add(stopButton);
        add(saveButton);
        add(loadButton);
        add(clearButton);
        add(stepOverButton);
        add(gridLinesButton);
    }

    public void addControlListener(ActionListener listener) {
        startButton.addActionListener(listener);
        stopButton.addActionListener(listener);
        saveButton.addActionListener(listener);
        loadButton.addActionListener(listener);
        clearButton.addActionListener(listener);
        stepOverButton.addActionListener(listener);
        gridLinesButton.addActionListener(listener);
    }
}
