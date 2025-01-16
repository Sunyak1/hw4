import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] array = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println("1. Сума елементів масиву: " + findSum(array));
        System.out.println("2. Максимальний елемент: " + findMax(array));
        System.out.println("3. Сума елементів у кожному рядку:");
        rowSums(array);
        System.out.println("4. Сума діагоналей та порівняння:");
        diagonalSums(array);
        System.out.println("5. Рядок з найбільшою сумою: " + rowWithMaxSum(array));
        System.out.println("6. Сума діагоналей квадратної матриці:");
        sumDiagonals(array);
        System.out.println("7. Кількість від’ємних елементів: " + countNegative(array));
        System.out.println("8. Стовпчик з найбільшою сумою: " + columnWithMaxSum(array));

        System.out.println("9. Масив після заміни нульових елементів:");
        replaceZeros(array);
        printArray(array);

        System.out.println("10. Середнє арифметичне для кожного стовпця:");
        columnAverages(array);
    }
    public static int findSum(int[][] array) {
        int sum = 0;
        for (int[] row : array) {
            for (int value : row) {
                sum += value;
            }
        }
        return sum;
    }
    public static String findMax(int[][] array) {
        int max = Integer.MIN_VALUE;
        int maxRow = -1, maxCol = -1;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] > max) {
                    max = array[i][j];
                    maxRow = i;
                    maxCol = j;
                }
            }
        }
        return max + " (індекси: " + maxRow + ", " + maxCol + ")";
    }
    public static void rowSums(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            int sum = 0;
            for (int value : array[i]) {
                sum += value;
            }
            System.out.println("Рядок " + i + ": " + sum);
        }
    }
    public static void diagonalSums(int[][] array) {
        int mainDiagonal = 0, secondaryDiagonal = 0;
        for (int i = 0; i < array.length; i++) {
            mainDiagonal += array[i][i];
            secondaryDiagonal += array[i][array.length - 1 - i];
        }
        System.out.println("Головна діагональ: " + mainDiagonal);
        System.out.println("Побічна діагональ: " + secondaryDiagonal);
        if (mainDiagonal > secondaryDiagonal) {
            System.out.println("Головна діагональ має більшу суму.");
        } else if (mainDiagonal < secondaryDiagonal) {
            System.out.println("Побічна діагональ має більшу суму.");
        } else {
            System.out.println("Суми рівні.");
        }
    }
    public static int rowWithMaxSum(int[][] array) {
        int maxSum = Integer.MIN_VALUE;
        int maxRow = -1;
        for (int i = 0; i < array.length; i++) {
            int sum = 0;
            for (int value : array[i]) {
                sum += value;
            }
            if (sum > maxSum) {
                maxSum = sum;
                maxRow = i;
            }
        }
        return maxRow;
    }
    public static void sumDiagonals(int[][] array) {
        diagonalSums(array);
    }
    public static int countNegative(int[][] array) {
        int count = 0;
        for (int[] row : array) {
            for (int value : row) {
                if (value < 0) {
                    count++;
                }
            }
        }
        return count;
    }
    public static int columnWithMaxSum(int[][] array) {
        int maxSum = Integer.MIN_VALUE;
        int maxCol = -1;
        for (int j = 0; j < array[0].length; j++) {
            int sum = 0;
            for (int[] row : array) {
                sum += row[j];
            }
            if (sum > maxSum) {
                maxSum = sum;
                maxCol = j;
            }
        }
        return maxCol;
    }
    public static void replaceZeros(int[][] array) {
        int sum = 0, count = 0;
        for (int[] row : array) {
            for (int value : row) {
                if (value != 0) {
                    sum += value;
                    count++;
                }
            }
        }
        double average = count == 0 ? 0 : (double) sum / count;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == 0) {
                    array[i][j] = (int) Math.round(average);
                }
            }
        }
    }
    public static void columnAverages(int[][] array) {
        for (int j = 0; j < array[0].length; j++) {
            int sum = 0;
            for (int[] row : array) {
                sum += row[j];
            }
            double average = (double) sum / array.length;
            System.out.println("Стовпець " + j + ": " + average);
        }
    }
    public static void printArray(int[][] array) {
        for (int[] row : array) {
            System.out.println(Arrays.toString(row));
        }
    }
}
