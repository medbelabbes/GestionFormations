package dao.impl;

import dao.GenericFacade;
import dao.idao.IKeyNoteDAO;
import dao.idao.IKeyNoteDAOLocal;
import entities.KeyNote;

import javax.ejb.Stateless;

@Stateless(name = "KeyNoteDAOImplEJB")
public class KeyNoteDAOImplBean   extends GenericFacade<KeyNote> implements IKeyNoteDAO, IKeyNoteDAOLocal {

}
