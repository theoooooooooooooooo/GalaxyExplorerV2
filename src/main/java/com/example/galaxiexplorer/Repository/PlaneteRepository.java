package com.example.galaxiexplorer.Repository;

import com.example.galaxiexplorer.Model.Planete;
import com.example.galaxiexplorer.Model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlaneteRepository extends JpaRepository<Planete, Long> {
    List<Planete> findAllByUtilisateur(Utilisateur utilisateur);
}