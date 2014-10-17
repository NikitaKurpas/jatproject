package entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-10-17T11:47:19.792+0200")
@StaticMetamodel(UserEntity.class)
public class UserEntity_ {
	public static volatile SingularAttribute<UserEntity, Integer> id;
	public static volatile SingularAttribute<UserEntity, String> username;
	public static volatile SingularAttribute<UserEntity, String> hashedPassword;
	public static volatile SingularAttribute<UserEntity, String> fullName;
	public static volatile ListAttribute<UserEntity, Post> posts;
}
