/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author labeebarana
 */
@Entity
@Table(name = "MOVIE")
@NamedQueries({
    @NamedQuery(name = "Movie.findAll", query = "SELECT m FROM Movie m"),
    @NamedQuery(name = "Movie.findByMovieid", query = "SELECT m FROM Movie m WHERE m.movieid = :movieid"),
    @NamedQuery(name = "Movie.findByMovietitle", query = "SELECT m FROM Movie m WHERE m.movietitle = :movietitle"),
    @NamedQuery(name = "Movie.findByMoviedesc", query = "SELECT m FROM Movie m WHERE m.moviedesc = :moviedesc")})
public class Movie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MOVIEID")
    private Integer movieid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "MOVIETITLE")
    private String movietitle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2000)
    @Column(name = "MOVIEDESC")
    private String moviedesc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "movie")
    private Collection<Movietime> movietimeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "movieid")
    private Collection<Ticket> ticketCollection;

    public Movie() {
    }

    public Movie(Integer movieid) {
        this.movieid = movieid;
    }

    public Movie(Integer movieid, String movietitle, String moviedesc) {
        this.movieid = movieid;
        this.movietitle = movietitle;
        this.moviedesc = moviedesc;
    }

    public Integer getMovieid() {
        return movieid;
    }

    public void setMovieid(Integer movieid) {
        this.movieid = movieid;
    }

    public String getMovietitle() {
        return movietitle;
    }

    public void setMovietitle(String movietitle) {
        this.movietitle = movietitle;
    }

    public String getMoviedesc() {
        return moviedesc;
    }

    public void setMoviedesc(String moviedesc) {
        this.moviedesc = moviedesc;
    }

    public Collection<Movietime> getMovietimeCollection() {
        return movietimeCollection;
    }

    public void setMovietimeCollection(Collection<Movietime> movietimeCollection) {
        this.movietimeCollection = movietimeCollection;
    }

    public Collection<Ticket> getTicketCollection() {
        return ticketCollection;
    }

    public void setTicketCollection(Collection<Ticket> ticketCollection) {
        this.ticketCollection = ticketCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (movieid != null ? movieid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movie)) {
            return false;
        }
        Movie other = (Movie) object;
        if ((this.movieid == null && other.movieid != null) || (this.movieid != null && !this.movieid.equals(other.movieid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Movie[ movieid=" + movieid + " ]";
    }
    
}
