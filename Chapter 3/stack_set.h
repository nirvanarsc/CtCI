#include <string.h>
#include "stack.h"

struct SetOfStacks {
  int size;
  int curr_stack;
  int max_stack_size;
  struct Stack** stacks;
};

struct SetOfStacks* createSetOfStacks(int capacity) {
  struct SetOfStacks* set_of_stacks =
      (struct SetOfStacks*)malloc(sizeof(struct SetOfStacks));
  set_of_stacks->size = 0;
  set_of_stacks->curr_stack = 0;
  set_of_stacks->max_stack_size = capacity;
  set_of_stacks->stacks = (struct Stack**)malloc(
      sizeof(struct Stack) * (set_of_stacks->curr_stack + 1));
  set_of_stacks->stacks[set_of_stacks->curr_stack] =
      createStack(set_of_stacks->max_stack_size);
  return set_of_stacks;
}

bool isSetEmpty(struct SetOfStacks* set_of_stacks) {
  return set_of_stacks->size == 0;
}

void pushToSet(struct SetOfStacks* set_of_stacks, int item) {
  int* index = &set_of_stacks->curr_stack;
  struct Stack* curr = set_of_stacks->stacks[*index];

  if (isFull(curr)) {
    struct Stack** increased =
        (struct Stack**)malloc(sizeof(struct Stack) * (++*index + 1));
    memcpy(increased, set_of_stacks->stacks, sizeof(struct Stack) * *index);
    free(set_of_stacks->stacks);
    set_of_stacks->stacks = increased;
    curr = set_of_stacks->stacks[*index] =
        createStack(set_of_stacks->max_stack_size);
  }
  set_of_stacks->size++;
  push(curr, item);
}

void pushAllToSet(struct SetOfStacks* set_of_stacks, int* items,
                  int items_length) {
  for (int i = 0; i < items_length; i++) {
    pushToSet(set_of_stacks, items[i]);
  }
}

int popFromSet(struct SetOfStacks* set_of_stacks) {
  int* index = &set_of_stacks->curr_stack;
  struct Stack* curr = set_of_stacks->stacks[*index];

  if (isSetEmpty(set_of_stacks)) {
    return INT_MIN;
  }

  if (isEmpty(curr)) {
    struct Stack** decreased =
        (struct Stack**)malloc(sizeof(struct Stack) * (--*index + 1));
    memcpy(decreased, set_of_stacks->stacks, sizeof(struct Stack) * *index);
    free(set_of_stacks->stacks);
    set_of_stacks->stacks = decreased;
    curr = set_of_stacks->stacks[*index];
  }

  int res = pop(curr);
  printf("POPPING %d FROM STACK %d\n", res, *index);
  set_of_stacks->size--;
  return res;
}

void printStackSet(struct SetOfStacks* set_of_stacks) {
  for (int i = 0; i <= set_of_stacks->curr_stack; i++) {
    if (isEmpty(set_of_stacks->stacks[i])) {
      continue;
    }
    printf("PRINTING STACK %d\n", i);
    printStack(set_of_stacks->stacks[i]);
  }
}

void reorderStacks(struct SetOfStacks* set_of_stacks, int index) {
  if (index >= set_of_stacks->curr_stack) {
    return;
  }
  struct Stack* curr = set_of_stacks->stacks[index];
  struct Stack* next_stack = set_of_stacks->stacks[++index];
  while (!isFull(curr)) {
    push(curr, pop(next_stack));
  }
  reorderStacks(set_of_stacks, index);
}

int popAt(struct SetOfStacks* set_of_stacks, int index) {
  if (index > set_of_stacks->curr_stack) {
    return INT_MIN;
  }
  struct Stack* curr = set_of_stacks->stacks[index];
  int res = pop(curr);
  reorderStacks(set_of_stacks, index);
  return res;
}
