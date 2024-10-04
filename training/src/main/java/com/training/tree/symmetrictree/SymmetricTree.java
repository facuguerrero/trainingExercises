package com.training.tree.symmetrictree;

import com.training.tree.TreeNode;

class SymmetricTree {

  public boolean isSymmetric(TreeNode root) {
    return isSymmetricRec(root.getLeft(), root.getRight());
  }

  private boolean isSymmetricRec(TreeNode left, TreeNode right) {
    if (left == null && right == null) {
      return true;
    }

    if (left == null || right == null) {
      return false;
    }

    return left.equals(right) && isSymmetricRec(left.getLeft(), right.getRight()) && isSymmetricRec(
      left.getLeft(), right.getRight());
  }
}


