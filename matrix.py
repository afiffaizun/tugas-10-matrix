def tampilkan_matrix(matrix):
    print("\nMATRIX:")
    for row in matrix:
        print(" ".join(map(str, row)))
    print()


def sort_row_wise(matrix):
    return [sorted(row) for row in matrix]


def sort_column_wise(matrix):
    rows = len(matrix)
    cols = len(matrix[0])

    for j in range(cols):
        kolom = [matrix[i][j] for i in range(rows)]
        kolom.sort()

        for i in range(rows):
            matrix[i][j] = kolom[i]

    return matrix


def rotate_clockwise_by_one(matrix):
    rows = len(matrix)
    cols = len(matrix[0])

    result = [row[:] for row in matrix]

    for j in range(cols - 1):
        result[0][j + 1] = matrix[0][j]

    for i in range(rows - 1):
        result[i + 1][cols - 1] = matrix[i][cols - 1]

    for j in range(cols - 1, 0, -1):
        result[rows - 1][j - 1] = matrix[rows - 1][j]

    for i in range(rows - 1, 0, -1):
        result[i - 1][0] = matrix[i][0]

    return result


def rotate_counterclockwise_by_one(matrix):
    rows = len(matrix)
    cols = len(matrix[0])

    result = [row[:] for row in matrix]

    for i in range(rows - 1):
        result[i + 1][0] = matrix[i][0]

    for j in range(cols - 1):
        result[rows - 1][j + 1] = matrix[rows - 1][j]

    for i in range(rows - 1, 0, -1):
        result[i - 1][cols - 1] = matrix[i][cols - 1]

    for j in range(cols - 1, 0, -1):
        result[0][j - 1] = matrix[0][j]

    return result


def rotate_90(matrix):
    return [list(row) for row in zip(*matrix[::-1])]


def rotate_180(matrix):
    return [row[::-1] for row in matrix[::-1]]


def row_wise_traversal(matrix):
    print("\nRow-wise Traversal:")
    for row in matrix:
        for item in row:
            print(item, end=" ")
    print("\n")


def column_wise_traversal(matrix):
    print("\nColumn-wise Traversal:")
    rows = len(matrix)
    cols = len(matrix[0])

    for j in range(cols):
        for i in range(rows):
            print(matrix[i][j], end=" ")
    print("\n")


def spiral_print(matrix):
    print("\nSpiral Traversal:")

    top = 0
    bottom = len(matrix) - 1
    left = 0
    right = len(matrix[0]) - 1

    while top <= bottom and left <= right:

        for i in range(left, right + 1):
            print(matrix[top][i], end=" ")
        top += 1

        for i in range(top, bottom + 1):
            print(matrix[i][right], end=" ")
        right -= 1

        if top <= bottom:
            for i in range(right, left - 1, -1):
                print(matrix[bottom][i], end=" ")
            bottom -= 1

        if left <= right:
            for i in range(bottom, top - 1, -1):
                print(matrix[i][left], end=" ")
            left += 1

    print("\n")


def transpose(matrix):
    return [list(row) for row in zip(*matrix)]


# INPUT MATRIX
print("=== INPUT MATRIX baris dan Kolom ===")
rows = int(input("Masukkan jumlah baris : "))
cols = int(input("Masukkan jumlah kolom : "))

matrix = []

for i in range(rows):
    row = []
    for j in range(cols):
        nilai = int(input(f"Elemen [{i+1}][{j+1}] : "))
        row.append(nilai)
    matrix.append(row)

tampilkan_matrix(matrix)

while True:
    print("""
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
""")

    pilihan = int(input("Pilih menu : "))

    if pilihan == 1:
        matrix = sort_row_wise(matrix)
        tampilkan_matrix(matrix)

    elif pilihan == 2:
        matrix = sort_column_wise(matrix)
        tampilkan_matrix(matrix)

    elif pilihan == 3:
        matrix = rotate_clockwise_by_one(matrix)
        tampilkan_matrix(matrix)

    elif pilihan == 4:
        matrix = rotate_counterclockwise_by_one(matrix)
        tampilkan_matrix(matrix)

    elif pilihan == 5:
        matrix = rotate_90(matrix)
        tampilkan_matrix(matrix)

    elif pilihan == 6:
        matrix = rotate_180(matrix)
        tampilkan_matrix(matrix)

    elif pilihan == 7:
        row_wise_traversal(matrix)

    elif pilihan == 8:
        column_wise_traversal(matrix)

    elif pilihan == 9:
        spiral_print(matrix)

    elif pilihan == 10:
        matrix = transpose(matrix)
        tampilkan_matrix(matrix)

    elif pilihan == 0:
        print("Program selesai.")
        break

    else:
        print("Pilihan tidak tersedia!")