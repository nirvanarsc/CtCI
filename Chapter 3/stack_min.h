#include <stdio.h>
#include <stdlib.h>
#include "stack.h"

struct MStack {
  int top;
  int capacity;
  struct Stack* mins;
  int* array;
};

struct MStack* createMStack(int capacity) {
  struct MStack* stack = (struct MStack*)malloc(sizeof(struct MStack));
  struct Stack* mins = createStack(capacity);
  push(mins, INT_MAX);
  stack->capacity = capacity;
  stack->top = -1;
  stack->mins = mins;
  stack->array = (int*)malloc(stack->capacity * sizeof(int));
  return stack;
}

bool isMFull(struct MStack* stack) { return stack->top == stack->capacity - 1; }

bool isMEmpty(struct MStack* stack) { return stack->top == -1; }

bool pushM(struct MStack* stack, int item) {
  if (isMFull(stack)) return false;
  stack->array[++stack->top] = item;
  if (item <= peek(stack->mins)) {
    push(stack->mins, item);
  }
  return true;
}

bool pushMAll(struct MStack* stack, int* items, int items_length) {
  for (int i = 0; i < items_length; i++) {
    if (!pushM(stack, items[i])) {
      return false;
    }
  }
  return true;
}

int popM(struct MStack* stack) {
  if (isMEmpty(stack)) return INT_MIN;
  int curr = stack->array[stack->top--];
  if (curr == peek(stack->mins)) {
    pop(stack->mins);
  }
  return curr;
}

int peekM(struct MStack* stack) {
  if (isMEmpty(stack)) return INT_MIN;
  return stack->array[stack->top];
}

int min(struct MStack* stack) {
  if (isMEmpty(stack)) return INT_MIN;
  return peek(stack->mins);
}

void printMStack(struct MStack* stack) {
  for (int i = 0; i <= stack->top; i++) {
    printf("%d ", stack->array[i]);
  }
  printf("\n");
}
