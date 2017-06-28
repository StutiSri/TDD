package com.twu.mommifier;

import java.util.ArrayList;
import java.util.List;

public class Mommifier {

    public static final String MOMMY = "mommy";

    public String mommify(String input) {
        String result = "";
        int count = 0;
        List<Character> vowels = getVowelList();
        for (char character : input.toCharArray()) {
            if (vowels.contains(character)) {
                count++;
            }
        }
        if (input.length() == 0 || (double)count / (double)input.length() < 0.03)
            return input;
        for (char character : input.toCharArray()) {
            if (!vowels.contains(character)) {
                result += character;
            } else {
                result += MOMMY;
            }
        }
        return result;
    }

    private List<Character> getVowelList() {
        List<Character> vowels = new ArrayList<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        return vowels;
    }
}
