package com.panpan.walle.study.alg.leetcode;

import cn.hutool.core.lang.tree.TreeUtil;
import com.panpan.walle.study.alg.common.TreeNode;
import com.panpan.walle.study.alg.common.TreeUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 94:二叉树的中序遍历
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 *
 */
public class InorderTraversalSolution {

    public static void main(String[] args) {
        BuildTreeSolution buildTreeSolution = new BuildTreeSolution();
       TreeNode tree = buildTreeSolution.buildTree(new int[]{1,2,3}, new int[]{1,3,2});
       List<Integer> result = new InorderTraversalSolution().inorderTraversal(tree);
        System.out.println(result);

    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderTraversal(root, result);
        return result;
    }

    private void inorderTraversal(TreeNode root, List<Integer> result){
        if (root == null)
            return;
        if (root.left != null){
            inorderTraversal(root.left, result);
        }
        result.add(root.val);
        if (root.right != null){
            inorderTraversal(root.right, result);
        }
    }
}
