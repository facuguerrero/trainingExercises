package com.training.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

public class TreeNode {

  Integer val;
  TreeNode left;
  TreeNode right;

  public TreeNode getLeft() {
    return left;
  }

  public TreeNode getRight() {
    return right;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TreeNode treeNode = (TreeNode) o;
    return Objects.equals(val, treeNode.val);
  }

  public TreeNode() {
  }

  public TreeNode(Integer val) {
    this.val = val;
  }

  public TreeNode(List<Integer> values) {
    if (values == null || values.isEmpty()) {
      throw new IllegalArgumentException("Values list cannot be null or empty");
    }

    this.val = values.get(0);

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(this);

    int i = 1;
    while (i < values.size()) {
      TreeNode current = queue.poll();
      if (current == null) {
        continue;
      }

      Integer leftVal = values.get(i++);
      if (leftVal != null) {
        current.left = new TreeNode(leftVal);
        queue.add(current.left);
      }

      if (i < values.size()) {
        Integer rightVal = values.get(i++);
        if (rightVal != null) {
          current.right = new TreeNode(rightVal);
          queue.add(current.right);
        }
      }
    }
  }
}
