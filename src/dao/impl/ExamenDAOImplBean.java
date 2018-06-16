package dao.impl;

import dao.GenericFacade;
import dao.idao.IExamenDAO;
import dao.idao.IExamenDAOLocal;
import entities.Chapitre;
import entities.Examen;

import javax.ejb.Stateless;
import javax.persistence.Query;
import java.util.List;

@Stateless(name = "ExamenDAOImplEJB")
public class ExamenDAOImplBean extends GenericFacade<Examen> implements IExamenDAO, IExamenDAOLocal {

    @Override
    public List<Examen> findExmaneByChapitre(int idChapitre) {
        Query query = em.createQuery("SELECT e FROM Examen e WHERE e.chapitre.idChapitre=:idChapitre");
        query.setParameter("idChapitre", idChapitre);
        return (List<Examen>) query.getResultList();
    }

    @Override
    public List<String> findNameExamenByFormation(int idFormation) {
        Query query = em.createQuery("SELECT e.nomExamen FROM Examen e,Chapitre c WHERE e.chapitre.idChapitre = c.idChapitre and c.formation.idFormation =: idFormation");
        query.setParameter("idFormation", idFormation);
        return (List<String>) query.getResultList();
    }

    @Override
    public int findIdByName(String nameExamen) {
        Query query = em.createQuery("Select e.idExamen from Examen e where e.nomExamen =: nameExamen");
        query.setParameter("nameExamen", nameExamen);
        return (Integer) query.getSingleResult();
    }
}
