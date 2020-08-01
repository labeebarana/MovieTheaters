/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdi;

import ejb.MovieEJB;
import entity.Theater;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;

/**
 *
 * @author labeebarana
 */
@Named(value = "showMoviesBean")
@SessionScoped
public class ShowMoviesBean implements Serializable {

    @EJB
    private MovieEJB movieEJB;
    private Theater theater;

    
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
    
    
    
}
