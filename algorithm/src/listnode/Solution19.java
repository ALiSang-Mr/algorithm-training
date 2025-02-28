package listnode;

import java.util.List;

/**
 * 19. 删除链表的倒数第 N 个结点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * @date 2025/2/28
 */
public class Solution19 {


    public static void main(String[] args) {
        ListNode head = new ListNode(new int[]{1,2,3,4,5});
        System.out.println(head);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode curr = dummy;
        while (curr != null){

        }
        return null;

    }



    public static class ListNode{
        int val;
        ListNode next;

        ListNode(int x){
            val = x;
        }

        ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }

        public ListNode(int[] nums){
            if(nums == null || nums.length == 0){
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
            while (curr != null){
                s.append(curr.val);
                s.append("->");
                curr = curr.next;
            }
            s.append("NULL");
            return s.toString();
        }
    }
}
