import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.SwingUtilities;



public class Main extends Application{
   

    Freund freund = new Freund(null, null, null, null);
    Kartei kartei = new Kartei();
    public static boolean running = true;
    

    static String temp_Vorname;
    static String temp_Nachname;
    static LocalDate temp_Geburtstag;
    static String temp_Strasse;
    static String temp_Hausnummer;
    static String temp_PLZ;
    static String temp_Stadt;
    static String temp_Land;

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new FlashcardAppGUI().setVisible(true);
            }
        });

        while (running = true) {

            switch (Handlungsoptionen()) {
                case 1:
                    Get_user_input_Name();
                    Get_user_input_Adresse();
                    Option_1(temp_Vorname, temp_Nachname, temp_Geburtstag, temp_Strasse, temp_Hausnummer, temp_PLZ, temp_Stadt, temp_Land);
                    break;

                    case 2:
                    Freund foundFriend = Kartei.suchFreund(Option_2());
                    System.out.println(foundFriend);
                    break;

                    case 3:
                    System.out.println("Füge einen Freund hinzu: 1");
                    break;

                    case 4:
                    Freund foundFreund = Kartei.suchFreund(Option_4());
                    System.out.println(foundFreund);
                    break;

                case 5:
                    System.out.println("Füge einen Freund hinzu: 1");
                    break;
            }
        }

    }

 
    public static int Handlungsoptionen() {
     
        Scanner scanner = new Scanner(System.in);

        System.out.println("Es gibt die folgenden Optionen: ");
        System.out.println("Füge einen Freund hinzu: 1");
        System.out.println("Ändere einen bestehenden Freund: 2");
        System.out.println("Lösche einen Eintrag: 3");
        System.out.println("Suche nach einem Freund: 4");
        System.out.println("Zeige alle Freunde an: 5");

        Integer eingabe = scanner.nextInt();
        // catch all User inputs that are not integers 1-5 and prompt the user to try again
        
        while (eingabe < 1 || eingabe > 5) {
            System.out.println("Bitte geben Sie eine Zahl zwischen 1 und 5 ein.");
            eingabe = scanner.nextInt();
        }
        return eingabe;
    
    }

        public static Freund Option_1(String Vorname, String Nachname, LocalDate Geburtstag, String Strasse, String Hausnummer, String PLZ, String Stadt, String Land) {
        Adresse newAdresse = new Adresse(temp_Strasse, temp_Hausnummer, temp_PLZ, temp_Stadt, temp_Land);
        ArrayList<Adresse> adressenList = new ArrayList<>();
        adressenList.add(newAdresse);
        Freund newFreund = new Freund(temp_Vorname, temp_Nachname, temp_Geburtstag, adressenList);
        return newFreund;
    }

    public static String Option_2() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bitte geben Sie den Vor- oder Nachnamen des Freundes ein:");
        String name = scanner.nextLine();
        return name;
    }

    // public static Freund Option_3() {
    // new Freund(null, null, null, null);
    // }

    public static String Option_4() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bitte geben Sie den Namen des Freundes ein:");
        String name = scanner.nextLine();
        return name;
    }

    public static String promptForNonEmptyInput(String prompt) { // check if input is empty
        Scanner scanner = new Scanner(System.in);
        String input = "";
        while (input.isEmpty()) {
            System.out.println(prompt);
            input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Eingabe darf nicht leer sein. Bitte erneut eingeben.");
            }
        }
        return input;
    }

    public static LocalDate promptForDate(String prompt) { // check if date is in correct format and not null
        LocalDate date = null;
        while (date == null) {
            String dateString = promptForNonEmptyInput(prompt);
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                date = LocalDate.parse(dateString, formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Das Datum wurde im falschen Format eingegeben. Bitte versuchen Sie es erneut.");
            }
        }
        return date;
    }
    public static void Get_user_input_Name() {
       
        temp_Vorname = promptForNonEmptyInput("Bitte geben Sie den Vornamen ein:");
        temp_Nachname = promptForNonEmptyInput("Bitte geben Sie den Nachnamen ein:");
        temp_Geburtstag = promptForDate("Bitte geben Sie das Geburtsdatum ein: 'dd.MM.yyyy'");
    }

    public static void Get_user_input_Adresse() {
        temp_Strasse = promptForNonEmptyInput("Bitte geben Sie die Straße ein:");
        temp_Hausnummer = promptForNonEmptyInput("Bitte geben Sie die Hausnummer ein:");
        temp_PLZ = promptForNonEmptyInput("Bitte geben Sie die Postleitzahl ein:");
        temp_Stadt = promptForNonEmptyInput("Bitte geben Sie die Stadt ein:");
        temp_Land = promptForNonEmptyInput("Bitte geben Sie das Land ein:");
    }

    

}