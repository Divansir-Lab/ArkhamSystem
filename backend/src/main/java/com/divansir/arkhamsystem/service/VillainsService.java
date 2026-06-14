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
}
