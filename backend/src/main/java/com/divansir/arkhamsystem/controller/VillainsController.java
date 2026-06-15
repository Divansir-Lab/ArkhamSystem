package com.divansir.arkhamsystem.controller;

import com.divansir.arkhamsystem.entity.Villains;
import com.divansir.arkhamsystem.service.VillainsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/villains")
@RequiredArgsConstructor
public class VillainsController {

    private final VillainsService villainsService;

    @Operation(
        summary = "Get all villains",
        description = "Returns a list of all villains",
        tags = { "villains" }
    )
    @ApiResponses(
        value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved all villains"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
        }
    )
    @GetMapping
    public ResponseEntity<List<Villains>> getAllVillains() {
        return ResponseEntity.ok(villainsService.getAllVillains());
    }

    @Operation(
        summary = "Create villain",
        description = "Creates a new villain",
        tags = { "villains" }
    )
    @ApiResponses(
        value = {
            @ApiResponse(responseCode = "201", description = "Villain created"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
        }
    )
    @PostMapping
    public ResponseEntity<Villains> createVillain(@RequestBody Villains villain) {
        Villains createdVillain = villainsService.createVillain(villain);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdVillain);
    }

    @Operation(
        summary = "Update villain",
        description = "Updates a villain by id",
        tags = { "villains" }
    )
    @ApiResponses(
        value = {
            @ApiResponse(responseCode = "200", description = "Villain updated"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Villain not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
        }
    )
    @PutMapping("/{id}")
    public ResponseEntity<Villains> updateVillain(
        @PathVariable Long id,
        @RequestBody Villains villain
    ) {
        Villains updatedVillain = villainsService.updateVillain(id, villain);
        return ResponseEntity.ok(updatedVillain);
    }

    @Operation(
        summary = "Delete villain",
        description = "Deletes a villain by id",
        tags = { "villains" }
    )
    @ApiResponses(
        value = {
            @ApiResponse(responseCode = "204", description = "Villain deleted"),
            @ApiResponse(responseCode = "404", description = "Villain not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
        }
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVillain(@PathVariable Long id) {
        villainsService.deleteVillain(id);
        return ResponseEntity.noContent().build();
    }
}
