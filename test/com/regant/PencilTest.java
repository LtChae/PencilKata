package com.regant;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PencilTest {
    Pencil pencil;
    String paper;

    @BeforeEach
    void setup(){
        pencil = new Pencil(100);
        paper = "";
    }

    @Test
    void aPencilCanWriteTextOnPaper (){
        paper = pencil.write(paper, "Test");
        assertEquals("Test", paper);
    }

    @Test
    void aPencilCanWriteLongerTextOnPaper (){
        String exampleString = "Testing the length of a sentence we can write to paper with a pencil";
        paper = pencil.write(paper, exampleString);
        assertEquals(exampleString, paper);
    }

    @Test
    void aPencilCanWriteTextToAPaperTwiceAndAppend (){
        paper = pencil.write(paper, "In the beginning,");
        paper = pencil.write(paper, " there was a pencil.");
        assertEquals("In the beginning, there was a pencil.", paper);
    }

    @Test
    void weCanGetTheDurabilityOfAPencil (){
        assertEquals(100, pencil.getDurability());
    }
}