#include "linked_list.h"

node KthToLast(node head, int position) {
  node n = head;
  int traversal_position = 0;

  while (traversal_position++ != position) {
    n = n->next;
  }

  return n;
}

int main() {
  // Initialize the list.
  node head = createNode();
  head->data = 0;
  int values[] = {2, 3, 5, 2, 1, 5, 1, 3, 2};
  int length = sizeof(values) / sizeof(values[0]);
  addNodes(head, values, length);

  printf("Before:\n");
  printLinkedList(head);
  printf("After:\n");
  head = KthToLast(head, 4);
  printLinkedList(head);
}
