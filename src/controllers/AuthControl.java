package controllers;

import dao.idao.IAdministrateurDAO;
import dao.idao.IEtudiantDAO;
import dao.impl.AdministrateurDAOImplBean;
import dao.impl.EtudiantDAOImplBean;
import entities.Administrateur;
import entities.Adresse;
import entities.Etudiant;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Named
@SessionScoped
public class AuthControl implements Serializable {

    private String type;
    List<String> TypeCompte = new ArrayList<>();

    //Student attribut
    private int idEtudiant;
    private String nomEtudiant;
    private String prenomEtudiant;

    private String phone;
    private String LieuNaissance;
    private boolean usernameerror;
    private Date dateNaissance;
    private String rue;
    private int numero;
    private int codepost;
    private String ville;
    private Etudiant etudiant;


    //Admin Attributs

    private Administrateur administrateur;

    private int idAdmin;
    private String nom;
    private String prenom;
    private String telephone;


    //Common attributs
    private String username;
    private String email;
    private String password;
    private String confirmpassword;
    private Adresse adresse;


    @EJB
    private IEtudiantDAO Ee;
    @EJB
    private IAdministrateurDAO Ea;

    public List<String> gettingTypeCompte() {
        TypeCompte.clear();
        TypeCompte.add("Administrateur");
        TypeCompte.add("Etudiant");


        return TypeCompte;
    }

    @PostConstruct
    public void initializeType(){
        this.type="Administrateur";
    }


    //validate login
    public String validateUsernamePassword() {
        String x = "loginPage.xhtml?faces-redirect=true";
        boolean valid = false;
        if (type.equals("Etudiant")) {
            valid = Ee.login(username, password);
            if (valid) {
                usernameerror = valid;
                this.etudiant = Ee.currentEtudiant();
                x = "views/etudiant/formation/formations.xhtml?faces-redirect=true";
            }

        } else if (type.equals("Administrateur")) {
            valid = Ea.login(username, password);
            if (valid) {
                usernameerror = valid;
                administrateur = Ea.currentAdmin();
                x = "views/administrateur/formation/index.xhtml?faces-redirect=true";

            }
        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Incorrect Username and Passowrd",
                            "Please enter correct username and Password"));


        }

        return x;
    }

    public String subscribeStudent() {
        initializeType();
        Etudiant e = new Etudiant();
        e.setNomEtudiant(nomEtudiant);
        e.setPrenomEtudiant(prenomEtudiant);
        e.setEmail(email);
        e.setTelephone(phone);
        e.setUsername(username);
        e.setPassword(password);
        e.setLieuNaissance(LieuNaissance);
        e.setDateNaissance(dateNaissance);
        Adresse adresse = new Adresse();
        adresse.setNuemro(numero);
        adresse.setRue(rue);
        adresse.setCodePostale(codepost);
        adresse.setVille(ville);
        e.setAdresse(adresse);
        if (password.equals(confirmpassword)) {
            Ee.create(e);
        }
        return "loginPage.xhtml?faces-redirect=true";
    }


    public String subscribeAdmin() {
        initializeType();
        Administrateur a = new Administrateur();
        a.setNom(nom);
        a.setPrenom(prenom);
        a.setTelephone(telephone);
        a.setEmail(email);
        a.setPassword(password);
        a.setUsername(username);
        Adresse adresse = new Adresse();
        adresse.setNuemro(numero);
        adresse.setRue(rue);
        adresse.setCodePostale(codepost);
        adresse.setVille(ville);
        a.setAdresse(adresse);
        if (password.equals(confirmpassword)) {
            Ea.create(a);
        }
        return "loginPage.xhtml?faces-redirect=true";
    }


    //logout event, invalidate session
    public String logout() {
        return "login";
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public IEtudiantDAO getEe() {
        return Ee;
    }

    public void setEe(IEtudiantDAO ee) {
        Ee = ee;
    }

    public IAdministrateurDAO getEa() {
        return Ea;
    }

    public void setEa(IAdministrateurDAO ea) {
        Ea = ea;
    }

    public List<String> getTypeCompte() {
        return TypeCompte;
    }

    public void setTypeCompte(List<String> typeCompte) {
        TypeCompte = typeCompte;
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

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLieuNaissance() {
        return LieuNaissance;
    }

    public void setLieuNaissance(String lieuNaissance) {
        LieuNaissance = lieuNaissance;
    }

    public boolean isUsernameerror() {
        return usernameerror;
    }

    public void setUsernameerror(boolean usernameerror) {
        this.usernameerror = usernameerror;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public Administrateur getAdministrateur() {
        return administrateur;
    }

    public void setAdministrateur(Administrateur administrateur) {
        this.administrateur = administrateur;
    }

    public String getConfirmpassword() {
        return confirmpassword;
    }

    public void setConfirmpassword(String confirmpassword) {
        this.confirmpassword = confirmpassword;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCodepost() {
        return codepost;
    }

    public void setCodepost(int codepost) {
        this.codepost = codepost;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
