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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author wais
 */
@Entity
@Table(name = "usertoken")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usertoken.findAll", query = "SELECT u FROM Usertoken u"),
    @NamedQuery(name = "Usertoken.findByIduserToken", query = "SELECT u FROM Usertoken u WHERE u.iduserToken = :iduserToken"),
    @NamedQuery(name = "Usertoken.findByToken", query = "SELECT u FROM Usertoken u WHERE u.token = :token"),
    @NamedQuery(name = "Usertoken.findByValidatedOn", query = "SELECT u FROM Usertoken u WHERE u.validatedOn = :validatedOn"),
    @NamedQuery(name = "Usertoken.findByDateSent", query = "SELECT u FROM Usertoken u WHERE u.dateSent = :dateSent")})
public class Usertoken implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer iduserToken;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(nullable = false, length = 300)
    private String token;
    @Temporal(TemporalType.TIMESTAMP)
    private Date validatedOn;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateSent;
    @JoinColumn(name = "idUser", referencedColumnName = "iduser", nullable = false)
    @ManyToOne(optional = false)
    private User idUser;

    public Usertoken() {
    }

    public Usertoken(Integer iduserToken) {
        this.iduserToken = iduserToken;
    }

    public Usertoken(Integer iduserToken, String token) {
        this.iduserToken = iduserToken;
        this.token = token;
    }

    public Integer getIduserToken() {
        return iduserToken;
    }

    public void setIduserToken(Integer iduserToken) {
        this.iduserToken = iduserToken;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getValidatedOn() {
        return validatedOn;
    }

    public void setValidatedOn(Date validatedOn) {
        this.validatedOn = validatedOn;
    }

    public Date getDateSent() {
        return dateSent;
    }

    public void setDateSent(Date dateSent) {
        this.dateSent = dateSent;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iduserToken != null ? iduserToken.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usertoken)) {
            return false;
        }
        Usertoken other = (Usertoken) object;
        if ((this.iduserToken == null && other.iduserToken != null) || (this.iduserToken != null && !this.iduserToken.equals(other.iduserToken))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ak.fitness.entities.Usertoken[ iduserToken=" + iduserToken + " ]";
    }
    
}
