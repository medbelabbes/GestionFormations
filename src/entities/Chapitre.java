package entities;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

@Entity
public class Chapitre implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idChapitre;

    @NotNull
    @Future
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date dateChapitre;

    @NotNull
    @Size(min = 3, max = 25)
    private String nomChapitre;

    @NotNull
    private String tempsDebut;


    @NotNull
    private String tempsFin;

    @ManyToOne
    @JoinColumn(name = "idFormation")
    private Formation formation;

    @OneToOne(mappedBy = "chapitre", cascade = CascadeType.REMOVE,orphanRemoval = true)
    private Examen examen;


    public Chapitre() {
    }

    public Chapitre(@NotNull @Future Date dateChapitre, @NotNull @Size(min = 3, max = 25) String nomChapitre, @NotNull String tempsDebut, @NotNull String tempsFin, Formation formation, Examen examen) {
        this.dateChapitre = dateChapitre;
        this.nomChapitre = nomChapitre;
        this.tempsDebut = tempsDebut;
        this.tempsFin = tempsFin;
        this.formation = formation;
        this.examen = examen;
    }

    public int getIdChapitre() {
        return idChapitre;
    }

    public void setIdChapitre(int idChapitre) {
        this.idChapitre = idChapitre;
    }

    public Date getDateChapitre() {
        return dateChapitre;
    }

    public void setDateChapitre(Date dateChapitre) {
        this.dateChapitre = dateChapitre;
    }

    public String getNomChapitre() {
        return nomChapitre;
    }

    public void setNomChapitre(String nomChapitre) {
        this.nomChapitre = nomChapitre;
    }

    public String getTempsDebut() {
        return tempsDebut;
    }

    public void setTempsDebut(String tempsDebut) {
        this.tempsDebut = tempsDebut;
    }

    public String getTempsFin() {
        return tempsFin;
    }

    public void setTempsFin(String tempsFin) {
        this.tempsFin = tempsFin;
    }

    public Formation getFormation() {
        return formation;
    }

    public void setFormation(Formation formation) {
        this.formation = formation;
    }

    public Examen getExamen() {
        return examen;
    }

    public void setExamen(Examen examen) {
        this.examen = examen;
    }
}

