package controllers;

import dao.idao.*;
import entities.*;


import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.el.MethodExpression;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.*;


@Named
@SessionScoped
public class AdministrateurControl implements Serializable {


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

    private List<Etudiant> students = new ArrayList<>();

    private String path;

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
    private String nameExamen;
    private float noteSur;
    private Date date;
    private String tempsDebutExamen;
    private String tempsFinExamen;
    private int idExamen;
    private List<String> nomexmanes = new ArrayList<>();

    @EJB
    private IExamenDAOLocal Eex;


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
    private String LieuNaissance;
    private String rue;
    private int numero;
    private int codepost;
    private String ville;
    private Etudiant etudiant;

    @EJB
    private IEtudiantDAO Ee;

    //Add note attribute

    private float note;

    @EJB
    private IKeyNoteDAO EkeyNote;

    @EJB
    private INoteEtudiantDAO EnoteEtudiant;


    //Formations methods

    @PostConstruct
    public void getFormations() {
        lesFormations = Ef.findAll();
        students = Ee.findAll();

    }

    public String goToAdd() {
        getFormations();
        path = "addformation.xhtml?faces-redirect=true";
        return path;

    }


    public String addFormation() {

        Formation f = new Formation();
        f.setNom(nom);
        f.setDateDebut(date_debut);
        f.setDateFin(date_fin);
        f.setNiveau(niveau);
        f.setPrix(prix);
        Ef.create(f);
//        Ef.edit(f);
        getFormations();
        return "index.xhtml?faces-redirect=true";
    }

    public String getDataFormation(int id) {
        Formation f = new Formation();
        f = Ef.find(id);
        idFormation = f.getIdFormation();
        nom = f.getNom();
        date_debut = f.getDateDebut();
        date_fin = f.getDateFin();
        niveau = f.getNiveau();
        prix = f.getPrix();
        getFormations();
        path = "editformation.xhtml?faces-redirect=true";
        return path;
    }

    public String modifierFormation() {
        Formation f = new Formation();
        f.setIdFormation(idFormation);
        f.setNom(nom);
        f.setDateDebut(date_debut);
        f.setDateFin(date_fin);
        f.setNiveau(niveau);
        f.setPrix(prix);
        Ef.edit(f);
        getFormations();
        path = "index.xhtml?faces-redirect=true";
        return path;
    }

    public String supprimerFormation(int id) {
        Formation f = Ef.find(id);
        Ef.remove(f);
        getFormations();
        path = "index.xhtml?faces-redirect=true";
        return path;
    }


    //Chapitres methods

    public String getDataChapitre(int id) {

        Chapitre c;
        c = Ec.find(id);
        this.idChapitre = id;
        idFormation = c.getFormation().getIdFormation();
        nomChapitre = c.getNomChapitre();
        dateChapitre = c.getDateChapitre();
        tempsDebut = c.getTempsDebut().substring(11, 16);
        tempsFin = c.getTempsFin().substring(11, 16);
        getChapitres(idFormation);
        return "editchapitre.xhtml?faces-redirect=true";
    }

    public void viderChampsChapitre() {
        nomChapitre = null;
        tempsDebut = null;
        tempsFin = null;
        dateChapitre = null;
    }

    public void getChapitres(int idFormation) {
        this.idFormation = idFormation;
        lesChapitres = Ec.findChapitresByFormation(idFormation);
    }

    public String getChapitresPage(int idFormation) {
        getChapitres(idFormation);
        this.nom = Ef.getFormationName(idFormation);
        return "/views/administrateur/chapitre/index.xhtml?faces-redirect=true";
    }


    public String goToAddChapitre(int idFormation) {
        formation.setIdFormation(this.idFormation);
        this.idFormation = formation.getIdFormation();
        getChapitres(formation.getIdFormation());
        viderChampsChapitre();
        return "addchapitre.xhtml?faces-redirect=true";
    }

    public String addChapitre() {
        Chapitre c = new Chapitre();
        c.setNomChapitre(nomChapitre);
        c.setTempsDebut(tempsDebut);
        c.setTempsFin(tempsFin);
        c.setDateChapitre(dateChapitre);
        Formation f = Ef.find(formation.getIdFormation());
        formationnum = f.getIdFormation();
        c.setFormation(f);
        Ec.create(c);
        getChapitres(formation.getIdFormation());
        return "index.xhtml?faces-redirect=true";
    }

    public String modifierChapitre() {
        Chapitre c = new Chapitre();
        c.setIdChapitre(idChapitre);
        c.setNomChapitre(nomChapitre);
        c.setDateChapitre(dateChapitre);
        c.setTempsDebut(tempsDebut);
        c.setTempsFin(tempsFin);
        c.setFormation(Ef.find(this.idFormation));
        Ec.edit(c);
        getChapitres(this.idFormation);
        return "index.xhtml?faces-redirect=true";
    }

    public String supprimerChapitre(int idChapitre) {
        Chapitre c = Ec.find(idChapitre);
        Ec.remove(c);
        getChapitres(idFormation);
        return getChapitresPage(idFormation);
    }

    //Exmaen methods


    public String getDataExamen(int id) {
        Examen e = new Examen();
        e = Eex.find(id);
        this.idExamen = id;
        idChapitre = e.getChapitre().getIdChapitre();
        nomExamen = e.getNomExamen();
        noteSur = e.getNoteSur();
        date = e.getDate();
        tempsDebutExamen = e.getTempsDebutExamen().substring(11, 16);
        tempsFinExamen = e.getTempsFinExamen().substring(11, 16);
        getExamens(idChapitre);
        return "editexamen.xhtml?faces-redirect=true";
    }

    public void viderChampsExamen() {
        nomExamen = null;
        noteSur = 0;
        date = null;
        tempsDebut = null;
        tempsFin = null;

    }

    public void getExamens(int idChapitre) {
        lesExamens = Eex.findExmaneByChapitre(idChapitre);
        this.idChapitre = idChapitre;
    }

    public String getExamensPage(int idChapitre) {
        getExamens(idChapitre);

        return "/views/administrateur/examen/index.xhtml?faces-redirect=true";
    }

    public String goToAddExamen(int idChapitre) {
        getExamens(idChapitre);
        viderChampsExamen();
        return "/views/administrateur/examen/addexamen.xhtml?faces-redirect=true";

    }

    public String addExamen() {
        Examen e = new Examen();
        e.setNomExamen(nomExamen);
        e.setNoteSur(noteSur);
        e.setDate(date);
        e.setTempsDebutExamen(tempsDebutExamen);
        e.setTempsFinExamen(tempsFinExamen);
        Chapitre c = Ec.find(this.idChapitre);
        e.setChapitre(c);
        Eex.create(e);
        viderChampsExamen();
        getExamens(idChapitre);
        return "index.xhtml?faces-redirect=true";
    }

    public String modifierExamen() {
        Examen e = new Examen();
        e.setIdExamen(idExamen);
        e.setNomExamen(nomExamen);
        e.setNoteSur(noteSur);
        e.setDate(date);
        e.setTempsDebutExamen(tempsDebutExamen);
        e.setTempsFinExamen(tempsFinExamen);
        e.setChapitre(Ec.find(this.idChapitre));
        Eex.edit(e);
        getExamens(this.idChapitre);
        return "index.xhtml?faces-redirect=true";

    }

    public String supprimerExamen(int idExamen) {
        Examen e = Eex.find(idExamen);
        Eex.remove(e);
        getExamens(idChapitre);
        return getExamensPage(idChapitre);
    }

    // student methods
    public String getEtudiants(int idFormation) {
        this.idFormation = idFormation;
        lesEtudiants = Ef.getEtudiants(this.idFormation);

        return "/views/administrateur/etudiant/index.xhtml?faces-redirect=true";
    }


    public List<String> gettingNomExamen() {
        List<String> l = Eex.findNameExamenByFormation(this.idFormation);
//        for(int i=0;i<Eex.findNameExamenByFormation(this.idFormation).size();i++){
//            nomexmanes.set(i,Eex.findNameExamenByFormation(this.idFormation).get(i));
//        }
//        this.idExamen = Eex.findIdByName(this.nameExamen);
        return l;
    }

    public String goToAjouterNote(int idEtudiant, String nomEtudiant) {
        nomexmanes = gettingNomExamen();
        this.idEtudiant = idEtudiant;
        this.nomEtudiant = nomEtudiant;

        return "/views/administrateur/examen/addnoteexamen.xhtml?faces-redirect=true";
    }

    public String addNote() {
        Etudiant e = Ee.find(this.idEtudiant);
        Examen ex = Eex.find(Eex.findIdByName(this.nomExamen));
        KeyNote keyNote = new KeyNote(e, ex);
        NoteEtudiant noteEtudiant = new NoteEtudiant();
        noteEtudiant.setIdNote(keyNote);
        noteEtudiant.setNote(note);
        EnoteEtudiant.create(noteEtudiant);
        Set<NoteEtudiant> setNotesEtudiant = new HashSet<>();
        setNotesEtudiant.add(noteEtudiant);
        e.setLesNotes(setNotesEtudiant);
        ex.setLesNotes(setNotesEtudiant);
        if (note <= noteSur) {
            Ee.edit(e);
            Eex.edit(ex);
        }

        return "/views/administrateur/etudiant/index.xhtml?faces-redirect=true";


    }


    public List<String> getNomexmanes() {
        return nomexmanes;
    }

    public void setNomexmanes(List<String> nomexmanes) {
        this.nomexmanes = nomexmanes;
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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
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

    public IExamenDAOLocal getEex() {
        return Eex;
    }

    public void setEex(IExamenDAOLocal eex) {
        Eex = eex;
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

    public float getNote() {
        return note;
    }

    public void setNote(float note) {
        this.note = note;
    }

    public String getNameExamen() {
        return nameExamen;
    }

    public void setNameExamen(String nameExamen) {
        this.nameExamen = nameExamen;
    }

    public List<Etudiant> getStudents() {
        return students;
    }

    public void setStudents(List<Etudiant> students) {
        this.students = students;
    }

    public IKeyNoteDAO getEkeyNote() {
        return EkeyNote;
    }

    public void setEkeyNote(IKeyNoteDAO ekeyNote) {
        EkeyNote = ekeyNote;
    }

    public INoteEtudiantDAO getEnoteEtudiant() {
        return EnoteEtudiant;
    }

    public void setEnoteEtudiant(INoteEtudiantDAO enoteEtudiant) {
        EnoteEtudiant = enoteEtudiant;
    }


}


