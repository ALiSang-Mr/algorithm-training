package listnode;

/**
 * 237. 删除链表中的节点
 * 有一个单链表的 head，我们想删除它其中的一个节点 node。
 * 给你一个需要删除的节点 node 。你将 无法访问 第一个节点  head。
 * 链表的所有值都是 唯一的，并且保证给定的节点 node 不是链表中的最后一个节点。
 * 删除给定的节点。注意，删除节点并不是指从内存中删除它。这里的意思是：
 * 给定节点的值不应该存在于链表中。
 * 链表中的节点数应该减少 1。
 * node 前面的所有值顺序相同。
 * node 后面的所有值顺序相同。
 * 自定义测试：
 * 对于输入，你应该提供整个链表 head 和要给出的节点 node。node 不应该是链表的最后一个节点，而应该是链表中的一个实际节点。
 * 我们将构建链表，并将节点传递给你的函数。
 * 输出将是调用你函数后的整个链表。
 * <p>
 * 示例 1：
 * 输入：head = [4,5,1,9], node = 5
 * 输出：[4,1,9]
 * 解释：指定链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9
 * <p>
 * 示例 2：
 * 输入：head = [4,5,1,9], node = 1
 * 输出：[4,5,9]
 * 解释：指定链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9
 * <p>
 * 提示：
 * 链表中节点的数目范围是 [2, 1000]
 * -1000 <= Node.val <= 1000
 * 链表中每个节点的值都是 唯一 的
 * 需要删除的节点 node 是 链表中的节点 ，且 不是末尾节点
 */
public class Solution237 {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(4);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(5);
        ListNode n4 = new ListNode(9);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        deleteNode(n2);
        System.out.println(n1);
    }

    //时间复杂度=O(1)
    //空间复杂度=O(1)
    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public ListNode(int[] nums) {
            if (nums == null || nums.length == 0) {
                throw new IllegalArgumentException("arr can not empty");
            }
            this.val = nums[0];
            ListNode curr = this;
            for (int i = 1; i < nums.length; i++) {
                curr.next = new ListNode(nums[i]);
                curr = curr.next;
            }
        }

        @Override
        public String toString() {
            StringBuilder s = new StringBuilder();
            ListNode curr = this;
            while (curr != null) {
                s.append(curr.val);
                s.append("->");
                curr = curr.next;
            }
            s.append("NULL");
            return s.toString();
        }
    }
}
