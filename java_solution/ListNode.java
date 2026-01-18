class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    ListNode(int[] vals) {
        if (vals == null || vals.length == 0) {
            return;
        }

        this.val = vals[0];
        ListNode current = this;

        for (int i = 1; i < vals.length; i++) {
            current.next = new ListNode(vals[i]);
            current = current.next;
        }
    }
}
