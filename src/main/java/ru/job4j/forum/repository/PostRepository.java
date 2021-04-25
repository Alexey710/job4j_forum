package ru.job4j.forum.repository;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Post;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostRepository {

    private final List<Post> posts = new ArrayList<>();

    public PostRepository() {
        posts.add(Post.of("Продаю машину ладу 01."));
    }

    public void add(String name) {
        posts.add(Post.of(name));
    }

    public List<Post> getAll() {
        return posts;
    }
}
