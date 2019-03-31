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
  while (n->next != NULL) {
    printf("%d ", n->data);
    n = n->next;
  }
  printf("%d\n", n->data);
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
