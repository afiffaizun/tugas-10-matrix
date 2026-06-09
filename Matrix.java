import java.util.Arrays;
import java.util.Scanner;

public class Matrix {

    static Scanner input = new Scanner(System.in);

    public static void tampilkanMatrix(int[][] matrix, String judul) {
        System.out.println("\n" + judul + ":");
        for (int[] row : matrix) {
            for (int item : row) {
                System.out.print(item + "\t");
            }
            System.out.println();
        }
    }

    public static void tampilkanPerbandingan(int[][] asli, int[][] hasil) {
        System.out.println("\n===== PERBANDINGAN MATRIX =====");
        tampilkanMatrix(asli, "MATRIX ASLI");
        tampilkanMatrix(hasil, "HASIL OPERASI");
    }

    public static int[][] copyMatrix(int[][] matrix) {
        int[][] copy = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            copy[i] = Arrays.copyOf(matrix[i], matrix[i].length);
        }

        return copy;
    }

    public static int[][] sortRowWise(int[][] matrix) {
        int[][] result = copyMatrix(matrix);

        for (int i = 0; i < result.length; i++) {
            Arrays.sort(result[i]);
        }

        return result;
    }

    public static int[][] sortColumnWise(int[][] matrix) {
        int[][] result = copyMatrix(matrix);

        int rows = result.length;
        int cols = result[0].length;

        for (int j = 0; j < cols; j++) {

            int[] column = new int[rows];

            for (int i = 0; i < rows; i++) {
                column[i] = result[i][j];
            }

            Arrays.sort(column);

            for (int i = 0; i < rows; i++) {
                result[i][j] = column[i];
            }
        }

        return result;
    }

    public static int[][] rotate90(int[][] matrix) {
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

    public static int[][] rotate180(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[rows - 1 - i][cols - 1 - j] = matrix[i][j];
            }
        }

        return result;
    }

    public static int[][] transpose(int[][] matrix) {
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

    public static int[][] rotateClockwiseByOne(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] result = copyMatrix(matrix);

        for (int j = 0; j < cols - 1; j++)
            result[0][j + 1] = matrix[0][j];

        for (int i = 0; i < rows - 1; i++)
            result[i + 1][cols - 1] = matrix[i][cols - 1];

        for (int j = cols - 1; j > 0; j--)
            result[rows - 1][j - 1] = matrix[rows - 1][j];

        for (int i = rows - 1; i > 0; i--)
            result[i - 1][0] = matrix[i][0];

        return result;
    }

    public static int[][] rotateCounterClockwiseByOne(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] result = copyMatrix(matrix);

        for (int i = 0; i < rows - 1; i++)
            result[i + 1][0] = matrix[i][0];

        for (int j = 0; j < cols - 1; j++)
            result[rows - 1][j + 1] = matrix[rows - 1][j];

        for (int i = rows - 1; i > 0; i--)
            result[i - 1][cols - 1] = matrix[i][cols - 1];

        for (int j = cols - 1; j > 0; j--)
            result[0][j - 1] = matrix[0][j];

        return result;
    }

    public static void rowWiseTraversal(int[][] matrix) {
        System.out.println("\nRow-wise Traversal:");

        for (int[] row : matrix) {
            for (int item : row) {
                System.out.print(item + " ");
            }
        }

        System.out.println();
    }

    public static void columnWiseTraversal(int[][] matrix) {
        System.out.println("\nColumn-wise Traversal:");

        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int j = 0; j < cols; j++) {
            for (int i = 0; i < rows; i++) {
                System.out.print(matrix[i][j] + " ");
            }
        }

        System.out.println();
    }

    public static void spiralTraversal(int[][] matrix) {

        System.out.println("\nSpiral Traversal:");

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {

            for (int i = left; i <= right; i++)
                System.out.print(matrix[top][i] + " ");
            top++;

            for (int i = top; i <= bottom; i++)
                System.out.print(matrix[i][right] + " ");
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--)
                    System.out.print(matrix[bottom][i] + " ");
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--)
                    System.out.print(matrix[i][left] + " ");
                left++;
            }
        }

        System.out.println();
    }

    public static void main(String[] args) {

        System.out.println("=== PROGRAM OPERASI MATRIX ===");

        System.out.print("Jumlah Baris : ");
        int rows = input.nextInt();

        System.out.print("Jumlah Kolom : ");
        int cols = input.nextInt();

        int[][] matrixAsli = new int[rows][cols];

        System.out.println("\nInput Matrix:");

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("Elemen [" + (i + 1) + "][" + (j + 1) + "] : ");
                matrixAsli[i][j] = input.nextInt();
            }
        }

        int pilihan;

        do {
            System.out.println("""
                    
                    ===== MENU =====
                    1. Sort Row Wise
                    2. Sort Column Wise
                    3. Rotate Clockwise By 1
                    4. Rotate Counter Clockwise By 1
                    5. Rotate 90 Degree
                    6. Rotate 180 Degree
                    7. Row Wise Traversal
                    8. Column Wise Traversal
                    9. Spiral Traversal
                    10. Transpose
                    0. Exit
                    =================
                    """);

            System.out.print("Pilih Menu : ");
            pilihan = input.nextInt();

            int[][] hasil;

            switch (pilihan) {

                case 1:
                    hasil = sortRowWise(matrixAsli);
                    tampilkanPerbandingan(matrixAsli, hasil);
                    break;

                case 2:
                    hasil = sortColumnWise(matrixAsli);
                    tampilkanPerbandingan(matrixAsli, hasil);
                    break;

                case 3:
                    hasil = rotateClockwiseByOne(matrixAsli);
                    tampilkanPerbandingan(matrixAsli, hasil);
                    break;

                case 4:
                    hasil = rotateCounterClockwiseByOne(matrixAsli);
                    tampilkanPerbandingan(matrixAsli, hasil);
                    break;

                case 5:
                    hasil = rotate90(matrixAsli);
                    tampilkanPerbandingan(matrixAsli, hasil);
                    break;

                case 6:
                    hasil = rotate180(matrixAsli);
                    tampilkanPerbandingan(matrixAsli, hasil);
                    break;

                case 7:
                    tampilkanMatrix(matrixAsli, "MATRIX ASLI");
                    rowWiseTraversal(matrixAsli);
                    break;

                case 8:
                    tampilkanMatrix(matrixAsli, "MATRIX ASLI");
                    columnWiseTraversal(matrixAsli);
                    break;

                case 9:
                    tampilkanMatrix(matrixAsli, "MATRIX ASLI");
                    spiralTraversal(matrixAsli);
                    break;

                case 10:
                    hasil = transpose(matrixAsli);
                    tampilkanPerbandingan(matrixAsli, hasil);
                    break;

                case 0:
                    System.out.println("Program selesai.");
                    break;

                default:
                    System.out.println("Pilihan tidak tersedia!");
            }

        } while (pilihan != 0);
    }
}