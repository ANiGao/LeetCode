package linkedlist_;
public class LinkedList_Interview_0207 {

}

class Solution_Interview_0207 {

    /*
    思路：
    1.先排除二者中，长的一方多出来的部分
    2.然后进行遍历对比
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        // A 链表总个数
        ListNode curA = headA;
        int aNum = 0;

        // B 链表总个数
        ListNode curB = headB;
        int bNum = 0;
        while (curA != null) {
            curA = curA.next;
            aNum++;
        }
        while (curB != null) {
            curB = curB.next;
            bNum++;
        }

        curA = headA;
        curB = headB;

        //让 A 和 B 的长度相同
        if (aNum > bNum) {
            for (int i = 0; i < aNum - bNum; i++) {
                curA = curA.next;
            }
        } else if (aNum < bNum) {
            for (int i = 0; i < bNum - aNum; i++) {
                curB = curB.next;
            }
        }
        while (curA != null) {
            if (curA == curB) {
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }
        return null;
    }


}