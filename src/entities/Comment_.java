package entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-10-17T11:47:20.085+0200")
@StaticMetamodel(Comment.class)
public class Comment_ {
	public static volatile SingularAttribute<Comment, Integer> id;
	public static volatile SingularAttribute<Comment, UserEntity> author;
	public static volatile SingularAttribute<Comment, String> text;
	public static volatile SingularAttribute<Comment, Post> post;
}
