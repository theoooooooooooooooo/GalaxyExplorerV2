package com.example.galaxiexplorer.Service;

import com.example.galaxiexplorer.Model.Planete;
import com.example.galaxiexplorer.Repository.PlaneteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaneteService {

    @Autowired
    private PlaneteRepository planeteRepository;

    public List<Planete> getAllPlanete(){
        return (List<Planete>) planeteRepository.findAll();
    }

    public Optional<Planete> getPlaneteById(Long id){
        return planeteRepository.findById(id);
    }

    public Planete addPlanete(Planete planete){
        return planeteRepository.save(planete);
    }

    public void deletePlanete(Long id){
        planeteRepository.deleteById(id);
    }
}
