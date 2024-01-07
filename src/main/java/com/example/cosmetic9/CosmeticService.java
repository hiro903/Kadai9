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
        Optional<Cosmetic> cosmetic = this.cosmeticMapper.findBYId(id);
        if (cosmetic.isPresent()) {
            //isPresent⇒存在する、ブーリアン型のメソッド

            return cosmetic.get();
        } else {
            throw new CosmeticNotFoundException("cosmetic" + id + "not found");
        }
    }
}
