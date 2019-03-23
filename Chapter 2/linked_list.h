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

void printLinkedList(node head) {
  printf("%d\n", head->data);
  if (head->next != NULL) {
    printLinkedList(head->next);
  }
}
