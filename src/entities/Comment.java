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
    private User author;

    @Column(nullable = false, length = 240)
    private String text;

    private static final long serialVersionUID = 1L;

    public Comment() {
	super();
    }
}
