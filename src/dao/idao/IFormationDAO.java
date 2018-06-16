package dao.idao;

import dao.IGenericDAO;
import entities.Etudiant;
import entities.Formation;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface IFormationDAO extends IGenericDAO<Formation> {
    String getFormationName(int idFormation);
    List<Etudiant> getEtudiants(int idFormation);

}
