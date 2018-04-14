package com.regant;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PencilTest {

    @Test
    void aPencilCanWriteTextOnPaper (){
        Pencil pencil = new Pencil();
        String paper = "";
        paper = pencil.write(paper, "Test");
        assertEquals("Test", paper);
    }

    @Test
    void aPencilCanWriteLongerTextOnPaper (){
        String exampleString = "Testing the length of a sentence we can write to paper with a pencil";
        Pencil pencil = new Pencil();
        String paper = "";
        paper = pencil.write(paper, exampleString);
        assertEquals(exampleString, paper);
    }
}