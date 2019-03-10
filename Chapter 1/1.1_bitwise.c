#include <stdint.h>
#include <stdio.h>
#include <string.h>

int main(int argc, char **argv) {
  if (argc < 2) {
    printf("%s expects at least 1 argument\n", argv[0]);
    return 1;
  }

  /* Assumes only letters a through z. */
  char *string = argv[1];

  int len = strlen(string);

  if (len > 26) {
    printf("String contains duplicate characters!\n");
    return 0;
  }
  uint8_t checker = 0;

  for (uint8_t i = 0; i < len; i++) {
    int val = string[i] - 'a';
    if ((checker & (1 << val)) > 0) {
      printf("String contains duplicate characters! %c\n", string[i]);
      return 0;
    }
    checker |= (1 << val);
  }
  printf("String contains only unique characters! OK!\n");
  return 0;
}