import java.util.Random;

public class HW2_Task2_MergeSort {
    public static void main(String[] args) {
        int[] rndArr = randomArray();
        System.out.println("Non-sorted array");
        for (int i = 0; i < rndArr.length; i++) {
            System.out.print(rndArr[i] + " ");
        }
        System.out.println();

        int[] sortedArray = arraySort(rndArr);
        System.out.println("Sorted array");
        for (int i = 0; i < sortedArray.length; i++) {
            System.out.print(sortedArray[i] + " ");
        }
    }

    public static int[] arraySort(int[] sourceArray) {
        if (sourceArray == null) {
            return null;
        }

        int len = sourceArray.length;
        if (len < 2) {
            return sourceArray;
        }

        int[] leftHalf = new int[len / 2];
        System.arraycopy(sourceArray, 0, leftHalf, 0, len / 2);

        int[] rightHalf = new int[len - len / 2];
        System.arraycopy(sourceArray, len / 2, rightHalf, 0, len - len / 2);

        leftHalf = arraySort(leftHalf);
        rightHalf = arraySort(rightHalf);
        return mergeArray(leftHalf, rightHalf);
    }

    public static int[] mergeArray(int[] leftHalf, int[] rightHalf) {
        int[] sortedArray = new int[leftHalf.length + rightHalf.length];

        int leftPointer = 0;
        int rightPointer = 0;

        for (int i = 0; i < sortedArray.length; i++) {
            if (leftPointer == leftHalf.length) {
                sortedArray[i] = rightHalf[rightPointer];
                rightPointer++;
            } else if (rightPointer == rightHalf.length) {
                sortedArray[i] = leftHalf[leftPointer];
                leftPointer++;
            } else if (leftHalf[leftPointer] < rightHalf[rightPointer]) {
                sortedArray[i] = leftHalf[leftPointer];
                leftPointer++;
            } else {
                sortedArray[i] = rightHalf[rightPointer];
                rightPointer++;
            }
        }
        return sortedArray;
    }

    public static int[] randomArray() { //Генарция случайного массива для тестов
        Random s = new Random();
        int x = s.nextInt(11);
        int[] randArr = new int[x];
        for (int i = 0; i < x; i++) {
            int k = s.nextInt(21);
            randArr[i] = k;
        }
        return randArr;
    }

}
