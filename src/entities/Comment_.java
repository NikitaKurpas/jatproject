package entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-11-12T19:21:57.889+0100")
@StaticMetamodel(Comment.class)
public class Comment_ {
	public static volatile SingularAttribute<Comment, Integer> id;
	public static volatile SingularAttribute<Comment, UserEntity> author;
	public static volatile SingularAttribute<Comment, String> text;
	public static volatile SingularAttribute<Comment, Post> post;
}
