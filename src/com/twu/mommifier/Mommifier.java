package com.twu.mommifier;

import java.util.ArrayList;
import java.util.List;

public class Mommifier {

    public static final String MOMMY = "mommy";
    private final List<Character> vowelList = getVowelList();

    public String mommify(String input) {
        if (!canBeMummified(input))
            return input;

        StringBuilder result = new StringBuilder();
        boolean isVowelSetMummified = false;
        for (char character : input.toCharArray()) {
            if (!vowelList.contains(character)) {
                result.append(character);
                isVowelSetMummified = false;
            } else if (!isVowelSetMummified) {
                result.append(MOMMY);
                isVowelSetMummified = true;
            }
        }

        return result.toString();
    }

    private boolean canBeMummified(String input) {
        int count = getCountOfVowels(input);
        if (input.length() == 0 || (double) count / (double) input.length() <= 0.30)
            return false;
        return true;
    }

    private int getCountOfVowels(String input) {
        int count = 0;
        for (char character : input.toCharArray()) {
            if (vowelList.contains(character)) {
                count++;
            }
        }
        return count;
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
