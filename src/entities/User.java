package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity
@NamedQueries({ @NamedQuery(name = "User.all", query = "SELECT u FROM User u") })
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(unique = true, length = 16)
    private String username;

    @Column(nullable = false, length = 120)
    private String hashedPassword;

    @Column(nullable = true)
    private String fullName;

    private static final long serialVersionUID = 1L;

    public User() {
	super();
    }

    public User(String username, String hashedPassword, String fullName) {
	super();
	this.username = username;
	this.hashedPassword = hashedPassword;
	this.fullName = fullName;
    }

    /**
     * @return the id
     */
    public Integer getId() {
	return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(Integer id) {
	this.id = id;
    }

    /**
     * @return the username
     */
    public String getUsername() {
	return username;
    }

    /**
     * @param username
     *            the username to set
     */
    public void setUsername(String username) {
	this.username = username;
    }

    /**
     * @return the hashedPassword
     */
    public String getHashedPassword() {
	return hashedPassword;
    }

    /**
     * @param hashedPassword
     *            the hashedPassword to set
     */
    public void setHashedPassword(String hashedPassword) {
	this.hashedPassword = hashedPassword;
    }

    /**
     * @return the fullName
     */
    public String getFullName() {
	return fullName;
    }

    /**
     * @param fullName
     *            the fullName to set
     */
    public void setFullName(String fullName) {
	this.fullName = fullName;
    }
}
