/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdi;

import ejb.MovieEJB;
import entity.Movie;
import entity.Movietime;
import entity.MovietimePK;
import entity.Theater;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author labeebarana
 */
@Named(value = "showMoviesBean")
@RequestScoped
public class ShowMoviesBean implements Serializable {

    @EJB
    private MovieEJB movieEJB;
    private Theater theater;
    private List<Movietime> movieList;
    

    
    public ShowMoviesBean() {
    }

    public MovieEJB getMovieEJB() {
        return movieEJB;
    }

    public void setMovieEJB(MovieEJB movieEJB) {
        this.movieEJB = movieEJB;
    }

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }
    
    public String showMovies(){
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
        String zipcode = params.get("zipcode");
        List<Theater> theaterID = movieEJB.getTheaterIDfromZipCode(Integer.parseInt(zipcode));
        
        int sd = theaterID.get(0).getTheaterid(); 
        movieList = movieEJB.getMoviesForTheater(sd);
        return "ShowMovies";
    }
        
    public List<Movietime> getMovieList(){
        if (theater != null)
            return movieEJB.getMoviesForTheater(theater.getTheaterid());
        else
            return null;
    }
    
}
