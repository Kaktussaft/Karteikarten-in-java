import java.util.ArrayList;
import java.time.LocalDate;
import java.util.List;

public class Kartei {

    static List<Freund> freundListe = Freund.Freund_Liste;

    public static void Freund_ändern(Freund freund, String vorname, String nachname, LocalDate geburtsdatum,
            String strasse,
            String hausnummer, String plz, String stadt, String land) {
        if (!vorname.equals("0")) {
            freund.Vorname = vorname;
        }
        if (!nachname.equals("0")) {
            freund.Nachname = nachname;
        }

        if (geburtsdatum != null) {
            freund.Geburtsdatum = geburtsdatum;
        }

        Adresse neueAdresse = new Adresse(null, null, null, null, null);
        if (!strasse.equals("0")) {
            neueAdresse.Strasse = strasse;
        }
        if (!hausnummer.equals("0")) {
            neueAdresse.Hausnummer = hausnummer;
        }
        if (!plz.equals("0")) {
            neueAdresse.PLZ = plz;
        }
        if (!stadt.equals("0")) {
            neueAdresse.Stadt = stadt;
        }
        if (!land.equals("0")) {
            neueAdresse.Land = land;
        }

              if (!strasse.equals("0") || !hausnummer.equals("0") || !plz.equals("0") || !stadt.equals("0")
                || !land.equals("0")) {
            freund.Adressen.clear();
            freund.Adressen.add(neueAdresse);
        }
    }

    public static List<Freund> suchFreunde(String name) {
        List<Freund> freunde = new ArrayList<>();
        for (Freund freund : freundListe) {
            if (freund.Vorname.equals(name) || freund.Nachname.equals(name)) {
                freunde.add(freund);
            }
        }
        return freunde;
    }

}