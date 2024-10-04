package com.training.hashing.twosum;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TwoSumTest {

  private TwoSum twoSum = new TwoSum();

  @ParameterizedTest
  @MethodSource("testUseCases")
  void testCases(int[] nums, int target, int[] expectedResult) {
    int[] result = twoSum.twoSum(nums, target);

    assertTrue(Arrays.equals(expectedResult, result));
  }

  private static Stream<Arguments> testUseCases() {
    return Stream.of(
      Arguments.of(new int[]{2, 7, 11, 15}, 9, new int[]{0, 1}),
      Arguments.of(new int[]{3, 2, 4}, 6, new int[]{1, 2}),
      Arguments.of(new int[]{3, 3}, 6, new int[]{0, 1})
    );
  }
}
