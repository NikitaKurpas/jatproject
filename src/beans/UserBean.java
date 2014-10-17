package beans;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import sessionbeans.UserSessionBeanLocal;
import entities.UserEntity;

@ManagedBean(name = "userBean")
@SessionScoped
public class UserBean implements Serializable {

    @EJB
    private UserSessionBeanLocal userSB;

    private String username;

    private String password;

    private String fullName;

    private UserEntity loggedUser;

    private boolean logged = false;

    /**
     * 
     */
    private static final long serialVersionUID = 5022669426687458041L;

    public String login() {
	UserEntity user = userSB.logIn(username, password);

	System.out.print(user == null ? "User is null" : user.getUsername());

	if (user == null)
	    return "login.xhtml?message=\"Failed to log in\"";

	loggedUser = user;
	logged = true;
	return "index.xhtml";
    }

    public String register() {
	loggedUser = userSB.createUser(username, password, fullName);
	System.out.print(loggedUser == null ? "User is null" : loggedUser
		.getUsername());
	if (loggedUser == null)
	    return "register.xhtml?message=\"Failed to register\"";
	logged = true;
	return "index.xhtml";
    }

    public String logout() {
	FacesContext.getCurrentInstance().getExternalContext()
		.invalidateSession();
	logged = false;
	return "index.xhtml";
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

    /**
     * @return the isLogged
     */
    public boolean isLogged() {
	return logged;
    }

    /**
     * @return the loggedUser
     */
    public UserEntity getLoggedUser() {
	return loggedUser;
    }

}
