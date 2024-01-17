package com.example.cosmetic9;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CosmeticController {

    private final CosmeticService cosmeticService;

    public CosmeticController(CosmeticService cosmeticService) {
        this.cosmeticService = cosmeticService;
    }

    @GetMapping("/cosmetics/{id}")
    public ResponseEntity<Cosmetic> getCosmetic(@PathVariable("id") int id) {
        return ResponseEntity.ok(cosmeticService.findCosmetic(id));
    }
}
