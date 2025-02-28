package listnode;

/**
 * 1290. 二进制链表转整数
 * 给你一个单链表的引用结点 head。链表中每个结点的值不是 0 就是 1。已知此链表是一个整数数字的二进制表示形式。
 * 请你返回该链表所表示数字的 十进制值 。
 *
 * 输入：head = [1,0,1]
 * 输出：5
 * 解释：二进制数 (101) 转化为十进制数 (5)
 *
 * 示例 2：
 * 输入：head = [0]
 * 输出：0
 *
 * 示例 3：
 * 输入：head = [1]
 * 输出：1
 *
 * 示例 4：
 * 输入：head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
 * 输出：18880
 *
 * 示例 5：
 * 输入：head = [0,0]
 * 输出：0
 *
 * 提示：
 * 链表不为空。
 * 链表的结点总数不超过 30。
 * 每个结点的值不是 0 就是 1。
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class Solution1290 {

    public static void main(String[] args) {
        ListNode head = new ListNode(new int[]{1, 0, 1});
        int sum = getDecimalValue(head);
        System.out.println(sum);
        System.out.println(head);
    }

    public static int getDecimalValue(ListNode head) {
        ListNode current = head;
        int sum = 0;
        while (current != null) {
            sum = sum * 2 + current.val;
            current = current.next;
        }
        return sum;
    }

    public static int getDecimalValue1(ListNode head) {
        int res = 0;
        while (head != null) {
            res <<= 1; //左移等于乘2
            res |= head.val; //异或相当于相加
            head = head.next;
        }
        return res;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
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

