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
        if (input == null)
            return input;

        input = input.toLowerCase();
        if (!canBeMommified(input))
            return input;

        return getMommifiedString(input);
    }

    //TODO: This is a long method. Can you try to refactor this?
    private String getMommifiedString(String input) {
        char[] inputCharacters = input.toCharArray();
        StringBuilder result = new StringBuilder();


        for (int index = 0; index < inputCharacters.length; index++) {
            result.append(next(inputCharacters, index, index - 1));
        }

        return result.toString();
    }

    private String next(char[] inputCharacters, int currentIndex, int previousIndex) {
        char currentCharacter = inputCharacters[currentIndex];
        if(isVowel(currentCharacter)){
            if (previousIndex < 0 || !isVowel(inputCharacters[previousIndex]))
                return MOMMY;
            return "";
        }
        return "" + currentCharacter;
    }

    private boolean isVowel(char character) {
        return vowelList.contains(character);
    }

    private boolean canBeMommified(String input) {
        int countOfVowels = getCountOfVowels(input);

        //TODO: What will be the count of vowels for empty string?
        if (countOfVowels == 0)
            return false;

        double percentageOfVowelsPresentInString = (double) countOfVowels / (double) input.length();

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
