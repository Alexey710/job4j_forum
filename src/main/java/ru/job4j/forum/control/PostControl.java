package ru.job4j.forum.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.forum.service.PostService;

@Controller
public class PostControl {
    @Autowired
    private PostService postService;

    @PostMapping("/create")
    public String addPost(@RequestParam(value = "name", required = false) String name, Model model) {
        //postService.add(name);
        model.addAttribute("posts", postService.getAll());
        return "index";
    }

    @GetMapping("/create")
    public String getCreatePage() {
        return "posts/create";
    }
}
