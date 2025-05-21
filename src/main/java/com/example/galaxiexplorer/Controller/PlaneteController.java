package com.example.galaxiexplorer.Controller;

import com.example.galaxiexplorer.Model.Galaxy;
import com.example.galaxiexplorer.Model.Planete;
import com.example.galaxiexplorer.Model.Utilisateur;
import com.example.galaxiexplorer.Repository.UtilisateurRepository;
import com.example.galaxiexplorer.Service.GalaxyService;
import com.example.galaxiexplorer.Service.PlaneteService;
import com.example.galaxiexplorer.Service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
//        model.addAttribute("galaxies", galaxyService.getAllGalaxies());
        return "authentification/planete/form";
    }

    @PostMapping("/Planetes/enregistrer")
    public String Enregistrer(@ModelAttribute Planete planete) {
        Utilisateur utilisateur = utilisateurService.getUtilisateurConnecte();

        if (utilisateur != null) {
//            Long galaxyId = planete.getGalaxy().getId();
//
//            // Récupération complète de la galaxie depuis la base
//            galaxyService.getGalaxyById(galaxyId).ifPresent(planete::setGalaxy);

            // Ajout de l'utilisateur connecté
            planete.setUtilisateur(utilisateur);
//            System.out.println("Type reçu : " + planete.getType());
            // ENREGISTREMENT
            planeteService.addPlanete(planete); // <--- doit appeler .save()
        }

        return "redirect:/";
    }





}
