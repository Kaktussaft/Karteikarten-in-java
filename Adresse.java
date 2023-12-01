import java.util.List;
import java.util.ArrayList;

public class Adresse
{
    private int Adresse_ID = 1;
    public String Strasse;
    public String Hausnummer;
    public String PLZ;
    public String Stadt;
    public String Land;
    private static List<Adresse> Adressen = new ArrayList<>();


    public int getAdresse_ID() {
        return Adresse_ID;
    }

    public void setAdresse_ID(int adresse_ID) {
        Adresse_ID = adresse_ID;
    }
  
    
    public Adresse(String strasse, String hausnummer, String plz, String stadt, String land) {
        this.Strasse = strasse;
        this.Hausnummer = hausnummer;
        this.PLZ = plz;
        this.Stadt = stadt;
        this.Land = land;
        this.Adresse_ID = Adressen.size() + 1;
        Adressen.add(this);
    }


    
}