package controllers;

import dao.idao.IChapitreDAOLocal;
import dao.idao.IEtudiantDAO;
import dao.idao.IExamenDAO;
import dao.idao.IFormationDAOLocal;
import entities.*;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Named
@SessionScoped
public class EtudiantControl implements Serializable {

    // Student attributs
    private List<Etudiant> lesEtudiants = new ArrayList<>();
    private int idEtudiant;
    private String nomEtudiant;
    private String prenomEtudiant;
    private String email;
    private String phone;
    private String username;
    private Date dateNaissance;
    private String password;
    private String confirmpassword;
    private String LieuNaissance;
    private Adresse adresse;
    private String rue;
    private int numero;
    private int codepost;
    private String ville;
    private Etudiant etudiant;

    @EJB
    private IEtudiantDAO Ee;


    //Formations attributs
    private List<Formation> lesFormations = new ArrayList<>();
    private String nom;
    private Date date_debut;
    private Date date_fin;
    private String niveau;
    private float prix;
    private int idFormation;
    private Formation formation = new Formation();
    private int formationnum;
    @EJB
    private IFormationDAOLocal Ef;


    //Chapters attributs

    private List<Chapitre> lesChapitres = new ArrayList<>();
    private String tempsDebut;
    private String tempsFin;
    private int idChapitre;
    private Date dateChapitre;
    private String nomChapitre;
    private Chapitre chapitre;
    @EJB
    private IChapitreDAOLocal Ec;

    //Examen attributs

    private List<Examen> lesExamens = new ArrayList<>();
    private String nomExamen;
    private float noteSur;
    private Date date;
    private String tempsDebutExamen;
    private String tempsFinExamen;
    private int idExamen;

    @EJB
    private IExamenDAO Eex;


    @PostConstruct
    public void getFormations() {
        etudiant = Ee.currentEtudiant();
        lesFormations = Ef.findAll();
    }


    public String goToFormation() {

        getFormations();
        return "/views/etudiant/formation/formations.xhtml?faces-redirect=true";
    }

    public String inscrireEtudiant(int idEtudiant, int idFormation) {
        getFormations();
        Etudiant e = Ee.find(idEtudiant);
        Formation f = Ef.find(idFormation);
        List<Etudiant> etudiants = new ArrayList<>();
        List<Formation> formations = new ArrayList<>();
        etudiants.add(e);
        formations.add(f);
        e.setLesFormations(formations);
        f.setLesEtudiants(etudiants);
        Ee.edit(e);
        Ef.edit(f);

        return "/views/etudiant/formation/formations.xhtml?faces-redirect=true";
    }

    public String getMesFormations(int idEtudiant) {
        getFormations();
        lesFormations = Ee.getFormations(idEtudiant);
        return "mesformations.xhtml?faces-redirect=true";
    }

    public String voirChapitre(int idFormation) {
        getFormations();
        lesChapitres = Ec.findChapitresByFormation(idFormation);
        return "/views/etudiant/chapitre/chapitres.xhtml";
    }

    public String getDataExamen(int idChapitre) {
        getFormations();
        lesExamens = Eex.findExmaneByChapitre(idChapitre);
        return "/views/etudiant/examen/examens.xhtml";
    }


    public List<Etudiant> getLesEtudiants() {
        return lesEtudiants;
    }

    public void setLesEtudiants(List<Etudiant> lesEtudiants) {
        this.lesEtudiants = lesEtudiants;
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

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
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

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public IEtudiantDAO getEe() {
        return Ee;
    }

    public void setEe(IEtudiantDAO ee) {
        Ee = ee;
    }

    public List<Formation> getLesFormations() {
        return lesFormations;
    }

    public void setLesFormations(List<Formation> lesFormations) {
        this.lesFormations = lesFormations;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public int getIdFormation() {
        return idFormation;
    }

    public void setIdFormation(int idFormation) {
        this.idFormation = idFormation;
    }

    public Formation getFormation() {
        return formation;
    }

    public void setFormation(Formation formation) {
        this.formation = formation;
    }

    public int getFormationnum() {
        return formationnum;
    }

    public void setFormationnum(int formationnum) {
        this.formationnum = formationnum;
    }

    public IFormationDAOLocal getEf() {
        return Ef;
    }

    public void setEf(IFormationDAOLocal ef) {
        Ef = ef;
    }

    public List<Chapitre> getLesChapitres() {
        return lesChapitres;
    }

    public void setLesChapitres(List<Chapitre> lesChapitres) {
        this.lesChapitres = lesChapitres;
    }

    public String getTempsDebut() {
        return tempsDebut;
    }

    public void setTempsDebut(String tempsDebut) {
        this.tempsDebut = tempsDebut;
    }

    public String getTempsFin() {
        return tempsFin;
    }

    public void setTempsFin(String tempsFin) {
        this.tempsFin = tempsFin;
    }

    public int getIdChapitre() {
        return idChapitre;
    }

    public void setIdChapitre(int idChapitre) {
        this.idChapitre = idChapitre;
    }

    public Date getDateChapitre() {
        return dateChapitre;
    }

    public void setDateChapitre(Date dateChapitre) {
        this.dateChapitre = dateChapitre;
    }

    public String getNomChapitre() {
        return nomChapitre;
    }

    public void setNomChapitre(String nomChapitre) {
        this.nomChapitre = nomChapitre;
    }

    public Chapitre getChapitre() {
        return chapitre;
    }

    public void setChapitre(Chapitre chapitre) {
        this.chapitre = chapitre;
    }

    public IChapitreDAOLocal getEc() {
        return Ec;
    }

    public void setEc(IChapitreDAOLocal ec) {
        Ec = ec;
    }

    public List<Examen> getLesExamens() {
        return lesExamens;
    }

    public void setLesExamens(List<Examen> lesExamens) {
        this.lesExamens = lesExamens;
    }

    public String getNomExamen() {
        return nomExamen;
    }

    public void setNomExamen(String nomExamen) {
        this.nomExamen = nomExamen;
    }

    public float getNoteSur() {
        return noteSur;
    }

    public void setNoteSur(float noteSur) {
        this.noteSur = noteSur;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTempsDebutExamen() {
        return tempsDebutExamen;
    }

    public void setTempsDebutExamen(String tempsDebutExamen) {
        this.tempsDebutExamen = tempsDebutExamen;
    }

    public String getTempsFinExamen() {
        return tempsFinExamen;
    }

    public void setTempsFinExamen(String tempsFinExamen) {
        this.tempsFinExamen = tempsFinExamen;
    }

    public int getIdExamen() {
        return idExamen;
    }

    public void setIdExamen(int idExamen) {
        this.idExamen = idExamen;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public IExamenDAO getEex() {
        return Eex;
    }

    public void setEex(IExamenDAO eex) {
        Eex = eex;
    }

    public String getConfirmpassword() {
        return confirmpassword;
    }

    public void setConfirmpassword(String confirmpassword) {
        this.confirmpassword = confirmpassword;
    }
}
