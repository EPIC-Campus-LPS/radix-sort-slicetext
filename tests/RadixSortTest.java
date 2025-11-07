import static org.junit.jupiter.api.Assertions.*;

class RadixSortTest {

    @org.junit.jupiter.api.Test
    void radixSort() {
        int[] arr = {316, 455, 201, 711};
        arr = RadixSort.radixSort(arr, 10);
        int[] expected = {201, 316, 455, 711};
        System.out.print("Got: ");
        for(int i : arr) {
            System.out.print(i + ", ");
        }
        System.out.println();
        assertArrayEquals(expected, arr);
    }
}