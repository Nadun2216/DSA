public class OptimizedBubbleSort {

    public static void bubbleSort(int[] array) {

        int n = array.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {

            swapped = false;

            for (int j = 0; j < n - i - 1; j++) {

                if (array[j] > array[j + 1]) {

                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;

                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }
    }

    public static void printArray(int[] array) {

        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int[] array = {64, 34, 25, 12, 22, 11, 90};

        System.out.println("Original Array:");
        printArray(array);

        bubbleSort(array);

        System.out.println("Sorted Array:");
        printArray(array);
    }
}