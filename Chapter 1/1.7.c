#include <stdint.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int **rotateMatrix(int length, int matrix[length][length]) {
  int **copy = (int **)malloc(length * sizeof(int *));
  for (int i = 0; i < length; i++)
    copy[i] = (int *)malloc(length * sizeof(int));

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
  int disp[3][3] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
  int length = sizeof(disp[0]) / sizeof(disp[0][0]);
  int **res = rotateMatrix(length, disp);
  printMatrix(length, res);
}
