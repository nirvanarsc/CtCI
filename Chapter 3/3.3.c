#include "stack_set.h"

int main() {
  int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
  int len = sizeof(arr) / sizeof(arr[0]);
  StackSet* set_of_stacks = createSetOfStacks(2);
  pushAllToSet(set_of_stacks, arr, len);
  printf("Popping %d at index 1.\n", popAt(set_of_stacks, 1));
  printf("Popping %d at index 1.\n", popAt(set_of_stacks, 1));
  printStackSet(set_of_stacks);
  printf("\n");

  pushToSet(set_of_stacks, 10);
  pushToSet(set_of_stacks, 10);
  printStackSet(set_of_stacks);
  printf("\n");

  printf("Popping %d at index 3.\n", popAt(set_of_stacks, 3));
  printf("Popping %d at index 3.\n", popAt(set_of_stacks, 3));
  printStackSet(set_of_stacks);
}
