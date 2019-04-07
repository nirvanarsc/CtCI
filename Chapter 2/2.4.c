#include "linked_list.h"

node partition(node head, int partition_value) {
  node smaller = NULL;
  node smaller_start = NULL;
  node bigger = NULL;
  node bigger_start = NULL;
  while (head != NULL) {
    if (head->data >= partition_value) {
      if (bigger == NULL) {
        bigger_start = bigger = head;
      } else {
        bigger->next = head;
        bigger = bigger->next;
      }
    } else {
      if (smaller == NULL) {
        smaller_start = smaller = head;
      } else {
        smaller->next = head;
        smaller = smaller->next;
      }
    }
    head = head->next;
  }
  if (bigger != NULL) {
    bigger->next = NULL;
  }
  if (smaller != NULL) {
    smaller->next = bigger_start;
    return smaller_start;
  }

  return bigger_start;
}

int main() {
  // Initialize the list.
  int values[] = {10, 3, 5, 8, 5, 10, 2, 2};
  int length = sizeof(values) / sizeof(values[0]);
  node head = fromArray(values, length);

  printf("Before:\n");
  printLinkedList(head);
  head = partition(head, 5);
  printf("After:\n");
  printLinkedList(head);
}
