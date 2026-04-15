package org.example.session08_baitap04.controller;

import jakarta.validation.Valid;
import org.example.session08_baitap04.dto.UserRegistrationDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        // Bắt buộc phải có dòng này để Thymeleaf bind dữ liệu vào form
        model.addAttribute("user", new UserRegistrationDto());
        return "register-test"; // Tên file HTML trong thư mục templates
    }

    @PostMapping("/register")
    public String handleRegister(@Valid @ModelAttribute("user") UserRegistrationDto user,
                                 BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "register-test"; // Nếu có lỗi (mật khẩu không khớp) sẽ hiện lại form
        }
        return "redirect:/auth/success";
    }
}