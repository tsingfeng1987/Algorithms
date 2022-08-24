package com.qing.algorithms.datastructure.graph.search;

import lombok.Data;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

public class BfsAndDfs {

    @Data
    static class Node {

        private String value;

        private List<Node> siblings;

    }

    public static void main(String[] args) {
        Node rootNode = initRootNode();

        System.out.println("*******************To bfs find 'G'");
        bfs(rootNode, "G");
        System.out.println("*******************To bfs find 'X'");
        bfs(rootNode, "X");
        System.out.println("*******************To dfs find 'G'");
        dfs(rootNode, "G");
        System.out.println("*******************To dfs find 'X'");
        dfs(rootNode, "X");
        System.out.println("*******************End");
    }

    private static boolean bfs(Node root, String toSearch) {
        Deque<Node> nodeQueue = new LinkedBlockingDeque<>();
        Node curNode;
        nodeQueue.offer(root);
        boolean found = false;
        while (true) {
            curNode = nodeQueue.poll();
            if (curNode == null) {
                break;
            }
            found = curNode.value.equals(toSearch);
            System.out.println("Handling: "+curNode.value);
            if (found) {
                break;
            }
            List<Node> siblings = curNode.siblings;
            if (!CollectionUtils.isEmpty(siblings)) {
                siblings.forEach(nodeQueue::offer);
            }



        }
        System.out.println((found ? "" : "[没有]") + "找到节点:" + toSearch);
        return found;

    }


    private static boolean dfs(Node root, String toSearch) {
        Deque<Node> nodeStack = new LinkedBlockingDeque<>();
        Node curNode;
        nodeStack.offerLast(root);
        boolean found = false;
        while (true) {
            curNode = nodeStack.pollLast();
            if (curNode == null) {
                break;
            }


            found = curNode.value.equals(toSearch);
            System.out.println("Handling: "+curNode.value);
            if (found) {

                break;
            }
            List<Node> siblings = curNode.siblings;
            if (!CollectionUtils.isEmpty(siblings)) {
                siblings.forEach(nodeStack::offer);
            }

        }
        System.out.println((found ? "" : "[没有]") + "找到节点:" + toSearch);
        return found;

    }


    private static Node initRootNode() {
        Node root = new Node();
        root.value = "A";



        Node c = new Node();
        c.value = "C";

        Node e = new Node();
        e.value = "E";

        Node b = new Node();
        b.setValue("B");
        b.setSiblings(Arrays.asList(c, e));

        Node d = new Node();
        d.value = "D";
        d.setSiblings(Collections.singletonList(c));

        Node g = new Node();
        g.value = "G";

        Node h = new Node();
        h.value = "H";

        Node f = new Node();
        f.value = "F";
        f.siblings = Arrays.asList(g, h);

        root.siblings = Arrays.asList(f,b, d);
        return root;
    }


}
