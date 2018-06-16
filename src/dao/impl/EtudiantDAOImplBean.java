package dao.impl;

import dao.GenericFacade;
import dao.idao.IEtudiantDAO;
import dao.idao.IEtudiantDAOLocal;
import entities.Etudiant;
import entities.Formation;

import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.Query;
import java.util.List;


@Stateless(name = "EtudiantDAOImplEJB")
public class EtudiantDAOImplBean extends GenericFacade<Etudiant> implements IEtudiantDAO, IEtudiantDAOLocal {

    private Etudiant etudiant = new Etudiant();

    @Override
    public boolean login(String username, String password) {
        boolean valide = false;

        try {
            Query query = em.createQuery("SELECT e FROM Etudiant e where e.username =: username and e.password =: password");
            query.setParameter("username", username);
            query.setParameter("password", password);
            Etudiant e = (Etudiant) query.getSingleResult();
            if (e.getUsername() != null && e.getPassword() != null) {
                etudiant = e;
                valide = true;

            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return valide;
    }

    @Override
    public Etudiant currentEtudiant() {
        return etudiant;
    }

    @Override
    public List<Formation> getFormations(int idEtudiant) {
        Query query = em.createQuery("SELECT e.lesFormations FROM Etudiant e where e.idEtudiant =: idEtudiant");
        query.setParameter("idEtudiant", idEtudiant);
        return (List<Formation>) query.getResultList();
    }


}
