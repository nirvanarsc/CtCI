#include "linked_list.h"

node loopDetection(node head) {
  node slow = head;
  node fast = head;

  while (fast != NULL && fast->next != NULL) {
    slow = slow->next;
    fast = fast->next->next;
    if (slow == fast) {
      break;
    }
  }

  if (fast == NULL || fast->next == NULL) {
    printf("No loop detected!\n");
    return NULL;
  }

  slow = head;
  while (slow != fast) {
    slow = slow->next;
    fast = fast->next;
  }
  printf("Loop detected at %d\n", fast->data);
  return fast;
}

int main() {
  node a = createValueNode(1);
  node b = createValueNode(2);
  node c = createValueNode(3);
  node d = createValueNode(4);
  node e = createValueNode(5);
  node f = c;
  node head1 = linkNodes(a, 5, b, c, d, e, f);

  int values[] = {1, 2, 3, 4, 5, 2, 5, 4, 3, 2, 1};
  int length = sizeof(values) / sizeof(values[0]);
  node head2 = fromArray(values, length);

  loopDetection(head1);
  loopDetection(head2);
}
