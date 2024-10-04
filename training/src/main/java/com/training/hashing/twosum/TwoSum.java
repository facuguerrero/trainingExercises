package com.training.hashing.twosum;

import java.util.HashMap;
import java.util.Map;

class TwoSum {

  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> numbersToPositions = new HashMap<>();
    for (int x = 0; x < nums.length; x++) {
      numbersToPositions.put(nums[x], x);
    }

    for (int i = 0; i < nums.length; i++) {
      int complement = target - nums[i];

      if (numbersToPositions.containsKey(complement) && numbersToPositions.get(complement) != i) {
        return new int[]{i, numbersToPositions.get(complement)};
      }
    }
    return new int[]{};
  }
}
