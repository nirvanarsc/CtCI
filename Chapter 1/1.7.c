#include <stdint.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int **rotateMatrix(int length, int **matrix) {
  // after this line, copy = 0x123213213 (pointer to memory)
  int **copy = (int **)malloc(length * sizeof(int *));
  for (int i = 0; i < length; i++)
    copy[i] = (int *)malloc(length * sizeof(int));
  // after this line, copy = [0x123213, 0x213213, 0x213213]

  for (int row = 0; row < length; row++) {
    for (int col = 0; col < length; col++) {
      copy[row][col] = matrix[length - (col + 1)][row];
    }
  }

  return copy;
}

void printMatrix(int length, int **matrix) {
  for (int row = 0; row < length; row++) {
    for (int col = 0; col < length; col++) {
      printf("%d ", matrix[row][col]);
    }
    printf("\n");
  }
}

int main() {
  // in memory as: a -> [a0 -> [1,2,3] a1 -> [4,5,6] a2 -> [7,8,9]]
  int a0[3] = {1, 2, 3};
  int a1[3] = {4, 5, 6};
  int a2[3] = {7, 8, 9};
  int *matrix[3] = {a0, a1, a2};

  // in memory as: 123456789 (sequence of NUMBERS)
  // int disp[3][3] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

  int length = sizeof(matrix) / sizeof(matrix[0]);
  int **res = rotateMatrix(length, matrix);
  printMatrix(length, res);
}
