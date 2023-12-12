// import javax.swing.*;
// import java.awt.*;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
// import java.util.HashMap;

// public class FlashcardAppGUI extends JFrame {
//     private JTextArea friendInfo;

//     public FlashcardAppGUI() {
//         setTitle("Karteikarten für Freunde");
//         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         setLayout(new GridBagLayout());
//         setSize(1000, 700);

//         GridBagConstraints constraints = new GridBagConstraints();

//         // Column 1
//         JPanel panel1 = new JPanel();
//         panel1.setPreferredSize(new Dimension(300, 700));
//         JScrollPane scrollPane1 = new JScrollPane(panel1);
//         scrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//         constraints.gridx = 0;
//         constraints.gridy = 0;
//         constraints.weightx = 0; // No extra space
//         constraints.weighty = 1.0; // Allow vertical expansion
//         constraints.fill = GridBagConstraints.BOTH;
//         add(scrollPane1, constraints);

    

//         // Column 2
//         JPanel panel2 = new JPanel();
//         panel2.setPreferredSize(new Dimension(700, 700));
//         // inputbar label
//         JLabel label = new JLabel("Freund suchen");
//         panel2.add(label, BorderLayout.NORTH);
//         // inbuptbar
//         JTextField inputBar = new JTextField();
//         inputBar.setPreferredSize(new Dimension(500, 30));
//         panel2.add(inputBar);
//         constraints.gridx = 1;
//         constraints.gridy = 0;
//         constraints.weightx = 0;
//         constraints.weighty = 0.7; // Allow vertical expansion
//         constraints.fill = GridBagConstraints.BOTH;
//         add(panel2, constraints);

//         JPanel inputFieldsPanel = createInputFields();
//         panel2.add(inputFieldsPanel, BorderLayout.CENTER);

//     }
//     private HashMap<String, JTextField> inputFields = new HashMap<>();

//         public JPanel createInputFields() {
//         // Create a panel for the input fields
//         JPanel inputPanel = new JPanel(new GridLayout(3, 4)); // 3 rows, 4 columns

//         // Define the labels
//         String[] labels = { "Vorname", "Nachname", "Geburtsdatum", "Strasse", "Hausnummer", "PLZ", "Stadt", "Land" };

//         // Create fields with labels
//         for (String labelText : labels) {
//             // Create a panel for the label-input pair
//             JPanel pairPanel = new JPanel(new BorderLayout());

//             // Create label
//             JLabel label = new JLabel(labelText);
//             pairPanel.add(label, BorderLayout.NORTH); // Add label to the top

//             // Create input field
//             JTextField inputField = new JTextField();
//             inputField.setPreferredSize(new Dimension(100, 20));
//             pairPanel.add(inputField, BorderLayout.CENTER); // Add input field to the center

//             // Store input field
//             inputFields.put(labelText, inputField);

//             inputPanel.add(pairPanel);
//         }

//         // Create buttons
//         JButton createButton = new JButton("Erstelle neuen Freund");
//         JButton saveButton = new JButton("Speichern");
//         JButton deleteButton = new JButton("Löschen");

//         // Add buttons to panel
//         inputPanel.add(createButton);
//         inputPanel.add(saveButton);
//         inputPanel.add(deleteButton);

//         return inputPanel;
//     }
    
// }