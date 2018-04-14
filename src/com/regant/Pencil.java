package com.regant;

public class Pencil {
    private int durability;
    public Pencil(int durability) {
        this.durability = durability;
    }

    public String write(String paper, String text) {
        for (char letter: text.toCharArray()) {
            if (Character.isUpperCase(letter)) {
                durability -= 2;
            } else {
                durability -= 1;
            }
        }
        return paper + text;
    }

    public int getDurability() {
        return durability;
    }
}
