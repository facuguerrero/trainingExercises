package com.training.tree.maximumdeepbinarytree;

import static org.junit.Assert.assertEquals;

import com.training.tree.TreeNode;
import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class MaximumDeepBinaryTreeTest {

  private MaximumDeepBinaryTree maximumDeepBinaryTree = new MaximumDeepBinaryTree();

  @ParameterizedTest
  @MethodSource("testUseCases")
  void testCases(TreeNode root, int expectedResult) {
    int result = maximumDeepBinaryTree.maxDepth(root);

    assertEquals(expectedResult, result);
  }

  private static Stream<Arguments> testUseCases() {
    return Stream.of(
      Arguments.of(new TreeNode(Arrays.asList(3, 9, 20, null, null, 15, 7)), 3),
      Arguments.of(new TreeNode(Arrays.asList(1, null, 2)), 2)
    );
  }
}
