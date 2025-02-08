package org.example;

import java.util.Random;
import java.util.Scanner;

class Matrix{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Введите размер матрицы (строки и столбцы, не более 20х20):");
        int rows = get_valid_size(scanner, "Введите количество строк (1-20):");
        int cols = get_valid_size(scanner, "Введите количество столбцов (1-20):");

        int[][] matrix = new int[rows][cols];
        fill_matrix(matrix, random);

        System.out.println("Сгенерированная матрица:");
        print_matrix(matrix);

        int[] min_element = find_min_element(matrix);
        int[] max_element = find_max_element(matrix);
        int sum = calculate_sum(matrix);

        System.out.println("Максимальный элемент: строка " + max_element[1]
                + ", столбец " + max_element[2]
                + ", значение - " + max_element[0]);

        System.out.println("Минимальный элемент: строка " + min_element[1]
                + ", столбец " + min_element[2]
                + ", значение - " + min_element[0]);

        System.out.println("Сумма всех элементов матрицы - " + sum);

        System.out.println("Транспонированная матрица:");
        print_matrix(transpose_matrix(matrix));
    }

    private static int get_valid_size(Scanner scanner, String prompt) {
        int size;
        while (true) {
            System.out.println(prompt);
            if (scanner.hasNextInt()) {
                size = scanner.nextInt();
                if (size >= 1 && size <= 20) {
                    return size;
                } else {
                    System.out.println("Ошибка: число должно быть в диапазоне от 1 до 20.");
                }
            } else {
                System.out.println("Ошибка: введите корректное целое число.");
                scanner.next();
            }
        }
    }

    private static void fill_matrix(int[][] matrix, Random random) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = random.nextInt(100) + 1;
            }
        }
    }

    private static void print_matrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.printf("%4d", value);
            }
            System.out.println();
        }
    }

    private static int[] find_min_element(int[][] matrix) {
        int min = Integer.MAX_VALUE, row_index = 0, col_index = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] < min) {
                    min = matrix[i][j];
                    row_index = i;
                    col_index = j;
                }
            }
        }
        return new int[]{min, row_index + 1, col_index + 1};
    }

    private static int[] find_max_element(int[][] matrix) {
        int max = Integer.MIN_VALUE, row_index = 0, col_index = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                    row_index = i;
                    col_index = j;
                }
            }
        }
        return new int[]{max, row_index + 1, col_index + 1};
    }

    private static int calculate_sum(int[][] matrix) {
        int sum = 0;
        for (int[] row : matrix) {
            for (int value : row) {
                sum += value;
            }
        }
        return sum;
    }

    private static int[][] transpose_matrix(int[][] matrix){
        int[][] transposed = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                transposed[j][i] = matrix[i][j];
            }
        }
        return transposed;
    }
}
