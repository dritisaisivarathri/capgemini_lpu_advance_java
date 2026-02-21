package com.assignment4;


public class BlogMain {

    public static void main(String[] args) {

        BlogService service = new BlogService();

        // Register User
        service.registerUser("Driti", "driti@gmail.com", "1234");

        //  Create Post
        service.createPost(1, "Hibernate Guide", "Understanding JPA mappings");

        // Update Post
        service.updatePost(1, "Hibernate Advanced Guide", "Deep dive into mappings");

        //  Add Comment
        service.addComment(1, 1, "Very helpful post!");

        //  Fetch Posts by User
        service.getPostsByUser(1);

        //  Fetch Comments of Post
        service.getCommentsOfPost(1);

        //  Fetch Comments by User
        service.getCommentsByUser(1);

        //  Delete Post
        service.deletePost(1);

        BlogService.closeFactory();

        System.out.println("All Blog operations executed successfully!");
    }
}
