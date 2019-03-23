#include <stdbool.h>
#include <stdint.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// Returns true if s1 is substring of s2
bool isSubstring(char* s1, char* s2) {
  int s1_length = strlen(s1);
  int s2_length = strlen(s2);

  for (int i = 0; i <= s2_length - s1_length; i++) {
    int j;

    for (j = 0; j < s1_length; j++)
      if (s2[i + j] != s1[j]) break;

    if (j == s1_length) {
      printf("Found a match at index %d\n", i);
      return true;
    }
  }

  return false;
}

int main(int argc, char** argv) {
  if (argc < 3) {
    printf("%s expects at least 2 arguments\n", argv[0]);
    return 1;
  }

  char* s1 = argv[1];
  char* s2 = argv[2];
  int s2_length = strlen(s2);
  char* s3 = (char*)malloc(s2_length * 2 * sizeof(char));
  for (int i = 0, j = s2_length; i < s2_length; i++, j++) {
    s3[i] = s2[i];
    s3[j] = s2[i];
  }

  bool res = isSubstring(s1, s3);

  if (res) {
    printf("%s is a rotation of %s\n", s2, s1);
  } else {
    printf("%s is NOT a rotation of %s\n", s2, s1);
  }
  return 0;
}
