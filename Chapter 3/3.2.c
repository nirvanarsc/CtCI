#include "stack_min.h"

int main() {
  int arr[] = {10, 9, 8, 7, 300, 5, 4, 3, 2, 1, -1};
  int arr_length = sizeof(arr) / sizeof(arr[0]);
  struct Stack* stack = createStack(arr_length);

  pushAll(stack, arr, arr_length);
  printStack(stack);
  printf("%d\n", stack->min);
}
