package com.twu.mommifier;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class MommifierTest {

    private Mommifier mommifier;

    @Before
    public void setUp() {
        mommifier = new Mommifier();
    }

    @Test
    public void shouldNotMommifyEmptyString() {
        assertEquals("", mommifier.mommify(""));
    }

    @Test
    public void shouldNotMommifyNonVowelString() {
        assertEquals("b", mommifier.mommify("b"));
    }

    @Test
    public void shouldMommifySingleVowelString() {
        assertEquals("mommy", mommifier.mommify("a"));
        assertEquals("mommy", mommifier.mommify("e"));
        assertEquals("mommy", mommifier.mommify("i"));
        assertEquals("mommy", mommifier.mommify("o"));
        assertEquals("mommy", mommifier.mommify("u"));
    }

    @Test
    public void shouldNotMommifyStringHavingLessThan30PercentVowels() {
        assertEquals("hard", mommifier.mommify("hard"));
    }

    @Test
    public void shouldNotMommifyStringHavingExactly30PercentVowels() {
        assertEquals("abcdefghij", mommifier.mommify("abcdefghij"));
    }

    @Test
    public void shouldMommifyStringHavingMoreThan30PercentVowels() {
        assertEquals("hmommyr", mommifier.mommify("her"));
    }

    @Test
    public void shouldReplaceOneContinuousSetOfVowelsWithWordMommy() {
        assertEquals("hmommyr", mommifier.mommify("hear"));
    }

    /*
        TODO: I am confused as to what are you trying to test.
        Are you testing that multiple vowels in string should be replaced or
        consecutive vowels should be replaced?
     */
    @Test
    public void shouldReplaceEachOccurrenceOfAContinuousSetOfVowelsWithWordMommy() {
        assertEquals("hmommyllmommy", mommifier.mommify("heaelloee"));
    }

    @Test
    public void shouldMommifyStringHavingUppercaseCharacters() {
        assertEquals("pmommylmommy", mommifier.mommify("paULA"));
    }

    @Test
    public void shouldNotMommifyNullString() {
        assertNull(mommifier.mommify(null));
    }
}
