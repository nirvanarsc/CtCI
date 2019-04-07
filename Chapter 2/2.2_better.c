#include "linked_list.h"

node KthToLast(node head, int k) {
  node slow = head;
  node fast = head;
  for (int i = 0; i < k; i++) {
    if (fast == NULL) {
      return NULL;
    }
    fast = fast->next;
  }

  while (fast != NULL) {
    fast = fast->next;
    slow = slow->next;
  }

  return slow;
}

int main() {
  // Initialize the list.
  int values[] = {2, 3, 5, 2, 1, 5, 1, 3, 2};
  int length = sizeof(values) / sizeof(values[0]);
  node head = fromArray(values, length);

  printf("Before:\n");
  printLinkedList(head);
  printf("After:\n");
  head = KthToLast(head, 9);
  printLinkedList(head);
}
