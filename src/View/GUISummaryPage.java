/*
package View;

import javax.swing.*;
import java.awt.*;


public class GUISummaryPage {
    public static void main(String args[]) {

        //Creating the Frame
        JFrame frame = new JFrame("Library OneSearch");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.setBackground(Color.WHITE);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();


        JTextArea textArea = new JTextArea(30,20);
        textArea.append("Library OneSearch");
        textArea.setFont(new Font("Calibri", Font.PLAIN, 16));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 1;
        panel.add(textArea,c);


        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.setVisible(true);
    }
} */

package View;
// Java program to create a blank text
// field of definite number of columns.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class text extends JFrame implements ActionListener {
    // JTextField
    static JTextField t;

    // JTextArea
    static JTextArea a;

    // JFrame
    static JFrame f;

    // JButton
    static JButton b;

    // label to display text
    static JLabel l;

    // default constructor
    text() {}

    // main class
    public static void main(String[] args)
    {
        // create a new frame to store text field and button
        f = new JFrame("Library OneSearch Application");

        // create a label to display text
        l = new JLabel("nothing entered");

        // create a new button
        b = new JButton("search");

        // create a object of the text class
        text te = new text();

        // addActionListener to button
        b.addActionListener(te);

        // create a object of JTextField with 16 columns
        t = new JTextField(16);

        a = new JTextArea();
        a.append("Library OneSearch");
        a.setForeground(new Color(147, 112, 219));

        // create a panel to add buttons and textfield
        JPanel p = new JPanel();

        // add buttons and textfield to panel
        p.add(a);
        p.add(t);
        p.add(b);
        p.add(l);
        // add panel to frame
        f.add(p);

        // set the size of frame
        f.setSize(800, 800);

        f.show();
    }

    // if the button is pressed
    public void actionPerformed(ActionEvent e)
    {
        String s = e.getActionCommand();
        if (s.equals("search")) {
            // set the text of the label to the text of the field
            l.setText(t.getText());

            // set the text of field to blank
            t.setText("");
        }
    }
}