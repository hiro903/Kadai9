package com.example.cosmetic9;

public class Cosmetic {
    private int id;
    private String name;
    private String effect;

    public Cosmetic(int id, String name, String effect) {
        this.id = id;
        this.name = name;
        this.effect = effect;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEffect() {
        return effect;
    }
}
