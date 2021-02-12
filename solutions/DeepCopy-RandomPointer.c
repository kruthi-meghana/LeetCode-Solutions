/**
 *Question: A linked list of length n is given such that each node contains an additional random  *pointer, which could point to any node in the list, or null.
 *
 *Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes,  *where each new node has its value set to the value of its corresponding original node. Both the  *next and random pointer of the new nodes should point to new nodes in the copied list such that  *the pointers in the original list and copied list represent the same list state. None of the  *pointers in the new list should point to nodes in the original list.
 *
 *For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for  *the corresponding two nodes x and y in the copied list, x.random --> y.
 *
 *Return the head of the copied linked list.
 *
 *The linked list is represented in the input/output as a list of n nodes. Each node is represented  *as a pair of [val, random_index] where:
 *
 *val: an integer representing Node.val
 *random_index: the index of the node (range from 0 to n-1) that the random pointer points to, or  *null if it does not point to any node.
 *Your code will only be given the head of the original linked list.
 *
 *@author: Kruthi Meghana
 */

/**
 * Definition for a Node.
 * struct Node {
 *     int val;
 *     struct Node *next;
 *     struct Node *random;
 * };
 */

struct Node* deepCopy(struct Node* dummy) {
    struct Node* new = (struct Node*) malloc(sizeof(struct Node));
    if(dummy -> next == NULL) {
        new -> val = dummy -> val;
        new ->next = NULL;
    } else {
        new -> val = dummy -> val;
        new -> next = deepCopy(dummy -> next);
    }
    return new;
}
struct Node* copyRandomList(struct Node* head) {
    
    if (head == NULL)
        return head;
    struct Node* oldHead = head;
    struct Node* head1 = deepCopy(head);
    struct Node* newHead  = head1;
    int i = 0;

    
    while(head1 != NULL && oldHead != NULL) {
        if(oldHead -> random == NULL)
            head1 -> random = NULL;
        else {
            int index = (oldHead -> random - oldHead)/2;
            int current = 0;
            
            if (index < 0) {
                head = newHead;
                index = i + index;
            } else {
                head = head1;
            }
            
            while (head!= NULL) {
                 if (abs(index) == current) {
                    head1 -> random = head;
                    break;
                }
                head = head -> next;
                current += 1;
            }
        }
        oldHead = oldHead -> next;
        head1 = head1 -> next;
        i += 1;
    }
    
	return newHead;
}