package insertionsort;

/**
 *
 * @author KingDavid
 */
public class Main {

    public static void main(String[] args) {
        int[] intArray = new int[]{5, 3, 1, 7, 4, 12};
        toString(intArray);
        InsertionSort insertSort = new InsertionSort();
        insertSort.insertionSort(intArray);
        toString(intArray);
    }

    public static void toString(int[] intArray) {
        String temp = "";

        for (int i = 0; i < intArray.length; i++) {
            temp += intArray[i] + ", ";
        }

        System.out.println(temp);
    }
}
