package com.twu.mommifier;
//TODO: Format code
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Mommifier {
    private final String MOMMY = "mommy";
    //TODO: What is this thirty percent intended to do? Do you think the name is good enough? What is it's significance?
    private final double THIRTY_PERCENT = 0.30;

    private static final List<Character> vowelList = Arrays.asList('a', 'e', 'i', 'o', 'u');

    /*
        TODO: Another way of doing this is create a static list and initialize it up there at the time of declaration.
         You don't necessarily need a method.
     */

    String mommify(String input) {
        input = input.toLowerCase();
        if (!canBeMommified(input))
            return input;

        return getMommifiedString(input);
    }

    //TODO: This is a long method. Can you try to refactor this?
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

        //TODO: What will be the count of vowels for empty string?
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

}
