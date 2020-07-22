/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author labeebarana
 */
@Entity
@Table(name = "TICKET")
@NamedQueries({
    @NamedQuery(name = "Ticket.findAll", query = "SELECT t FROM Ticket t"),
    @NamedQuery(name = "Ticket.findByTicketid", query = "SELECT t FROM Ticket t WHERE t.ticketid = :ticketid"),
    @NamedQuery(name = "Ticket.findByMoviedatetime", query = "SELECT t FROM Ticket t WHERE t.moviedatetime = :moviedatetime")})
public class Ticket implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TICKETID")
    private Integer ticketid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "MOVIEDATETIME")
    private String moviedatetime;
    @JoinColumn(name = "MOVIEID", referencedColumnName = "MOVIEID")
    @ManyToOne(optional = false)
    private Movie movieid;
    @JoinColumn(name = "THEATERID", referencedColumnName = "THEATERID")
    @ManyToOne(optional = false)
    private Theater theaterid;

    public Ticket() {
    }

    public Ticket(Integer ticketid) {
        this.ticketid = ticketid;
    }

    public Ticket(Integer ticketid, String moviedatetime) {
        this.ticketid = ticketid;
        this.moviedatetime = moviedatetime;
    }

    public Integer getTicketid() {
        return ticketid;
    }

    public void setTicketid(Integer ticketid) {
        this.ticketid = ticketid;
    }

    public String getMoviedatetime() {
        return moviedatetime;
    }

    public void setMoviedatetime(String moviedatetime) {
        this.moviedatetime = moviedatetime;
    }

    public Movie getMovieid() {
        return movieid;
    }

    public void setMovieid(Movie movieid) {
        this.movieid = movieid;
    }

    public Theater getTheaterid() {
        return theaterid;
    }

    public void setTheaterid(Theater theaterid) {
        this.theaterid = theaterid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ticketid != null ? ticketid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ticket)) {
            return false;
        }
        Ticket other = (Ticket) object;
        if ((this.ticketid == null && other.ticketid != null) || (this.ticketid != null && !this.ticketid.equals(other.ticketid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Ticket[ ticketid=" + ticketid + " ]";
    }
    
}
