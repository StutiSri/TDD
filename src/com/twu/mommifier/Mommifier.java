package com.twu.mommifier;

public class Mommifier {

    public static final String MOMMY = "mommy";

    public String mommify(String input) {
        String[] vowels = {"a", "e", "i", "o", "u"};
        for (String vowel : vowels) {
            if (input.contains(vowel)) {
                return MOMMY;
            }
        }
        return input;
    }
}
