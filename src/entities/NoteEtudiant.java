package entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class NoteEtudiant implements Serializable {
    @EmbeddedId
    private KeyNote idNote;

    private float note;


    public NoteEtudiant() {
    }

    public NoteEtudiant(KeyNote idNote, float note) {
        this.idNote = idNote;
        this.note = note;
    }

    public KeyNote getIdNote() {
        return idNote;
    }

    public void setIdNote(KeyNote idNote) {
        this.idNote = idNote;
    }

    public float getNote() {
        return note;
    }

    public void setNote(float note) {
        this.note = note;
    }
}
