package com.regant;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PencilTest {
    Pencil pencil;
    String paper;

    @BeforeEach
    void setup(){
        pencil = new Pencil(100, 10, 50);
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
        assertEquals(100, pencil.getTipDurability());
    }

    @Test
    void writingALowerCaseLetterDecreasesTheDurabilityOfAPencilByOne (){
        pencil.write(paper, "a");
        assertEquals(99, pencil.getTipDurability());
    }

    @Test
    void writingASeriesOfLowerCaseLettersDecreasesTheDurabilityOfAPencilByOnePerLetter (){
        pencil.write(paper, "series");
        assertEquals(94, pencil.getTipDurability());
    }

    @Test
    void writingAnUpperCaseLetterDecreasesTheDurabilityOfAPencilByTwo (){
        pencil.write(paper, "A");
        assertEquals(98, pencil.getTipDurability());
    }

    @Test
    void writingAMixedCaseStringDecreasesTheDurabilityOfAPencilByTheAppropriateAmount (){
        pencil.write(paper, "Assert");
        assertEquals(93, pencil.getTipDurability());
    }

    @Test
    void writingASpaceDoesNotDecreaseTheDurabilityOfAPencil (){
        pencil.write(paper, " ");
        assertEquals(100, pencil.getTipDurability());
    }

    @Test
    void aPencilWithoutDurabilityWritesSpacesInsteadOfCharacters (){
        Pencil dullPencil = new Pencil(0, 1, 50);
        paper = dullPencil.write(paper, "This");
        assertEquals("    ", paper);
    }

    @Test
    void aPencilWritesSpacesInsteadOfCharactersAfterRunningOutOfDurability (){
        Pencil dullPencil = new Pencil(4, 1, 50);
        paper = dullPencil.write(paper, "This");
        assertEquals("Thi ", paper);
    }

    @Test
    void aPencilCanBeResharpenedToItsOriginalDurability (){
        pencil.write(paper, "This is a test");
        pencil.sharpen();
        assertEquals(100, pencil.getTipDurability());
    }

    @Test
    void weCanGetTheLengthOfAPencil (){
        assertEquals(10, pencil.getLength());
    }

    @Test
    void weCanGetTheLengthOfALongPencil (){
        Pencil longPencil = new Pencil(20, 100, 50);
        assertEquals(100, longPencil.getLength());
    }

    @Test
    void sharpeningAPencilDecreasesTheLengthOfAPencilByOne (){
        pencil.sharpen();
        assertEquals(9, pencil.getLength());
    }

    @Test
    void sharpeningAPencilWithALengthOfZeroDoesNotRestoreDurability (){
        Pencil stubbyPencil = new Pencil(100, 0, 50);
        stubbyPencil.write(paper, "Word");
        stubbyPencil.sharpen();
        assertEquals(95, stubbyPencil.getTipDurability());
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

    @Test
    void aPencilWillNotEraseTextItCannotFind (){
        paper = "How much wood would a woodchuck chuck if a woodchuck could chuck wood?";
        paper = pencil.erase(paper, "stork");
        assertEquals(paper, paper);
    }

    @Test
    void aPencilCanBeCreatedWithAnEraserDurabilityAndWeCanGetIt (){
        Pencil pencilWithEraser = new Pencil(100, 100, 50);
        assertEquals(50, pencilWithEraser.getEraserDurability());
    }

    @Test
    void aPencilCanBeCreatedWithALargeEraserDurabilityAndWeCanGetIt (){
        Pencil pencilWithEraser = new Pencil(100, 100, 1000);
        assertEquals(1000, pencilWithEraser.getEraserDurability());
    }

    @Test
    void whenTextIsErasedTheEraserDurabilityIsDecreasedByOnePerCharacter (){
        paper = "This is a test";
        pencil.erase(paper, "test");
        assertEquals(46, pencil.getEraserDurability());
    }

    @Test
    void whenTextIsErasedTheEraserDurabilityIsNotDecreasedForWhitespace (){
        paper = "This is a test";
        pencil.erase(paper, "a test");
        assertEquals(45, pencil.getEraserDurability());
    }

    @Test
    void whenAnEraserRunsOutOfDurabilityItStopsErasingInTheOppositeOrderOfWriting (){
        Pencil pencilWithWornEraser = new Pencil(100, 100, 3);
        paper = "This is a test";
        paper = pencilWithWornEraser.erase(paper, "a test");
        assertEquals("This is a t   ", paper);
    }

    @Test
    void whenAnEraserStartsWithNoDurabilityNothingIsErased (){
        Pencil pencilWithWornEraser = new Pencil(100, 100, 3);
        paper = "This is a test";
        paper = pencilWithWornEraser.erase(paper, "a test");
        assertEquals(paper, paper);
    }

    @Test
    void aPencilCanBeUsedToEditExistingText (){
        paper = "This is a     ";
        paper = pencil.edit(paper, "text");
        assertEquals("This is a text", paper);
    }

    @Test
    void aPencilCanBeUsedToEditAnyExistingText (){
        paper = "An       a day keeps the doctor away";
        paper = pencil.edit(paper, "onion");
        assertEquals("An onion a day keeps the doctor away", paper);
    }
}