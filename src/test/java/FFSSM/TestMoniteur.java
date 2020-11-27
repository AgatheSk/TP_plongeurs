/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FFSSM;

import java.time.LocalDate;
import java.time.Month;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author agath
 */
public class TestMoniteur {

    private Plongeur p;
    private Licence l1;
    private Licence l2;
    private Club c1;
    private Moniteur m1;// L'objet à tester

    @BeforeEach
    public void setUp() {
        // Initialiser les objets utilisés dans les tests
        m1 = new Moniteur("AFGF", "Bob", "Robert", "quelque part", "3630", LocalDate.of(2006, 6, 6), 3, 456, GroupeSanguin.BPLUS);
        c1 = new Club(m1, "Sous l'ocean", "777");
        p = new Plongeur("FG", "Bastide", "Rémi", "dans une maison", "112", LocalDate.of(1800, 4, 25), 0, GroupeSanguin.AMOINS);
    }

    @Test
    public void TestEmployeurActuel() {
        m1.nouvelleEmbauche(c1, LocalDate.of(2020, 11, 25));
        assertEquals(c1.toString(), m1.employeurActuel().orElse(null).toString(), "L'employeur actuel n'est pas le bon");
    }

    @Test
    public void TestTerminerEmbauche() {
        m1.nouvelleEmbauche(c1, LocalDate.of(2020, 11, 25));
        m1.terminerEmbauche(LocalDate.of(2020, Month.DECEMBER, 25));
        //on vérifie que l'emploi est bien terminé
        assertTrue(m1.getEmployeurs().peekFirst().estTerminee(), "L'emploi est censé être terminé");
    }

    @Test
    public void TestTerminerEmbaucheNull() {
                System.out.println("Ici");

        try {
                            System.out.println("Debut");

            // On termine une embauche sans employeurs
            m1.terminerEmbauche(LocalDate.of(2020, Month.DECEMBER, 25));
                                        System.out.println("fin");

            fail();
        } catch (IllegalArgumentException e) {
                                        System.out.println("pls");

            System.out.println(e);
        }
    }
    
    @Test
    public void TestTerminerEmbaucheDejaTerminee() {
        m1.nouvelleEmbauche(c1, LocalDate.of(2020, 11, 25));
        m1.terminerEmbauche(LocalDate.of(2020, Month.DECEMBER, 25));

        try {
            // On termine une embauche déjà terminée
            m1.terminerEmbauche(LocalDate.of(2020, Month.DECEMBER, 25));
            fail();
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }
}
