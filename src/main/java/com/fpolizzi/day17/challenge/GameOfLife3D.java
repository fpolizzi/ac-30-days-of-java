package com.fpolizzi.day17.challenge;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by fpolizzi on 13.11.25
 */
public class GameOfLife3D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("=== 3D Game of Life ===");
        System.out.print("Enter cube size: ");
        int size = scanner.nextInt();
        System.out.print("Enter number of generations: ");
        int generations = scanner.nextInt();

        int[][][] grid = new int[size][size][size];
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                for (int k = 0; k < size; k++)
                    grid[i][j][k] = random.nextInt(2);

        for (int gen = 0; gen <= generations; gen++) {
            System.out.println("\nGeneration " + gen + ":");
            display3DGrid(grid);
            System.out.println("Live cells: " + countLiveCells(grid));
            if (gen < generations) grid = nextGeneration(grid);
        }

        scanner.close();
    }

    static void display3DGrid(int[][][] grid) {
        int size = grid.length;
        for (int layer = 0; layer < size; layer++) {
            System.out.println("Layer " + layer + ":");
            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    System.out.print(grid[layer][row][col] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    static int countLiveCells(int[][][] grid) {
        int count = 0, size = grid.length;
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                for (int k = 0; k < size; k++)
                    count += grid[i][j][k];
        return count;
    }

    static int[][][] nextGeneration(int[][][] grid) {
        int size = grid.length;
        int[][][] next = new int[size][size][size];
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                for (int k = 0; k < size; k++) {
                    int neighbors = countNeighbors(grid, i, j, k);
                    int current = grid[i][j][k];
                    if (current == 1) next[i][j][k] = (neighbors >= 2 && neighbors <= 3) ? 1 : 0;
                    else next[i][j][k] = (neighbors == 3) ? 1 : 0;
                }
        return next;
    }

    static int countNeighbors(int[][][] grid, int layer, int row, int col) {
        int size = grid.length, count = 0;
        for (int di = -1; di <= 1; di++)
            for (int dj = -1; dj <= 1; dj++)
                for (int dk = -1; dk <= 1; dk++) {
                    if (di == 0 && dj == 0 && dk == 0) continue;
                    int nl = layer + di, nr = row + dj, nc = col + dk;
                    if (nl >= 0 && nl < size && nr >= 0 && nr < size && nc >= 0 && nc < size)
                        count += grid[nl][nr][nc];
                }
        return count;
    }
}
