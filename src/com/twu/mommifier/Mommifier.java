package com.twu.mommifier;

import java.util.ArrayList;
import java.util.List;

public class Mommifier {

    public static final String MOMMY = "mommy";

    public String mommify(String input) {
        String result = "";
        boolean isSetMummified = false;
        int count = 0;
        List<Character> vowels = getVowelList();
        for (char character : input.toCharArray()) {
            if (vowels.contains(character)) {
                count++;
            }
        }
        if (input.length() == 0 || (double)count / (double)input.length() <= 0.3)
            return input;
        for (char character : input.toCharArray()) {
            if (!vowels.contains(character)) {
                result += character;
                isSetMummified = false;
            } else if(!isSetMummified){
                result += MOMMY;
                isSetMummified = true;
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
