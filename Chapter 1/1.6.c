#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// TODO create .h files for quick sort, merge sort & counting sort

int main(int argc, char **argv) {
  if (argc < 2) {
    printf("%s expects at least 1 argument\n", argv[0]);
    return 1;
  }
  // Assume string is sorted
  char *string = argv[1];
  int len = strlen(string);

  // aabcccccaaa => a2b1c5a3

  // if aabbc => a2b2c1

  // if len <= number of unique characters * 2 then don't compress

  // count unique characters

  int unique_characters = 1;
  int c = string[0];
  for (int i = 0; i < len; i++) {
    if (string[i] != c) {
      ++unique_characters;
      c = string[i];
    }
  }

  if (len <= unique_characters*2) {
    printf("%s does not need to be compressed.\n", string);
  } else {
    char *string2 = (char *)calloc(unique_characters*2, sizeof(char));
    int char_counter = 0;
    int character = string[0];
    int string2_index = 0;
    for (int i = 1; i<len; i++) {
      if(character == string[i]) {
        ++char_counter;
      }
      else {
        string2[string2_index++] = character;
        string2[string2_index++] = (char)char_counter;
        character = string[i];
        char_counter = 0;
      }


    }


    printf("%s has %d unique characters and needs to be compressed.\nCompressed string is %s\n", string, unique_characters, string2);
  }
}
