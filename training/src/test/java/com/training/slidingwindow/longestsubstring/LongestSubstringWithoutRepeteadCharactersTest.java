package com.training.slidingwindow.longestsubstring;

import static org.junit.Assert.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class LongestSubstringWithoutRepeteadCharactersTest {

    private LongestSubstringWithoutRepeatingCharacters longestSubstringWithoutRepeatingCharacters = new LongestSubstringWithoutRepeatingCharacters();

    @ParameterizedTest
    @MethodSource("testUseCases")
    void testCases(String string, int expectedLongestSubstring) {
        int result = longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring(string);

        assertEquals(expectedLongestSubstring, result);
    }

    private static Stream<Arguments> testUseCases() {
        return Stream.of(
          Arguments.of("tmmzuxt", 5),
          Arguments.of("abcabcbb", 3),
          Arguments.of("bbbbb", 1)
        );
    }
}
