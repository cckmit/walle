package com.panpan.walle.study.alg.leetcode;

import com.panpan.walle.study.alg.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 102: 层序遍历
 */
public class LevelOrderSolution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;
        List<TreeNode> queue = new ArrayList<>();
        queue.add(root);

        while (true){

            if (queue.isEmpty()) break;

            List<Integer> levelList = new ArrayList<>();
            List<TreeNode> levelQueue = new ArrayList<>();
            while (!queue.isEmpty()){
                TreeNode node = queue.remove(0);
                levelList.add(node.val);
                if (node.left != null){
                    levelQueue.add(node.left);
                }
                if (node.right != null){
                    levelQueue.add(node.right);
                }
            }

            result.add(levelList);
            queue.addAll(levelQueue);

        }

        return result;
    }
}
