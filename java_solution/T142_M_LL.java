import java.util.HashSet;
import java.util.Set;

public class T142_M_LL {
    public ListNode detectCycle2(ListNode head) {
        ListNode point = head;
        Set<ListNode> set = new HashSet<>();
        while (point != null){
            if (set.contains(point)){
                return point;
            }else {
                set.add(point);
            }
            point = point.next;
        }
        return null;
    }

    public ListNode detectCycle(ListNode head){
        return null;
    }
}
