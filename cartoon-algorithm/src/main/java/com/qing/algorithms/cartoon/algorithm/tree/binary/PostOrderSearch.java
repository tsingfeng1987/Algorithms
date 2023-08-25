package com.qing.algorithms.cartoon.algorithm.tree.binary;

import java.util.Stack;

/**
 * @author guoqf
 */
public class PostOrderSearch {



    private static Integer[] createValues() {
        return new Integer[]{3, 2, 9, null, null, 10, null, null, 8, null, 4};
    }

    public static void main(String[] args) {
        BinaryTreeNode tree = BinaryTreeNode.createTree(createValues());

        postOrderSearchTree(tree);

    }

    private static void postOrderSearchTree(BinaryTreeNode treeNode) {
        Stack<BinaryTreeNode> stack = new Stack<>();

        BinaryTreeNode node = treeNode;

        BinaryTreeNode lastPopped = null;
        while (node != null || !stack.isEmpty()) {

            //将当前节点及其左子节点入栈，直到指向当前子树最左叶子节点的左子节点(NIL)
            while (node != null) {
                /*
                 * 节点入栈的顺序是parent->left->right，与前序遍历顺序一致
                 */
                stack.push(node);
                node = node.getLeftChild();
            }

            //取得遍历节点
            if (!stack.isEmpty()) {
                //node=null，向从栈顶弹出
                node = stack.pop();

                // 由于父节点是最后遍历（打印），但是父节点需要遍历两次：一、右子节点入栈前，二、右子节点出栈后（或没有右子节点），第二次才是真正遍历父节点
                if (node.getRightChild() == null || node.getRightChild() == lastPopped) {
                    //右子节点出栈后或者没有右子节点时遍历，真正遍历父节点
                    // 打印遍历节点
                    System.out.println(node.getValue());
                    lastPopped = node;
                    node = null;
                }else {
                    // 右子节点入栈前遍历，需要先将右子节点入栈，由于右子节点出栈后还需要当前节点，所以当前节点还需要再次入栈
                    stack.push(node);
                    node = node.getRightChild();
                }


            }

        }

    }


}
