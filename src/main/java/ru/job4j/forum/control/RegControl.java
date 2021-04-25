package ru.job4j.forum.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.security.core.userdetails.User;

@Controller
public class RegControl {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private final InMemoryUserDetailsManager inMemoryUserDetailsManager;

    public RegControl(InMemoryUserDetailsManager inMemoryUserDetailsManager) {
        this.inMemoryUserDetailsManager = inMemoryUserDetailsManager;
    }

    @PostMapping("/reg")
    public String save(@RequestParam(value = "username", required = false) String username,
                       @RequestParam(value = "password", required = false) String password) {
        password = passwordEncoder.encode(password);
        inMemoryUserDetailsManager.createUser(
                User.withUsername(username).password(password).roles("USER").build());
        return "redirect:/login";
    }

    @GetMapping("/reg")
    public String reg() {
        return "reg";
    }
}
