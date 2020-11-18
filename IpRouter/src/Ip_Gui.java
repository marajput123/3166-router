/**

**/

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ip_Gui implements ActionListener {
    private static JFrame frame;
    private static JLabel label;
    private static JButton button;
    private static JTextField inputText;
    private static JPanel panel;

    public static void main(String[] args) {
        frame = new JFrame();
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel();
        frame.add(panel);
        panel.setLayout(null);
        label = new JLabel("Please Enter the Ip Address Below: ");
        label.setBounds(130, -10, 400, 300);
        panel.add(label);
        inputText = new JTextField(30);
        inputText.setBounds(155, 155, 165, 35);
        panel.add(inputText);
        button = new JButton("Submit");
        button.setBounds(185, 200, 100, 35);
        button.addActionListener( new Ip_Gui());
        panel.add(button);


        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {


    }
}
