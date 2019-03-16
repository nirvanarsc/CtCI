#include <stdint.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int **setZeros(int rows, int cols, int matrix[rows][cols]) {
  int **copy = (int **)malloc(rows * sizeof(int *));
  for (int i = 0; i < cols; i++) copy[i] = (int *)malloc(cols * sizeof(int));

  int *row = (int *)calloc(rows, sizeof(int));
  int *column = (int *)calloc(cols, sizeof(int));

  for (int i = 0; i < rows; i++) {
    for (int j = 0; j < cols; j++) {
      copy[i][j] = matrix[i][j];
      if (matrix[i][j] == 0) {
        row[i] = 1;
        column[j] = 1;
      }
    }
  }

  for (int i = 0; i < rows; i++) {
    if (row[i]) {
      for (int j = 0; j < rows; j++) {
        copy[i][j] = 0;
      }
    }
  }

  for (int j = 0; j < cols; j++) {
    if (column[j]) {
      for (int i = 0; i < cols; i++) {
        copy[i][j] = 0;
      }
    }
  }

  return copy;
}

void printMatrix(int rows, int cols, int **matrix) {
  for (int row = 0; row < rows; row++) {
    for (int col = 0; col < cols; col++) {
      printf("%d ", matrix[row][col]);
    }
    printf("\n");
  }
}

int main() {
  int disp[3][4] = {{1, 1, 1, 1}, {1, 0, 1, 1}, {1, 1, 0, 1}};
  int row_length = sizeof(disp) / sizeof(disp[0]);
  int col_length = sizeof(disp[0]) / sizeof(disp[0][0]);
  printf("rows %d\n", row_length);
  printf("cols %d\n", col_length);
  int **res = setZeros(row_length, col_length, disp);
  printMatrix(row_length, col_length, res);
}
