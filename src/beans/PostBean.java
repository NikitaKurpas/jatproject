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
package beans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import sessionbeans.PostSessionBeanLocal;
import entities.Post;

/**
 * 
 * @version $Id$
 */
@ManagedBean(name = "postBean")
@SessionScoped
public class PostBean {

    private String title, text;

    @ManagedProperty(value = "#{userBean}")
    private UserBean userBean;

    private Post currentPost = null;

    @EJB
    private PostSessionBeanLocal postSB;

    public List<Post> getAllPosts() {
	return postSB.getAllPosts();
    }

    public List<Post> findPostsByTitle() {
	return postSB.findPostsByTitle(title);
    }

    public String createPost() {
	Post post = new Post(title, text, userBean.getLoggedUser());
	postSB.createPost(post);
	return "index.xhtml?faces-redirect=true";
    }

    public String persistPost() {
	postSB.createPost(currentPost);
	return "index.xhtml?faces-redirect=true";
    }

    /**
     * @return the title
     */
    public String getTitle() {
	return title;
    }

    /**
     * @param title
     *            the title to set
     */
    public void setTitle(String title) {
	this.title = title;
    }

    /**
     * @return the text
     */
    public String getText() {
	return text;
    }

    /**
     * @param text
     *            the text to set
     */
    public void setText(String text) {
	this.text = text;
    }

    /**
     * @return the userBean
     */
    public UserBean getUserBean() {
	return userBean;
    }

    /**
     * @param userBean
     *            the userBean to set
     */
    public void setUserBean(UserBean userBean) {
	this.userBean = userBean;
    }

    /**
     * @return the currentPost
     */
    public Post getCurrentPost() {
	return currentPost;
    }

    /**
     * @param currentPost
     *            the currentPost to set
     */
    public void setCurrentPost(Post currentPost) {
	// Implement as converter:
	// http://stackoverflow.com/questions/13335295/conversion-error-setting-value-userid-for-null-converter
	this.currentPost = currentPost;
    }
}
