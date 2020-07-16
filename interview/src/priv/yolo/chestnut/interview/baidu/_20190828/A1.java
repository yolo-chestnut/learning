package priv.yolo.chestnut.interview.baidu._20190828;

/**
 * 求给定的单链表中倒数第k个结点的值。要求只允许遍历1遍，空间复杂度O(1)。
 */
public class A1 {

    public static void main(String[] args) {
        Node n9 = new Node(9, null);
        Node n8 = new Node(8, n9);
        Node n7 = new Node(7, n8);
        Node n6 = new Node(6, n7);
        Node n5 = new Node(5, n6);
        Node n4 = new Node(4, n5);
        Node n3 = new Node(3, n4);
        Node n2 = new Node(2, n3);
        Node n1 = new Node(1, n2);
        Node n0 = new Node(0, n1);

        int k = 6;
        Node result = fastSlowPointer(n0, k);
        System.out.println(result == null ? null : result.val);
    }

    // 快慢指针法，参考链接：https://www.cnblogs.com/javatalk/p/11333737.html
    private static Node fastSlowPointer(Node node, int k) {
        // 根结点为空或者只有根结点，返回根结点本身
        if (node == null || node.next == null) return node;

        // 定义快慢指针
        Node fast = node.next;
        Node slow = fast;

        // 计数器
        int i;
        // 让快指针比慢指针先走k步
        for (i = 0; i < k && fast.next != null; i++) {
            fast = fast.next;
        }

        // 单链表本身不足k个，返回null
        if (i < k) {
            return null;
        }

        // 当快指针比慢指针多走k步后，快慢指针同时走，直到快指针遍历到单链表结束，返回此时慢指针对应的结点
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }

}

class Node {
    int val;
    Node next;

    Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }

}
