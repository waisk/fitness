/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ak.fitness.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author wais
 */
@Entity
@Table(name = "user", catalog = "akfitness", schema = "akfitness", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"iduser"}),
//    @UniqueConstraint(columnNames = {"email"}),
    @UniqueConstraint(columnNames = {"username"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findByIduser", query = "SELECT u FROM User u WHERE u.iduser = :iduser"),
    @NamedQuery(name = "User.findByFirstname", query = "SELECT u FROM User u WHERE u.firstname = :firstname"),
    @NamedQuery(name = "User.findByLastname", query = "SELECT u FROM User u WHERE u.lastname = :lastname"),
    @NamedQuery(name = "User.findByUsername", query = "SELECT u FROM User u WHERE u.username = :username"),
    @NamedQuery(name = "User.findByPassword", query = "SELECT u FROM User u WHERE u.password = :password"),
    @NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE u.email = :email"),
    @NamedQuery(name = "User.findByCreationdate", query = "SELECT u FROM User u WHERE u.creationdate = :creationdate"),
    @NamedQuery(name = "User.findByAdmin", query = "SELECT u FROM User u WHERE u.admin = :admin")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer iduser;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(nullable = false, length = 45)
    private String firstname;
    @Size(max = 45)
    @Column(length = 45)
    private String lastname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(nullable = false, length = 45)
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(nullable = false, length = 45)
    private String password;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(nullable = false, length = 45)
    private String email;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationdate;
    private Boolean admin;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUser")
    private Collection<Usertoken> usertokenCollection;

    public User() {
    }

    public User(Integer iduser) {
        this.iduser = iduser;
    }

    public User(Integer iduser, String firstname, String username, String password, String email, Date creationdate) {
        this.iduser = iduser;
        this.firstname = firstname;
        this.username = username;
        this.password = password;
        this.email = email;
        this.creationdate = creationdate;
    }

    public Integer getIduser() {
        return iduser;
    }

    public void setIduser(Integer iduser) {
        this.iduser = iduser;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iduser != null ? iduser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.iduser == null && other.iduser != null) || (this.iduser != null && !this.iduser.equals(other.iduser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ak.fitness.entities.User[ iduser=" + iduser + " ]";
    }

    @XmlTransient
    @JsonIgnore
    public Collection<Usertoken> getUsertokenCollection() {
        return usertokenCollection;
    }

    public void setUsertokenCollection(Collection<Usertoken> usertokenCollection) {
        this.usertokenCollection = usertokenCollection;
    }
    
}
