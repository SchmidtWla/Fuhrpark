package arbeiter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SchichtArbeiterTest {

    SchichtArbeiter schichtArbeiter;

    @BeforeEach
    public void setup() {
        schichtArbeiter = new SchichtArbeiter(3000, "Pascal", 14);
        schichtArbeiter.setAnzahlStunden(40);
    }

    @Test
    public void testID() {
        assertThrows(IllegalArgumentException.class, () -> {
            SchichtArbeiter schichtarbeiter = new SchichtArbeiter(1, "arnold", 14); //
        });
        assertThrows(IllegalArgumentException.class, () -> {
            SchichtArbeiter schichtarbeiter = new SchichtArbeiter(9000, "gustav", 14);
        });
        assertDoesNotThrow(() -> {
            SchichtArbeiter schichtarbeiter = new SchichtArbeiter(3001, "alfred", 14);
        });
    }

    @Test
    public void testEinkommen() {
        System.out.println("1");
        assertEquals(560, schichtArbeiter.einkommen(), 0); //festgehalt + bonuszahlung
    }

    @Test
    public void testGehaltComparator() {
        Mitarbeiter.MitarbeiterComparator comp = new Mitarbeiter.MitarbeiterComparator();
        SchichtArbeiter schichtArbeiterMehrGeld = new SchichtArbeiter(3002, "zed", 15);
        schichtArbeiterMehrGeld.setAnzahlStunden(40);
        //jjjjj
        //NOch mehr dummes Zeug
        SchichtArbeiter schichtArbeiterWenigerGeld = new SchichtArbeiter(3002, "Pascal", 0);
        schichtArbeiterWenigerGeld.setAnzahlStunden(40);
        SchichtArbeiter schichtArbeiterGleichGeld = new SchichtArbeiter(3002, "Patrik", 14);
        schichtArbeiterGleichGeld.setAnzahlStunden(40);
        assertEquals(-1, comp.compare(schichtArbeiter,schichtArbeiterMehrGeld), "Mehr Geld");
        assertEquals(0, comp.compare(schichtArbeiter, schichtArbeiterGleichGeld), "Gleiches Geld");
        assertEquals(1, comp.compare(schichtArbeiter, schichtArbeiterWenigerGeld), "Weniger Geld");
    }

    @Test
    public void testNameCompare() {
        SchichtArbeiter schichtArbeiterkleinerName = new SchichtArbeiter(3002, "Alf", 15);
        schichtArbeiterkleinerName.setAnzahlStunden(40);
        SchichtArbeiter schichtArbeiterGleicherName= new SchichtArbeiter(3002, "Pascal", 0);
        schichtArbeiterGleicherName.setAnzahlStunden(40);
        SchichtArbeiter schichtArbeiterGrosserName = new SchichtArbeiter(3002, "zed", 14);
        schichtArbeiterGrosserName.setAnzahlStunden(40);
        assertTrue( schichtArbeiter.compareTo(schichtArbeiterkleinerName) > 0, "Mehr Geld");
        assertTrue( schichtArbeiter.compareTo(schichtArbeiterGleicherName) == 0, "Gleiches Geld");
        assertTrue( schichtArbeiter.compareTo(schichtArbeiterGrosserName) < 0, "Weniger Geld");
    }

}
