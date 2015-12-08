package info.sigmaproject.jat.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Entity implementation class for Entity: UserEntity
 *
 */
@Entity
@NamedQueries({ @NamedQuery(name = "UserEntity.selectAll", query = "SELECT u FROM UserEntity u") })
public class UserEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(unique = true, length = 16)
    private String username;

    @Column(nullable = false, length = 120)
    private String hashedPassword;

    @Column(nullable = true)
    private String fullName;

    @OneToMany(mappedBy = "author")
    private List<Post> posts;

    private static final long serialVersionUID = 1L;

    public UserEntity() {
	super();
    }

    public UserEntity(String username, String hashedPassword, String fullName) {
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

    /**
     * @return the posts
     */
    public List<Post> getPosts() {
	return posts;
    }

    /**
     * @param posts
     *            the posts to set
     */
    public void setPosts(List<Post> posts) {
	this.posts = posts;
    }
}
