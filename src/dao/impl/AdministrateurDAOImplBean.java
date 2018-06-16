package dao.impl;

import dao.GenericFacade;
import dao.idao.IAdministrateurDAO;
import dao.idao.IAdministrateurDAOLocal;
import entities.Administrateur;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateful(name = "AdministrateurDAOImplEJB")
public class AdministrateurDAOImplBean extends GenericFacade<Administrateur> implements IAdministrateurDAO, IAdministrateurDAOLocal {
    @PersistenceContext(unitName = "TrainingManager2")
    EntityManager em;

    public Administrateur admin;

    @Override
    public boolean login(String username, String password) {
        boolean valide = false;

        try {
            Query query = em.createQuery("SELECT a FROM Administrateur a where a.username =: username and a.password =: password");
            query.setParameter("username", username);
            query.setParameter("password", password);
            admin = (Administrateur) query.getSingleResult();
            if (admin.getUsername() != null && admin.getPassword() != null) {
                valide = true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return valide;
    }

    @Override
    public Administrateur currentAdmin() {
        return admin;
    }
}
