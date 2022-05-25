package linkedlist_;
public class LinkedList_203 {

}
//

//
class Solution_203 {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}

//链表基本定义类，可能作为其他项目基础类
//在这儿为单向链表
class ListNode {

    //节点值
    int val;
    //下一个节点
    ListNode next;

    //无参构造
    public ListNode() {

    }

    //单个有参构造
    public ListNode(int val) {
        this.val = val;
    }

    //双参数有参构造
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    //get&set
    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public int getVal() {
        return val;
    }
}

