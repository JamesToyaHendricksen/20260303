package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/todo")
public class TodoController {

    @GetMapping
    public String list(Model model) {
        List<TodoItem> todos = List.of(
                new TodoItem(1L, "Set up environment", "OPEN"),
                new TodoItem(2L, "Build list page", "IN_PROGRESS"),
                new TodoItem(3L, "Verify behavior", "DONE")
        );

        model.addAttribute("todos", todos);
        return "todo/list";
    }

    @GetMapping("/new")
    public String showNewForm() {
        return "todo/form";
    }

    @PostMapping("/confirm")
    public String confirm(@RequestParam("title") String title, Model model) {
        model.addAttribute("title", title);
        return "todo/confirm";
    }

    @GetMapping("/complete")
    public String showComplete() {
        return "todo/complete";
    }

    public record TodoItem(Long id, String title, String status) {
    }
}