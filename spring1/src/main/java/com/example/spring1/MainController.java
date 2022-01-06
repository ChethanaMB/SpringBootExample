package com.example.spring1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("/welcome")
    public String welcome() {
        return "Hey Chethana";
    }
    
    @PostMapping("/addString")
    public String addString(@RequestBody Addition a){
        return "sum="+(a.a+a.b);
    }

    @GetMapping("/add/{a}/{b}")
    public int sum(@PathVariable int a, @PathVariable int b){
        return (a+b);
    }
}