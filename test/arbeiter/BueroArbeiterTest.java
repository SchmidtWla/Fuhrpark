package arbeiter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BueroArbeiterTest {

    BueroArbeiter bueroArbeiter;

    @BeforeEach
    public void setup() {
        bueroArbeiter = new BueroArbeiter(5120,"arnold", 5000);
    }

    @Test
    public void testID(){
        assertThrows(IllegalArgumentException.class, () -> {
            BueroArbeiter bueroArbeiter = new BueroArbeiter(1, "arnold", 5000);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            BueroArbeiter bueroArbeiter = new BueroArbeiter(6000, "gustav", 5000);
        });
        assertDoesNotThrow(() -> {
            BueroArbeiter bueroArbeiter = new BueroArbeiter(5120, "alfred", 5000);
        });
    }

    @Test
    public void testEinkommen() {
        assertEquals(bueroArbeiter.einkommen(), 5000, 0);
    }
}
