#include "stack_set.h"

int main() {
  int arr[] = {1, 2, 30, 4, 5, 6, 7, 8, 9};
  int len = sizeof(arr) / sizeof(arr[0]);
  struct SetOfStacks* set_of_stacks = createSetOfStacks(2);
  pushAllToSet(set_of_stacks, arr, len);
  popAt(set_of_stacks, 1);
  printStackSet(set_of_stacks);
}
