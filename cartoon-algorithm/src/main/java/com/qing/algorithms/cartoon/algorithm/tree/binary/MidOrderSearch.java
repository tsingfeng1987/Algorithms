package com.qing.algorithms.cartoon.algorithm.tree.binary;

import java.util.Stack;

/**
 * @author guoqf
 */
public class MidOrderSearch {



    private static Integer[] createValues() {
        return new Integer[]{3, 2, 9, null, null, 10, null, null, 8, null, 4};
    }

    public static void main(String[] args) {
        BinaryTreeNode tree = BinaryTreeNode.createTree(createValues());

        midOrderSearchTree(tree);

    }

    private static void midOrderSearchTree(BinaryTreeNode treeNode) {
        Stack<BinaryTreeNode> stack = new Stack<>();

        BinaryTreeNode node = treeNode;
        while (node != null || !stack.isEmpty()) {

            //将当前节点及其左子节点入栈，直到指向当前子树最左叶子节点的左子节点(NIL)
            while (node != null) {

                stack.push(node);
                node = node.getLeftChild();
            }

            //取得右子节点
            if (!stack.isEmpty()) {
                //node=null，向从栈顶弹出
                node = stack.pop();
                /*
                 * 在出栈时打印（遍历），因为节点出栈的顺序，正好是left->parent->right，与中序遍历顺序一致
                 */
                System.out.println(node.getValue());
                //由于弹出的节点在入栈时已经查找，因此直接获取弹出节点的右子节点
                node = node.getRightChild();

            }

        }

    }


}
