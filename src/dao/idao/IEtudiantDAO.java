package dao.idao;

import dao.IGenericDAO;
import entities.Etudiant;
import entities.Formation;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface IEtudiantDAO extends IGenericDAO<Etudiant> {
     boolean login(String username, String password);
     Etudiant currentEtudiant();
     List<Formation> getFormations(int idEtudiant);

}
