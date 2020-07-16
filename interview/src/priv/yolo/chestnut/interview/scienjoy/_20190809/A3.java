package priv.yolo.chestnut.interview.scienjoy._20190809;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Write a function to print ZigZag order traversal of a binary tree.
 * For the below binary tree the zigzag order traversal will be
 * 1 3 2 7 6 5 4.
 * 二叉树（完整）如下
 * 1
 * 2 3
 * 7 6 5 4
 * 编写一个函数来打印二叉树的Z字形顺序遍历。
 */
public class A3 {

    public static void main(String[] args) {
        Node node7 = new Node(null, null, 7);
        Node node6 = new Node(null, null, 6);
        Node node5 = new Node(null, null, 5);
        Node node4 = new Node(null, null, 4);
        Node node3 = new Node(node5, node4, 3);
        Node node2 = new Node(node7, node6, 2);
        Node node1 = new Node(node2, node3, 1);

        ZigZagOrderPrint(node1);
    }

    private static void ZigZagOrderPrint(Node node) {
        boolean flag = true;
        Deque<Node> deque = new LinkedList<>();

        Node last = node;

        if (node != null) {
            deque.offerFirst(node);
        }

        while (!deque.isEmpty()) {
            Node temp = flag ? deque.pollFirst() : deque.pollLast();

            if (flag) {
                if (temp.left != null) {
                    deque.offerLast(temp.left);
                }
                if (temp.right != null) {
                    deque.offerLast(temp.right);
                }
            } else {
                if (temp.right != null) {
                    deque.offerFirst(temp.right);
                }
                if (temp.left != null) {
                    deque.offerFirst(temp.left);
                }
            }

            if (temp == last) {
                last = flag ? deque.peekFirst() : deque.peekLast();
                System.out.print(temp.value + "\n");
                flag = !flag;
            } else {
                System.out.print(temp.value + "  ");
            }

        }

    }

}

class Node {

    Node left;
    Node right;
    int value;

    Node(Node left, Node right, int value) {
        this.left = left;
        this.right = right;
        this.value = value;
    }

}
