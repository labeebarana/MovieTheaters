/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author labeebarana
 */
@Entity
@Table(name = "TICKETBOUGHT")
@NamedQueries({
    @NamedQuery(name = "Ticketbought.findAll", query = "SELECT t FROM Ticketbought t"),
    @NamedQuery(name = "Ticketbought.findByCustomerid", query = "SELECT t FROM Ticketbought t WHERE t.ticketboughtPK.customerid = :customerid"),
    @NamedQuery(name = "Ticketbought.findByTicketid", query = "SELECT t FROM Ticketbought t WHERE t.ticketboughtPK.ticketid = :ticketid")})
public class Ticketbought implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TicketboughtPK ticketboughtPK;

    public Ticketbought() {
    }

    public Ticketbought(TicketboughtPK ticketboughtPK) {
        this.ticketboughtPK = ticketboughtPK;
    }

    public Ticketbought(int customerid, int ticketid) {
        this.ticketboughtPK = new TicketboughtPK(customerid, ticketid);
    }

    public TicketboughtPK getTicketboughtPK() {
        return ticketboughtPK;
    }

    public void setTicketboughtPK(TicketboughtPK ticketboughtPK) {
        this.ticketboughtPK = ticketboughtPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ticketboughtPK != null ? ticketboughtPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ticketbought)) {
            return false;
        }
        Ticketbought other = (Ticketbought) object;
        if ((this.ticketboughtPK == null && other.ticketboughtPK != null) || (this.ticketboughtPK != null && !this.ticketboughtPK.equals(other.ticketboughtPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Ticketbought[ ticketboughtPK=" + ticketboughtPK + " ]";
    }
    
}
