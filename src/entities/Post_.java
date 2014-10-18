package entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-10-18T11:41:54.314+0200")
@StaticMetamodel(Post.class)
public class Post_ {
	public static volatile SingularAttribute<Post, Integer> id;
	public static volatile SingularAttribute<Post, UserEntity> author;
	public static volatile ListAttribute<Post, Comment> comments;
	public static volatile SingularAttribute<Post, String> text;
	public static volatile SingularAttribute<Post, String> title;
}
