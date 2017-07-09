package com.twu.mommifier;

//TODO: Unused imports?!
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Mommifier {
    private final String MOMMY = "mommy";
    /*
        TODO: What is this thirty percent intended to do? Do you think the name is good enough?
        What is it's significance?
     */
    private final double THIRTY_PERCENT = 0.30;

    private static final List<Character> vowelList = Arrays.asList('a', 'e', 'i', 'o', 'u');

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

        //TODO: Can you keep the previous for loop format and try and do this?
        for (int index = 0; index < inputCharacters.length; index++) {
            //TODO: Do you need both current index and previous index?
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
        //TODO: Is there a better way to typecast it to string?
        return "" + currentCharacter;
    }

    private boolean isVowel(char character) {
        return vowelList.contains(character);
    }

    private boolean canBeMommified(String input) {
        int countOfVowels = getCountOfVowels(input);

        /*
            TODO: If the count of vowels for empty string is zero, what would the percentage be?
            Will the canBeMommified return the same result as false?
         */
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
