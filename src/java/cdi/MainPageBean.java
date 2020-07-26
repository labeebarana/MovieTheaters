/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdi;

import ejb.MovieEJB;
import entity.Theater;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author labeebarana
 */
@Named(value = "mainPageBean")
@RequestScoped
public class MainPageBean {
//this is a test for the git repo
    @EJB
    private MovieEJB movieEJB;
    private Theater theater;

    
    public MainPageBean() {
        
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
    
    @PostConstruct
    public void init() {
    theater = new Theater();
}
    
    public List<Theater> getTheaterList(){
            return movieEJB.findAllTheaters();
        }
    
    public List<Theater> getTheatersForZip(int zipcode){
        return movieEJB.getTheatersForZipcode(zipcode);
    }
    
}
