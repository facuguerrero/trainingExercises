package com.training.dynamicprogramming.longestpalindromicsubstring;

import static org.junit.Assert.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class LongestPalindromicSubstringTest {

  private LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();

  @ParameterizedTest
  @MethodSource("testUseCases")
  void testCases(String string, String expectedResult) {
    String result = longestPalindromicSubstring.longestPalindromeBottomUp(string);

    assertEquals(expectedResult, result);
  }

  private static Stream<Arguments> testUseCases() {
    return Stream.of(
      Arguments.of("", ""),
      Arguments.of("babad", "aba"),
      Arguments.of("cbbd", "bb")
    );
  }
}
