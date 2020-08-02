/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author labeebarana
 */
@Entity
@Table(name = "MOVIETIME")
@NamedQueries({
    @NamedQuery(name = "Movietime.findAll", query = "SELECT m FROM Movietime m"),
    @NamedQuery(name = "Movietime.findByTheaterid", query = "SELECT m FROM Movietime m WHERE m.movietimePK.theaterid = :theaterID"),
    @NamedQuery(name = "Movietime.findByMovieid", query = "SELECT m FROM Movietime m WHERE m.movietimePK.movieid = :movieid"),
    @NamedQuery(name = "Movietime.findByStarttime", query = "SELECT m FROM Movietime m WHERE m.movietimePK.starttime = :starttime")})
public class Movietime implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MovietimePK movietimePK;
    @JoinColumn(name = "MOVIEID", referencedColumnName = "MOVIEID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Movie movie;
    @JoinColumn(name = "THEATERID", referencedColumnName = "THEATERID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Theater theater;

    public Movietime() {
    }

    public Movietime(MovietimePK movietimePK) {
        this.movietimePK = movietimePK;
    }

    public Movietime(String theaterid, int movieid, String starttime) {
        this.movietimePK = new MovietimePK(theaterid, movieid, starttime);
    }

    public MovietimePK getMovietimePK() {
        return movietimePK;
    }

    public void setMovietimePK(MovietimePK movietimePK) {
        this.movietimePK = movietimePK;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (movietimePK != null ? movietimePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movietime)) {
            return false;
        }
        Movietime other = (Movietime) object;
        if ((this.movietimePK == null && other.movietimePK != null) || (this.movietimePK != null && !this.movietimePK.equals(other.movietimePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Movietime[ movietimePK=" + movietimePK + " ]";
    }
    
}
