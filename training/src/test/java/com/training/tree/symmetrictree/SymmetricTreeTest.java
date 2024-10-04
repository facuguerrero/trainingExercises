package com.training.tree.symmetrictree;

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
class SymmetricTreeTest {

  private SymmetricTree symmetricTree = new SymmetricTree();

  @ParameterizedTest
  @MethodSource("testUseCases")
  void testCases(TreeNode root, Boolean expectedResult) {
    Boolean result = symmetricTree.isSymmetric(root);

    assertEquals(expectedResult, result);
  }

  private static Stream<Arguments> testUseCases() {
    return Stream.of(
      Arguments.of(new TreeNode(Arrays.asList(1, 2, 2, 3, 4, 4, 3)), true),
      Arguments.of(new TreeNode(Arrays.asList(1, 2, 2, null, 3, null, 3)), false),
      Arguments.of(new TreeNode(Arrays.asList(1, 2, 2, 3, 4, 4, 3, null, null, 5, 6, 6, 5)), true),
      Arguments.of(new TreeNode(Arrays.asList(1, 0)), false)
    );
  }
}
