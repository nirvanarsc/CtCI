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

  int z = pop(curr);
  printf("POPPING %d FROM STACK %d\n", z, *index);
  set_of_stacks->size--;
  return z;
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
