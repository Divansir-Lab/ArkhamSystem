package com.divansir.arkhamsystem.service;

import com.divansir.arkhamsystem.entity.Villains;
import com.divansir.arkhamsystem.repository.VillainsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VillainsService {

    private final VillainsRepository villainsRepository;

    public List<Villains> getAllVillains() {
        return villainsRepository.findAll();
    }

    public Villains createVillain(Villains villain) {
        return villainsRepository.save(villain);
    }

    public Villains updateVillain(Long id, Villains villain) {
        Villains existingVillain = villainsRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Villain not found"));

        existingVillain.setName(villain.getName());
        existingVillain.setDescription(villain.getDescription());
        existingVillain.setHeight(villain.getHeight());
        existingVillain.setWeight(villain.getWeight());
        existingVillain.setImageUrl(villain.getImageUrl());

        return villainsRepository.save(existingVillain);
    }
}
