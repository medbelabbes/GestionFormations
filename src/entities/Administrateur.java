package entities;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
public class Administrateur implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAdmin;

    @NotNull
    @Size(min = 3, max = 25)
    private String nom;

    @NotNull
    @Size(min = 3, max = 25)
    private String prenom;

    @NotNull
    @Size(min = 5, max = 25)
    private String username;

    @NotNull
    @Email
    @Size(min = 5, max = 25)
    private String email;

    @NotNull
    @Size(min = 5, max = 25)
    private String telephone;

    @NotNull
    @Size(min = 8, max = 25)
    private String password;


    @Embedded
    private Adresse adresse;

    @OneToOne
    @JoinColumn(name="idCentre")
    private Centre centre;



    public Administrateur() {
    }

    public Administrateur(@NotNull @Size(min = 3, max = 25) String nom, @NotNull @Size(min = 3, max = 25) String prenom, @NotNull @Size(min = 5, max = 25) String username, @NotNull @Size(min = 5, max = 25) String email, @NotNull @Size(min = 5, max = 25) String telephone, @NotNull @Size(min = 8, max = 25) String password, Adresse adresse, Centre centre) {
        this.nom = nom;
        this.prenom = prenom;
        this.username = username;
        this.email = email;
        this.telephone = telephone;
        this.password = password;
        this.adresse = adresse;
        this.centre = centre;
    }

    public Administrateur(@NotNull @Size(min = 3, max = 25) String nom, @NotNull @Size(min = 3, max = 25) String prenom, @NotNull @Size(min = 5, max = 25) String username, @NotNull @Size(min = 5, max = 25) String email, @NotNull @Size(min = 5, max = 25) String telephone, @NotNull @Size(min = 8, max = 25) String password, Adresse adresse) {
        this.nom = nom;
        this.prenom = prenom;
        this.username = username;
        this.email = email;
        this.telephone = telephone;
        this.password = password;
        this.adresse = adresse;
    }

    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
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

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public Centre getCentre() {
        return centre;
    }

    public void setCentre(Centre centre) {
        this.centre = centre;
    }
}
