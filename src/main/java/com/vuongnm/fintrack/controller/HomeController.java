package com.vuongnm.fintrack.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    // Khi user truy cập vào endpoint / thì homepage() được gọi
    @GetMapping("/")
    public String homepage() {
        return "index";  // Trả về trang index.html
    }

    // Có thể mapping thêm các endpoint khác nữa...
}