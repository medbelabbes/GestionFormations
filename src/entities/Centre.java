package entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Centre implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCentre;

    @NotNull
    @Size(min = 3, max = 25)
    private String designation;

    @NotNull
    @Size(min = 3, max = 45)
    private String Domaine;


    @Embedded
    private Adresse adresse;

    @Embedded
    private Localisation localisation;

    @OneToOne(mappedBy = "centre",cascade = CascadeType.REMOVE)
    private Administrateur administrateur;

    @OneToMany(mappedBy = "centre", cascade = CascadeType.REMOVE,orphanRemoval = true)
    private Set<Formation> Lesformations = new HashSet<>();

    public Centre() {
    }

    public Centre(@NotNull @Size(min = 3, max = 25) String designation, @NotNull @Size(min = 3, max = 45) String domaine, Adresse adresse, Localisation localisation, Administrateur administrateur, Set<Formation> lesformations) {
        this.designation = designation;
        Domaine = domaine;
        this.adresse = adresse;
        this.localisation = localisation;
        this.administrateur = administrateur;
        Lesformations = lesformations;
    }

    public Centre(@NotNull @Size(min = 3, max = 25) String designation, @NotNull @Size(min = 3, max = 45) String domaine, Adresse adresse, Localisation localisation, Administrateur administrateur) {
        this.designation = designation;
        Domaine = domaine;
        this.adresse = adresse;
        this.localisation = localisation;
        this.administrateur = administrateur;
    }

    public int getIdCentre() {
        return idCentre;
    }

    public void setIdCentre(int idCentre) {
        this.idCentre = idCentre;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDomaine() {
        return Domaine;
    }

    public void setDomaine(String domaine) {
        Domaine = domaine;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public Localisation getLocalisation() {
        return localisation;
    }

    public void setLocalisation(Localisation localisation) {
        this.localisation = localisation;
    }

    public Administrateur getAdministrateur() {
        return administrateur;
    }

    public void setAdministrateur(Administrateur administrateur) {
        this.administrateur = administrateur;
    }

    public Set<Formation> getLesformations() {
        return Lesformations;
    }

    public void setLesformations(Set<Formation> lesformations) {
        Lesformations = lesformations;
    }
}