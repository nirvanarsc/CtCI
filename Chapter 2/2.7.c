#include "linked_list.h"

node checkIntersection(node head1, node head2) {
  node curr1 = head1;
  node curr2 = head2;

  while (curr1 != NULL) {
    while (curr2 != NULL) {
      if (curr1 == curr2) {
        printf("Lists intersect at node %d!\n", curr1->data);
        return curr1;
      }
      curr2 = curr2->next;
    }
    curr2 = head2;
    curr1 = curr1->next;
  }
  printf("Lists do not intersect!\n");
  return NULL;
}

int main() {
  node a = createValueNode(1);
  node b = createValueNode(2);
  node c = createValueNode(3);
  node d = createValueNode(4);
  node e = createValueNode(5);

  node f = createValueNode(1);
  node g = createValueNode(2);
  node h = c;
  node k = createValueNode(4);
  node l = createValueNode(5);

  node head1 = linkNodes(a, 4, b, c, d, e);
  node head2 = linkNodes(f, 4, g, h, k, l);

  printLinkedList(head1);
  printLinkedList(head2);
  checkIntersection(head1, head2);
}
