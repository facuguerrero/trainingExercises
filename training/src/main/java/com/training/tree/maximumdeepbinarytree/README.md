# Maximum deep binary tree

Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the longest path from the root node down
to the farthest leaf node.

### Example 1:

Input: root = [3,9,20,null,null,15,7]
Output: 3

### Example 2:

Input: root = [1,null,2]
Output: 2

### Constraints:

The number of nodes in the tree is in the range [0, 104].
-100 <= Node.val <= 100

### Analysis

* [Link](https://leetcode.com/problems/maximum-depth-of-binary-tree)
* Difficulty: easy
* Time Complexity: T(n) = 2 T(n/2) + O(1) --> T(n) = O(n^log_2(2)) = O(n)
* Space Complexity: O(1)
