package com.twu.mommifier;

import java.util.ArrayList;
import java.util.List;

//TODO: Be consistent with mommify and mommify

class Mommifier {
    //TODO: Where is this being accessed from? Is it being accessed outside of the class?
    private final String MOMMY = "mommy";
    private final double THIRTY_PERCENT = 0.30;

    //TODO: Can you find out a better way to initialize this?
    private final List<Character> vowelList;

    public Mommifier() {
        vowelList = getVowelList();
    }

    //TODO: Long method! Could you try simplifying this?
    String mommify(String input) {
        input = input.toLowerCase();
        //Good use of guard clause!
        if (!canBeMommified(input))
            return input;

        return getMommifiedString(input);
    }

    private String getMommifiedString(String input) {
        StringBuilder result = new StringBuilder();
        boolean isVowelSetFound = false;

        for (char character : input.toCharArray()) {
            if(vowelList.contains(character)){
                if(!isVowelSetFound)
                    result.append(MOMMY);
                isVowelSetFound = true;
            }
            else{
                result.append(character);
                isVowelSetFound = false;
            }
        }

        return result.toString();
    }

    private boolean canBeMommified(String input) {
        int count = getCountOfVowels(input);
        /*
            TODO: Simplify this block.
            1. This is a long conditional. What is being compared to 0.30? Difficult to understand.
            2. What is 0.30 magic number?
            3. What is the return type of the conditional and that of canBeMommified method?
            4. What is your percentage vowel when string is empty? Do you need the check?
                 - the check is needed to avoid the NullPointerException at line 58
         */
        if(input.length() == 0)
            return false;

        double percentageOfVowelsPresentInString = (double) count / (double) input.length();

        return percentageOfVowelsPresentInString > THIRTY_PERCENT;
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
