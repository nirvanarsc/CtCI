#include <stdint.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void append(char* s, char c) {
  int len = strlen(s);
  s[len] = c;
  s[len + 1] = '\0';
}

int main(int argc, char** argv) {
  if (argc < 3) {
    printf("%s expects at least 2 arguments\n", argv[0]);
    return 1;
  }

  char* string = argv[1];
  
  int length = atoi(argv[2]);
  // Same as below https://opensource.apple.com/source/Libc/Libc-186/stdlib.subproj/atoi.c.auto.html
  // int length = strtol(argv[2], NULL, 10);
  int resultLength = 0;

  for (int i = 0; i < length; i++) {
    if (string[i] == ' ') {
      resultLength += 3;
    } else
      resultLength += 1;
  }

  char result[resultLength];

  for (int i = 0; i < length; i++) {
    if (string[i] == ' ') {
      append(result, '%');
      append(result, '2');
      append(result, '0');
    } else
      append(result, string[i]);
  }

  printf("The result is %s\n", result);
}
