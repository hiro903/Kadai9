package com.example.cosmetic9;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CosmeticService {
    public final CosmeticMapper cosmeticMapper;

    public CosmeticService(CosmeticMapper cosmeticMapper) {
        this.cosmeticMapper = cosmeticMapper;
    }

    public Cosmetic findCosmetic(int id) {
        Optional<Cosmetic> cosmetic = this.cosmeticMapper.findById(id);
        return cosmetic.orElseThrow(() -> new CosmeticNotFoundException("Cosmetic with id " + id + " not found"));
    }
}
