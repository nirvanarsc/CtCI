#include <stdbool.h>
#include <stdint.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

bool oneEditReplace(char* s1, char* s2) {
  int s1_length = strlen(s1);
  bool foundDifference = false;
  for (int i = 0; i < s1_length; i++) {
    if (s1[i] != s2[i]) {
      if (foundDifference) {
        return false;
      }

      foundDifference = true;
    }
  }
  return true;
}

/* Check if you can insert a character into s1 to make s2. */
bool oneEditlnsert(char* s1, char* s2) {
  int s1_length = strlen(s1);
  int s2_length = strlen(s2);
  int index1 = 0;
  int index2 = 0;
  while (index2 < s2_length && index1 < s1_length) {
    if (s1[index1] != s2[index2]) {
      if (index1 != index2) {
        return false;
      }
      index2++;
    } else {
      index1++;
      index2++;
    }
  }
  return true;
}

bool oneEditAway(char* s1, char* s2) {
  int s1_length = strlen(s1);
  int s2_length = strlen(s2);
  if (s1_length == s2_length) {
    return oneEditReplace(s1, s2);
  } else if (s1_length + 1 == s2_length) {
    return oneEditlnsert(s1, s2);
  } else if (s1_length - 1 == s2_length) {
    return oneEditlnsert(s2, s1);
  }
  return false;
}

int main(int argc, char** argv) {
  if (argc < 3) {
    printf("%s expects at least 2 arguments\n", argv[0]);
    return 1;
  }

  bool res = oneEditAway(argv[1], argv[2]);

  if (res) {
    printf("%s is one edit away from %s\n", argv[1], argv[2]);
  } else {
    printf("%s is NOT one edit away from %s\n", argv[1], argv[2]);
  }
  return 0;
}
