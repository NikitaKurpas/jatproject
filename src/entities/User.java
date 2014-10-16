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
}
