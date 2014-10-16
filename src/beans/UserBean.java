package beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.User;

@ManagedBean(name = "userBean")
@SessionScoped
public class UserBean implements Serializable {

    private String username;

    private String password;

    private String fullName;

    @PersistenceContext
    EntityManager em;

    /**
     * 
     */
    private static final long serialVersionUID = 5022669426687458041L;

    public String login() {
	Query query = em
		.createQuery("SELECT u FROM User u WHERE u.username = :username");
	query.setParameter("username", this.username);

	List<Object> result = query.getResultList();

	if (result.isEmpty()) {
	    return "/login.xhtml?fail=true&message=\"Username not found\"";
	}

	User user = (User) result.get(0);
	if (bcrypt.BCrypt.checkpw(this.password, user.getHashedPassword())) {
	    this.password = null;
	    return "/index.xhtml";
	}

	return "/login.xhtml?fail=true&message=\"Password is incorrect\"";
    }

    public String register() {
	String hashedPassword = bcrypt.BCrypt.hashpw(this.password,
		bcrypt.BCrypt.gensalt());
	User user = new User(username, hashedPassword, fullName);
	em.persist(user);
	this.password = null;
	return "/index.xhtml";
    }

    public String logout() {
	FacesContext.getCurrentInstance().getExternalContext()
		.invalidateSession();
	return "/index.xhtml";
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
     * @return the password
     */
    public String getPassword() {
	return password;
    }

    /**
     * @param password
     *            the password to set
     */
    public void setPassword(String password) {
	this.password = password;
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
