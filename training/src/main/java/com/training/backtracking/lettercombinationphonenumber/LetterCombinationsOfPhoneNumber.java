package com.training.backtracking.lettercombinationphonenumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class LetterCombinationsOfPhoneNumber {

  private final Map<String, List<String>> numberToLetters = Map.of(
    "2", List.of("a", "b", "c"),
    "3", List.of("d", "e", "f"),
    "4", List.of("g", "h", "i"),
    "5", List.of("j", "k", "l"),
    "6", List.of("m", "n", "o"),
    "7", List.of("p", "q", "r", "s"),
    "8", List.of("t", "u", "v"),
    "9", List.of("w", "x", "y", "z")
  );


  public List<String> letterCombinations(String digits) {
    // 0 <= digits.length <= 4
    if (digits.length() == 0) {
      return List.of();
    }

    return letterCombinationsRec(digits);
  }

  private List<String> letterCombinationsRec(String digits) {
    if (digits.length() == 1) {
      return getLettersFromNumber(digits);
    }

    List<String> first = letterCombinationsRec(digits.substring(0, digits.length() - 1));
    List<String> second = letterCombinationsRec(
      digits.substring(digits.length() - 1, digits.length()));

    return mergeResults(first, second);
  }

  private List<String> getLettersFromNumber(String digit) {
    return numberToLetters.get(String.valueOf(digit));
  }

  private List<String> mergeResults(List<String> first, List<String> second) {
    List<String> result = new ArrayList<>();
    for (String item : first) {
      for (String item2 : second) {
        result.add(item + item2);
      }
    }
    return result;
  }
}
