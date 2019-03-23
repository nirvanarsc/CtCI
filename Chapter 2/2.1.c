#include "linked_list.h"

int main() {
  node head = createNode();
  head->data = 0;
  for (int i = 1; i <= 5; i++) {
    addNode(head, i);
  }
  printLinkedList(head);
}
