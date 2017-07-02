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
        //TODO: This is duplicated in every test case.
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

    //TODO: Can you think of a different name? What do you want to do to consecutive vowels?
    @Test
    public void shouldReplaceOneContinuousSetOfVowelsWithWordMommy(){
        assertEquals("hmommyr", mommifier.mommify("hear"));
    }

    //TODO: What are the consecutive sets here?
    @Test
    public void shouldReplaceEachOccurrenceOfAContinuousSetOfVowelsWithWordMommy(){
        assertEquals("hmommyllmommy", mommifier.mommify("hello"));
    }

    //TODO: Can you think of more test cases? Sad path and edge cases or any others?
    @Test
    public void shouldMommifyStringHavingUppercaseCharacters(){
        assertEquals("pmommylmommy", mommifier.mommify("paULA"));
    }
}
