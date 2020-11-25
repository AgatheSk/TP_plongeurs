package FFSSM;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Plongeur extends Personne {

    int niveau;
    public List<Licence> licences;
    GroupeSanguin groupe;

    public Plongeur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, LocalDate naissance, int niveau, GroupeSanguin g) {
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance);
        this.niveau = niveau;
        this.licences = new ArrayList<>(); 
        this.groupe=g;
    }
    

    public void ajouteLicence(String numero, LocalDate delivrance, Club club) {
        this.licences.add(new Licence(this, numero, delivrance, club));
    }

}
