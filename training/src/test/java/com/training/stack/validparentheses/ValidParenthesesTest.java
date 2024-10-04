package com.training.stack.validparentheses;

import static org.junit.Assert.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ValidParenthesesTest {

    private ValidParentheses validParentheses = new ValidParentheses();

    @ParameterizedTest
    @MethodSource("testUseCases")
    void testCases(String string, Boolean expectedResult) {
        Boolean result = validParentheses.isValid(string);

        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> testUseCases() {
        return Stream.of(
          Arguments.of("()", true),
          Arguments.of("()[]{}", true),
          Arguments.of("(]", false),
          Arguments.of("(", false),
          Arguments.of("]", false)
        );
    }
}
