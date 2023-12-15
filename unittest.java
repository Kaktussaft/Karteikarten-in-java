import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class unittest {
        //Ein Versuch an Unit_testing -habe mich Schlussendlich entschieden mit Seed-DAten zu testen
    static Stream<Arguments> testData() {
        return Stream.of(
                arguments("John", "Doe", LocalDate.of(1990, 1, 1), "Street1", "1A", "12345", "City1", "Country1"),
                arguments("Jane", "Doe", LocalDate.of(1992, 2, 2), "Street2", "2B", "23456", "City2", "Country2"),
                arguments("Alice", "Smith", LocalDate.of(1994, 3, 3), "Street3", "3C", "34567", "City3", "Country3"),
                arguments("Bob", "Johnson", LocalDate.of(1996, 4, 4), "Street4", "4D", "45678", "City4", "Country4"),
                arguments("Charlie", "Brown", LocalDate.of(1998, 6, 5), "Street5", "5E", "56789", "City5", "Country5"));
    }

    @ParameterizedTest
    @MethodSource("testData")
    //test Option 1 adding friends to the list
    void testOption_1(String Vorname, String Nachname, LocalDate Geburtstag, String Strasse, String Hausnummer, String PLZ, String Stadt, String Land) {
        Adresse adresse = new Adresse(Strasse, Hausnummer, PLZ, Stadt, Land);
        ArrayList<Adresse> adressen = new ArrayList<>();
        adressen.add(adresse);
        Freund freund = new Freund(Vorname, Nachname, Geburtstag, adressen);
        
        List<Freund> freundListe = new ArrayList<>();
        freundListe.add(freund);

        assertEquals(1, freundListe.size());
        assertEquals(freund, freundListe.get(0));
    }
}