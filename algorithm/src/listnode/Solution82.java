package listnode;

/**
 * 82. 删除排序链表中的重复元素 II
 * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
 *
 * 示例 1：
 * 输入：head = [1,2,3,3,4,4,5]
 * 输出：[1,2,5]
 *
 * 示例 2：
 * 输入：head = [1,1,1,2,3]
 * 输出：[2,3]
 *
 * 提示：
 * 链表中节点数目在范围 [0, 300] 内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序 排列
 */
public class Solution82 {

    public static void main(String[] args) {
        ListNode head = new ListNode(new int[]{1, 2, 3, 3, 4, 4, 5});
        deleteDuplicates(head);
        System.out.println(head);
    }

    //因为头节点有可能是重复需要被删除的节点所以需要定义dummy节点
    //时间复杂度：两个while循环只是操作的节点指向所以是O(n)
    //空间复杂度：没有额外的使用，只有中间变量所以是O(1)
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode curr = dummy;
        while (curr.next != null && curr.next.next != null) {
            int val = curr.next.val;
            //当前节点的下个节点和下下个节点相等则进入下个while循环
            if (val == curr.next.next.val) {
                while (curr.next != null && val == curr.next.val) {
                    curr.next = curr.next.next;
                }
            } else {
                curr = curr.next;
            }
        }
        return dummy.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        ListNode(int val, ListNode next) { this.val = val; this.next = next; }


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
