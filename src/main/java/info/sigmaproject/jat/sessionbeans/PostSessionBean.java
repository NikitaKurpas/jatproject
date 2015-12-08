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

import info.sigmaproject.jat.entities.Post;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @version $Id$
 */
@Stateless
public class PostSessionBean implements PostSessionBeanLocal {

    @PersistenceContext(name = "JAT_project_blog")
    EntityManager em;

    @Override
    public List<Post> getAllPosts() {
        return em.createNamedQuery("Post.selectAll").getResultList();
    }

    @Override
    public Post createPost(Post post) {
        em.persist(post);
        em.flush();
        return post;
    }

    @Override
    public Post getPostById(String postId) {
        return em.find(Post.class, postId);
    }

    @Override
    public Post getPostByTitle(String title) {
        List<Post> posts = em
                .createQuery("SELECT p FROM Post p WHERE p.title = :title", Post.class)
                .setParameter("title", title).getResultList();
        if (posts.isEmpty())
            return null;
        return posts.get(0);
    }

    @Override
    public List<Post> findPostsByTitle(String title) {
        return em.createQuery("SELECT p FROM Post p WHERE p.title LIKE :title", Post.class)
                .setParameter("title", "title").getResultList();
    }

}
