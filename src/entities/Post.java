package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: Post
 *
 */
@Entity
@NamedQueries({ @NamedQuery(name = "Post.all", query = "SELECT p FROM Post p") })
public class Post implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    private User author;

    @OneToMany
    private List<entities.Comment> comments;

    @Column(nullable = false, length = 500)
    private String text;

    @Column(unique = true, length = 60)
    private String title;

    private static final long serialVersionUID = 1L;

    public Post() {
	super();
    }
}
