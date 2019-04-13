#include <limits.h>
#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>

struct Stack {
  int top;
  int capacity;
  int* array;
};

struct Stack* createStack(int capacity) {
  struct Stack* stack = (struct Stack*)malloc(sizeof(struct Stack));
  stack->capacity = capacity;
  stack->top = -1;
  stack->array = (int*)malloc(stack->capacity * sizeof(int));
  return stack;
}

bool isFull(struct Stack* stack) { return stack->top == stack->capacity - 1; }

bool isEmpty(struct Stack* stack) { return stack->top == -1; }

bool push(struct Stack* stack, int item) {
  if (isFull(stack)) return false;
  stack->array[++stack->top] = item;
  printf("%d pushed to stack\n", item);
  return true;
}

int pop(struct Stack* stack) {
  if (isEmpty(stack)) return INT_MIN;
  return stack->array[stack->top--];
}

int peek(struct Stack* stack) {
  if (isEmpty(stack)) return INT_MIN;
  return stack->array[stack->top];
}

void printStack(struct Stack* stack) {
  for (int i = 0; i <= stack->top; i++) {
    printf("%d", stack->array[i]);
  }
  printf("\n");
}
