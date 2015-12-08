package info.sigmaproject.jat.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Entity implementation class for Entity: Post
 *
 */
@Entity
@NamedQueries({ @NamedQuery(name = "Post.selectAll", query = "SELECT p FROM Post p") })
public class Post implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    private UserEntity author;

    @OneToMany(mappedBy = "post")
    private List<Comment> comments;

    @Column(nullable = false, length = 3000)
    private String text;

    @Column(unique = true, length = 150)
    private String title;

    private static final long serialVersionUID = 1L;

    public Post() {
	super();
    }

    public Post(String title, String text, UserEntity author) {
	this.title = title;
	this.text = text;
	this.author = author;
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
     * @return the author
     */
    public UserEntity getAuthor() {
	return author;
    }

    /**
     * @param author
     *            the author to set
     */
    public void setAuthor(UserEntity author) {
	this.author = author;
    }

    /**
     * @return the comments
     */
    public List<Comment> getComments() {
	return comments;
    }

    /**
     * @param comments
     *            the comments to set
     */
    public void setComments(List<Comment> comments) {
	this.comments = comments;
    }

    /**
     * @return the text
     */
    public String getText() {
	return text;
    }

    /**
     * @param text
     *            the text to set
     */
    public void setText(String text) {
	this.text = text;
    }

    /**
     * @return the title
     */
    public String getTitle() {
	return title;
    }

    /**
     * @param title
     *            the title to set
     */
    public void setTitle(String title) {
	this.title = title;
    }
}
