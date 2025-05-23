package com.example.galaxiexplorer.Service;

import com.example.galaxiexplorer.Model.Planete;
import com.example.galaxiexplorer.Model.Utilisateur;
import com.example.galaxiexplorer.Repository.PlaneteRepository;
import com.example.galaxiexplorer.Repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class PlaneteService {

    @Autowired
    private PlaneteRepository planeteRepository;

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    public List<Planete> getAllPlanete() {
        return (List<Planete>) planeteRepository.findAll();
    }

    public Optional<Planete> getPlaneteById(Long id) {
        return planeteRepository.findById(id);
    }

    public Planete addPlanete(Planete planete) {
        return planeteRepository.save(planete); // <--- obligatoire
    }

    public void deletePlanete(Long id) {
        planeteRepository.deleteById(id);
    }

    public List<Planete> findAllByUsername(String username) {
        Optional<Utilisateur> utilisateur = utilisateurRepository.findByUsername(username);
        if (utilisateur.isEmpty()) {
            return Collections.emptyList();
        }
        return planeteRepository.findAllByUtilisateur(utilisateur.orElse(null));
    }

}
