package linkedlist_;
public class LinkedList_707 {

}

//单链表定义类
/*class ListNode {
    int val;
    ListNode next;

    public ListNode() {

    }

    public void ListNode(int val) {
        this.val = val;
    }

    public void ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

}*/

//单链表方法类
class MyLinkedList {

    //虚拟头结点
    ListNode head;
    //长度
    int size;

    public MyLinkedList() {
        head = new ListNode(0);
        size = 0;
    }

    //get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
    public int get(int index) {
        /*
        原来链表长度为 1——size 对应index 【0——size-1】
        由于加了虚拟头结点，即长度更新为 0，1——size 指针【-1——size-1】

        此处表达 0——size-1 对应原长度
         */
        if (index < 0 || index >= size) {
            return -1;
        }
        //使用临时节点可以避免 head 被更改
        ListNode currentNode = head;
        //***由于包含第一个虚拟【-1】，对应长度为 i = 0; 所以多来一次
        /*例子
        如果找第一个节点，index=0（ONE）
         */
        for (int i = 0; i <= index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode.val;
    }

    //addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。
    //插入后，新节点将成为链表的第一个节点。
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    //addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
    public void addAtTail(int val) {
        addAtIndex(size, val);

    }

    //addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为val  的节点。
    // 如果 index 等于链表的长度，则该节点将附加到链表的末尾。
    // 如果 index 大于链表长度，则不会插入节点。
    // 如果 index 小于0，则在头部插入节点。
    public void addAtIndex(int index, int val) {
        /*
        此处不应该过多思索，按题意，（如果索引大于长度，不会插入节点。）
        之后找到的节点就是末节点

        原来链表长度为 1——size 对应index 【0——size-1】
        由于加了虚拟头结点，即长度更新为 0，1——size 指针【-1——size-1】

        //由于 index 是比 size 大1的（数值上），而且找的节点为前驱节点，当他两等于时，刚好找的最后一个节点。
         */
        if (index > size) {
            return;
        }
        if (index < 0) {
            index = 0;
        }
        size++;
        ListNode pre = head;
        /*
        假如index = 0
        不执行for直接添加,前驱为-1
        pass

        假如index = size
        找到尾节点size-1，即为前驱
         */
        //找到index前节点pre
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        ListNode addNode = new ListNode(val);
        addNode.next = pre.next;
        pre.next = addNode;
    }

    //deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        size--;
        ListNode currentNode = head;
        //***找到index前驱
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        //主体是currentNode | currentNode.next 即为 index
        currentNode.next = currentNode.next.next;
    }
}

////////////////////////分隔线//////////////////////////


//编译未过，大抵思路了解
//建议看官方版本（附，末尾）

//双链表定义类
class DoublyLinkedList {
    int val;
    DoublyLinkedList prev;
    DoublyLinkedList next;

    public DoublyLinkedList() {

    }

    //构造函数没有返回类型
    public DoublyLinkedList(int val) {
        this.val = val;
    }

    public void DoublyLinkedList(int val, DoublyLinkedList next, DoublyLinkedList prev) {
        this.val = val;
        this.prev = prev;
        this.next = next;
    }
}

//双链表方法类
class MyDoublyLinkedList {


    //长度
    int size;
    //虚拟头节点
    DoublyLinkedList head;
    //虚拟尾部节点
    DoublyLinkedList tail;

    public MyDoublyLinkedList() {
        size = 0;
        head = new DoublyLinkedList(0);
        tail = new DoublyLinkedList(0);
        //哨兵节点作为伪头和伪尾
        head.next = tail;
        tail.prev = head;
    }

    //get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
    public int get(int index) {

        if (index < 0 || index >= size) {
            return -1;
        }
        // 选择最快的方式：从头部移动
        // 或从尾部移动
        DoublyLinkedList currentNode = head;
        if (index < size - index - 1)
            for (int i = 0; i <= index; i++) {
                currentNode = currentNode.next;
            }
        else {
            currentNode = tail;
            for (int i = 0; i <= size - index - 1; i++) {
                currentNode = currentNode.prev;
            }
        }
        return currentNode.val;
    }

    //addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。
    //插入后，新节点将成为链表的第一个节点。
    public void addAtHead(int val) {
        //虚拟头节点
        DoublyLinkedList pred = head;
        //下一个节点，真实头节点
        DoublyLinkedList succ = head.next;
        size++;
        DoublyLinkedList currentNode = new DoublyLinkedList(val);
        currentNode.prev = pred;
        currentNode.next = succ;
        pred.next = currentNode;
        succ.prev = currentNode;
    }

    //addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
    public void addAtTail(int val) {
        //尾节点上一个节点
        DoublyLinkedList pred = tail.prev;
        //真实尾节点
        DoublyLinkedList succ = tail;
        size++;
        DoublyLinkedList currentNode = new DoublyLinkedList(val);
        currentNode.prev = pred;
        currentNode.next = succ;
        pred.next = currentNode;
        succ.prev = currentNode;
    }


    //addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为val的节点。
    //如果 index 等于链表的长度则该节点将附加到链表的末尾。
    //如果 index 大于链表长度则不会插入节点。
    //如果index小于0，则在头部插入节点。
    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if (index < 0) {
            index = 0;
        }
        size++;
        //找到插入位置的头尾节点
        DoublyLinkedList pred = new DoublyLinkedList();
        DoublyLinkedList succ = new DoublyLinkedList();
        //前往后快
        if (index < size - index) {
            pred = head;
            //前驱
            for (int i = 0; i < index; i++) {
                pred = pred.next;
                succ = pred.next;
            }
        }
        //后往前快
        else {
            succ = tail;
            for (int i = 0; i < size - index; i++) {
                succ = succ.prev;
                pred = succ.prev;
            }
        }
        DoublyLinkedList curr = new DoublyLinkedList();
        curr.prev = pred;
        curr.next = succ;
        pred.next = curr;
        succ.prev = curr;
    }

    //deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        size--;
        //找到删除位置的头尾节点
        DoublyLinkedList pred = new DoublyLinkedList();
        DoublyLinkedList succ = new DoublyLinkedList();
        //前往后快
        if (index < size - index) {
            pred = head;
            //前驱
            for (int i = 0; i < index; i++) {
                pred = pred.next;
                succ = pred.next.next;
            }
        }
        //后往前快
        else {
            succ = tail;
            for (int i = 0; i < size - index - 1; i++) {
                succ = succ.prev;
                pred = succ.prev.prev;
            }
        }
        pred.next = succ;
        succ.prev = pred;
    }


}

//*******官方版本
/*
public class ListNode {
    int val;
    ListNode next;
    ListNode prev;
    ListNode(int x) { val = x; }
}

class MyLinkedList {
    int size;
    // sentinel nodes as pseudo-head and pseudo-tail
    ListNode head, tail;
    public MyLinkedList() {
        size = 0;
        head = new ListNode(0);
        tail = new ListNode(0);
        head.next = tail;
        tail.prev = head;
    }

    //Get the value of the index-th node in the linked list. If the index is invalid, return -1.
    public int get(int index) {
        // if index is invalid
        if (index < 0 || index >= size) return -1;

        // choose the fastest way: to move from the head
        // or to move from the tail
        ListNode curr = head;
        if (index + 1 < size - index)
            for(int i = 0; i < index + 1; ++i) curr = curr.next;
        else {
            curr = tail;
            for(int i = 0; i < size - index; ++i) curr = curr.prev;
        }

        return curr.val;
    }

    //Add a node of value val before the first element of the linked list.
    //After the insertion, the new node will be the first node of the linked list.
    public void addAtHead(int val) {
        ListNode pred = head, succ = head.next;

        ++size;
        ListNode toAdd = new ListNode(val);
        toAdd.prev = pred;
        toAdd.next = succ;
        pred.next = toAdd;
        succ.prev = toAdd;
    }

    //Append a node of value val to the last element of the linked list.
    public void addAtTail(int val) {
        ListNode succ = tail, pred = tail.prev;

        ++size;
        ListNode toAdd = new ListNode(val);
        toAdd.prev = pred;
        toAdd.next = succ;
        pred.next = toAdd;
        succ.prev = toAdd;
    }

    //Add a node of value val before the index-th node in the linked list.
    //If index equals to the length of linked list, the node will be appended to the end of linked list.
    //If index is greater than the length, the node will not be inserted.
    public void addAtIndex(int index, int val) {
        // If index is greater than the length,
        // the node will not be inserted.
        if (index > size) return;

        // [so weird] If index is negative,
        // the node will be inserted at the head of the list.
        if (index < 0) index = 0;

        // find predecessor and successor of the node to be added
        ListNode pred, succ;
        if (index < size - index) {
            pred = head;
            for(int i = 0; i < index; ++i) pred = pred.next;
            succ = pred.next;
        }
        else {
            succ = tail;
            for (int i = 0; i < size - index; ++i) succ = succ.prev;
            pred = succ.prev;
        }

        // insertion itself
        ++size;
        ListNode toAdd = new ListNode(val);
        toAdd.prev = pred;
        toAdd.next = succ;
        pred.next = toAdd;
        succ.prev = toAdd;
    }

    // Delete the index-th node in the linked list, if the index is valid.
    public void deleteAtIndex(int index) {
        // if the index is invalid, do nothing
        if (index < 0 || index >= size) return;

        // find predecessor and successor of the node to be deleted
        ListNode pred, succ;
        if (index < size - index) {
            pred = head;
            for(int i = 0; i < index; ++i) pred = pred.next;
            succ = pred.next.next;
        }
        else {
            succ = tail;
            for (int i = 0; i < size - index - 1; ++i) succ = succ.prev;
            pred = succ.prev.prev;
        }

        // delete pred.next
        --size;
        pred.next = succ;
        succ.prev = pred;
    }
}*/
