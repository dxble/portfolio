package selectionsort;

/**
 *
 * @author KingDavid
 */
public class Main {

    public static void main(String[] args) {
        int[] intArray = new int[]{6, 3, 7, 1, 4};
        toString(intArray);
        SelectionSort selecSort = new SelectionSort();
        selecSort.selectionSort(intArray);
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
