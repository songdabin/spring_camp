package com.example.demo.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/post")
@Controller
public class PostController {
    //PathVariable => url에 있는 값을 변수로 받아올 수 있는 기능!!
    @GetMapping("/{page}")
    public String page(@PathVariable String page) {
        return "post/" + page;
    }

    @GetMapping("/{page}/{id}")
    public String page2(@PathVariable String page, @PathVariable String id) {
        return "post/" + page;
    }
}
