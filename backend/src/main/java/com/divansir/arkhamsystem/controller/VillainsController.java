package com.divansir.arkhamsystem.controller;

import com.divansir.arkhamsystem.entity.Villains;
import com.divansir.arkhamsystem.service.VillainsService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/villains")
@RequiredArgsConstructor
public class VillainsController {

    private final VillainsService villainsService;

    public ResponseEntity<Villain> createVillain() {
        Villain villain = new Villain();

        return ResponseEntity.ok(villain);
    }

    @Operation(
        summary = "Get all villains",
        description = "Returns a list of all villains",
        tags = { "villains" }
    )
    @ApiResponses(
        value = {
            @ApiResponse(
                responseCode = "200",
                description = "Successfully retrieved all villains"
            ),
            @ApiResponse(responseCode = "204", description = "No content"),
            @ApiResponse(
                responseCode = "500",
                description = "Internal server error"
            ),
            @ApiResponse(
                responseCode = "404",
                description = "No villains found"
            ),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
        }
    )
    @GetMapping("/")
    public List<Villains> getAllVillains() {
        return villainsService.getAllVillains();
    }
}
