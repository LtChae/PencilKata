package com.regant;

public class Pencil {
    private int durability;
    private int initialDurability;
    public Pencil(int durability) {
        this.durability = durability;
        this.initialDurability = durability;
    }

    public String write(String paper, String text) {
        for (char letter: text.toCharArray()) {
            if (durability > 0) {
                if (Character.isUpperCase(letter)) {
                    durability -= 2;
                } else if (Character.isLowerCase(letter)) {
                    durability -= 1;
                }
                paper += letter;
            } else {
                paper += " ";
            }
        }
        return paper;
    }

    public int getDurability() {
        return durability;
    }

    public void sharpen() {
        durability = initialDurability;
    }

    public int getLength() {
        return 4;
    }
}
