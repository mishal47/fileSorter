import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame {
    String userInput;

    public MyFrame() {window();}

    public void window() {
        JFrame frame = new JFrame("My program");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 120);
        frame.setLocation(700, 400);

        JLabel label = new JLabel("Enter your start directory:");
        JTextField textField = new JTextField(100);
        JButton button = new JButton("To GO!");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userInput = textField.getText();
            }
        });

        frame.add(label, BorderLayout.NORTH);
        frame.add(textField);
        frame.add(button, BorderLayout.SOUTH);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public String getUserInput() {return userInput;}
}