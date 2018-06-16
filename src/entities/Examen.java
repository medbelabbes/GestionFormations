package entities;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
public class Examen implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idExamen;

    @NotNull
    @Size(min = 3, max = 25)
    private String nomExamen;

    @NotNull
    private float noteSur;


    @NotNull
    @Future
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;

    @NotNull
    private String tempsDebutExamen;


    @NotNull
    private String tempsFinExamen;

    @OneToOne
    @JoinColumn(name = "idChapitre")
    private Chapitre chapitre;

    @OneToMany(mappedBy = "idNote.examen")
    private Set<NoteEtudiant> LesNotes;

    public Examen() {
    }

    public Examen(@NotNull @Size(min = 3, max = 25) String nomExamen, @NotNull float noteSur, @NotNull @Future Date date, @NotNull String tempsDebutExamen, @NotNull String tempsFinExamen, Chapitre chapitre, Set<NoteEtudiant> lesNotes) {
        this.nomExamen = nomExamen;
        this.noteSur = noteSur;
        this.date = date;
        this.tempsDebutExamen = tempsDebutExamen;
        this.tempsFinExamen = tempsFinExamen;
        this.chapitre = chapitre;
        LesNotes = lesNotes;
    }

    public int getIdExamen() {
        return idExamen;
    }

    public void setIdExamen(int idExamen) {
        this.idExamen = idExamen;
    }

    public String getNomExamen() {
        return nomExamen;
    }

    public void setNomExamen(String nomExamen) {
        this.nomExamen = nomExamen;
    }

    public float getNoteSur() {
        return noteSur;
    }

    public void setNoteSur(float noteSur) {
        this.noteSur = noteSur;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTempsDebutExamen() {
        return tempsDebutExamen;
    }

    public void setTempsDebutExamen(String tempsDebutExamen) {
        this.tempsDebutExamen = tempsDebutExamen;
    }

    public String getTempsFinExamen() {
        return tempsFinExamen;
    }

    public void setTempsFinExamen(String tempsFinExamen) {
        this.tempsFinExamen = tempsFinExamen;
    }

    public Chapitre getChapitre() {
        return chapitre;
    }

    public void setChapitre(Chapitre chapitre) {
        this.chapitre = chapitre;
    }

    public Set<NoteEtudiant> getLesNotes() {
        return LesNotes;
    }

    public void setLesNotes(Set<NoteEtudiant> lesNotes) {
        LesNotes = lesNotes;
    }
}