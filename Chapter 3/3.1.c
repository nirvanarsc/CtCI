#include "stack.h"
#include "string.h"

int main() {
  int arr_size = 100;
  int split_size = arr_size / 3;
  int* arr = malloc(arr_size * sizeof(int));
  int index = 0;
  while (index < arr_size) {
    arr[index] = index;
    index++;
  }

  int* firstPart = malloc(split_size * sizeof(int));
  int* secondPart = malloc(split_size * sizeof(int));
  int* thirdPart = malloc(split_size * sizeof(int));

  memcpy(firstPart, arr, split_size * sizeof(int));
  memcpy(secondPart, arr + split_size, split_size * sizeof(int));
  memcpy(thirdPart, arr + 2 * split_size, split_size * sizeof(int));

  Stack* stack1 = createStack(split_size);
  Stack* stack2 = createStack(split_size);
  Stack* stack3 = createStack(split_size);

  pushAll(stack1, firstPart, split_size);
  pushAll(stack2, secondPart, split_size);
  pushAll(stack3, thirdPart, split_size);

  printStack(stack1);
  printStack(stack2);
  printStack(stack3);
}
