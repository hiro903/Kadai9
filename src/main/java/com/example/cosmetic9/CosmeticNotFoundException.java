package com.example.cosmetic9;

public class CosmeticNotFoundException extends RuntimeException {
    //コンストラクター
    public CosmeticNotFoundException(String massage) {
        super(massage);
    }
}
