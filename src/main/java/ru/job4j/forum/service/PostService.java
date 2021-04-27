package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.repository.PostRepository;

import java.util.*;

@Service
public class PostService {
    private final PostRepository posts;

    public PostService(PostRepository posts) {
        this.posts = posts;
    }

    public List<Post> getAll() {
        List<Post> rsl = new ArrayList<>();
        posts.findAll().forEach(rsl::add);
        return rsl;
    }

    public Post findById(Long id) {
        Post post = null;
        Optional<Post> optPost = posts.findById(id);
        if (optPost.isPresent()) {
            post = optPost.get();
        }
        return post;
    }

    public void create(Post post) {
        Calendar current = new GregorianCalendar();
        post.setCreated(current);
        posts.save(post);
    }

}
