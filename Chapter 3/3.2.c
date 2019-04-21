#include "stack_min.h"

int main() {
  int arr[] = {10, 9, 8, 7, 300, 5, 4, 3, 2, 1, 20};
  int arr_length = sizeof(arr) / sizeof(arr[0]);
  struct MStack* stack = createMStack(arr_length);

  pushMAll(stack, arr, arr_length);
  printMStack(stack);

  popM(stack);
  popM(stack);
  popM(stack);
  printMStack(stack);
  printf("%d\n", min(stack));
  popM(stack);
  popM(stack);
  popM(stack);
  popM(stack);
  printMStack(stack);
  printf("%d\n", min(stack));
}
