package com.twu.mommifier;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MommifierTest {
    @Test
    public void shouldNotMommifyEmptyString(){
        //TODO: This is duplicated in every test case.
        Mommifier mommifier = new Mommifier();
        assertEquals("", mommifier.mommify(""));
    }

    @Test
    public void shouldNotMommifyNonVowelString(){
        Mommifier mommifier = new Mommifier();
        assertEquals("b", mommifier.mommify("b"));
    }

    @Test
    public void shouldMommifySingleVowelString(){
        Mommifier mommifier = new Mommifier();
        assertEquals("mommy", mommifier.mommify("a"));
        assertEquals("mommy", mommifier.mommify("e"));
        assertEquals("mommy", mommifier.mommify("i"));
        assertEquals("mommy", mommifier.mommify("o"));
        assertEquals("mommy", mommifier.mommify("u"));
    }

    @Test
    public void shouldNotMommifyStringHavingLessThan30PercentVowels(){
        Mommifier mommifier = new Mommifier();
        assertEquals("hard", mommifier.mommify("hard"));
    }

    @Test
    public void shouldNotMommifyStringHavingExactly30PercentVowels(){
        Mommifier mommifier = new Mommifier();
        assertEquals("abcdefghij", mommifier.mommify("abcdefghij"));
    }

    @Test
    public void shouldMommifyStringHavingMoreThan30PercentVowels(){
        Mommifier mommifier = new Mommifier();
        assertEquals("hmommyr", mommifier.mommify("her"));
    }

    //TODO: Can you think of a different name? What do you want to do to consecutive vowels?
    @Test
    public void shouldMommifyStringHavingMoreThan30PercentVowelsInAConsecutiveSet(){
        Mommifier mommifier = new Mommifier();
        assertEquals("hmommyr", mommifier.mommify("hear"));
    }

    //TODO: What are the consecutive sets here?
    @Test
    public void shouldMommifyStringHavingMoreThan30PercentVowelsInTwoConsecutiveSets(){
        Mommifier mommifier = new Mommifier();
        assertEquals("hmommyllmommy", mommifier.mommify("hello"));
    }

    //TODO: Can you think of more test cases? Sad path and edge cases or any others?
}
