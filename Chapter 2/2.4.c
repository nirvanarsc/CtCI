#include "linked_list.h"

// TODO FIX deleteNode()
void partition(node head, int partition_value) {
  node n = head;
  int length = getLength(head);
  while (length-- > 0) {
    if (n->data >= partition_value) {
      // Optimize by using deleteMiddleNote()?
      n = deleteNode(head, n->data);
      addNode(n, n->data);
    }
    n = n->next;
  }
}

int main() {
  // Initialize the list.
  node head = createNode();
  head->data = 3;
  int values[] = {5, 8, 5, 10, 2, 1};
  int length = sizeof(values) / sizeof(values[0]);
  addNodes(head, values, length);

  printf("Before:\n");
  printLinkedList(head);
  partition(head, 5);
  printf("After:\n");
  printLinkedList(head);
}
