/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author labeebarana
 */
@Embeddable
public class TicketboughtPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "CUSTOMERID")
    private int customerid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TICKETID")
    private int ticketid;

    public TicketboughtPK() {
    }

    public TicketboughtPK(int customerid, int ticketid) {
        this.customerid = customerid;
        this.ticketid = ticketid;
    }

    public int getCustomerid() {
        return customerid;
    }

    public void setCustomerid(int customerid) {
        this.customerid = customerid;
    }

    public int getTicketid() {
        return ticketid;
    }

    public void setTicketid(int ticketid) {
        this.ticketid = ticketid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) customerid;
        hash += (int) ticketid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TicketboughtPK)) {
            return false;
        }
        TicketboughtPK other = (TicketboughtPK) object;
        if (this.customerid != other.customerid) {
            return false;
        }
        if (this.ticketid != other.ticketid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TicketboughtPK[ customerid=" + customerid + ", ticketid=" + ticketid + " ]";
    }
    
}
