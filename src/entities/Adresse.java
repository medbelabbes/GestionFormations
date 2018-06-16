package entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Embeddable
public class Adresse implements Serializable {


    @NotNull
    @Size(min = 3,max = 45)
    private String rue;

    @NotNull
    private int nuemro;

    @NotNull
    @Size(min = 3,max = 10)
    @Column(name = "code_postal")
    private int codePostale;

    @NotNull
    @Size(min = 3,max = 25)
    private String ville;

    public Adresse() {
    }

    public Adresse(String rue, int nuemro, int codePostale, String ville) {
        this.rue = rue;
        this.nuemro = nuemro;
        this.codePostale = codePostale;
        this.ville = ville;
    }

    public String getRue() {
        return rue;
    }



    public void setRue(String rue) {
        this.rue = rue;
    }

    public int getNuemro() {
        return nuemro;
    }

    public void setNuemro(int nuemro) {
        this.nuemro = nuemro;
    }

    public int getCodePostale() {
        return codePostale;
    }

    public void setCodePostale(int codePostale) {
        this.codePostale = codePostale;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }
}
