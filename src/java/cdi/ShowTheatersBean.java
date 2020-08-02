/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdi;

import ejb.MovieEJB;
import entity.Movietime;
import entity.MovietimePK;
import entity.Theater;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;

/**
 *
 * @author labeebarana
 */
@Named(value = "showTheatersBean")
@SessionScoped
public class ShowTheatersBean implements Serializable {

    @EJB
    private MovieEJB movieEJB;
    private List<Theater> theaterList;
    private Theater theater;
    private Movietime movietime;
    private MovietimePK movieTimePk;

    public MovietimePK getMovieTimePk() {
        return movieTimePk;
    }

    public void setMovieTimePk(MovietimePK movieTimePk) {
        this.movieTimePk = movieTimePk;
    }

    public Movietime getMovietime() {
        return movietime;
    }

    public void setMovietime(Movietime movietime) {
        this.movietime = movietime;
    }

    
    public ShowTheatersBean() {
        theater = new Theater();
    }

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }
    
    public String showTheater(Theater theater){
        this.theater = theater;
        return "ShowTheater";
    }
    
    @PostConstruct
    public void init() {
    theater = new Theater();
 }
    
    public String showTheaters(){
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
        String zipcode = params.get("zipcode");
        theaterList = movieEJB.getTheatersForZipcode(Integer.parseInt(zipcode));
        return "ShowTheater";
    }
    

    
    public List<Theater> getTheaterList(){
        if (theater != null)
            return movieEJB.getTheatersForZipcode(theater.getZipcode());
        else
            return null;
    }

  
    
        
   
    
    
}
