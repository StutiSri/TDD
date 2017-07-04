package com.twu.mommifier;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MommifierTest {

    private Mommifier mommifier;

    @Before
    public void setUp(){
        mommifier = new Mommifier();
    }

    @Test
    public void shouldNotMommifyEmptyString(){
        assertEquals("", mommifier.mommify(""));
    }

    @Test
    public void shouldNotMommifyNonVowelString(){
        assertEquals("b", mommifier.mommify("b"));
    }

    @Test
    public void shouldMommifySingleVowelString(){
        assertEquals("mommy", mommifier.mommify("a"));
        assertEquals("mommy", mommifier.mommify("e"));
        assertEquals("mommy", mommifier.mommify("i"));
        assertEquals("mommy", mommifier.mommify("o"));
        assertEquals("mommy", mommifier.mommify("u"));
    }

    @Test
    public void shouldNotMommifyStringHavingLessThan30PercentVowels(){
        assertEquals("hard", mommifier.mommify("hard"));
    }

    @Test
    public void shouldNotMommifyStringHavingExactly30PercentVowels(){
        assertEquals("abcdefghij", mommifier.mommify("abcdefghij"));
    }

    @Test
    public void shouldMommifyStringHavingMoreThan30PercentVowels(){
        assertEquals("hmommyr", mommifier.mommify("her"));
    }

    @Test
    public void shouldReplaceOneContinuousSetOfVowelsWithWordMommy(){
        assertEquals("hmommyr", mommifier.mommify("hear"));
    }

    //TODO: In the input example do you have a continuous set of vowels?
    @Test
    public void shouldReplaceEachOccurrenceOfAContinuousSetOfVowelsWithWordMommy(){
        assertEquals("hmommyllmommy", mommifier.mommify("hello"));
    }

    @Test
    public void shouldMommifyStringHavingUppercaseCharacters(){
        assertEquals("pmommylmommy", mommifier.mommify("paULA"));
    }

    //TODO: What happens on null input?
}
