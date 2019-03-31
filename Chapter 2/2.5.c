#include "linked_list.h"

node convertToList(int sum) {
  int *arr = toArray(sum);
  return fromArray(arr, sizeof(*arr));
}

int main() {
  // Initialize the first list.
  int values[] = {6, 7, 2};
  int length = sizeof(values) / sizeof(values[0]);
  node head = fromArray(values, length);

  // Initialize the second list.
  int values2[] = {1, 3, 3, 4};
  int length2 = sizeof(values2) / sizeof(values2[0]);
  node head2 = fromArray(values2, length2);

  int sum = convertFromList(head) + convertFromList(head2);
  printf("The sum of %d and %d is %d\n", convertFromList(head),
         convertFromList(head2), sum);

  printLinkedList(convertToList(sum));
}
