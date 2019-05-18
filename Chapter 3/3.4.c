#include "my_queue.h"

int main() {
  MyQueue* a = createQueue(10);
  add(a, 1);
  add(a, 2);
  add(a, 3);
  add(a, 4);
  printQueue(a);
  printf("%d\n", dequeue(a));
  printf("%d\n", dequeue(a));
  printf("%d\n", dequeue(a));
  printf("%d\n", dequeue(a));
}
