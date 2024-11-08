package mk.ukim.finki.aud.web.controller;

import mk.ukim.finki.aud.model.exceptions.InvalidArgumentsException;
import mk.ukim.finki.aud.model.exceptions.InvalidUserCredetialsExceptions;
import mk.ukim.finki.aud.model.exceptions.PasswordDoNotMatchException;
import mk.ukim.finki.aud.service.AuthService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/register")
public class RegisterController {

    private final AuthService authService;

    public RegisterController(AuthService authService) {
        this.authService = authService;
    }
    @GetMapping
    public String getRegisterPage(@RequestParam(required = false) String error, Model model){
        if(error != null && !error.isEmpty()){
            model.addAttribute("hasError",true);
            model.addAttribute("error",error);
        }
        return "register";
    }

    @PostMapping
    public String register(@RequestParam String username, @RequestParam String password,@RequestParam String repeatPassword,@RequestParam String name,@RequestParam String surname){
        try {
            this.authService.register(username, password, repeatPassword, name, surname);
            return "redirect:/login";
        }catch (PasswordDoNotMatchException | InvalidArgumentsException exception){
            return "redirect:/register?error="+ exception.getMessage();
        }

    }
}
