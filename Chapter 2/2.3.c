#include "linked_list.h"

int deleteMiddleNode(node middle) {
  if (middle == NULL || middle->next == NULL) {
    printf("Cannot remove the last element!\n");
    return 1;
  }

  node next = middle->next;
  middle->data = next->data;
  middle->next = next->next;
  return 0;
}

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
