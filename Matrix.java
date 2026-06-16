import java.util.Scanner;
import java.util.Arrays;

public class Matrix {

    static void tampilkanMatrix(int[][] matrix) {
        System.out.println("\nMATRIX:");
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static int[][] sortRowWise(int[][] matrix) {
        int[][] result = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            result[i] = matrix[i].clone();
            Arrays.sort(result[i]);
        }
        return result;
    }

    static int[][] sortColumnWise(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] result = new int[rows][cols];

        for (int j = 0; j < cols; j++) {
            int[] kolom = new int[rows];
            for (int i = 0; i < rows; i++) {
                kolom[i] = matrix[i][j];
            }
            Arrays.sort(kolom);
            for (int i = 0; i < rows; i++) {
                result[i][j] = kolom[i];
            }
        }
        return result;
    }

    static int[][] rotateClockwiseByOne(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            result[i] = matrix[i].clone();
        }

        for (int j = 0; j < cols - 1; j++) {
            result[0][j + 1] = matrix[0][j];
        }

        for (int i = 0; i < rows - 1; i++) {
            result[i + 1][cols - 1] = matrix[i][cols - 1];
        }

        for (int j = cols - 1; j > 0; j--) {
            result[rows - 1][j - 1] = matrix[rows - 1][j];
        }

        for (int i = rows - 1; i > 0; i--) {
            result[i - 1][0] = matrix[i][0];
        }

        return result;
    }

    static int[][] rotateCounterClockwiseByOne(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            result[i] = matrix[i].clone();
        }

        for (int i = 0; i < rows - 1; i++) {
            result[i + 1][0] = matrix[i][0];
        }

        for (int j = 0; j < cols - 1; j++) {
            result[rows - 1][j + 1] = matrix[rows - 1][j];
        }

        for (int i = rows - 1; i > 0; i--) {
            result[i - 1][cols - 1] = matrix[i][cols - 1];
        }

        for (int j = cols - 1; j > 0; j--) {
            result[0][j - 1] = matrix[0][j];
        }

        return result;
    }

    static int[][] rotate90(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] result = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[j][rows - 1 - i] = matrix[i][j];
            }
        }
        return result;
    }

    static int[][] rotate180(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix[rows - 1 - i][cols - 1 - j];
            }
        }
        return result;
    }

    static void rowWiseTraversal(int[][] matrix) {
        System.out.println("\nRow-wise Traversal:");
        for (int[] row : matrix) {
            for (int item : row) {
                System.out.print(item + " ");
            }
        }
        System.out.println("\n");
    }

    static void columnWiseTraversal(int[][] matrix) {
        System.out.println("\nColumn-wise Traversal:");
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int j = 0; j < cols; j++) {
            for (int i = 0; i < rows; i++) {
                System.out.print(matrix[i][j] + " ");
            }
        }
        System.out.println("\n");
    }

    static void spiralPrint(int[][] matrix) {
        System.out.println("\nSpiral Traversal:");

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                System.out.print(matrix[top][i] + " ");
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                System.out.print(matrix[i][right] + " ");
            }
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    System.out.print(matrix[bottom][i] + " ");
                }
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    System.out.print(matrix[i][left] + " ");
                }
                left++;
            }
        }

        System.out.println("\n");
    }

    static int[][] transpose(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] result = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[j][i] = matrix[i][j];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== INPUT MATRIX baris dan Kolom ===");
        System.out.print("Masukkan jumlah baris : ");
        int rows = sc.nextInt();
        System.out.print("Masukkan jumlah kolom : ");
        int cols = sc.nextInt();

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("Elemen [" + (i + 1) + "][" + (j + 1) + "] : ");
                matrix[i][j] = sc.nextInt();
            }
        }

        tampilkanMatrix(matrix);

        while (true) {
            System.out.println("""
            ========= MENU =========
            1. Sort the matrix row-wise
            2. Sort the matrix column-wise
            3. Rotate Matrix Clockwise by 1
            4. Rotate Matrix Counter-Clockwise by 1
            5. Rotate a matrix by 90
            6. Rotate a matrix by 180
            7. Row-wise traversal of matrix
            8. Column-wise traversal of matrix
            9. Print matrix in spiral form
            10. Transpose matrix
            0. Quit
            ========================
            """);

            System.out.print("Pilih menu : ");
            int pilihan = sc.nextInt();

            switch (pilihan) {
                case 1:
                    matrix = sortRowWise(matrix);
                    tampilkanMatrix(matrix);
                    break;
                case 2:
                    matrix = sortColumnWise(matrix);
                    tampilkanMatrix(matrix);
                    break;
                case 3:
                    matrix = rotateClockwiseByOne(matrix);
                    tampilkanMatrix(matrix);
                    break;
                case 4:
                    matrix = rotateCounterClockwiseByOne(matrix);
                    tampilkanMatrix(matrix);
                    break;
                case 5:
                    matrix = rotate90(matrix);
                    tampilkanMatrix(matrix);
                    break;
                case 6:
                    matrix = rotate180(matrix);
                    tampilkanMatrix(matrix);
                    break;
                case 7:
                    rowWiseTraversal(matrix);
                    break;
                case 8:
                    columnWiseTraversal(matrix);
                    break;
                case 9:
                    spiralPrint(matrix);
                    break;
                case 10:
                    matrix = transpose(matrix);
                    tampilkanMatrix(matrix);
                    break;
                case 0:
                    System.out.println("Program selesai.");
                    sc.close();
                    return;
                default:
                    System.out.println("Pilihan tidak tersedia!");
            }
        }
    }
}