package linkedlist_;
public class LinkedList_206 {

}

/** ListNode 定义
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution_206 {
    //以下为解法
    /**
     *利用 ListNode 构造方法使用 新链表 直接进行反转
     */
    /*class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode ans = null;
            for (ListNode x = head; x != null; x = x.next) {
                ans = new ListNode(x.val,ans);
            }
            return ans;
        }
    }*/




/**
 *     思路:双指针迭代  正向顺序反转
 *     null haed node2 node3 node4....node(tail - 1 ) tail【原链表】
 *
 *     //定位
 *     left = null
 *     right = head
 *
 *     temp = right.next（暂时保存）
 *     //反转
 *     right.next = left
 *
 *     //移动
 *     left = right (head反转后)
 *     right = temp (node2原)//此时原head已变，head.next 不能指向note2。 所以要提前保存
 *
 *
 *      */

    /*public ListNode reverseList(ListNode head) {
        //给 left 赋空值,作为反转链表 尾 。
        ListNode left = null;
        ListNode right = head;
        ListNode temp = null;
        while (right != null) {
            temp = right.next;
            right.next = left;
            //往后移
            left = right;
            right = temp;
        }
        return left;
    }*/

    //----------------------------------------------

    /**
     * 递归一:  双指针递归反转
     * 开始 null , head
     * 循环 不断改变 right 节点的next 为 left
     * 结束 right == null  return left
     */
    public ListNode reverseList(ListNode head) {
        return reverse(null, head);
    }

    public ListNode reverse(ListNode left, ListNode right) {
        if (right == null) {
            return left;
        }
        //临时节点保存
        ListNode temp = right.next;
        right.next = left;

        return reverse(right, temp);

    }
}
//-------------------------------------------------------

/**
 *递归二:  单头节点递归反转
 *      由于是单指针，单反转一个节点后，需要释放前一个节点的指针，不然造成环路
 *
 * 以链表1->2->3->4->5举例
 *
 * @param head
 * @return
 */

/*
public ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) {
            */
/*
                直到当前节点的下一个节点为空时返回当前节点
                由于5没有下一个节点了，所以此处返回节点5
             *//*

        return head;
    }
    //递归传入下一个节点，目的是为了到达最后一个节点
    ListNode newHead = reverseList(head.next);
                */
/*
            第一轮出栈，head为5，head.next为空，返回5
            第二轮出栈，head为4，head.next为5，执行head.next.next=head也就是5.next=4，
                      把当前节点的子节点的子节点指向当前节点
                      此时链表为1->2->3->4<->5，由于4与5互相指向，所以此处要断开4.next=null
                      此时链表为1->2->3->4<-5
                      返回节点5
            第三轮出栈，head为3，head.next为4，执行head.next.next=head也就是4.next=3，
                      此时链表为1->2->3<->4<-5，由于3与4互相指向，所以此处要断开3.next=null
                      此时链表为1->2->3<-4<-5
                      返回节点5
            第四轮出栈，head为2，head.next为3，执行head.next.next=head也就是3.next=2，
                      此时链表为1->2<->3<-4<-5，由于2与3互相指向，所以此处要断开2.next=null
                      此时链表为1->2<-3<-4<-5
                      返回节点5
            第五轮出栈，head为1，head.next为2，执行head.next.next=head也就是2.next=1，
                      此时链表为1<->2<-3<-4<-5，由于1与2互相指向，所以此处要断开1.next=null
                      此时链表为1<-2<-3<-4<-5
                      返回节点5
            出栈完成，最终头节点5->4->3->2->1
         *//*
    // 把当前节点的子节点的子节点指向当前节点
    head.next.next = head;

    head.next = null;
    return newHead;
}*/
