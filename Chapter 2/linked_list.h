#include <math.h>
#include <stdarg.h>
#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>

typedef struct LinkedList *node;

struct LinkedList {
  int data;
  struct LinkedList *next;
};

node createNode() {
  node temp;
  temp = (node)malloc(sizeof(struct LinkedList));
  temp->next = NULL;
  return temp;
}

node createValueNode(int value) {
  node temp;
  temp = (node)malloc(sizeof(struct LinkedList));
  temp->next = NULL;
  temp->data = value;
  return temp;
}

node linkNodes(node head, int count, ...) {
  node curr = head;
  va_list ap;
  va_start(ap, count);
  for (int j = 0; j < count; j++) {
    node t = va_arg(ap, node);
    curr->next = t;
    curr = t;
  }
  va_end(ap);
  return head;
}

node addNode(node head, int value) {
  node temp, p;
  temp = createNode();
  temp->data = value;
  if (head == NULL) {
    head = temp;
  } else {
    p = head;
    while (p->next != NULL) {
      p = p->next;
    }
    p->next = temp;
  }
  return head;
}

void addNodes(node head, int *values, int length) {
  for (int i = 0; i < length; i++) {
    addNode(head, values[i]);
  }
}

void addCharNodes(node head, char *values, int length) {
  for (int i = 0; i < length; i++) {
    addNode(head, values[i]);
  }
}

node fromArray(int *values, int length) {
  node head = createNode();
  head->data = values[0];
  for (int i = 1; i < length; i++) {
    addNode(head, values[i]);
  }
  return head;
}

node fromReverseArray(int *values, int length) {
  node head = createNode();
  head->data = values[length - 1];
  for (int i = length - 2; i >= 0; i--) {
    addNode(head, values[i]);
  }
  return head;
}

node deleteNode(node head, int value) {
  node n = head;

  if (n->data == value) {
    return head->next;
  }

  while (n->next != NULL) {
    if (n->next->data == value) {
      n->next = n->next->next;
      return head;
    }
    n = n->next;
  }
  return head;
}

void deleteMiddleNode(node middle) {
  if (middle == NULL || middle->next == NULL) {
    printf("Cannot remove the last element!\n");
    return;
  }

  node next = middle->next;
  middle->data = next->data;
  middle->next = next->next;
}

void deleteLastNode(node head) {
  node n = head;
  if (head == NULL || head->next == NULL) {
    return;
  }
  while (n->next->next != NULL) {
    n = n->next;
  }
  n->next = NULL;
  free(n->next);
}

void printLinkedList(node head) {
  node n = head;
  while (n != NULL) {
    printf("%d ", n->data);
    n = n->next;
  }
  printf("\n");
}

void printCharLinkedList(node head) {
  node n = head;
  while (n->next != NULL) {
    printf("%c ", n->data);
    n = n->next;
  }
  printf("%c\n", n->data);
}

int getLength(node head) {
  node n = head;
  int length = 1;
  while (n->next != NULL) {
    length++;
    n = n->next;
  }
  return length;
}

int *toArray(int number) {
  int n = log10(number) + 1;
  int *numberArray = calloc(n, sizeof(int));
  for (int i = 0; i < n; ++i, number /= 10) {
    numberArray[i] = number % 10;
  }
  return numberArray;
}

// 6 7 2 => 276
int convertFromList(node head) {
  node n = head;
  int index = 0;
  int res = 0;
  while (n->next != NULL) {
    res += n->data * pow(10, index++);
    n = n->next;
  }
  res += n->data * pow(10, index++);
  return res;
}

// 6 7 2 => 672
int convertFromReverseList(node head) {
  node n = head;
  int index = getLength(head);
  int res = 0;
  while (n->next != NULL) {
    res += n->data * pow(10, --index);
    n = n->next;
  }
  res += n->data * pow(10, --index);
  return res;
}

node reverse(node head) {
  node prev = NULL;
  node current = head;
  node next = NULL;
  while (current != NULL) {
    next = current->next;
    current->next = prev;
    prev = current;
    current = next;
  }
  head = prev;
  return head;
}
