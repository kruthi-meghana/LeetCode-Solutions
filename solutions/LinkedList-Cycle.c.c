/**
 *Question: Given head, the head of a linked list, determine if the linked list has a cycle in it.
 *
 *There is a cycle in a linked list if there is some node in the list that can be reached again by  *continuously following the next pointer. Internally, pos is used to denote the index of the node   *that tail's next pointer is connected to. Note that pos is not passed as a parameter.
 *
 *Return true if there is a cycle in the linked list. Otherwise, return false.
 * @author: Kruthi Meghana
 */

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
bool hasCycle(struct ListNode *head) {
    
    if(head == NULL)
        return false;
    
    struct ListNode *slowPtr = head;
    struct ListNode *fastPtr = head->next;
    
    while(slowPtr < fastPtr && slowPtr != NULL && fastPtr != NULL && fastPtr-> next != NULL) {
        slowPtr = slowPtr -> next;
        fastPtr = fastPtr -> next -> next;
    }
    
    
    if (fastPtr == NULL || fastPtr -> next == NULL || slowPtr == NULL)
        return false;
    return true;
}