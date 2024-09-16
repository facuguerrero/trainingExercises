package com.training.binarysearch.findpositionsofelementinsortedarray;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class FindFirstAndLastPositionOfElementInArrayTest {

    private FindFirstAndLastPositionOfElementInSortedArray findFirstAndLastPositionOfElementInSortedArray = new FindFirstAndLastPositionOfElementInSortedArray();

    @ParameterizedTest
    @MethodSource("testUseCases")
    void testCases(int[] nums, int target, int[] expectedResult) {
        int[] result =
        findFirstAndLastPositionOfElementInSortedArray.findFirstAndLastPositionOfElementInSortedArray(nums, target);

        assertTrue(Arrays.equals(expectedResult, result));
    }

    private static Stream<Arguments> testUseCases() {
        return Stream.of(
          Arguments.of(new int[]{5,7,7,8,8,10}, 8, new int[]{3,4}),
          Arguments.of(new int[]{5,7,7,8,8,10}, 6, new int[]{-1,-1}),
          Arguments.of(new int[]{}, 6, new int[]{-1,-1})
        );
    }
}
