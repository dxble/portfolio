package bubblesort;

/**
 *
 * @author KingDavid
 */
public class Main {
    public static void main(String[] args){
        int[] intArray = new int[]{5, 7, 2, 4, 1, 7, 4, 12};
        toString(intArray);
        BubbleSort bubSort = new BubbleSort();
        bubSort.bubbleSort(intArray);
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
