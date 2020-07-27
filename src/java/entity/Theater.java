/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
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
@Table(name = "THEATER")
@NamedQueries({
    @NamedQuery(name = "Theater.findAll", query = "SELECT t FROM Theater t"),
    @NamedQuery(name = "Theater.findByTheaterid", query = "SELECT t FROM Theater t WHERE t.theaterid = :theaterid"),
    @NamedQuery(name = "Theater.findByTheatername", query = "SELECT t FROM Theater t WHERE t.theatername = :theatername"),
    @NamedQuery(name = "Theater.findByZipcode", query = "SELECT t.theatername FROM Theater t WHERE t.zipcode = :zipcode")})
public class Theater implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "THEATERID")
    private Integer theaterid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "THEATERNAME")
    private String theatername;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ZIPCODE")
    private int zipcode;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "theater")
    private Collection<Movietime> movietimeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "theaterid")
    private Collection<Ticket> ticketCollection;

    public Theater() {
    }

    public Theater(Integer theaterid) {
        this.theaterid = theaterid;
    }

    public Theater(Integer theaterid, String theatername, int zipcode) {
        this.theaterid = theaterid;
        this.theatername = theatername;
        this.zipcode = zipcode;
    }

    public Integer getTheaterid() {
        return theaterid;
    }

    public void setTheaterid(Integer theaterid) {
        this.theaterid = theaterid;
    }

    public String getTheatername() {
        return theatername;
    }

    public void setTheatername(String theatername) {
        this.theatername = theatername;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
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
        hash += (theaterid != null ? theaterid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Theater)) {
            return false;
        }
        Theater other = (Theater) object;
        if ((this.theaterid == null && other.theaterid != null) || (this.theaterid != null && !this.theaterid.equals(other.theaterid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Theater[ theaterid=" + theaterid + " ]";
    }
    
}
