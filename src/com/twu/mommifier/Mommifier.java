package com.twu.mommifier;

import java.util.Arrays;
import java.util.List;

class Mommifier {
    private final String MOMMY = "mommy";
    //TODO: Very long name. How about "THRESHOLD_VOWEL_PERCENTAGE"?
    /**
     * I thought about it, but seemed that it was not giving the intent of
     * the threshold percentage. But I like this one better :D
     */
    private final double THRESHOLD_VOWEL_PERCENTAGE = 0.30;

    private static final List<Character> vowelList = Arrays.asList('a', 'e', 'i', 'o', 'u');

    String mommify(String input) {
        if (input == null)
            return input;

        input = input.toLowerCase();
        if (!canBeMommified(input))
            return input;

        return getMommifiedString(input);
    }

    private String getMommifiedString(String input) {
        char[] inputCharacters = input.toCharArray();
        StringBuilder result = new StringBuilder();
        for (int index = 0; index < inputCharacters.length; index++) {
            result.append(next(inputCharacters, index));
        }

        return result.toString();
    }

    private String next(char[] inputCharacters, int currentIndex) {
        int previousIndex = currentIndex - 1;
        char currentCharacter = inputCharacters[currentIndex];
        if (isVowel(currentCharacter)) {
            if (previousIndex < 0 || !isVowel(inputCharacters[previousIndex]))
                return MOMMY;
            return "";
        }
        //TODO: Does this need to return a string?
        /**
         * Since we are returning a String - Mommy from this method,
         * if we have to return a character - it has to be string as well right?
         * We cannot have multiple return types.
         */
        return Character.toString(currentCharacter);
    }

    private boolean isVowel(char character) {
        return vowelList.contains(character);
    }

    private boolean canBeMommified(String input) {
        int countOfVowels = getCountOfVowels(input);

        /*
            TODO: If the count of vowels for empty string is zero, what would the percentage be?
            Will the canBeMommified return the same result as false?
            The percentage would be zero only, and hence canBeMommified will
            always return false for empty string.
         */
        //TODO: Good point. Try removing this block and run your tests

        /**
         * Some magic took place and I am not getting any arithmetic exception
         * even on divide by zero.
         */

        double percentageOfVowelsPresentInString = (double) countOfVowels / (double) input.length();

        return percentageOfVowelsPresentInString > THRESHOLD_VOWEL_PERCENTAGE;
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
