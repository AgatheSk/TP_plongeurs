/**
 * @(#) LicencePlongeur.java
 */
package FFSSM;

import java.time.LocalDate;

public class Licence {

    public Personne possesseur;

    public String numero;

    public LocalDate delivrance;

    public Club club;

    public Licence(Personne possesseur, String numero, LocalDate delivrance, Club club) {
        this.possesseur = possesseur;
        this.setNumero(numero);
        this.delivrance = delivrance;
        this.club = club;
    }

    public void setNumero(String numero) {
        if (null == numero) {
            throw new IllegalArgumentException("numero is null");
        }
        this.numero = numero;
    }

    public Personne getPossesseur() {
        return possesseur;
    }

    public String getNumero() {
        return numero;
    }

    public LocalDate getDelivrance() {
        return delivrance;
    }

    public Club getClub() {
        return club;
    }

    /**
     * Est-ce que la licence est valide à la date indiquée ? Une licence est
     * valide pendant un an à compter de sa date de délivrance
     *
     * @param d la date à tester
     * @return vrai si valide à la date d
     *
     */
    public boolean estValide(LocalDate d) {
        // si la date de delivrance + 1 ans est supérieure ou égale à la date de plongée 
        return this.delivrance.plusYears(1).isEqual(d) || this.delivrance.plusYears(1).isAfter(d);
    }

    /**
     * On vérifie si les licences sont égales à partir de leurs numéros On
     * redéfinit la méthode equals de la classe Objet
     *
     * @param l
     * @return si les licences sont égales
     */
    @Override
    public boolean equals(Object l) {
        if (l != null && l.getClass().equals(Licence.class)) {
            Licence l1 = (Licence) l;
            return this.numero.equals(l1.numero);
        } else {
            return false;
        }
    }

}
