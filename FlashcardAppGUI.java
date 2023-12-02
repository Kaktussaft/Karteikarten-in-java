import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FlashcardAppGUI extends JFrame {
    private JButton showButton;
    private JLabel flashcardLabel;
    private JList<String> friendList;
    private JTextArea friendInfo;

    public FlashcardAppGUI() {
        setTitle("Karteikarten für Freunde");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        showButton = new JButton("Show Flashcard");
        flashcardLabel = new JLabel();

        showButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Replace this with your flashcard logic
                String flashcardText = "This is a sample flashcard text.";
                flashcardLabel.setText(flashcardText);
            }
        });

        String[] friends = {"John Doe", "Jane Doe"};
        friendList = new JList<>(friends);
        friendList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        friendList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                String selectedFriend = friendList.getSelectedValue();
                String friendInfoText = "This is the full information of " + selectedFriend + ".";
                friendInfo.setText(friendInfoText);
            }
        });

        friendInfo = new JTextArea();
        friendInfo.setEditable(false);

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, new JScrollPane(friendList), new JScrollPane(friendInfo));
        splitPane.setDividerLocation(200);

        add(showButton, BorderLayout.NORTH);
        add(flashcardLabel, BorderLayout.SOUTH);
        add(splitPane, BorderLayout.CENTER);

        setSize(1000, 700);
        setLocationRelativeTo(null); // Centers the frame
    }
}