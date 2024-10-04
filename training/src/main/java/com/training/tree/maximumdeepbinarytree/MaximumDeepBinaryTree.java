package com.training.tree.maximumdeepbinarytree;

import com.training.tree.TreeNode;

class MaximumDeepBinaryTree {

  public int maxDepth(TreeNode root) {
    return maxDepthRec(root);
  }

  private int maxDepthRec(TreeNode node) {
      if (node == null) {
          return 0;
      }

    return Math.max(maxDepthRec(node.getLeft()), maxDepthRec(node.getRight())) + 1;
  }
}


