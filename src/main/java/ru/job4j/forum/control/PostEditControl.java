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
public class PostEditControl {
    @Autowired
    private PostService postService;

    @GetMapping("/edit")
    public String getEditPage(@RequestParam(value = "id", required = false) String id,
                              @RequestParam(value = "name", required = false) String name,
                              Model model) {
        model.addAttribute("id", id);
        model.addAttribute("name", name);
        return "post/edit";
    }

    @PostMapping("/edit")
    public String updateName(@ModelAttribute Post post,
                             @RequestParam(value = "name_form", required = false) String name,
                              Model model) {
        post.setName(name);
        System.out.println(post);
        postService.create(post);
        return "redirect:/";
    }
}

