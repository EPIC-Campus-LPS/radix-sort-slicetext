import java.util.HashMap;
import java.util.LinkedList;

public class RadixSort {
    /**
     * Sort array of numbers with Radix Sort
     * @param arr the numbers
     * @param base the base of the numbers
     * @return sorted array
     */
    public static int[] radixSort(int[] arr, int base) {
        HashMap<Integer, LinkedList<Integer>> radixMap = new HashMap<>();
        for(int i = 0; i < base; i++) {
            radixMap.put(i, new LinkedList<>());
        }

        int maxVal = getMaxArr(arr);

        int exp = 1;

        while(maxVal / exp > 0) {
            // Sort in map
            for(int i : arr) {
                int index = (i / exp) % 10;
                radixMap.get(index).push(i);
            }
            // Put back in arr
            int index = 0;
            for(int i = 0; i < base; i++) {
                while(!radixMap.get(i).isEmpty()) {
                    arr[index] = radixMap.get(i).pop();
                    index++;
                }
            }

            exp *= 10;
        }

        return arr;
    }

    private static int getMaxArr(int[] arr) {
        int max = arr[0];
        for(int i : arr) {
            if(i > max) {
                max = i;
            }
        }
        return max;
    }
}
