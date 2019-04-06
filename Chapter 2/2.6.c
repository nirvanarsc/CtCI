#include <stdbool.h>
#include "linked_list.h"

/* This is a singly linked list solution. For doubly linked list we can use two
 * indexes one at the start and one at the end that check if each value is
 * equal. With a doubly linked list we can also start in the middle and work our
 * way toward the beginning/end of the list.
 */

bool isPalindrome(node first, node reverse) {
  node k = first;
  node j = reverse;
  while (k->next != NULL && j->next != NULL) {
    if (k->data != j->data) {
      return false;
    }
    k = k->next;
    j = j->next;
  }
  return true;
}

int main() {
  // Initialize the first list.
  int values[] = {1, 2, 3, 4, 5, 2, 5, 4, 3, 2, 1};
  int length = sizeof(values) / sizeof(values[0]);
  node head1 = fromArray(values, length);
  node head2 = fromArray(values, length);
  node reversed = reverse(head1);

  isPalindrome(head2, reversed) ? printf("Success\n")
                                : printf("Not a palindrome\n");
}
