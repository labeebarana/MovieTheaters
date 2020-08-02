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
import javax.validation.constraints.Size;

/**
 *
 * @author labeebarana
 */
@Embeddable
public class MovietimePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "THEATERID")
    private String theaterid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MOVIEID")
    private int movieid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "STARTTIME")
    private String starttime;

    public MovietimePK() {
    }

    public MovietimePK(String theaterid, int movieid, String starttime) {
        this.theaterid = theaterid;
        this.movieid = movieid;
        this.starttime = starttime;
    }

    public String getTheaterid() {
        return theaterid;
    }

    public void setTheaterid(String theaterid) {
        this.theaterid = theaterid;
    }

    public int getMovieid() {
        return movieid;
    }

    public void setMovieid(int movieid) {
        this.movieid = movieid;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

  /*  @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) theaterid;
        hash += (int) movieid;
        hash += (starttime != null ? starttime.hashCode() : 0);
        return hash;
    }
*/
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MovietimePK)) {
            return false;
        }
        MovietimePK other = (MovietimePK) object;
        if (this.theaterid != other.theaterid) {
            return false;
        }
        if (this.movieid != other.movieid) {
            return false;
        }
        if ((this.starttime == null && other.starttime != null) || (this.starttime != null && !this.starttime.equals(other.starttime))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.MovietimePK[ theaterid=" + theaterid + ", movieid=" + movieid + ", starttime=" + starttime + " ]";
    }
    
}
