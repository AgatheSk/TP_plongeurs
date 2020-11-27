/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FFSSM;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author agath
 */
public class TestLicence {

    private Plongeur p; 
    private Licence l1;// L'objet à tester
    private Club c1;
    private Moniteur m1;

    @BeforeEach
    public void setUp() {
        // Initialiser les objets utilisés dans les tests
        m1 = new Moniteur("AFGF", "Bob", "Robert", "quelque part", "3630", LocalDate.of(2006, 6, 6), 3, 456, GroupeSanguin.BPLUS);
        c1 = new Club(m1, "Sous l'ocean", "777");
        p = new Plongeur("FG", "Bastide", "Rémi", "dans une maison", "112", LocalDate.of(1800, 4, 25), 0, GroupeSanguin.AMOINS);
    }

    @Test
    public void setNumeroNull() {
        try {
            l1 = new Licence(p, null, LocalDate.of(2020, 12, 31), c1);
            fail();
        } catch (IllegalArgumentException e) {
            System.out.print(e);
        }
    }

    @Test
    public void TestLicenceValide() {
        l1 = new Licence(p, "7824", LocalDate.of(2020, 12, 31), c1);
        assertTrue(l1.estValide(LocalDate.of(2020, 11, 25)), "La licence est censée être valide");
    }

    @Test
    public void TestLicencePasValide() {
        l1 = new Licence(p, "7824", LocalDate.of(2020, 12, 31), c1);
        assertFalse(l1.estValide(LocalDate.of(2022, 1, 11)), "La licence est censée être invalide");
    }

    @Test
    public void TestLicenceValide2() {
        l1 = new Licence(p, "7824", LocalDate.of(2020, 12, 31), c1);
        assertTrue(l1.estValide(LocalDate.of(2020, 12, 31)), "La licence est censée être valide");
    }
}
