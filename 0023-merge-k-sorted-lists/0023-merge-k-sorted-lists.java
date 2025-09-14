/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> list = new LinkedList<>();

        for(ListNode node : lists){
            
            while(node != null){
                list.add(node.val);
                node = node.next;
            }
        }

        Collections.sort(list);
        ListNode node = new ListNode(0);
        ListNode root = node;
        for(int i : list){
            ListNode temp = new ListNode(i);
            node.next = temp;
            node = temp;
        }

        System.out.println(list.toString());
        return root.next;
    }
}