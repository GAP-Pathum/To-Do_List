import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToDoListApp {
    private static DefaultListModel<String> listModel;

    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("To-Do List Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null); // Center the window

        // Create the panel for the UI components
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(Color.LIGHT_GRAY); // Set background color

        // Create the list model and JList
        listModel = new DefaultListModel<>();
        JList<String> todoList = new JList<>(listModel);
        todoList.setBackground(Color.WHITE); // Set background color for list
        todoList.setForeground(Color.BLACK); // Set text color for list
        todoList.setFont(new Font("Arial", Font.PLAIN, 14)); // Set font style and size

        JScrollPane scrollPane = new JScrollPane(todoList);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Create a text field, add and remove buttons
        JTextField taskInput = new JTextField();
        taskInput.setBackground(Color.WHITE); // Set background color for text field
        taskInput.setForeground(Color.BLACK); // Set text color for text field
        taskInput.setFont(new Font("Arial", Font.PLAIN, 14)); // Set font style and size
        taskInput.setPreferredSize(new Dimension(250, 30)); // Set preferred size for the text field

        JButton addButton = new JButton("Add Task");
        addButton.setBackground(Color.GREEN); // Set background color for button
        addButton.setForeground(Color.WHITE); // Set text color for button
        addButton.setFont(new Font("Arial", Font.BOLD, 14)); // Set font style and size

        JButton removeButton = new JButton("Remove Task");
        removeButton.setBackground(Color.RED); // Set background color for button
        removeButton.setForeground(Color.WHITE); // Set text color for button
        removeButton.setFont(new Font("Arial", Font.BOLD, 14)); // Set font style and size

        // Panel for the input and buttons
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());
        inputPanel.setBackground(Color.LIGHT_GRAY); // Set background color for input panel
        inputPanel.add(taskInput);
        inputPanel.add(addButton);
        inputPanel.add(removeButton);

        panel.add(inputPanel, BorderLayout.SOUTH);

        // Action listener for the add button
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String task = taskInput.getText();
                if (!task.isEmpty()) {
                    listModel.addElement(task);
                    taskInput.setText("");
                }
            }
        });

        // Action listener for the remove button
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = todoList.getSelectedIndex();
                if (selectedIndex != -1) {
                    listModel.remove(selectedIndex);
                } else {
                    JOptionPane.showMessageDialog(frame, "Select a task to remove.", "No Task Selected", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        // Set up and show the frame
        frame.add(panel);
        frame.setVisible(true);
    }
}
