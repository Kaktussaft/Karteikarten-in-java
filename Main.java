import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

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

        //Seed Daten um zu testen
        Option_1("John", "Doe", LocalDate.of(1990, 1, 1), "Street1", "1A", "12345", "City1", "Country1");
        Option_1("Jane", "Doe", LocalDate.of(1992, 2, 2), "Street2", "2B", "23456", "City2", "Country2");
        Option_1("Alice", "Smith", LocalDate.of(1994, 3, 3), "Street3", "3C", "34567", "City3", "Country3");
        Option_1("Bob", "Johnson", LocalDate.of(1996, 4, 4), "Street4", "4D", "45678", "City4", "Country4");
        Option_1("Charlie", "Brown", LocalDate.of(1998, 6, 5), "Street5", "5E", "56789", "City5", "Country5");

        while (running = true) {
            List<Freund> foundFriends = new ArrayList<>();// initialize foundFriends

            switch (Handlungsoptionen()) { 
                case 1: //Freund hinzufügen
                    Get_user_input_Name();
                    Get_user_input_Adresse();
                    Option_1(temp_Vorname, temp_Nachname, temp_Geburtstag, temp_Strasse, temp_Hausnummer, temp_PLZ,
                            temp_Stadt, temp_Land);
                    break;

                case 2: //Freund ändern
                foundFriends = Kartei.suchFreunde(Option_2());
                var counter = 1;
                for (Freund freund : foundFriends) {
                    System.out.println(counter + " " + freund.Vorname + " " + freund.Nachname);
                    counter++;
                }
                var to_be_changed = Integer.parseInt(promptForNonEmptyInput("Wählen Sie aus welchen Freund Sie ändern möchten"));
                var Requested_change = Integer.parseInt(promptForNonEmptyInput("Es gibt 3 Optionen: Das bestehende Freund Object Ändern: 1; oder eine Adresse hinzufügen 2; oder alle Adressen löschen 3"));
                System.out.println("Falls sie ein Feld nicht ändern möchten geben Sie 0 ein");

                switch (Requested_change) {
                    case 1: //Freund ändern
                        Get_user_input_Name();
                        Get_user_input_Adresse();
                        Kartei.Freund_ändern(foundFriends.get(to_be_changed - 1), temp_Vorname, temp_Nachname, temp_Geburtstag, temp_Strasse, temp_Hausnummer, temp_PLZ, temp_Stadt, temp_Land);
                        break;
                    case 2: //Adresse hinzufügen
                       Get_user_input_Adresse();
                        Adresse newAdresse = new Adresse(temp_Strasse, temp_Hausnummer, temp_PLZ, temp_Stadt, temp_Land);
                        foundFriends.get(to_be_changed - 1).Adressen.add(newAdresse);
                        break;
                    case 3: //Alle Adressen löschen
                        foundFriends.get(to_be_changed - 1).Adressen.clear();
                        break;
                        }

                break;

                case 3: //Freund löschen
                    System.out.println("\n");
                    foundFriends = Kartei.suchFreunde(Option_2());
                    var counter_delete = 1;
                    for (Freund Freund : foundFriends) {
                        System.out.println(counter_delete + " " + Freund.Vorname + " " + Freund.Nachname);
                        counter_delete++;
                    }
                    var to_be_deleted = Integer.parseInt(promptForNonEmptyInput("Wählen Sie aus welchen Freund Sie löschen möchten"));
                    
                    Freund toRemove = foundFriends.get(to_be_deleted - 1);
                    Freund.Freund_Liste.remove(toRemove);
                
                    System.out.println("\n");
                    break;

                case 4: //Freund suchen
                    System.out.println("\n");
                    foundFriends = Kartei.suchFreunde(Option_2());
                    for (Freund Freund : foundFriends) {
                        System.out.println(Freund.Vorname + " " + Freund.Nachname + " " + Freund.Geburtsdatum);

                        Print_Out_Adresses(Freund);
                        System.out.println("\n");
                    }
                    break;

                    case 5: //Alle Freunde anzeigen
                    Option_5();
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
        // catch all User inputs that are not integers 1-5 and prompt the user to try
        // again

        while (eingabe < 1 || eingabe > 5) {
            System.out.println("Bitte geben Sie eine Zahl zwischen 1 und 5 ein.");
            eingabe = scanner.nextInt();
        }
        return eingabe;

    }

    // Freund hinzufügen
    public static void Option_1(String Vorname, String Nachname, LocalDate Geburtstag, String Strasse,
            String Hausnummer, String PLZ, String Stadt, String Land) {
        Adresse newAdresse = new Adresse(Strasse, Hausnummer, PLZ, Stadt, Land);
        ArrayList<Adresse> adressenList = new ArrayList<>();
        adressenList.add(newAdresse);
        Freund newFreund = new Freund(Vorname, Nachname, Geburtstag, adressenList); // New friend object is created in
                                                                                    // the constructor
    }

    public static String Option_2() {
        
        var freund_name = promptForNonEmptyInput("Bitte geben Sie den Namen des Freundes ein:");
         return freund_name; 
    }
    

    

    public static String Option_4() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bitte geben Sie den Namen des Freundes ein:");
        String name = scanner.nextLine();
        return name;
    }

    public static void Option_5()
    {
         System.out.println("\n");
                    System.out.println("Anzahl Freunde: " + Freund.Freund_Liste.size() );
                    for (Freund freund : Freund.Freund_Liste) {
                        System.out.println(freund.Vorname + " " + freund.Nachname + " " + freund.Geburtsdatum);

                        Print_Out_Adresses(freund);
                        System.out.println("\n");
                    }
                   
    }

    //make sure the user does not enter an empty string
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

    //make sure the user enters a date in the correct format
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

        //get user input for name
    public static void Get_user_input_Name() {

        temp_Vorname = promptForNonEmptyInput("Bitte geben Sie den Vornamen ein:");
        temp_Nachname = promptForNonEmptyInput("Bitte geben Sie den Nachnamen ein:");
        temp_Geburtstag = promptForDate("Bitte geben Sie das Geburtsdatum ein: 'dd.MM.yyyy'");
    }

    //get user input for address
    public static void Get_user_input_Adresse() {
        temp_Strasse = promptForNonEmptyInput("Bitte geben Sie die Straße ein:");
        temp_Hausnummer = promptForNonEmptyInput("Bitte geben Sie die Hausnummer ein:");
        temp_PLZ = promptForNonEmptyInput("Bitte geben Sie die Postleitzahl ein:");
        temp_Stadt = promptForNonEmptyInput("Bitte geben Sie die Stadt ein:");
        temp_Land = promptForNonEmptyInput("Bitte geben Sie das Land ein:");
    }

    public static void Print_Out_Adresses(Freund freund) { //print out multiple adresses and don't throw and error if there are none
        if(freund.Adressen.size() > 0){
            for (Adresse adresse : freund.Adressen){
                System.out.println(adresse.Strasse + " " + adresse.Hausnummer+ " " + adresse.PLZ  + ", " + adresse.Stadt + ", " + adresse.Land);
            }
        }
    }

}