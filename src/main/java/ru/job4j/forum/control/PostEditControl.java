package ru.job4j.forum.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.job4j.forum.service.PostService;

@Controller
public class PostEditControl {
    @Autowired
    private PostService postService;

    @GetMapping("/edit")
    public String getEditPage() {
        return "posts/edit";
    }
}

