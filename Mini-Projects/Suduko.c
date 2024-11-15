#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

#define N 9
bool rows[N][N+1];
bool cols[N][N+1];
bool boxes[N][N+1];

void printGrid(int grid[N][N]) {
    for (int row = 0; row < N; row++) {
        for (int col = 0; col < N; col++) {
            printf("%2d", grid[row][col]);
        }
        printf("\n");
    }
}

void initializeHashmaps(int grid[N][N]) {
    for (int i  = 0; i < N; i++) {
        for (int j  = 0; j < N+1; j++) {
            rows[i][j]  =  false;
            cols[i][j]  =  false;
            boxes[i][j] =  false;
        }
    }
    for (int row = 0; row < N; row++) {
        for (int col = 0; col < N; col++) {
            if (grid[row][col] != 0) {
                int num = grid[row][col];
                rows[row][num] = true;
                cols[col][num] = true;
                boxes[(row/3)*3 + col/3][num] = true;
            }
        }
    }
}

bool isSafe(int row, int col, int num) {
    return !rows[row][num] && !cols[col][num] && 
            !boxes[(row/3)*3 + col/3][num];
}

bool findEmptyLocation(int grid[N][N], int *row, int *col) {
    for (*row = 0; *row < N; (*row)++) {
        for (*col = 0; *col < N; (*col)++) {
            if (grid[*row][*col] == 0) {
                return true;
            }
        }
    }
    return false;
}

bool solveSudoku(int grid[N][N]) {
    int row, col;
    if (!findEmptyLocation(grid, &row, &col)) {
        return true;
    }
    for (int num = 1; num <= 9; num++) {
        if (isSafe(row, col, num)) {
            grid[row][col] = num;
            rows[row][num] = true;
            cols[col][num] = true;
            boxes[(row/3)*3 + col/3][num] = true;
            if (solveSudoku(grid)) {
                return true;
            }
            grid[row][col] = 0;
            rows[row][num] = false;
            cols[col][num] = false;
            boxes[(row/3)*3 + col/3][num] = false;
        }
    }
    return false;
}

int main() {
    int grid[N][N] = {
        {5, 3, 0, 0, 7, 0, 0, 0, 0},
        {6, 0, 0, 1, 9, 5, 0, 0, 0},
        {0, 9, 8, 0, 0, 0, 0, 6, 0},
        {8, 0, 0, 0, 6, 0, 0, 0, 3},
        {4, 0, 0, 8, 0, 3, 0, 0, 1},
        {7, 0, 0, 0, 2, 0, 0, 0, 6},
        {0, 6, 0, 0, 0, 0, 2, 8, 0},
        {0, 0, 0, 4, 1, 9, 0, 0, 5},
        {0, 0, 0, 0, 8, 0, 0, 7, 9}
    };

    initializeHashmaps(grid);
    if (solveSudoku(grid)) {
        printGrid(grid);
    } else {
        printf("No solution exists");
    }
    return 0;
}