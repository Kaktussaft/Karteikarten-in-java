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

    public static Freund suchFreund(String name)
    {
        for (Freund freund : freundListe) {
            if (freund.Vorname.equals(name) || freund.Nachname.equals(name)) {
                return freund;
            }
        }
        return null;
    }
    // public Freund_anzeigen(Freund freund)
    // {

    // return new freund();
    // }

}