package listnode;

/**
 * 83. 删除排序链表中的重复元素
 * 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表
 * 示例 1：
 * 输入：head = [1,1,2]
 * 输出：[1,2]
 *
 * 示例 2：
 * 输入：head = [1,1,2,3,3]
 * 输出：[1,2,3]
 *
 * 提示：
 * 链表中节点数目在范围 [0, 300] 内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序 排列
 */
public class Solution83 {

    public static void main(String[] args) {
        ListNode head = new ListNode(new int[]{1, 1, 2});
//        deleteDuplicates(head);
        System.out.println(head);

    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        //判断是否需要dummy节点只需要看是否可以保留头节点
        //如果可以保留就不需要创建dummy节点
        ListNode curr = head;
        //判断是否当前节点有下一个节点，如果有继续循环，否则终止了
        while (curr.next != null) {
            if (curr.next.val == curr.val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;
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

            ListNode dummy = new ListNode(0); // 虚拟头节点
            ListNode curr = dummy;
            for (int num : nums) {
                curr.next = new ListNode(num);
                curr = curr.next;
            }
            //这里更新的是this当前节点
            //如果不能修改当前节点
            //那么构造方法改成普通方法直接返回dummy.next就可以了
            this.val = dummy.next.val;
            this.next = dummy.next.next;
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
