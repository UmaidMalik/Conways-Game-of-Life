package view;

import javax.swing.*;
import javax.swing.colorchooser.AbstractColorChooserPanel;
import java.awt.event.ActionListener;

public class ControlPanel extends JPanel {
    private JButton startButton;
    private JButton stopButton;
    private JButton saveButton;
    private JButton loadButton;
    private JButton clearButton;
    private JButton stepOverButton;
    private JButton gridLinesButton;
    private JButton speedUpButton;
    private JButton slowDownButton;
    private JCheckBox edgeWrappingCheckBox;
    private JColorChooser colorChooser;
    private JButton testButton;
    // we need to add speed up, speed down, show the generation count, and show the current speed
    // display x and y coordinates of the mouse pointer
    // toggle grid lines
    // modifiable rules

    public static final String START = "Start";
    public static final String STOP = "Stop";
    public static final String SAVE = "Save";
    public static final String LOAD = "Load";
    public static final String CLEAR = "Clear";
    public static final String STEP_OVER = "Step Over";
    public static final String GRID_LINES = "Grid Lines";
    public static final String SPEED_UP = "Speed Up";
    public static final String SLOW_DOWN = "Slow Down";
    public static final String EDGE_WRAPPING = "Edge Wrapping";
    public static final String TEST = "Test";

    public ControlPanel() {
        // create GUI components
        startButton = new JButton(START);
        stopButton = new JButton(STOP);
        saveButton = new JButton(SAVE);
        loadButton = new JButton(LOAD);
        clearButton = new JButton(CLEAR);
        stepOverButton = new JButton(STEP_OVER);
        gridLinesButton = new JButton(GRID_LINES);
        speedUpButton = new JButton(SPEED_UP);
        slowDownButton = new JButton(SLOW_DOWN);
        edgeWrappingCheckBox = new JCheckBox(EDGE_WRAPPING);
        edgeWrappingCheckBox.setBounds(100, 100, 50, 50);
        testButton = new JButton(TEST);

        // add components to container
        add(startButton);
        add(stopButton);
        add(saveButton);
        add(loadButton);
        add(clearButton);
        add(stepOverButton);
        add(gridLinesButton);
        add(speedUpButton);
        add(slowDownButton);
        add(edgeWrappingCheckBox);
        add(testButton);
    }

    public void addControlListener(ActionListener listener) {
        startButton.addActionListener(listener);
        stopButton.addActionListener(listener);
        saveButton.addActionListener(listener);
        loadButton.addActionListener(listener);
        clearButton.addActionListener(listener);
        stepOverButton.addActionListener(listener);
        gridLinesButton.addActionListener(listener);
        speedUpButton.addActionListener(listener);
        slowDownButton.addActionListener(listener);
        edgeWrappingCheckBox.addActionListener(listener);
        testButton.addActionListener(listener);
    }
}
