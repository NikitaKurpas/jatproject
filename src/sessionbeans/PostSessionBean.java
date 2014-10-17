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

/**
 * 
 * @version $Id$
 */
@Stateless
public class PostSessionBean implements PostSessionBeanLocal {

    @PersistenceContext(unitName = "JATProject_2")
    EntityManager em;

    /**
     * {@inheritDoc}
     * 
     * @see sessionbeans.PostSessionBeanLocal#getAllPosts()
     */
    @Override
    public List<entities.Post> getAllPosts() {
	return em.createNamedQuery("Post.all").getResultList();
    }

    /**
     * {@inheritDoc}
     * 
     * @see sessionbeans.PostSessionBeanLocal#createPost(entities.Post)
     */
    @Override
    public entities.Post createPost(entities.Post post) {
	em.persist(post);
	em.flush();
	return post;
    }

    /**
     * {@inheritDoc}
     * 
     * @see sessionbeans.PostSessionBeanLocal#getPostById(java.lang.String)
     */
    @Override
    public entities.Post getPostById(String postId) {
	return em.find(entities.Post.class, postId);
    }

    /**
     * {@inheritDoc}
     * 
     * @see sessionbeans.PostSessionBeanLocal#getPostByTitle(java.lang.String)
     */
    @Override
    public entities.Post getPostByTitle(String title) {
	List<entities.Post> posts = em
		.createQuery("SELECT p FROM Post p WHERE p.title = :title")
		.setParameter("title", title).getResultList();
	if (posts.isEmpty())
	    return null;
	return posts.get(0);
    }

    /**
     * {@inheritDoc}
     * 
     * @see sessionbeans.PostSessionBeanLocal#findPostsByTitle(java.lang.String)
     */
    @Override
    public List<entities.Post> findPostsByTitle(String title) {
	return em.createQuery("SELECT p FROM Post p WHERE p.title LIKE :title")
		.setParameter("title", "title").getResultList();
    }

}
