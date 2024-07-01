/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author aluru
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class chatui extends JFrame {

    private JTextArea chatArea;
    private JTextField messageField;
    private JButton sendButton;

    public chatui() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Simple Chat App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);  // Set the initial size of the window
        setLocationRelativeTo(null);  // Center the window on the screen

        // Create the chat area (where messages will be displayed)
        chatArea = new JTextArea();
        chatArea.setEditable(false);  // Make it read-only
        JScrollPane scrollPane = new JScrollPane(chatArea);  // Add scroll bars if needed
        add(scrollPane, BorderLayout.CENTER);  // Add the chat area to the center of the frame

        // Create the panel for message input
        JPanel inputPanel = new JPanel(new BorderLayout());
        messageField = new JTextField();
        inputPanel.add(messageField, BorderLayout.CENTER);  // Add text field for typing messages
        sendButton = new JButton("Send");
        inputPanel.add(sendButton, BorderLayout.EAST);  // Add send button to the right
        add(inputPanel, BorderLayout.SOUTH);  // Add input panel to the bottom of the frame

        // Attach an ActionListener to the send button
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();  // Define what happens when send button is clicked
            }
        });
    }

    // Method to handle sending a message
    private void sendMessage() {
        String message = messageField.getText().trim();  // Get text from message field
        if (!message.isEmpty()) {
            // Replace with your logic for sending message
            chatArea.append("You: " + message + "\n");  // Display sent message in chat area
            messageField.setText("");  // Clear message field after sending
        }
    }

    // Main method to start the application
    public static void main(String[] args) {
        // Use SwingUtilities.invokeLater to ensure GUI components are created in EDT
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new chatui().setVisible(true);  // Create and display the UI window
            }
        });
    }
}


