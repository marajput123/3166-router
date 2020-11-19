/**

**/

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.*;
import java.util.*;


public class Ip_Gui implements ActionListener {
    private static JFrame frame;
    private static JLabel label;
    private static JLabel label1;
    private static JLabel label2;
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
        label = new JLabel("Enter the Ipv4 Address below:");
        label.setBounds(130, -10, 400, 300);
        panel.add(label);
        inputText = new JTextField(30);
        inputText.setBounds(155, 155, 165, 35);
        panel.add(inputText);
        button = new JButton("Submit");
        button.setBounds(185, 200, 100, 35);
        button.addActionListener( new Ip_Gui());
        panel.add(button);
        label1 = new JLabel();
        label1.setBounds(175, 235, 200, 35 );
        panel.add(label1);
        label2 = new JLabel();
        label2.setBounds(175, 270, 200, 35);
        panel.add(label2);


        frame.setVisible(true);



    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String input = inputText.getText();
        IpAddress Ip = new IpAddress(input);
        if (!Ip.validate()) {
            label1.setText("Invalid Ip Address");
            label2.setText("");
            return;
        }
        else {
            label1.setText("Valid Ip Address");
            Ip.convertToBinary();
            Ip.getNewAddress();
            String s = Ip.match();
            label2.setText(s);
        }

        System.out.println(input);
    }
}



