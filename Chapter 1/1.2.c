#include <stdint.h>
#include <stdio.h>
#include <string.h>

char* sortString(char* string) {
  char temp;

  int i, j;
  int n = strlen(string);

  // implement quick sort or merge sort
  // try to implement count sort O(K + N)
  // bubble sort = bad O(N^2)
  for (i = 0; i < n - 1; i++) {
    for (j = i + 1; j < n; j++) {
      if (string[i] > string[j]) {
        temp = string[i];
        string[i] = string[j];
        string[j] = temp;
      }
    }
  }
  return string;
}

int main(int argc, char** argv) {
  if (argc < 3) {
    printf("%s expects at least 2 arguments\n", argv[0]);
    return 1;
  }

  char* a = argv[1];
  char* b = argv[2];
  size_t lengthA = strlen(a);
  size_t lengthB = strlen(b);

  if (lengthA != lengthB) {
    printf("Strings are not a permutation of each other\n");
    return 1;
  }

  sortString(a);
  sortString(b);

  for (size_t i = 0; i < lengthA; i++) {
    if (a[i] != b[i]) {
      printf("Strings are not a permutation of each other\n");
      return 1;
    }
  }
  printf("Strings are a permutation of each other\n");

  return 0;
}
