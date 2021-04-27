package ru.job4j.forum.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.service.PostService;

@Controller
public class PostCreateControl {
    @Autowired
    private PostService postService;

    @GetMapping("/create")
    public String getCreatePage() {
        return "post/create";
    }

    @PostMapping("/create")
    public String createPost(@ModelAttribute Post post) {
        postService.create(post);
        return "redirect:/";
    }
}
