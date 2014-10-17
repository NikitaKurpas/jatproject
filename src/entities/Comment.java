package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * Entity implementation class for Entity: Comment
 *
 */
@Entity
@NamedQueries({ @NamedQuery(name = "Comment.all", query = "SELECT c FROM Comment c") })
public class Comment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    private UserEntity author;

    @Column(nullable = false, length = 240)
    private String text;

    @ManyToOne
    private Post post;

    private static final long serialVersionUID = 1L;

    public Comment() {
	super();
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
     * @return the post
     */
    public Post getPost() {
	return post;
    }

    /**
     * @param post
     *            the post to set
     */
    public void setPost(Post post) {
	this.post = post;
    }
}
