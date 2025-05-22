package com.example.galaxiexplorer.Controller;


import com.example.galaxiexplorer.Model.Planete;
import com.example.galaxiexplorer.Model.Utilisateur;
import com.example.galaxiexplorer.Service.GalaxyService;
import com.example.galaxiexplorer.Service.PlaneteService;
import com.example.galaxiexplorer.Service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Controller
public class PlaneteController {

    @Autowired
    private PlaneteService planeteService;

    @Autowired
    private GalaxyService galaxyService;

    @Autowired
    private UtilisateurService utilisateurService;

    @GetMapping("/Planetes/creer")
    public String showCreateForm(Model model) {
        model.addAttribute("planete", new Planete());
        model.addAttribute("galaxies", galaxyService.getAllGalaxies()); // 👈 ajoute ça
        return "authentification/planete/form";
    }


    @PostMapping("/Planetes/enregistrer")
    public String Enregistrer(@ModelAttribute Planete planete) {
        Utilisateur utilisateur = utilisateurService.getUtilisateurConnecte();

        if (utilisateur != null) {
            planete.setUtilisateur(utilisateur);
            planeteService.addPlanete(planete);
        }

        return "redirect:/";
    }

}
