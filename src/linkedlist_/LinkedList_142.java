package linkedlist_;
public class LinkedList_142 {

}

class Solution_142 {
    /*
    具体解析：
    https://programmercarl.com/0142.%E7%8E%AF%E5%BD%A2%E9%93%BE%E8%A1%A8II.html#_142-%E7%8E%AF%E5%BD%A2%E9%93%BE%E8%A1%A8ii
     */

    public ListNode detectCycle(ListNode head) {
        //前节点 previous node 每次走两步
        ListNode pre = head;
        //后节点 back node 每次走一步
        ListNode bac = head;

        //有环时，同时把相遇节点保存下来，进行下一步查找环头
        while (pre != null && pre.next != null) {
            pre = pre.next.next;
            bac = bac.next;
            //有环
            if (pre == bac) {
                //记录相遇节点
                ListNode cur1 = pre;
                //从头开始的节点
                ListNode cur2 = head;
                //二者相遇位置为环头
                while (cur1 != cur2){
                    cur1 = cur1.next;
                    cur2 = cur2.next;
                }
                //环头
                return cur1;
            }
        }
        //无环
        return null;
    }


}
