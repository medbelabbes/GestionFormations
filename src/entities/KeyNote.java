package entities;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class KeyNote implements Serializable {

    @ManyToOne
    @JoinColumn(name="idEtudiant")
    private Etudiant etudiant;


    @ManyToOne
    @JoinColumn(name="idExmaen")
    private Examen examen;

    public KeyNote() {
    }

    public KeyNote(Etudiant etudiant, Examen examen) {
        this.etudiant = etudiant;
        this.examen = examen;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public Examen getExamen() {
        return examen;
    }

    public void setExamen(Examen examen) {
        this.examen = examen;
    }
}
