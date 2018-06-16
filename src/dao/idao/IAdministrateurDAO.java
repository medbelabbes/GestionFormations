package dao.idao;

import dao.IGenericDAO;
import entities.Administrateur;

import javax.ejb.Remote;

@Remote
public interface IAdministrateurDAO extends IGenericDAO<Administrateur> {
    boolean login(String username, String password);
    Administrateur currentAdmin();
}
