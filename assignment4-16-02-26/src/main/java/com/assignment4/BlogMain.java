package com.assignment4;


public class BlogMain {

    public static void main(String[] args) {

        BlogService service = new BlogService();

        // 1️⃣ Register User
        service.registerUser("Driti", "driti@gmail.com", "1234");

        // 2️⃣ Create Post
        service.createPost(1, "Hibernate Guide", "Understanding JPA mappings");

        // 3️⃣ Update Post
        service.updatePost(1, "Hibernate Advanced Guide", "Deep dive into mappings");

        // 4️⃣ Add Comment
        service.addComment(1, 1, "Very helpful post!");

        // 5️⃣ Fetch Posts by User
        service.getPostsByUser(1);

        // 6️⃣ Fetch Comments of Post
        service.getCommentsOfPost(1);

        // 7️⃣ Fetch Comments by User
        service.getCommentsByUser(1);

        // 8️⃣ Delete Post
        service.deletePost(1);

        BlogService.closeFactory();

        System.out.println("All Blog operations executed successfully!");
    }
}
