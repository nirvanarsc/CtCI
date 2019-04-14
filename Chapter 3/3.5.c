#include "stack.h"

struct Stack* sort(struct Stack* stack, int size) {
  struct Stack* sorted = createStack(size);
  push(sorted, pop(stack));

  while (!isEmpty(stack)) {
    if (peek(stack) < peek(sorted)) {
      push(sorted, pop(stack));
    } else {
      int t = pop(stack);
      while (t > peek(sorted) && !isEmpty(sorted)) {
        push(stack, pop(sorted));
      }
      push(sorted, t);
    }
  }
  return sorted;
}

int main() {
  int arr[] = {10, 9, -8, 20, 3, 50, 1};
  int arr_length = sizeof(arr) / sizeof(arr[0]);
  struct Stack* stack = createStack(arr_length);
  pushAll(stack, arr, arr_length);

  printStack(stack);
  printStack(sort(stack, arr_length));
}
