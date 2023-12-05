import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;

public class FlashcardAppGUI extends JFrame {
    private JButton showButton;
    private JLabel flashcardLabel;
    private JList<Freund> friendList;
    private JTextArea friendInfo;

    public FlashcardAppGUI() {
        setTitle("Karteikarten für Freunde");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
    
        // Create the friend list
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (Freund freund : Freund.Freund_Liste) {
            listModel.addElement(freund.Vorname + " " + freund.Nachname);
        }
        JList<String> friendList = new JList<>(listModel);
        JScrollPane friendListScrollPane = new JScrollPane(friendList);
    
        // Create the input and edit options
        JPanel inputAndEditPanel = new JPanel();
      
    
        // Create the split pane
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, friendListScrollPane, inputAndEditPanel);
        splitPane.setDividerLocation(200); // Set the initial divider location
    
        // Add the split pane to the frame
        add(splitPane, BorderLayout.CENTER);
        setSize(1000, 700);
    }
}