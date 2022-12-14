package View;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiMainFrame extends JFrame {
    private JPanel mainPanel;
    private JTextArea desc;
    private JLabel title;
    private JFormattedTextField searchBar;
    private JButton searchButton;
    private JCheckBox check1;
    private JCheckBox check4;
    private JCheckBox check3;
    private JCheckBox check6;
    private JCheckBox check2;
    private JCheckBox check5;
    private JCheckBox check7;
    private JCheckBox check8;

    //include a JComboBox
    public GuiMainFrame(){
        setContentPane(mainPanel);
        setSize(800,600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String searchedItem = searchBar.getText();

                if (check1.isSelected()){
                    String libraryName = check1.getText();
                }

                if (check2.isSelected()){
                    String libraryName = check2.getText();
                }

                if (check3.isSelected()){
                    String libraryName = check3.getText();
                }

                if (check4.isSelected()){
                    String libraryName = check4.getText();
                }

                if (check5.isSelected()){
                    String libraryName = check5.getText();
                }

                if (check6.isSelected()){
                    String libraryName = check6.getText();
                }

            }
        });
    }

    //Search Bar Information and multi-choice checkboxes are processed once the search button is clicked
    //Error Throws:

    public static void main(String[] args) {

        GuiMainFrame myFrame = new GuiMainFrame();
    }
}
