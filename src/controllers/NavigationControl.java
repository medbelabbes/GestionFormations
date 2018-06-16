package controllers;


import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class NavigationControl implements Serializable {

    public String goToSignUpStudent(){
        return "/signupstudent.xhtml?faces-redirect=true";
    }
    public String goToSignUpAdmin(){
        return "/signupadmin.xhtml?faces-redirect=true";
    }
}
