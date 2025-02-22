import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TaskComponent extends JPanel implements ActionListener {
    private JCheckBox checkBox;
    private JTextPane textPane;
    private JButton deleteButton;

    private JPanel parentPanel;

    public JTextPane getTextPane() {
        return textPane;
    }

    public TaskComponent(JPanel parentPanel) {
        this.parentPanel = parentPanel;

        textPane = new JTextPane();
        textPane.setPreferredSize(Constants.TASKFIELD_SIZE);
        textPane.setContentType("text/html");

        checkBox = new JCheckBox();
        checkBox.setPreferredSize(Constants.CHECKBOX_SIZE);
        checkBox.addActionListener(this);

        deleteButton = new JButton("X");
        deleteButton.setPreferredSize(Constants.DELETE_BUTTON_SIZE);
        deleteButton.addActionListener(this);

        add(checkBox);
        add(textPane);
        add(deleteButton);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(checkBox.isSelected()) {
            String taskText = textPane.getText().replaceAll("<[^>]*>", "");

            textPane.setText("<html><s>" + taskText  + "</s></html>");
        } else if(!checkBox.isSelected()) {
            String taskText = textPane.getText().replaceAll("<[^>]*>", "");

            textPane.setText(taskText);
        }
        if(e.getActionCommand().equalsIgnoreCase("X")) {
            parentPanel.remove(this);
            parentPanel.repaint();
            parentPanel.revalidate();
        }
    }
}
