#include <stdint.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// TODO create .h files for quick sort, merge sort & counting sort

int calcUniqueChars(char *str, int len) {
  int unique_characters = 1;
  int c = str[0];
  for (int i = 1; i < len; i++) {
    if (str[i] != c) {
      ++unique_characters;
      c = str[i];
    }
  }
  return unique_characters;
}

int main(int argc, char **argv) {
  if (argc < 2) {
    printf("%s expects at least 1 argument\n", argv[0]);
    return 1;
  }

  // Assume string is sorted
  char *string = argv[1];
  int len = strlen(string);

  int unique_characters = calcUniqueChars(string, len);

  int len2 = unique_characters * 2;

  if (len <= len2) {
    printf("%s does not need to be compressed.\n", string);
    return 0;
  } else {
    char *string2 = (char *)malloc(len2 * sizeof(char));
    int char_counter = 1;
    int character = string[0];
    int string2_index = 0;
    for (int i = 1; i <= len; i++) {
      if (character == string[i]) {
        ++char_counter;
      } else {
        string2[string2_index++] = character;
        string2[string2_index++] = char_counter + '0';
        character = string[i];
        char_counter = 1;
      }
    }

    printf(
        "%s has %d unique characters and needs to be compressed.\nCompressed "
        "string is %s\n",
        string, unique_characters, string2);
    return 0;
  }
}
