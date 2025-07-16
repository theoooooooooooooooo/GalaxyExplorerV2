package com.example.galaxiexplorer.Controller;


import com.example.galaxiexplorer.Model.Planete;
import com.example.galaxiexplorer.Model.Utilisateur;
import com.example.galaxiexplorer.Service.GalaxyService;
import com.example.galaxiexplorer.Service.PlaneteService;
import com.example.galaxiexplorer.Service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

        return "redirect:/dashboard";
    }

    @GetMapping("/Planetes/details/{id}")
    public String details(@PathVariable Long id, Model model) {
        Planete planete = planeteService.getPlaneteById(id).orElse(null);
        model.addAttribute("planete", planete);
        return "authentification/planete/details";
    }

    @GetMapping("/Planetes/modifier/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Planete planete = planeteService.getPlaneteById(id).orElse(null);
        if (planete == null) {
            return "redirect:/"; // ou une page d'erreur
        }
        model.addAttribute("planete", planete);
        model.addAttribute("galaxies", galaxyService.getAllGalaxies());
        return "authentification/planete/form"; // même formulaire que création
    }

    @PostMapping("/Planetes/modifier/{id}")
    public String modifier(@PathVariable Long id, @ModelAttribute Planete updatedPlanete) {
        Planete existingPlanete = planeteService.getPlaneteById(id).orElse(null);
        if (existingPlanete != null) {
            existingPlanete.setNom(updatedPlanete.getNom());
            existingPlanete.setDescription(updatedPlanete.getDescription());
            existingPlanete.setPositionX(updatedPlanete.getPositionX());
            existingPlanete.setPositionY(updatedPlanete.getPositionY());
            existingPlanete.setType(updatedPlanete.getType());
            existingPlanete.setHabitable(updatedPlanete.getHabitable());
            existingPlanete.setGalaxy(updatedPlanete.getGalaxy());

            planeteService.addPlanete(existingPlanete);
        }
        return "redirect:/Planetes/details/" + id;
    }

    @GetMapping("/Planetes/supprimer/{id}")
    public String supprimer(@PathVariable Long id) {
        planeteService.deletePlanete(id);
        return "redirect:/";
    }


}
