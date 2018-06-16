package entities;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Formation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFormation;

    @NotNull
    @Size(min = 3, max = 25)
    private String nom;

    @NotNull
    @Future
    @Column(name = "date_debut")
    @Temporal(TemporalType.DATE)
    private Date dateDebut;

    @NotNull
    @Future
    @Column(name = "date_fin")
    @Temporal(TemporalType.DATE)
    private Date dateFin;

    @NotNull
    private float prix;

    @NotNull
    private String Niveau;


    @OneToMany(mappedBy = "formation", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Set<Chapitre> lesChapitres = new HashSet<>();


    @ManyToMany
    @JoinTable(name = "inscrire_avoir",
            joinColumns = @JoinColumn(name = "idFormation"),
            inverseJoinColumns = @JoinColumn(name = "idEtudiant"))
    private List<Etudiant> lesEtudiants;


    @ManyToOne
    @JoinColumn(name = "idCentre")
    private Centre centre;

    public Formation() {
    }

    public Formation(@NotNull @Size(min = 3, max = 25) String nom, @NotNull @Future Date dateDebut, @NotNull @Future Date dateFin, @NotNull float prix, @NotNull String niveau, Set<Chapitre> lesChapitres, List<Etudiant> lesEtudiants, Centre centre) {
        this.nom = nom;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.prix = prix;
        Niveau = niveau;
        this.lesChapitres = lesChapitres;
        this.lesEtudiants = lesEtudiants;
        this.centre = centre;
    }

    public int getIdFormation() {
        return idFormation;
    }

    public void setIdFormation(int idFormation) {
        this.idFormation = idFormation;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getNiveau() {
        return Niveau;
    }

    public void setNiveau(String niveau) {
        Niveau = niveau;
    }


    public Set<Chapitre> getLesChapitres() {
        return lesChapitres;
    }

    public void setLesChapitres(Set<Chapitre> lesChapitres) {
        this.lesChapitres = lesChapitres;
    }

    public List<Etudiant> getLesEtudiants() {
        return lesEtudiants;
    }

    public void setLesEtudiants(List<Etudiant> lesEtudiants) {
        this.lesEtudiants = lesEtudiants;
    }

    public Centre getCentre() {
        return centre;
    }

    public void setCentre(Centre centre) {
        this.centre = centre;
    }
}