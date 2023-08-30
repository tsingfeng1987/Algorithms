package com.qing.algorithms.cartoon.algorithm.tree.binary.depth;

import com.qing.algorithms.cartoon.algorithm.tree.binary.BinaryTreeNode;

import java.util.Stack;

/**
 * @author guoqf
 */
public class PreOrderSearch {



    private static Integer[] createValues() {
        return new Integer[]{3, 2, 9, null, null, 10, null, null, 8, null, 4};
    }

    public static void main(String[] args) {
        BinaryTreeNode tree = BinaryTreeNode.createTree(createValues());

        preOrderSearchTree(tree);

    }

    private static void preOrderSearchTree(BinaryTreeNode treeNode) {
        Stack<BinaryTreeNode> stack = new Stack<>();

        BinaryTreeNode node = treeNode;
        while (node != null || !stack.isEmpty()) {

            //遍历当前节点及其左子节点，直到指向当前子树最左叶子节点的左子节点(NIL)
            while (node != null) {
                /*
                 * 在入栈时打印（遍历），因为节点入栈的顺序，正好是parent->left->right，与前序遍历顺序一致
                 */
                System.out.println(node.getValue());

                stack.push(node);
                node = node.getLeftChild();
            }

            //取得右子节点
            if (!stack.isEmpty()) {
                //node=null，向从栈顶弹出
                node = stack.pop();
                //由于弹出的节点在入栈时已经查找，因此直接获取弹出节点的右子节点
                node = node.getRightChild();

            }

        }

    }


}
