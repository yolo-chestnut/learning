package priv.yolo.chestnut.interview.mi._20190816;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 第2轮
 * 层序遍历，需要按层打印
 * 5
 * 8 10
 * 7(8左) 6(8右) 11(10右)
 * 12(11左)
 */
public class A3 {

    public static void main(String[] args) {
        Node node7 = new Node(null, null, 7);
        Node node6 = new Node(null, null, 6);
        Node node12 = new Node(null, null, 12);
        Node node11 = new Node(node12, null, 11);
        Node node8 = new Node(node7, node6, 8);
        Node node10 = new Node(node11, null, 10);
        Node node5 = new Node(node8, node10, 5);

        levelTraversal(node5);

    }

    private static void levelTraversal(Node node) {
        Queue<Node> queue = new LinkedList<>();

        Node last = node;
        Node lastTemp = node;

        if (node != null) {
            queue.offer(node);
        }

        while (!queue.isEmpty()) {
            Node temp = queue.poll();

            if (temp.left != null) {
                queue.offer(temp.left);
                // 这里应该将队列最后一个入队列，应该用LinkedList.getLast();
                lastTemp = temp.left;
            }

            if (temp.right != null) {
                queue.offer(temp.right);
                lastTemp = temp.right;
            }

            if (last == temp) {
                System.out.print(temp.value + "\n");
                last = lastTemp;
            } else {
                System.out.print(temp.value + "  ");
            }

        }

    }

}

class Node {

    int value;
    Node left;
    Node right;

    Node(Node left, Node right, int value) {
        this.left = left;
        this.right = right;
        this.value = value;
    }

}
