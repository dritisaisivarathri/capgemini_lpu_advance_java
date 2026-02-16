package com.assignment4;



import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class BlogService {

    private static EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("blog");

    // =========================
    // 1️⃣ Register New User
    // =========================
    public void registerUser(String name, String email, String password) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);

        et.begin();
        em.persist(user);
        et.commit();

        em.close();
    }

    // =========================
    // 2️⃣ Create Post
    // =========================
    public void createPost(int userId, String title, String content) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        User user = em.find(User.class, userId);

        if (user == null) {
            System.out.println("User not found!");
            return;
        }

        Post post = new Post();
        post.setTitle(title);
        post.setContent(content);
        post.setCreatedAt(LocalDateTime.now());
        post.setUpdatedAt(LocalDateTime.now());
        post.setAuthor(user);

        et.begin();
        em.persist(post);
        et.commit();

        em.close();
    }

    // =========================
    // 3️⃣ Update Post
    // =========================
    public void updatePost(int postId, String newTitle, String newContent) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        Post post = em.find(Post.class, postId);

        if (post == null) {
            System.out.println("Post not found!");
            return;
        }

        et.begin();
        post.setTitle(newTitle);
        post.setContent(newContent);
        post.setUpdatedAt(LocalDateTime.now());
        et.commit();

        em.close();
    }

    // =========================
    // 4️⃣ Delete Post
    // =========================
    public void deletePost(int postId) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        Post post = em.find(Post.class, postId);

        if (post == null) {
            System.out.println("Post not found!");
            return;
        }

        et.begin();
        em.remove(post);
        et.commit();

        em.close();
    }

    // =========================
    // 5️⃣ Add Comment
    // =========================
    public void addComment(int userId, int postId, String commentText) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        User user = em.find(User.class, userId);
        Post post = em.find(Post.class, postId);

        if (user == null || post == null) {
            System.out.println("User or Post not found!");
            return;
        }

        Comment comment = new Comment();
        comment.setContent(commentText);
        comment.setCreatedAt(LocalDateTime.now());
        comment.setAuthor(user);
        comment.setPost(post);

        et.begin();
        em.persist(comment);
        et.commit();

        em.close();
    }

    // =========================
    // 6️⃣ Fetch All Posts by User
    // =========================
    public void getPostsByUser(int userId) {

        EntityManager em = emf.createEntityManager();

        User user = em.find(User.class, userId);

        if (user == null) {
            System.out.println("User not found!");
            return;
        }

        List<Post> posts = user.getPosts();

        for (Post p : posts) {
            System.out.println("Post ID: " + p.getId());
            System.out.println("Title: " + p.getTitle());
            System.out.println("Content: " + p.getContent());
            System.out.println("----------------------");
        }

        em.close();
    }

    // =========================
    // 7️⃣ Fetch All Comments of Post
    // =========================
    public void getCommentsOfPost(int postId) {

        EntityManager em = emf.createEntityManager();

        Post post = em.find(Post.class, postId);

        if (post == null) {
            System.out.println("Post not found!");
            return;
        }

        List<Comment> comments = post.getComments();

        for (Comment c : comments) {
            System.out.println("Comment ID: " + c.getId());
            System.out.println("Comment: " + c.getContent());
            System.out.println("----------------------");
        }

        em.close();
    }

    // =========================
    // 8️⃣ Fetch All Comments by User
    // =========================
    public void getCommentsByUser(int userId) {

        EntityManager em = emf.createEntityManager();

        User user = em.find(User.class, userId);

        if (user == null) {
            System.out.println("User not found!");
            return;
        }

        List<Comment> comments = user.getComments();

        for (Comment c : comments) {
            System.out.println("Comment ID: " + c.getId());
            System.out.println("Comment: " + c.getContent());
            System.out.println("----------------------");
        }

        em.close();
    }

    // =========================
    // Close Factory
    // =========================
    public static void closeFactory() {
        emf.close();
    }
}
