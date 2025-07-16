package com.example.galaxiexplorer.Api;

import com.example.galaxiexplorer.Model.Galaxy;
import com.example.galaxiexplorer.Service.GalaxyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/galaxies")
@CrossOrigin(origins = "*") // autorise les appels depuis le front (CORS)
public class GalaxyRestController {

    @Autowired
    private GalaxyService galaxyService;

    @GetMapping
    public List<Galaxy> getAllGalaxies() {
        return galaxyService.getAllGalaxies();
    }

    @GetMapping("/{id}")
    public Optional<Galaxy> getGalaxyById(@PathVariable Long id) {
        return galaxyService.getGalaxyById(id);
    }

    @PostMapping
    public Galaxy createGalaxy(@RequestBody Galaxy galaxy) {
        return galaxyService.addGalaxy(galaxy);
    }

    @DeleteMapping("/{id}")
    public void deleteGalaxy(@PathVariable Long id) {
        galaxyService.deleteGalaxyById(id);
    }
}

