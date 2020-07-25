/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Movie;
import entity.Movietime;
import entity.MovietimePK;
import entity.Theater;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author labeebarana
 */
@Stateless
public class MovieEJB {

    @PersistenceContext(unitName = "MovieTheatersPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    /**
     * returns all theaters
     * @return returns a List of the theaters
     *
     */
    public List<Theater> findAllTheaters(){
        return em.createNamedQuery("Theater.findAll", Theater.class).getResultList();
    }
    /**
     * Finds the movie by the movie ID  
     * @param movieID The primary key for movie entity
     * @return the movie in String format
     */
    public Theater getTheater(int zipcode){
       return em.createNamedQuery("Theater.findByZipcode", Theater.class).setParameter("zipcode", zipcode).getSingleResult(); 
    }
    
    public List<MovietimePK> getMoviesForTheater(int theaterID){
        return em.createNamedQuery("MovietimePK.findByTheaterid", MovietimePK.class).setParameter("theaterID", theaterID).getResultList();
    }
    
    public List<Theater> getTheatersForZipcode(int zipcode){
        return em.createNamedQuery("Theater.findByZipcode", Theater.class).setParameter("zipcode", zipcode).getResultList();
    }
     
    
    
}
