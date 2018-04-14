package com.regant;

public class Pencil {
    private int eraserDurability;
    private int tipDurability;
    private int initialTipDurability;
    private int length;

    public Pencil(int tipDurability, int length, int eraserDurability) {
        this.tipDurability = tipDurability;
        this.initialTipDurability = tipDurability;
        this.length = length;
        this.eraserDurability = eraserDurability;
    }

    public String write(String paper, String text) {
        for (char letter: text.toCharArray()) {
            if (tipDurability > 0) {
                if (Character.isUpperCase(letter)) {
                    tipDurability -= 2;
                } else if (Character.isLowerCase(letter)) {
                    tipDurability -= 1;
                }
                paper += letter;
            } else {
                paper += " ";
            }
        }
        return paper;
    }

    public int getTipDurability() {
        return tipDurability;
    }

    public void sharpen() {
        if (length > 0) {
            length--;
            tipDurability = initialTipDurability;
        }
    }

    public int getLength() {
        return length;
    }

    public String erase(String paper, String text) {
        int indexOfLastOccurrence = paper.lastIndexOf(text);
        char[] paperCharacters = paper.toCharArray();
        if (indexOfLastOccurrence >= 0) {
            for (int i = indexOfLastOccurrence + text.length() - 1; i >= indexOfLastOccurrence; i--) {
                if (eraserDurability > 0) {
                    if (paperCharacters[i] != ' ') {
                        eraserDurability--;
                    }
                    paperCharacters[i] = ' ';
                }
            }
        }
        return new String(paperCharacters);
    }

    public int getEraserDurability() {
        return eraserDurability;
    }

    public String edit(String paper, String replacementText) {
        int indexOfFirstBlankSpace = paper.indexOf("  ");
        char[] paperCharacters = paper.toCharArray();
        char[] replacementCharacters = replacementText.toCharArray();
        if (indexOfFirstBlankSpace != 0){
            indexOfFirstBlankSpace++;
        }
        if (indexOfFirstBlankSpace >= 0) {
            for (int i = indexOfFirstBlankSpace; i < replacementText.length() + indexOfFirstBlankSpace; i++) {
                char letter = replacementCharacters[i - indexOfFirstBlankSpace];
                if (Character.isUpperCase(letter)) {
                    tipDurability -= 2;
                } else if (Character.isLowerCase(letter)) {
                    tipDurability -= 1;
                }
                if (paperCharacters[i] == ' ') {
                    paperCharacters[i] = letter;
                } else {
                    paperCharacters[i] = '@';
                }

            }
        }
        return new String(paperCharacters);
    }
}
