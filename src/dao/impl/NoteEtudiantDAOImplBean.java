package dao.impl;

import dao.GenericFacade;
import dao.idao.INoteEtudiantDAO;
import dao.idao.INoteEtudiantDAOLocal;
import entities.NoteEtudiant;

import javax.ejb.Stateless;

@Stateless(name = "NoteEtudiantDAOImplEJB")
public class NoteEtudiantDAOImplBean extends GenericFacade<NoteEtudiant> implements INoteEtudiantDAO, INoteEtudiantDAOLocal {

}
