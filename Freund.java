import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class Freund {
    private int Freund_ID;
    public String Vorname;
    public String Nachname;
    public LocalDate Geburtsdatum;
    public List<Adresse> Adressen; 
    public static List<Freund> Freund_Liste = new ArrayList<>();
   

    public int getFreund_ID() {
        return Freund_ID;
    }

    public void setFreund_ID(int freund_ID) {
        Freund_ID = freund_ID;
    }

    public  Freund(String vorname, String nachname, LocalDate geburtsdatum, ArrayList<Adresse> adressen) {
        this.Vorname = vorname;
        this.Nachname = nachname;
        this.Geburtsdatum = geburtsdatum;
        this.Freund_ID = Freund_Liste.size() + 1;
        this.Adressen = adressen; 
        Freund_Liste.add(this);
    }
}
