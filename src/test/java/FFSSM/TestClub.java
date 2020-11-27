/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FFSSM;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author agath
 */
public class TestClub {
    private Plongeur p;
    private Licence l1;
    private Licence l2;
    private Club c1; // L'objet à tester
    private Moniteur m1;
    private Site s1;
    private Plongee pl1;
    private Plongee pl2;

    @BeforeEach
    public void setUp() {
        // Initialiser les objets utilisés dans les tests
        m1 = new Moniteur("AFGF", "Bob", "Robert", "quelque part", "3630", LocalDate.of(2006, 6, 6), 3, 456, GroupeSanguin.BPLUS);
        c1 = new Club(m1, "Sous l'ocean", "777");
        p = new Plongeur("FG", "Bastide", "Rémi", "dans une maison", "112", LocalDate.of(1800, 4, 25), 0, GroupeSanguin.AMOINS);
        l1 = new Licence(p,"7824", LocalDate.of(2020,12,31), c1);
        s1= new Site("La cage aux cachalots", "Grotte sous-marine assez spacieuse pour loger un cachalot");
        m1.ajouteLicence("7824", LocalDate.of(2020,12,31), c1);
        pl1= new Plongee (s1, m1, LocalDate.of(2021,01,01), 5000, 30);
        pl2= new Plongee (s1, m1, LocalDate.of(2021,01,02), 5000, 30);


    }
    
    @Test
    public void TestPlongeeConforme(){
        l2=new Licence(p,"8456", LocalDate.of(2020,12,31), c1);
        pl1.ajouteParticipant(l2);
        pl2.ajouteParticipant(l2);
        c1.organisePlongee(pl1);
        c1.organisePlongee(pl2);
        assertTrue(c1.plongeesNonConformes().isEmpty(), "Toutes les plongées sont censées être conformes");
    }
    
    public void TestPlongeeNonConforme(){
        l2=new Licence(p,"8456", LocalDate.of(2022,12,31), c1);
        pl1.ajouteParticipant(l2);
        // l2 non valide
        pl2.ajouteParticipant(l2);
        c1.organisePlongee(pl1);
        c1.organisePlongee(pl2);
        Set<Plongee> pltest;
        pltest = new HashSet<>();
        pltest.add(pl2);
        pltest.add(pl1);
        assertEquals(pltest, c1.plongeesNonConformes(), "Les plongées ne sont pas censés être conformes");
    }
    
}
