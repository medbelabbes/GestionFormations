

import entities.Adresse;
import entities.Etudiant;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Teste {

    public static void main(String... args) {


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrainingManager");
        EntityManager em = emf.createEntityManager();
//
//        try {
//            em.getTransaction().begin();
//            Etudiant e = new Etudiant();
//            e.setNom("Belabbes");
//            e.setPrenom("Mohammed");
//            e.setPassword("123123123");
//            e.setUsername("mohpixou95");
//            e.setAge(23);
//            e.setEmail("moh7@live.be");
//            e.setUsername("mohpixou");
//            e.setTelephone("0659298985");
//            e.setLieuNaissance("Rahouia");
//            Adresse adresse = new Adresse();
//            adresse.setCodePostale(14005);
//            adresse.setNuemro(3);
//            adresse.setRue("Boukhetache Bouziane");
//            adresse.setVille("Rahouia");
//            e.setAdresse(adresse);
//
//            Set<String> telephones = new HashSet<>();
//            telephones.add("06597298985");
//            telephones.add("07917074161");
//            telephones.add("06587579848");
//            e.setTelephone(telephones);
//            em.persist(e);
//            em.getTransaction().commit();
//        } catch (Exception e) {
//            System.out.println(e);
//        }


    }

}
