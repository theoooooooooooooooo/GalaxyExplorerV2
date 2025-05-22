package com.example.galaxiexplorer.Controller;

import com.example.galaxiexplorer.Model.Galaxy;
import com.example.galaxiexplorer.Service.GalaxyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GalaxyController {

    @Autowired
    private GalaxyService galaxyService;

    @GetMapping("/Galaxy/creer")
    public String Galaxy(Model model) {
        model.addAttribute("galaxy", new Galaxy());
        return "public/galaxy/form";
    }

    @PostMapping("/Galaxy/enregistrer")
    public String Enregistrer(@ModelAttribute Galaxy galaxy) {
        galaxyService.addGalaxy(galaxy);
        return "redirect:/";
    }
}
