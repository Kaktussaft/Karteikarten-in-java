import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Kartei {

    static List<Freund> freundListe = Freund.Freund_Liste;
    
   
    // public Freund_ändern(Freund freund)
    // {

    // return new freund();
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
    // public Freund_anzeigen(Freund freund)
    // {

    // return new freund();
    // }

}