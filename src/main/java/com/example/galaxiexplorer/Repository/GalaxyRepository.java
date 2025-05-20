package com.example.galaxiexplorer.Repository;

import com.example.galaxiexplorer.Model.Galaxy;
import org.springframework.data.repository.CrudRepository;

public interface GalaxyRepository extends CrudRepository<Galaxy, Long> {
}