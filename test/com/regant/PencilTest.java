package com.regant;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PencilTest {
    Pencil pencil;
    String paper;

    @BeforeEach
    void setup(){
        pencil = new Pencil();
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
}