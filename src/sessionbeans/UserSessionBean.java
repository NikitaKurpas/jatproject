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
package sessionbeans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.UserEntity;

/**
 * 
 * @version $Id$
 */
@Stateless
public class UserSessionBean implements UserSessionBeanLocal {

    @PersistenceContext(unitName = "JATProject_2")
    EntityManager em;

    /**
     * {@inheritDoc}
     * 
     * @see sessionbeans.UserSessionBeanLocal#createUser(entities.UserEntity)
     */
    @Override
    public entities.UserEntity createUser(entities.UserEntity user) {
	em.persist(user);
	em.flush();
	return user;
    }

    /**
     * {@inheritDoc}
     * 
     * @see sessionbeans.UserSessionBeanLocal#getUserById(java.lang.String)
     */
    @Override
    public entities.UserEntity getUserById(String userId) {
	return em.find(entities.UserEntity.class, userId);
    }

    /**
     * {@inheritDoc}
     * 
     * @see sessionbeans.UserSessionBeanLocal#getUserByUsername(java.lang.String)
     */
    @Override
    public entities.UserEntity getUserByUsername(String username) {
	List<entities.UserEntity> users = em
		.createQuery(
			"SELECT u FROM UserEntity u WHERE u.username = :username")
		.setParameter("username", username).getResultList();
	if (users.isEmpty())
	    return null;
	return users.get(0);
    }

    /**
     * {@inheritDoc}
     * 
     * @see sessionbeans.UserSessionBeanLocal#getAllUsers()
     */
    @Override
    public List<entities.UserEntity> getAllUsers() {
	return em.createNamedQuery("UserEntity.all").getResultList();
    }

    /**
     * {@inheritDoc}
     * 
     * @see sessionbeans.UserSessionBeanLocal#findUsers(java.lang.String)
     */
    @Override
    public List<entities.UserEntity> findUsers(String username) {
	return em
		.createQuery(
			"SELECT u FROM UserEntity u WHERE u.username LIKE :username")
		.setParameter("username", username).getResultList();
    }

    /**
     * {@inheritDoc}
     * 
     * @see sessionbeans.UserSessionBeanLocal#logIn(java.lang.String, java.lang.String)
     */
    @Override
    public UserEntity logIn(String username, String rawPassword) {
	Query query = em
		.createQuery("SELECT u FROM UserEntity u WHERE u.username = :username");
	query.setParameter("username", username);

	List<Object> result = query.getResultList();

	if (result.isEmpty()) {
	    return null;
	}

	entities.UserEntity user = (entities.UserEntity) result.get(0);
	if (bcrypt.BCrypt.checkpw(rawPassword, user.getHashedPassword())) {
	    return user;
	}

	return null;
    }

    /**
     * {@inheritDoc}
     * 
     * @see sessionbeans.UserSessionBeanLocal#createUser(java.lang.String,
     *      java.lang.String, java.lang.String)
     */
    @Override
    public UserEntity createUser(String username, String rawPassword, String fullName) {
	String hashedPassword = bcrypt.BCrypt.hashpw(rawPassword,
		bcrypt.BCrypt.gensalt());
	UserEntity user = new UserEntity(username, hashedPassword, fullName);
	em.persist(user);
	em.flush();
	return user;
    }

}
