package com.training.binarysearch.findpositionsofelementinsortedarray;

class FindFirstAndLastPositionOfElementInSortedArray {

  public int[] findFirstAndLastPositionOfElementInSortedArray(int[] nums, int target) {
    int[] result = {-1, -1};
    int left = binarySearch(nums, target, true);
    int right = binarySearch(nums, target, false);
    result[0] = left;
    result[1] = right;
    return result;
  }

  public int binarySearch(int[] nums, int target, boolean isSearchingLeftMost) {
    int left = 0;
    int right = nums.length - 1;
    int index = -1;

    while (left <= right) {
      int mid = left + (right - left) / 2;

      if (nums[mid] > target) {
        right = mid - 1;
      } else if (nums[mid] < target) {
        left = mid + 1;
      } else {
        index = mid;
        if (isSearchingLeftMost) {
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      }
    }
    return index;
  }
}