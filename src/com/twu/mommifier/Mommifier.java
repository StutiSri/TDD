package com.twu.mommifier;

import java.util.ArrayList;
import java.util.List;

//TODO: Be consistent with mommify and mummify

public class Mommifier {
    //TODO: Where is this being accessed from? Is it being accessed outside of the class?
    public static final String MOMMY = "mommy";

    //TODO: Can you find out a better way to initialize this?
    private final List<Character> vowelList = getVowelList();

    //TODO: Long method! Could you try simplifying this?
    public String mommify(String input) {
        input = input.toLowerCase();
        //Good use of guard clause!
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
        /*
            TODO: Simplify this block.
            1. This is a long conditional. What is being compared to 0.30? Difficult to understand.
            2. What is 0.30 magic number?
            3. What is the return type of the conditional and that of canBeMummified method?
            4. What is your percentage vowel when string is empty? Do you need the check?
         */
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
