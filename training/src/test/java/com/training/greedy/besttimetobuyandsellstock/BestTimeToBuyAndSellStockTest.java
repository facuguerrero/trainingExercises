package com.training.greedy.besttimetobuyandsellstock;

import static org.junit.Assert.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class BestTimeToBuyAndSellStockTest {

  private BestTimeToBuyAndSellStock bestTimeToBuyAndSellStock = new BestTimeToBuyAndSellStock();

  @ParameterizedTest
  @MethodSource("testUseCases")
  void testCases(int[] nums, int expectedMaxProfit) {
    int result = bestTimeToBuyAndSellStock.maxProfit(nums);

    assertEquals(expectedMaxProfit, result);
  }

  private static Stream<Arguments> testUseCases() {
    return Stream.of(
      Arguments.of(new int[]{7, 1, 5, 3, 6, 4}, 5),
      Arguments.of(new int[]{7, 6, 4, 3, 1}, 0)
    );
  }
}
