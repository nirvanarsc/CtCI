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

node deleteDuplicateNode(node head, int value) {
  node n = head;
  bool seen = false;

  if (n->data == value) {
    seen = true;
  }

  while (n->next != NULL) {
    if (n->next->data == value) {
      if (seen) {
        n->next = n->next->next;
        return head;
      } else {
        seen = true;
      }
    }
    n = n->next;
  }
  return head;
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
