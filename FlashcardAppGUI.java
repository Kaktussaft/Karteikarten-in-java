import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List; // Add this import statement

public class FlashcardAppGUI extends JFrame {
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

        // Create the label for the friend list
        JLabel friendListLabel = new JLabel("Alle gespeicherten Freunde");

        // Create a panel to hold the label and the friend list
        JPanel friendListPanel = new JPanel(new BorderLayout());
        friendListPanel.add(friendListLabel, BorderLayout.NORTH);
        friendListPanel.add(friendListScrollPane, BorderLayout.CENTER);

        // Create the label for the search field
        JLabel searchLabel = new JLabel("Suche Freund");

        

        // Declare and initialize the searchField variable this function will return the friend objects
        // and multiple off them if they are present
        JTextField searchField = new JTextField();
        searchField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = searchField.getText();
                List<Freund> freunde = Kartei.suchFreunde(name);
                if (!freunde.isEmpty()) {
                    StringBuilder sb = new StringBuilder();
                    for (Freund freund : freunde) {
                        sb.append(freund.toString()).append("\n");
                    }
                    friendInfo.setText(sb.toString());
                } else {
                    friendInfo.setText("Kein Freund gefunden mit Name: " + name);
                }
            }
        });

        // Create a panel to hold the search label and search field
        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new BoxLayout(searchPanel, BoxLayout.Y_AXIS));
        searchPanel.add(searchLabel);
        searchPanel.add(searchField);

        // Create the friend info area
        friendInfo = new JTextArea();
        friendInfo.setEditable(false);

        // Create a panel to hold the search panel and friend info area
        JPanel inputAndEditPanel = new JPanel(new BorderLayout());
        inputAndEditPanel.add(searchPanel, BorderLayout.NORTH);
        inputAndEditPanel.add(new JScrollPane(friendInfo), BorderLayout.CENTER);

        // Create the split pane and add the friend list panel and input/edit panel to
        // it
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, friendListPanel, inputAndEditPanel);
        splitPane.setDividerLocation(200); // Set the initial divider location

        // Add the split pane to the frame
        add(splitPane, BorderLayout.CENTER);

        // Set the size of the frame
        setSize(1000, 700);

    }
}