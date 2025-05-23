package com.example.galaxiexplorer.Controller;

import com.example.galaxiexplorer.Model.Galaxy;
import com.example.galaxiexplorer.Model.Planete;
import com.example.galaxiexplorer.Service.GalaxyService;
import com.example.galaxiexplorer.Service.PlaneteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private GalaxyService galaxyService;
    @Autowired
    private PlaneteService planeteService;

    @GetMapping("/")
    public String home(Model model) {
        List<Galaxy> galaxies = galaxyService.getAllGalaxies();
        for (Galaxy g : galaxies) {
            System.out.println("Galaxy: " + g.getNom());
            System.out.println("Planètes: " + g.getPlanetes());

        }
        model.addAttribute("galaxies", galaxies);
        return "public/home";
    }

}
