import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

public class ChatBotGUI extends JFrame {

    private JTextArea chatArea;
    private JTextField inputField;
    private JButton sendButton;
    private JButton clearButton;

    private HashMap<String, String> faq = new HashMap<>();

    public ChatBotGUI() {

        setTitle("FAQ ChatBot");
        setSize(600, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setFont(new Font("Arial", Font.PLAIN, 16));

        JScrollPane scrollPane = new JScrollPane(chatArea);

        inputField = new JTextField();

        sendButton = new JButton("Send");

        clearButton = new JButton("Clear Chat");

        JPanel bottom = new JPanel(new BorderLayout());

        JPanel buttons = new JPanel();

        buttons.add(sendButton);
        buttons.add(clearButton);

        bottom.add(inputField, BorderLayout.CENTER);
        bottom.add(buttons, BorderLayout.EAST);

        add(scrollPane, BorderLayout.CENTER);
        add(bottom, BorderLayout.SOUTH);

        initializeFAQ();

        chatArea.append("Bot : Hello! Ask me anything.\n\n");

        sendButton.addActionListener(e -> reply());

        inputField.addActionListener(e -> reply());

        clearButton.addActionListener(e -> {

            chatArea.setText("");

            chatArea.append("Bot : Hello! Ask me anything.\n\n");

        });

        setVisible(true);

    }

    private void initializeFAQ() {

        faq.put("hello", "Hello! How can I help you?");
        faq.put("hi", "Hi! How can I help you?");
        faq.put("hey", "Hello!");

        faq.put("bye", "Good Bye!");

        faq.put("thank", "You're Welcome.");

        faq.put("course", "CodeAlpha provides internship programs.");

        faq.put("internship", "The internship duration is generally one month.");

        faq.put("certificate", "Certificate is provided after successful completion.");

        faq.put("selection", "Selection is based on task completion.");

        faq.put("task", "Complete all assigned tasks before the deadline.");

        faq.put("deadline", "Check your internship dashboard for deadlines.");

        faq.put("java", "Java is an Object Oriented Programming Language.");

        faq.put("python", "Python is a powerful programming language.");

        faq.put("ai", "Artificial Intelligence enables machines to learn.");

        faq.put("machine learning", "Machine Learning is a branch of AI.");

        faq.put("github", "Upload your source code to GitHub.");

        faq.put("project", "Create a complete Java project.");

        faq.put("swing", "Swing is Java's GUI library.");

        faq.put("database", "MySQL is commonly used with Java.");

        faq.put("mysql", "MySQL is an open-source database.");

        faq.put("resume", "Keep your resume updated.");

        faq.put("job", "Practice DSA and Java projects.");

        faq.put("email", "Contact support through official email.");

        faq.put("support", "Please contact the support team.");

        faq.put("help", "Sure! Ask your question.");
    }

    private void reply() {

        String user = inputField.getText().trim();

        if (user.isEmpty())
            return;

        chatArea.append("You : " + user + "\n");

        String lower = user.toLowerCase();

        String answer = null;

        for (String key : faq.keySet()) {

            if (lower.contains(key)) {

                answer = faq.get(key);
                break;

            }

        }

        if (answer == null) {

            answer = "Sorry! I couldn't understand your question.";

        }

        chatArea.append("Bot : " + answer + "\n\n");

        inputField.setText("");


        chatArea.append("Bot : "+answer+"\n\n");

        inputField.setText("");

    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(ChatBotGUI::new);

    }

}