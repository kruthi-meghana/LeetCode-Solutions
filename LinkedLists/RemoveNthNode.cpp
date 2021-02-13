/**
  Question: Given the head of a linked list, remove the nth node from the end of the list and return its head.

  Example 1:

  Input: head = [1,2,3,4,5], n = 2
  Output: [1,2,3,5]

  @author: Kruthi Meghana
 */

class Solution {
public:
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        if(head == NULL)
            return head;
        
        ListNode* slowPtr = head;
        int index = 1;
        
        while(slowPtr -> next != NULL) {
            slowPtr = slowPtr -> next;
            index += 1;
        }
        slowPtr = head;
        index = index - n;
        if(index == 0)
            head = head -> next;
        else {
            while(index > 1) {
                slowPtr = slowPtr -> next;
                index--;
            }
            if(slowPtr->next == NULL)
                return NULL;
            slowPtr->next = slowPtr->next->next;   
        }
        return head;
    }
};
