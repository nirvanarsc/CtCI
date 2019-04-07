#include <stdint.h>
#include "linked_list.h"

void removeDuplicates(node head) {
  node prev = NULL;
  node curr = head;
  uint8_t *map = (uint8_t *)calloc(128, sizeof(uint8_t));
  while (curr != NULL) {
    if (map[curr->data] == 1) {
      prev->next = curr->next;
      free(curr);
      curr = prev->next;
    } else {
      map[curr->data] = 1;
      prev = curr;
      curr = curr->next;
    }
  }
}

int main() {
  // Initialize the list.
  int values[] = {2, 3, 5, 2, 5, 1, 1, 5, 1, 3, 10, 3};
  int length = sizeof(values) / sizeof(values[0]);
  node head = fromArray(values, length);

  printf("Before:\n");
  printLinkedList(head);
  removeDuplicates(head);
  printf("After:\n");
  printLinkedList(head);
}
