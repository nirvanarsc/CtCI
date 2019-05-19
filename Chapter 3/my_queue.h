#include <limits.h>
#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include "stack.h"

typedef struct MyQueue {
  int capacity;
  Stack *main, *temp;
} MyQueue;

MyQueue* createQueue(int capacity) {
  MyQueue* queue = malloc(sizeof(MyQueue));
  queue->capacity = capacity;
  queue->main = createStack(capacity);
  queue->temp = createStack(capacity);
  return queue;
}

bool isQueueFull(MyQueue* queue) { return isFull(queue->main); }

bool isQueueEmpty(MyQueue* queue) { return isEmpty(queue->main); }

void add(MyQueue* queue, int item) {
  if (isQueueFull(queue)) return;
  if (isQueueEmpty(queue)) {
    push(queue->main, item);
  } else {
    while (!isEmpty(queue->main)) {
      push(queue->temp, pop(queue->main));
    }
    push(queue->main, item);
    while (!isEmpty(queue->temp)) {
      push(queue->main, pop(queue->temp));
    }
  }
  printf("%d enqueued to queue\n", item);
}

int dequeue(MyQueue* queue) {
  if (isQueueEmpty(queue)) return INT_MIN;
  printf("%d dequeued from queue\n", peek(queue->main));
  return pop(queue->main);
}

void printQueue(MyQueue* queue) {
  if (isQueueEmpty(queue)) {
    printf("Queue is empty.");
  }
  for (int i = queue->main->top; i >= 0; i--) {
    printf("%d ", queue->main->array[i]);
  }
  printf("\n");
}
