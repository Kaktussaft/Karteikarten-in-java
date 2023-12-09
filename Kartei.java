import java.util.ArrayList;
import java.time.LocalDate;
import java.util.List;

public class Kartei {

    static List<Freund> freundListe = Freund.Freund_Liste;
    
   
    public Freund Freund_ändern(Freund freund, String vorname, String nachname, LocalDate geburtsdatum, String strasse,
            String hausnummer, String plz, String stadt, String land) {
    if (!vorname.isEmpty()) {
        freund.Vorname = vorname;
    }
    if (!nachname.isEmpty()) {
        freund.Nachname = nachname;
    }
    if (geburtsdatum != null) {
        freund.Geburtsdatum = geburtsdatum;
    }
    
    Adresse neueAdresse = new Adresse(null, null, null, null, null);
    if (!strasse.isEmpty()) {
        neueAdresse.Strasse = strasse;
    }
    if (!hausnummer.isEmpty()) {
        neueAdresse.Hausnummer = hausnummer;
    }
    if (!plz.isEmpty()) {
        neueAdresse.PLZ = plz;
    }
    if (!stadt.isEmpty()) {
        neueAdresse.Stadt = stadt;
    }
    if (!land.isEmpty()) {
        neueAdresse.Land = land;
    }
    
    freund.Adressen.clear();
    freund.Adressen.add(neueAdresse);

    return freund;
}
    // }
    // public Freund_löschen(Freund freund)
    // {

    // return new freund();
    // }

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