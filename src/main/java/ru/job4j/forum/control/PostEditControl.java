package ru.job4j.forum.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.forum.repository.PostRepository;

@Controller
public class PostEditControl {
    @Autowired
    private PostRepository postRepository;

    @GetMapping("/edit")
    public String getEditPage() {
        return "posts/edit";
    }
}

