package com.example.galaxiexplorer.Repository;

import com.example.galaxiexplorer.Model.Planete;
import org.springframework.data.repository.CrudRepository;

public interface PlaneteRepository extends CrudRepository<Planete, Long> {
}