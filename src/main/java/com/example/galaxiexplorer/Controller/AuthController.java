package com.example.galaxiexplorer.Controller;

import com.example.galaxiexplorer.Model.Planete;
import com.example.galaxiexplorer.Model.Utilisateur;
import com.example.galaxiexplorer.Repository.PlaneteRepository;
import com.example.galaxiexplorer.Repository.UtilisateurRepository;
import com.example.galaxiexplorer.Service.PlaneteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AuthController {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private PlaneteService planeteService;

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("utilisateur", new Utilisateur());
        return "authentification/formCreate";
    }

    @PostMapping("/register")
    public String processRegisterForm(Utilisateur utilisateur, Model model) {
        utilisateur.setPassword(passwordEncoder.encode(utilisateur.getPassword()));
        utilisateurRepository.save(utilisateur);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        return "authentification/formLog";
    }

    @GetMapping("/dashboard")
    public String dashboard(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        String username = userDetails.getUsername();

        // Suppose que tu as un service qui récupère les planètes par utilisateur
        List<Planete> planetes = planeteService.findAllByUsername(username);

        model.addAttribute("planetes", planetes);
        return "authentification/dashboard";  // nom de ta vue Thymeleaf dashboard.html
    }
}
