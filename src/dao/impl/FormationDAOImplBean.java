package dao.impl;

import dao.GenericFacade;
import dao.idao.IFormationDAO;
import dao.idao.IFormationDAOLocal;
import entities.Etudiant;
import entities.Formation;

import javax.ejb.Stateless;
import javax.persistence.Query;
import java.util.List;

@Stateless(name = "FormationDAOImplEJB")
public class FormationDAOImplBean extends GenericFacade<Formation> implements IFormationDAO, IFormationDAOLocal {
    @Override
    public String getFormationName(int idFormation) {
        Query query = em.createQuery("SELECT f.nom FROM Formation f where f.idFormation =: idFormation");
        query.setParameter("idFormation", idFormation);
        String name = (String) query.getSingleResult();
        return name;
    }

    @Override
    public List<Etudiant> getEtudiants(int idFormation) {
        Query query = em.createQuery("SELECT f.lesEtudiants FROM Formation f where f.idFormation =: idFormation");
        query.setParameter("idFormation", idFormation);
        return (List<Etudiant>) query.getResultList();

    }
//    @PersistenceContext(unitName = "TrainingManager2")
//    EntityManager em;

}
