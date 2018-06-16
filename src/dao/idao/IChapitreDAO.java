package dao.idao;

import dao.IGenericDAO;
import entities.Chapitre;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface IChapitreDAO extends IGenericDAO<Chapitre> {
    List<Chapitre> findChapitresByFormation(int idFormation);
}
