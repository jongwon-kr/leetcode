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
    public boolean isPalindrome(ListNode head) {
        boolean result = true;
        List<Integer> list = new LinkedList<>();

        ListNode currentNode = head;
        while(currentNode != null){
            list.add(currentNode.val);

            currentNode = currentNode.next;
        }

        int mid = list.size()/2;
        int start = 0, end = list.size() - 1;

        for(int i = 0; i < mid; i++){
            if(!(list.get(i) == list.get(end--))){
                result = false;
                break;
            }
        }
        return result;
    }
}