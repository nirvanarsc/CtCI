#include "linked_list.h"

int main() {
  // Initialize the list.
  node head = createNode();
  head->data = 'a';
  char values[] = {'b', 'c', 'd', 'e'};
  int length = sizeof(values) / sizeof(values[0]);
  addCharNodes(head, values, length);

  printf("Before:\n");
  printCharLinkedList(head);
  printf("After:\n");
  deleteMiddleNode(head->next->next);
  printCharLinkedList(head);
}
