package com.example.galaxiexplorer.Repository;

import com.example.galaxiexplorer.Model.Planete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface PlaneteRepository extends JpaRepository<Planete, Long> {
}