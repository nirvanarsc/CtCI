#include <stdint.h>
#include <stdio.h>
#include "linked_list.h"

void removeDuplicates(node head) {
  node n = head;
  uint8_t *map = (uint8_t *)calloc(128, sizeof(uint8_t));
  while (n->next != NULL) {
    if (map[n->data] == 1) {
      deleteDuplicateNode(head, n->data);
    }
    map[n->data] = 1;
    n = n->next;
  }

  if (map[n->data] == 1) {
    deleteDuplicateNode(head, n->data);
  }
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
  removeDuplicates(head);
  printf("After:\n");
  printLinkedList(head);
}
