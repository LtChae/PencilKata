package com.regant;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PencilTest {
    Pencil pencil;
    String paper;

    @BeforeEach
    void setup(){
        pencil = new Pencil(100, 10);
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

    @Test
    void writingALowerCaseLetterDecreasesTheDurabilityOfAPencilByOne (){
        pencil.write(paper, "a");
        assertEquals(99, pencil.getDurability());
    }

    @Test
    void writingASeriesOfLowerCaseLettersDecreasesTheDurabilityOfAPencilByOnePerLetter (){
        pencil.write(paper, "series");
        assertEquals(94, pencil.getDurability());
    }

    @Test
    void writingAnUpperCaseLetterDecreasesTheDurabilityOfAPencilByTwo (){
        pencil.write(paper, "A");
        assertEquals(98, pencil.getDurability());
    }

    @Test
    void writingAMixedCaseStringDecreasesTheDurabilityOfAPencilByTheAppropriateAmount (){
        pencil.write(paper, "Assert");
        assertEquals(93, pencil.getDurability());
    }

    @Test
    void writingASpaceDoesNotDecreaseTheDurabilityOfAPencil (){
        pencil.write(paper, " ");
        assertEquals(100, pencil.getDurability());
    }

    @Test
    void aPencilWithoutDurabilityWritesSpacesInsteadOfCharacters (){
        Pencil dullPencil = new Pencil(0, 1);
        paper = dullPencil.write(paper, "This");
        assertEquals("    ", paper);
    }

    @Test
    void aPencilWritesSpacesInsteadOfCharactersAfterRunningOutOfDurability (){
        Pencil dullPencil = new Pencil(4, 1);
        paper = dullPencil.write(paper, "This");
        assertEquals("Thi ", paper);
    }

    @Test
    void aPencilCanBeResharpenedToItsOriginalDurability (){
        pencil.write(paper, "This is a test");
        pencil.sharpen();
        assertEquals(100, pencil.getDurability());
    }

    @Test
    void weCanGetTheLengthOfAPencil (){
        assertEquals(10, pencil.getLength());
    }

    @Test
    void weCanGetTheLengthOfALongPencil (){
        Pencil longPencil = new Pencil(20, 100);
        assertEquals(100, longPencil.getLength());
    }

    @Test
    void sharpeningAPencilDecreasesTheLengthOfAPencilByOne (){
        pencil.sharpen();
        assertEquals(9, pencil.getLength());
    }

    @Test
    void sharpeningAPencilWithALengthOfZeroDoesNotRestoreDurability (){
        Pencil stubbyPencil = new Pencil(100, 0);
        stubbyPencil.write(paper, "Word");
        stubbyPencil.sharpen();
        assertEquals(95, stubbyPencil.getDurability());
    }

    @Test
    void aPencilCanEraseTheLastOccurrenceOfTextFromAPaper (){
        paper = "How much wood would a woodchuck chuck if a woodchuck could chuck wood?";
        paper = pencil.erase(paper, "chuck");
        assertEquals("How much wood would a woodchuck chuck if a woodchuck could       wood?", paper);
    }

    @Test
    void aPencilCanEraseTheLastOccurrenceOfDifferentTextFromAPaper (){
        paper = "How much wood would a woodchuck chuck if a woodchuck could chuck wood?";
        paper = pencil.erase(paper, "could");
        assertEquals("How much wood would a woodchuck chuck if a woodchuck       chuck wood?", paper);
    }

    @Test
    void aPencilCanEraseTheLastOccurrenceOfDifferentTextFromAPaperTwice (){
        paper = "How much wood would a woodchuck chuck if a woodchuck could chuck wood?";
        paper = pencil.erase(paper, "wood");
        paper = pencil.erase(paper, "wood");
        assertEquals("How much wood would a woodchuck chuck if a     chuck could chuck     ?", paper);
    }
}