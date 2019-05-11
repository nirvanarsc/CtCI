#include <stdio.h>
#include <stdlib.h>
#include "stack.h"

typedef struct MStack {
  int top;
  int capacity;
  Stack* mins;
  int* array;
} MStack;

MStack* createMStack(int capacity) {
  MStack* stack = malloc(sizeof(MStack));
  Stack* mins = createStack(capacity);
  push(mins, INT_MAX);
  stack->capacity = capacity;
  stack->top = -1;
  stack->mins = mins;
  stack->array = malloc(stack->capacity * sizeof(int));
  return stack;
}

bool isMFull(MStack* stack) { return stack->top == stack->capacity - 1; }

bool isMEmpty(MStack* stack) { return stack->top == -1; }

bool pushM(MStack* stack, int item) {
  if (isMFull(stack)) return false;
  stack->array[++stack->top] = item;
  if (item <= peek(stack->mins)) {
    push(stack->mins, item);
  }
  return true;
}

bool pushMAll(MStack* stack, int* items, int items_length) {
  for (int i = 0; i < items_length; i++) {
    if (!pushM(stack, items[i])) {
      return false;
    }
  }
  return true;
}

int popM(MStack* stack) {
  if (isMEmpty(stack)) return INT_MIN;
  int curr = stack->array[stack->top--];
  if (curr == peek(stack->mins)) {
    pop(stack->mins);
  }
  return curr;
}

int peekM(MStack* stack) {
  if (isMEmpty(stack)) return INT_MIN;
  return stack->array[stack->top];
}

int min(MStack* stack) {
  if (isMEmpty(stack)) return INT_MIN;
  return peek(stack->mins);
}

void printMStack(MStack* stack) {
  for (int i = 0; i <= stack->top; i++) {
    printf("%d ", stack->array[i]);
  }
  printf("\n");
}
