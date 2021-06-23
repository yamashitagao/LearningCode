package learning.datastructure;

/**
 * @description
 * @author:Gjc
 * @time: 9:26
 * @date: 2021-06-23
 */


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class RecycleListNode {
    //反转链表
    public ListNode reverseList(ListNode head) {
        ListNode t = null;
        ListNode r = null;
        while (head != null) {
            t = head;
            //头节点转变为第二节点（head.next）
            head = t.next;
            t.next = r;
            r = t;
        }

        return r;
    }
    //移除特定val
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        ListNode index = head;
        // 如果当前节点的 next节点值和 val相同，则删除。如果不相同，继续执行下一个。
        while (index != null && index.next != null) {
            if (index.next.val == val) {
                index.next = index.next.next;
                continue;// 这里是关键，防止出现多个目标值时露删的情况
            }
            index = index.next;
        }
        // 最后处理头部
        if (head.val == val) {
            head = head.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode ln1 = new ListNode(1);
        ListNode ln2 = new ListNode(2, ln1);
        ListNode ln3 = new ListNode(3, ln2);
        ListNode ln4 = new ListNode(4, ln3);
        RecycleListNode rln = new RecycleListNode();
        rln.reverseList(ln4);
//        rln.removeElements(ln4,3);



    }



}
