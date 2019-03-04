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

  // Stack
  // int map[128];
  // memset(map, 0, 128);

  // Heap
  // void pointer points to a block of memory of certain size
  uint8_t *map = (uint8_t *)calloc(128, sizeof(uint8_t));
  // This would still work - allocated memory size is still the same.
  // uint8_t *map2 = (uint8_t *) calloc(sizeof(uint8_t), 128);

  // printf("%lu\n", sizeof(uint64_t));

  // Try to use bits to access the correct item in the *map
  // if we try to optimize *map for memory -> 128 -> 16
  // hint: if we get 'c' = 0b1100011
  // since 'c' = 99 => 99/16 => x = 6; y = 3
  int len = strlen(string);
  for (int x = 0; x < len; x++) {
    uint8_t c = string[x];

    if (map[c] == 1) {
      printf("String contains not unique characters, %c, %d\n", c, x);
      return 0;
    }

    map[c] = 1;
  }

  printf("String contains only unique characters! OK!\n");

  return 0;
}
