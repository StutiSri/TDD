package com.twu.mommifier;

import org.junit.Test;

import java.lang.annotation.Target;

import static org.junit.Assert.assertEquals;

public class MommifierTest {

    @Test
    public void shouldNotMommifyEmptyString(){
        Mommifier mommifier = new Mommifier();
        assertEquals("", mommifier.mommify(""));
    }

    @Test
    public void shouldNotMommifyNonVowelString(){
        Mommifier mommifier = new Mommifier();
        assertEquals("b", mommifier.mommify("b"));
    }

    @Test
    public void shouldMommifyVowelString(){
        Mommifier mommifier = new Mommifier();
        assertEquals("mommy", mommifier.mommify("a"));
        assertEquals("mommy", mommifier.mommify("i"));
    }

}
