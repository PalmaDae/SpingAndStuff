package com.example.springstuff.controller;


import com.example.springstuff.dto.UserDto;
import com.example.springstuff.entity.UserEntity;
import com.example.springstuff.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RegistrationController {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String showForm(Model model) {
        model.addAttribute("userForm", new UserDto());
        return "registration";
    }

    @PostMapping("/registration")
    public String registerUser(
            @Valid @ModelAttribute("userForm") UserDto userDto,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes
    ) {
        if (!userDto.getPassword().equals(userDto.getPassCorrect())) {
            bindingResult.rejectValue("passCorrect", "error.userForm",
                    "Passwords do not match");
        }

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        UserEntity user = UserEntity.builder()
                .login(userDto.getLogin())
                .hash_pass(passwordEncoder.encode(userDto.getPassword()))
                .email(userDto.getEmail())
                .build();

        boolean created = userService.createUser(user);

        if (!created) {
            bindingResult.rejectValue("login", "error.userForm",
                    "User with this login already exists");
            return "registration";
        }

        redirectAttributes.addFlashAttribute("successMessage",
                "Registration successful!");

        return "redirect:/login";
    }
}