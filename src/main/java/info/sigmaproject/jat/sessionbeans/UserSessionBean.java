/*
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package info.sigmaproject.jat.sessionbeans;

import info.sigmaproject.jat.bcrypt.BCrypt;
import info.sigmaproject.jat.entities.UserEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * 
 * @version $Id$
 */
@Stateless
public class UserSessionBean implements UserSessionBeanLocal {

    @PersistenceContext(name = "JAT_project_blog")
	EntityManager em;

    @Override
    public UserEntity createUser(UserEntity user) {
	em.persist(user);
	em.flush();
	return user;
    }

    @Override
    public UserEntity getUserById(String userId) {
	return em.find(UserEntity.class, userId);
    }

    @Override
    public UserEntity getUserByUsername(String username) {
	List<UserEntity> users = em
		.createQuery(
			"SELECT u FROM UserEntity u WHERE u.username = :username", UserEntity.class)
		.setParameter("username", username).getResultList();
	if (users.isEmpty())
	    return null;
	return users.get(0);
    }

    @Override
    public List<UserEntity> getAllUsers() {
	return em.createNamedQuery("UserEntity.selectAll", UserEntity.class).getResultList();
    }

    @Override
    public List<UserEntity> findUsers(String username) {
	return em
		.createQuery(
			"SELECT u FROM UserEntity u WHERE u.username LIKE :username", UserEntity.class)
		.setParameter("username", username).getResultList();
    }

    @Override
    public UserEntity logIn(String username, String rawPassword) {
	Query query = em
		.createQuery("SELECT u FROM UserEntity u WHERE u.username = :username", UserEntity.class);
	query.setParameter("username", username);

	List<Object> result = query.getResultList();

	if (result.isEmpty()) {
	    return null;
	}

	UserEntity user = (UserEntity) result.get(0);
	if (BCrypt.checkpw(rawPassword, user.getHashedPassword())) {
	    return user;
	}

	return null;
    }

    @Override
    public UserEntity createUser(String username, String rawPassword, String fullName) {
	String hashedPassword = BCrypt.hashpw(rawPassword,
		BCrypt.gensalt());
	UserEntity user = new UserEntity(username, hashedPassword, fullName);
	em.persist(user);
	em.flush();
	return user;
    }

}
