package com.divansir.arkhamsystem.controller;

import com.divansir.arkhamsystem.entity.Villains;
import com.divansir.arkhamsystem.service.VillainsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/villains")
@RequiredArgsConstructor
public class VillainsController {

    private final VillainsService villainsService;

    @GetMapping("/a")
    public String getVillains() {
        return "Lista de viloes";
    }

    @GetMapping("/")
    public List<Villains> getAllVillains() {
        return villainsService.getAllVillains();
    }
}
