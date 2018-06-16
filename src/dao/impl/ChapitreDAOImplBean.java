package dao.impl;

import dao.GenericFacade;
import dao.idao.IChapitreDAO;
import dao.idao.IChapitreDAOLocal;
import entities.Chapitre;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Stateful(name = "ChapitreDAOImplEJB")
public class ChapitreDAOImplBean extends GenericFacade<Chapitre> implements IChapitreDAO, IChapitreDAOLocal {
    @PersistenceContext(unitName = "TrainingManager2")
    EntityManager em;

    @Override
    public List<Chapitre> findChapitresByFormation(int idFormation) {
        Query query = em.createQuery("SELECT c FROM Chapitre c WHERE c.formation.idFormation=:idFormation");
        query.setParameter("idFormation", idFormation);
        List<Chapitre> lesChapitres = query.getResultList();
        return lesChapitres;
    }
}
