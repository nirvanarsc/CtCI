#include <stdint.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// TODO create .h files for quick sort, merge sort & counting sort

unsigned int calcSequentialChars(char *str, int len) {
  unsigned int sequences = 1;
  int c = str[0];
  for (int i = 1; i < len; i++) {
    if (str[i] != c) {
      ++sequences;
      c = str[i];
    }
  }
  return sequences;
}

int main(int argc, char **argv) {
  if (argc < 2) {
    printf("%s expects at least 1 argument\n", argv[0]);
    return 1;
  }

  // Assume string is sorted
  char *string = argv[1];
  int len = strlen(string);

  unsigned int sequences = calcSequentialChars(string, len);

  int len2 = sequences * 2;

  if (len <= len2) {
    printf("%s does not need to be compressed.\n", string);
    return 0;
  }
  char *string2 = (char *)malloc((len2 + 1) * sizeof(char));
  int char_counter = 1;
  int character = string[0];
  int string2_index = 0;
  for (int i = 1; i <= len; i++) {
    if (character == string[i]) {
      ++char_counter;
    } else {
      string2[string2_index++] = character;
      string2_index += sprintf(&string2[string2_index], "%d", char_counter);
      character = string[i];
      char_counter = 1;
    }
  }

  printf(
      "%s has %d unique characters and needs to be compressed.\nCompressed "
      "string is %s\n",
      string, sequences, string2);
  return 0;
}
