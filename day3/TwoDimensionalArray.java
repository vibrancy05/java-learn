package day3;

public class TwoDimensionalArray {
    public static void main(String[] args) {
        int[][] arr =  {{1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}};
        printArray(arr);
        String [][] arr2 = {{"a", "b", "c"},
                            {"d", "e", "f"},
                            {"g", "h", "i"}};
        printArray(arr2);
        System.out.println(arr[1][1]);
        System.out.println(arr2[1][1]);
    }
    public static void printArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void printArray(String[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
