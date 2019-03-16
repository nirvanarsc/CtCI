#include <stdint.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(int argc, char **argv) {
  if (argc < 2) {
    printf("%s expects at least 1 argument\n", argv[0]);
    return 1;
  }

  char *string = argv[1];
  int len = strlen(string);
  uint8_t *map = (uint8_t *)calloc(128, sizeof(uint8_t));

  for (int x = 0; x < len; x++) {
    uint8_t c = string[x];
    ++map[c];
  }

  int flag = 0;
  for (int x = 0; x < 128; x++) {
    if (flag && map[x] % 2 != 0) {
      printf("%s is not a permutation of a palindrome \n", string);
      return 1;
    } else if (map[x] % 2 != 0) {
      flag = 1;
    }
  }
  printf("%s is a permutation of a palindrome \n", string);
  return 0;
}
