/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ak.fitness.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author wais
 */
@Entity
@Table(name = "subscription", catalog = "akfitness", schema = "akfitness", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"idsubscription"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Subscription.findAll", query = "SELECT s FROM Subscription s"),
    @NamedQuery(name = "Subscription.findByIdsubscription", query = "SELECT s FROM Subscription s WHERE s.idsubscription = :idsubscription"),
    @NamedQuery(name = "Subscription.findByPackage1", query = "SELECT s FROM Subscription s WHERE s.package1 = :package1"),
    @NamedQuery(name = "Subscription.findByValid", query = "SELECT s FROM Subscription s WHERE s.valid = :valid"),
    @NamedQuery(name = "Subscription.findByIduser", query = "SELECT s FROM Subscription s WHERE s.iduser = :iduser")})
public class Subscription implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer idsubscription;
    @Basic(optional = false)
    @NotNull
    @Column(name = "package", nullable = false)
    private int package1;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private boolean valid;
    private Integer iduser;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationdate;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedate;

    public Subscription() {
    }

    public Subscription(Integer idsubscription) {
        this.idsubscription = idsubscription;
    }

    public Subscription(Integer idsubscription, int package1, boolean valid, Date creationdate, Date updatedate) {
        this.idsubscription = idsubscription;
        this.package1 = package1;
        this.valid = valid;
        this.creationdate = creationdate;
        this.updatedate = updatedate;
    }

    public Integer getIdsubscription() {
        return idsubscription;
    }

    public void setIdsubscription(Integer idsubscription) {
        this.idsubscription = idsubscription;
    }

    public int getPackage1() {
        return package1;
    }

    public void setPackage1(int package1) {
        this.package1 = package1;
    }

    public boolean getValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public Integer getIduser() {
        return iduser;
    }

    public void setIduser(Integer iduser) {
        this.iduser = iduser;
    }
    
    
    public Date getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }

    public Date getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsubscription != null ? idsubscription.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subscription)) {
            return false;
        }
        Subscription other = (Subscription) object;
        if ((this.idsubscription == null && other.idsubscription != null) || (this.idsubscription != null && !this.idsubscription.equals(other.idsubscription))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ak.fitness.entities.Subscription[ idsubscription=" + idsubscription + " ]";
    }
    
}
