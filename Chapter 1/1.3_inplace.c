#include <stdint.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(int argc, char** argv) {
  if (argc < 3) {
    printf("%s expects at least 2 arguments\n", argv[0]);
    return 1;
  }

  // "Mr John Smith    " 13
  // "Mr%20John%20Smith"

  char* string = argv[1];
  int length = atoi(argv[2]);
  int actualLength = strlen(string);

  for (int i = length - 1, j = actualLength - 1; i >= 0; i--, j--) {
    if (string[i] == ' ') {
      string[j--] = '0';
      string[j--] = '2';
      string[j] = '%';
    } else
      string[j] = string[i];
  }

  printf("The result is '%s'\n", string);
}
