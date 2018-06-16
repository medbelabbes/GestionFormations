package dao.idao;

import dao.IGenericDAO;
import entities.KeyNote;
import entities.NoteEtudiant;

import javax.ejb.Remote;

@Remote
public interface INoteEtudiantDAO  extends IGenericDAO<NoteEtudiant> {
}
