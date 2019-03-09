#include <stdint.h>
#include <stdio.h>

void bin(uint8_t n) {
  for (uint8_t i = 1 << 7; i > 0; i = i / 2)
    (n & i) ? printf("1") : printf("0");
}

int main() {
  printf("Test1\n");
  printf("Test2\n");

  // int c = 0b1100011;
  uint8_t c = 257;
  uint8_t b = 2 << c;
  uint8_t a = 1 << c;
  uint8_t z = 1 << 7;
  uint8_t z_and = 5 & 3;
  uint8_t z_or = 5 | 3;
  printf("%d\t%d\t%d\n", c, b, a);
  printf("%d\n", z);
  bin(5);
  printf("\n");
  bin(3);
  printf("\n");
  bin(40);
  printf("\n");
  printf("%d\n", z_and);
  printf("%d\n", z_or);
  bin(z_and);
  printf("\n");
  bin(z_or);
  printf("\n");
}