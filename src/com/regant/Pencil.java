package com.regant;

public class Pencil {
    private int durability;
    public Pencil(int durability) {
        this.durability = durability;
    }

    public String write(String paper, String text) {
        durability -= text.length();
        return paper + text;
    }

    public int getDurability() {
        return durability;
    }
}
