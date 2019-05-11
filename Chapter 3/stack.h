#include <limits.h>
#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>

typedef struct Stack {
  int top;
  int capacity;
  int* array;
} Stack;

Stack* createStack(int capacity) {
  Stack* stack = malloc(sizeof(Stack));
  stack->capacity = capacity;
  stack->top = -1;
  stack->array = malloc(stack->capacity * sizeof(int));
  return stack;
}

bool isFull(Stack* stack) { return stack->top == stack->capacity - 1; }

bool isEmpty(Stack* stack) { return stack->top == -1; }

bool push(Stack* stack, int item) {
  if (isFull(stack)) return false;
  stack->array[++stack->top] = item;
  return true;
}

bool pushAll(Stack* stack, int* items, int items_length) {
  for (int i = 0; i < items_length; i++) {
    if (!push(stack, items[i])) {
      return false;
    }
  }
  return true;
}

int pop(Stack* stack) {
  if (isEmpty(stack)) return INT_MIN;
  return stack->array[stack->top--];
}

int peek(Stack* stack) {
  if (isEmpty(stack)) return INT_MIN;
  return stack->array[stack->top];
}

void printStack(Stack* stack) {
  if (isEmpty(stack)) {
    printf("Stack is empty.");
  }
  for (int i = 0; i <= stack->top; i++) {
    printf("%d ", stack->array[i]);
  }
  printf("\n");
}
