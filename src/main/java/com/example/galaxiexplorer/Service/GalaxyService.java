package com.example.galaxiexplorer.Service;

import com.example.galaxiexplorer.Model.Galaxy;
import com.example.galaxiexplorer.Repository.GalaxyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GalaxyService {

    @Autowired
    private GalaxyRepository galaxyRepository;

    public List<Galaxy> getAllGalaxies() {
        return (List<Galaxy>) galaxyRepository.findAll();
    }

    public Optional<Galaxy> getGalaxyById(Long id) {
        return galaxyRepository.findById(id);
    }

    public Galaxy addGalaxy(Galaxy galaxy) {
        return galaxyRepository.save(galaxy);
    }

    public void deleteGalaxyById(Long id) {
        galaxyRepository.deleteById(id);
    }
}
