package com.divansir.arkhamsystem.service;

import com.divansir.arkhamsystem.entity.Villains;
import com.divansir.arkhamsystem.repository.VillainsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VillainsService {

    private final VillainsRepository villainsRepository;

    public List<Villains> getAllVillains() {
        return villainsRepository.findAll();
    }

    public Optional<Villains> getVillainById(Long id) {
        return villainsRepository.findById(id);
    }

    public Villains createVillain(Villains villain) {
        return villainsRepository.save(villain);
    }

    public Optional<Villains> updateVillain(Long id, Villains villain) {
        return villainsRepository.findById(id).map(existingVillain -> {
            existingVillain.setName(villain.getName());
            existingVillain.setDescription(villain.getDescription());
            existingVillain.setHeight(villain.getHeight());
            existingVillain.setWeight(villain.getWeight());
            existingVillain.setImageUrl(villain.getImageUrl());

            return villainsRepository.save(existingVillain);
        });
    }

    public boolean deleteVillain(Long id) {
        if (!villainsRepository.existsById(id)) {
            return false;
        }

        villainsRepository.deleteById(id);
        return true;
    }
}
