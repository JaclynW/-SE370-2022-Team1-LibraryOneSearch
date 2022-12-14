//package View;
//import javax.swing.*;
//import java.awt.*;
//
//
//public class GUISearch {
//    public static void main(String args[]) {
//
//        //Creating the Frame
//        JFrame frame = new JFrame("libraryonesearch.com");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(800, 800);
//        frame.setBackground(Color.WHITE);
//
//        JPanel panel = new JPanel(new GridBagLayout());
//        GridBagConstraints c = new GridBagConstraints();
//        //Insets insets = new Insets(4, 4, 4, 4);
//
//
//
//
//        //Creating the panel at bottom and adding components
////             // the panel is not visible in output
////            JLabel title = new JLabel("Library OneSearch", JLabel.NORTH);
////            title.setFont(new Font("Serif", Font.BOLD, 48));
////            title.setForeground(Color.black);
//
//        //JLabel desc = new JLabel("Use Library OneSearch to locate books, magazines, and other articles of literature at San Diego based Libraries", JLabel.CENTER);
//        //desc.setFont(new Font("Serif", Font.PLAIN, 25));
//        JTextArea textArea = new JTextArea(10,20);
//        textArea.append("Use Library OneSearch to locate books, magazines, and other articles of literature at San Diego based Libraries");
//        textArea.setFont(new Font("Serif", Font.PLAIN, 16));
//        textArea.setLineWrap(true);
//        textArea.setWrapStyleWord(true);
//        textArea.setEditable(false);
//        c.fill = GridBagConstraints.HORIZONTAL;
//        c.weightx = 0.5;
//        c.gridx = 1;
//        c.gridy = 1;
//        panel.add(textArea,c);
//        // desc.setForeground(Color.black);
//
//
//
////            JLabel select = new JLabel("Select Your Libraries Below", JLabel.SOUTH);
////            select.setFont(new Font("Serif", Font.PLAIN, 40));
////            select.setForeground(Color.black);
//
//        //Adding Components to the frame.
//        //frame.getContentPane().add(BorderLayout.SOUTH, select);
//        //frame.getContentPane().add(BorderLayout.NORTH, title);
//        frame.getContentPane().add(BorderLayout.CENTER, panel);
//        frame.setVisible(true);
//    }
//}

package View;

import Controller.UIController;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

public class GUISearch extends JPanel implements ActionListener {

    private JButton search, add, delete;
    private JTextField textField;

    public GUISearch() {

        search = new JButton("Search");
        add = new JButton("Add");
        delete = new JButton("Delete");
        textField = new JTextField(20);
        add.addActionListener(this);
        delete.addActionListener(this);
        setLayout(new BorderLayout());
        JPanel top = new JPanel();
        top.add(search);
        add(top, BorderLayout.NORTH);
        JPanel bottom = new JPanel();
        bottom.add(add);
        bottom.add(delete);
        add(bottom, BorderLayout.SOUTH);
        setVisible(true);
        setSize(400, 500);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add) {
            UIController.getInstance().changeCard("Next");
        } else if (e.getSource() == delete) {
            System.out.println("do something");
        }
    }

}