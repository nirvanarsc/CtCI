#include <stdint.h>
#include <stdio.h>
#include "linked_list.h"

void removeDuplicates(node head) {
  node n = head;
  uint8_t *map = (uint8_t *)calloc(128, sizeof(uint8_t));
  while (n->next != NULL) {
    if (map[n->data] == 1) {
      deleteMiddleNode(n);
    } else {
      map[n->data] = 1;
      n = n->next;
    }
    if (n->next == NULL && map[n->data] == 1) {
      deleteLastNode(head);
    }
  }
}

int main() {
  // Initialize the list.
  node head = createNode();
  head->data = 0;
  int values[] = {2, 3, 5, 2, 5, 1, 5, 1, 3, 10, 3};

  int length = sizeof(values) / sizeof(values[0]);
  addNodes(head, values, length);

  printf("Before:\n");
  printLinkedList(head);
  removeDuplicates(head);
  printf("After:\n");
  printLinkedList(head);
}
