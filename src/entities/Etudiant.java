package entities;


import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
public class Etudiant implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEtudiant;

    @NotNull
    @Size(min = 3, max = 25)
    private String nomEtudiant;

    @NotNull
    @Size(min = 3, max = 25)
    private String prenomEtudiant;

    @NotNull
    @Size(min = 5, max = 25)
    private String username;

    @Email
    @NotNull
    @Size(min = 5, max = 25)
    private String email;

    @NotNull
    @Size(min = 5, max = 25)
    private String telephone;


    @NotNull
    @Size(min = 8, max = 25)
    private String password;


    @NotNull
    @Past
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;

    @Transient
    private Integer age;

    @NotNull
    @Size(min = 3, max = 45)
    private String lieuNaissance;


    @Embedded
    private Adresse adresse;


    @ManyToMany(mappedBy = "lesEtudiants")
    private List<Formation> lesFormations;

    @OneToMany(mappedBy = "idNote.etudiant")
    private Set<NoteEtudiant> LesNotes;

    public Etudiant() {
    }

    public Etudiant(@NotNull @Size(min = 3, max = 25) String nom, @NotNull @Size(min = 3, max = 25) String prenom, @NotNull @Size(min = 5, max = 25) String username, @Email @NotNull @Size(min = 5, max = 25) String email, @NotNull @Size(min = 5, max = 25) String telephone, @NotNull @Size(min = 8, max = 25) String password, @Null @Past Date dateNaissance, Integer age, @NotNull @Size(min = 3, max = 45) String lieuNaissance, Adresse adresse, List<Formation> lesFormations, Set<NoteEtudiant> lesNotes) {
        this.nomEtudiant = nom;
        this.prenomEtudiant = prenom;
        this.username = username;
        this.email = email;
        this.telephone = telephone;
        this.password = password;
        this.dateNaissance = dateNaissance;
        this.age = age;
        this.lieuNaissance = lieuNaissance;
        this.adresse = adresse;
        this.lesFormations = lesFormations;
        LesNotes = lesNotes;
    }

    public int getIdEtudiant() {
        return idEtudiant;
    }

    public void setIdEtudiant(int idEtudiant) {
        this.idEtudiant = idEtudiant;
    }

    public String getNomEtudiant() {
        return nomEtudiant;
    }

    public void setNomEtudiant(String nomEtudiant) {
        this.nomEtudiant = nomEtudiant;
    }

    public String getPrenomEtudiant() {
        return prenomEtudiant;
    }

    public void setPrenomEtudiant(String prenomEtudiant) {
        this.prenomEtudiant = prenomEtudiant;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getLieuNaissance() {
        return lieuNaissance;
    }

    public void setLieuNaissance(String lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public List<Formation> getLesFormations() {
        return lesFormations;
    }

    public void setLesFormations(List<Formation> lesFormations) {
        this.lesFormations = lesFormations;
    }

    public Set<NoteEtudiant> getLesNotes() {
        return LesNotes;
    }

    public void setLesNotes(Set<NoteEtudiant> lesNotes) {
        LesNotes = lesNotes;
    }
}



