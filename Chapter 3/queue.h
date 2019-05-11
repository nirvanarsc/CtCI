#include <limits.h>
#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>

typedef struct Queue {
  int front, rear, size;
  int capacity;
  int* array;
} Queue;

Queue* createQueue(int capacity) {
  Queue* queue = (Queue*)malloc(sizeof(Queue));
  queue->capacity = capacity;
  queue->front = queue->size = 0;
  queue->rear = capacity - 1;  // This is important, see the enqueue
  queue->array = (int*)malloc(queue->capacity * sizeof(int));
  return queue;
}

bool isFull(Queue* queue) { return (queue->size == queue->capacity); }

bool isEmpty(Queue* queue) { return (queue->size == 0); }

void add(Queue* queue, int item) {
  if (isFull(queue)) return;
  queue->rear = (queue->rear + 1) % queue->capacity;
  queue->array[queue->rear] = item;
  queue->size = queue->size + 1;
  printf("%d enqueued to queue\n", item);
}

int dequeue(Queue* queue) {
  if (isEmpty(queue)) return INT_MIN;
  int item = queue->array[queue->front];
  queue->front = (queue->front + 1) % queue->capacity;
  queue->size = queue->size - 1;
  return item;
}

int peekFront(Queue* queue) {
  if (isEmpty(queue)) return INT_MIN;
  return queue->array[queue->front];
}

int peekRear(Queue* queue) {
  if (isEmpty(queue)) return INT_MIN;
  return queue->array[queue->rear];
}

void printQueue(Queue* queue) {
  for (int i = queue->front; i < queue->front + queue->size; i++) {
    printf("%d ", queue->array[i]);
  }
  printf("\n");
}
