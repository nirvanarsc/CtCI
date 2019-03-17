#include <stdbool.h>
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
  uint32_t checker = 0;

  for (int x = 0; x < len; x++) {
    uint8_t c = string[x];
    if ('A' <= c && c <= 'Z') {
      // 32 is the character for space so c += ' '; is also valid
      // Convert to lowercase.
      c += 32;
    }
    // a is now 0, b=1, z=25
    c -= 'a';
    checker ^= 1 << c;
  }

  bool flag = false;
  for (int x = 0; x < 32; x++) {
    uint32_t toggle = checker & (1 << x);
    if (flag && toggle) {
      printf(
          "%s is NOT a permutation of a palindrome.\nSecond invalid character "
          "is %c\n",
          string, x + 'a');
      return 1;
    } else if (toggle) {
      flag = true;
    }
  }
  printf("%s is a permutation of a palindrome \n", string);
  return 0;
}
