package arbeiter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SchichtArbeiterTest {

    SchichtArbeiter schichtArbeiter;

    @BeforeEach
    public void setup() {
        schichtArbeiter = new SchichtArbeiter(3000, "NichtPascal", 14);
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
        assertEquals(560, schichtArbeiter.einkommen(), 0); //festgehalt + bonuszahlung
    }

    @Test
    public void testGehaltComparator() {
        SchichtArbeiter schichtArbeiterMehrGeld = new SchichtArbeiter(3002, "zed", 15);
        schichtArbeiterMehrGeld.setAnzahlStunden(40);
        SchichtArbeiter schichtArbeiterWenigerGeld = new SchichtArbeiter(3002, "Pascal", 0);
        schichtArbeiterWenigerGeld.setAnzahlStunden(40);
        SchichtArbeiter schichtArbeiterGleichGeld = new SchichtArbeiter(3002, "Patrik", 14);
        schichtArbeiterGleichGeld.setAnzahlStunden(40);
        assertEquals(1, schichtArbeiter.compareGehalt(schichtArbeiterWenigerGeld), "Mehr Geld");
        assertEquals(0, schichtArbeiter.compareGehalt(schichtArbeiterGleichGeld), "Gleiches Geld");
        assertEquals(-1, schichtArbeiter.compareGehalt(schichtArbeiterMehrGeld), "Weniger Geld");

    }
}
