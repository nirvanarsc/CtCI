#include <string.h>
#include "stack.h"

typedef struct SetOfStacks {
  int size;
  int curr_stack;
  int max_stack_size;
  Stack** stacks;
} StackSet;

StackSet* createSetOfStacks(int capacity) {
  StackSet* set_of_stacks = malloc(sizeof(StackSet));
  set_of_stacks->size = 0;
  set_of_stacks->curr_stack = 0;
  set_of_stacks->max_stack_size = capacity;
  set_of_stacks->stacks =
      malloc(sizeof(Stack) * (set_of_stacks->curr_stack + 1));
  set_of_stacks->stacks[set_of_stacks->curr_stack] =
      createStack(set_of_stacks->max_stack_size);
  return set_of_stacks;
}

bool isSetEmpty(StackSet* set_of_stacks) { return set_of_stacks->size == 0; }

void pushToSet(StackSet* set_of_stacks, int item) {
  int* index = &set_of_stacks->curr_stack;
  Stack* curr = set_of_stacks->stacks[*index];

  if (isFull(curr)) {
    Stack** increased = malloc(sizeof(Stack) * (++*index + 1));
    memcpy(increased, set_of_stacks->stacks, sizeof(Stack) * *index);
    free(set_of_stacks->stacks);
    set_of_stacks->stacks = increased;
    curr = set_of_stacks->stacks[*index] =
        createStack(set_of_stacks->max_stack_size);
  }
  set_of_stacks->size++;
  push(curr, item);
}

void pushAllToSet(StackSet* set_of_stacks, int* items, int items_length) {
  for (int i = 0; i < items_length; i++) {
    pushToSet(set_of_stacks, items[i]);
  }
}

int popFromSet(StackSet* set_of_stacks) {
  int* index = &set_of_stacks->curr_stack;
  Stack* curr = set_of_stacks->stacks[*index];

  if (isSetEmpty(set_of_stacks)) {
    return INT_MIN;
  }

  if (isEmpty(curr)) {
    Stack** decreased = malloc(sizeof(Stack) * (--*index + 1));
    memcpy(decreased, set_of_stacks->stacks, sizeof(Stack) * *index);
    free(set_of_stacks->stacks);
    set_of_stacks->stacks = decreased;
    curr = set_of_stacks->stacks[*index];
  }

  int res = pop(curr);
  printf("POPPING %d FROM STACK %d\n", res, *index);
  set_of_stacks->size--;
  return res;
}

void printStackSet(StackSet* set_of_stacks) {
  for (int i = 0; i <= set_of_stacks->curr_stack; i++) {
    if (isEmpty(set_of_stacks->stacks[i])) {
      continue;
    }
    printf("PRINTING STACK %d\n", i);
    printStack(set_of_stacks->stacks[i]);
  }
}

int popAt(StackSet* set_of_stacks, int index) {
  if (index > set_of_stacks->curr_stack) {
    return INT_MIN;
  }
  Stack* curr = set_of_stacks->stacks[index];
  int res = pop(curr);
  if (isEmpty(curr)) {
    while (index < set_of_stacks->curr_stack) {
      Stack* c = set_of_stacks->stacks[index];
      Stack* n = set_of_stacks->stacks[++index];
      *c = *n;
    }
    set_of_stacks->curr_stack--;
  }
  return res;
}
