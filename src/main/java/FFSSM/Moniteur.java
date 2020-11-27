/**
 * @(#) Moniteur.java
 */
package FFSSM;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class Moniteur extends Plongeur {

    public int numeroDiplome;

    private LinkedList<Embauche> employeurs = new LinkedList<>();

    /**
     *
     * @param numeroINSEE
     * @param nom
     * @param prenom
     * @param adresse
     * @param telephone
     * @param naissance
     * @param niveau
     * @param numeroDiplome
     * @param groupe
     */
    public Moniteur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, LocalDate naissance, int niveau, int numeroDiplome, GroupeSanguin groupe) {
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance, niveau, groupe);
        this.numeroDiplome = numeroDiplome;
    }

    /**
     * Si ce moniteur n'a pas d'embauche, ou si sa dernière embauche est
     * terminée, ce moniteur n'a pas d'employeur.
     *
     * @return l'employeur actuel de ce moniteur sous la forme d'un Optional
     */
    public Optional<Club> employeurActuel() {
        System.out.println("Taille : " + this.employeurs.size());
        if (this.employeurs.isEmpty() || this.employeurs.peekLast().estTerminee()) {
            return Optional.empty();
        }
        return Optional.of(this.employeurs.peekLast().getEmployeur());
    }

    /**
     * Enregistrer une nouvelle embauche pour cet employeur
     *
     * @param employeur le club employeur
     * @param debutNouvelle la date de début de l'embauche
     */
    public void nouvelleEmbauche(Club employeur, LocalDate debutNouvelle) {
        this.employeurs.add(new Embauche(debutNouvelle, this, employeur));
    }

    public List<Embauche> emplois() {
        return this.employeurs;
    }

    public void terminerEmbauche(LocalDate fin) {
        if (this.employeurActuel().isEmpty()) {

            throw new IllegalArgumentException(this.nom + " " + this.prenom + " n'est pas employé.");

        } else {
            this.employeurs.peekLast().terminer(fin);

        }
    }

    public int getNumeroDiplome() {
        return numeroDiplome;
    }

    public LinkedList<Embauche> getEmployeurs() {
        return employeurs;
    }

}
