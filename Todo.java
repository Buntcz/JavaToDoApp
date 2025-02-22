
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Todo extends JFrame implements ActionListener {
    
    private JPanel taskPanel,taskContainer;

    public Todo() {
        super("To do list app");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(Constants.GUI_SIZE);
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

        addGuiElem();
    }
    private void addGuiElem() {
        JLabel bannerLabel = new JLabel("To Do List");
        bannerLabel.setBounds(
            (Constants.GUI_SIZE.width - bannerLabel.getPreferredSize().width)/2,
            15,
            Constants.BANNER_SIZE.width,
            Constants.BANNER_SIZE.height
        );
        

        taskPanel = new JPanel();

        taskContainer = new JPanel();
        taskContainer.setLayout(new BoxLayout(taskContainer, BoxLayout.Y_AXIS));
        taskPanel.add(taskContainer);

        JScrollPane scrollPane = new JScrollPane(taskPanel);
        scrollPane.setBounds(8,70,Constants.TASKPANEL_SIZE.width,Constants.TASKPANEL_SIZE.height);
        scrollPane.setMaximumSize(Constants.TASKPANEL_SIZE);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        JButton btn = new JButton("Add Task");
        btn.setBounds(-5,Constants.GUI_SIZE.height - 88,Constants.TASKADD_BUTTON_SIZE.width,Constants.TASKADD_BUTTON_SIZE.height);
        btn.addActionListener(this);

        this.getContentPane().add(bannerLabel);
        this.getContentPane().add(scrollPane);
        this.getContentPane().add(btn);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if(command.equalsIgnoreCase("Add Task")) {
            TaskComponent taskComponent = new TaskComponent(taskContainer);
            taskContainer.add(taskComponent);

            taskComponent.getTextPane().requestFocus();
            revalidate();
            repaint();
        }
    }
}

