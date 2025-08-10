
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ChatBotGUI extends JFrame {
    private JTextArea chatArea;
    private JTextField inputField;
    private JButton sendButton;
    private List<String> faqs;

    public ChatBotGUI() {
        setTitle("Java AI Chatbot");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Chat display
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        add(new JScrollPane(chatArea), BorderLayout.CENTER);

        // Input panel
        JPanel inputPanel = new JPanel(new BorderLayout());
        inputField = new JTextField();
        sendButton = new JButton("Send");
        inputPanel.add(inputField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);
        add(inputPanel, BorderLayout.SOUTH);

        // FAQs
        faqs = new ArrayList<>();
        faqs.add("Hi, I am your chatbot!");
        faqs.add("I can answer simple questions.");
        faqs.add("Type 'bye' to exit.");

        // Button action
        sendButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });

        // Press Enter to send
        inputField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });
    }

    private void sendMessage() {
        String userText = inputField.getText().trim();
        if (!userText.isEmpty()) {
            chatArea.append("You: " + userText + "\n");
            String response = getResponse(userText);
            chatArea.append("Bot: " + response + "\n");
            inputField.setText("");
        }
    }

    private String getResponse(String input) {
        input = input.toLowerCase();

        if (input.contains("hello") || input.contains("hi")) {
            return "Hello! How can I help you today?";
        } else if (input.contains("how are you")) {
            return "I'm just a bot, but I'm doing great!";
        } else if (input.contains("faq")) {
            return String.join("\n", faqs);
        } else if (input.contains("bye")) {
            return "Goodbye! Have a nice day.";
        } else {
            return "Sorry, I don't understand that.";
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ChatBotGUI bot = new ChatBotGUI();
            bot.setVisible(true);
        });
    }
}
