// 描述
// 给定一棵二叉树(保证非空)以及这棵树上的两个节点对应的val值 o1 和 o2，请找到 o1 和 o2 的最近公共祖先节点。

// 数据范围：树上节点数满足 1 \le n \le 10^5 \1≤n≤10 
// 5
//    , 节点值val满足区间 [0,n)
// 要求：时间复杂度 O(n)O(n)

// 注：本题保证二叉树中每个节点的val值均不相同。

import java.util.*;

/*
 * public class TreeNode {
 *   int val = 0;
 *   TreeNode left = null;
 *   TreeNode right = null;
 * }
 */

public class Solution {
    /**
     * 
     * @param root TreeNode类 
     * @param o1 int整型 
     * @param o2 int整型 
     * @return int整型
     */
    public int lowestCommonAncestor (TreeNode root, int o1, int o2) {
        // write code here
        //1.记录每个节点的父亲结点,HashMap
        Map<Integer, Integer> parent = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        // 1.1，根节点的父节点入map，根节点入队
        parent.put(root.val,Integer.MIN_VALUE);
        queue.add(root);
        //1.2 bfs直到两个节点找到
        while(!parent.containsKey(o1) || !parent.containsKey(o2)){
            TreeNode node = queue.poll();
            if(node.left!=null){
                parent.put(node.left.val,node.val);
                queue.add(node.left);
            }
            if(node.right!=null){
                parent.put(node.right.val,node.val);
                queue.add(node.right);
            }
        }
        
        //2.记录o1到根节点的路径,集合Set
        Set<Integer> o1Ancestors = new HashSet<>();
        while(parent.containsKey(o1)){
            o1Ancestors.add(o1);
            o1 = parent.get(o1);
        }
        
        // 3.在o2到根节点的路径上寻找o1是否包含
        while(!o1Ancestors.contains(o2)){
            o2 = parent.get(o2);
        }
        return o2;
    }
}
