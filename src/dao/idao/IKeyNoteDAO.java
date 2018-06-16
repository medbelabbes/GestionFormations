package dao.idao;

import dao.IGenericDAO;
import entities.Formation;
import entities.KeyNote;

import javax.ejb.Remote;

@Remote
public interface IKeyNoteDAO extends IGenericDAO<KeyNote> {
}
