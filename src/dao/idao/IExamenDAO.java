package dao.idao;

import dao.IGenericDAO;
import entities.Chapitre;
import entities.Examen;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface IExamenDAO extends IGenericDAO<Examen> {
    List<Examen> findExmaneByChapitre(int idChapitre);
    List<String> findNameExamenByFormation(int idFormation);
    int findIdByName(String nameExamen);

}
