package com.training.backtracking.lettercombinationphonenumber;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class LetterCombinationsOfPhoneNumberTest {

  private LetterCombinationsOfPhoneNumber letterCombinationsOfPhoneNumber = new LetterCombinationsOfPhoneNumber();

  @ParameterizedTest
  @MethodSource("testUseCases")
  void testCases(String digits, List<String> expectedResult) {
    List<String> result = letterCombinationsOfPhoneNumber.letterCombinations(digits);

    assertEquals(expectedResult, result);
  }

  private static Stream<Arguments> testUseCases() {
    return Stream.of(
      Arguments.of("", List.of()),
      Arguments.of("2", List.of("a", "b", "c")),
      Arguments.of("23", List.of("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"))
    );
  }


}
