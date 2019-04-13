#include "stack.h"

int main() {
  struct Stack* stack = createStack(6);
  struct Stack* temp = createStack(6);
  int arr[] = {10, 9, 8, 20, 3, 50};
  pushAll(stack, arr, 6);
  if (isEmpty(temp)) {
    push(temp, pop(stack));
  }
  while (!isEmpty(stack)) {
    if (peek(stack) < peek(temp)) {
      push(temp, pop(stack));
    } else {
      int t = pop(temp);
      push(temp, pop(stack));
      push(stack, t);
    }
    printStack(temp);
    printStack(stack);
  }

  printStack(temp);
  printStack(stack);
}
