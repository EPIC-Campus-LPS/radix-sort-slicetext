import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        File f = new File("src/input.txt");
        Scanner scanner = new Scanner(f);
        String text = "";
        while(scanner.hasNextLine()) {
            text += scanner.nextLine();
            text += "\n";
        }

        String[] strArr = text.split("\n");
        int[] arr = new int[strArr.length];
        int index = 0;
        for(String s : strArr) {
            arr[index] = Integer.parseInt(s);
            index++;
        }
        arr = RadixSort.radixSort(arr, 10);

        BufferedWriter writer = new BufferedWriter(new FileWriter("src/result.txt", true));
        for(int i : arr) {
            System.out.println(i);
            writer.write(Integer.toString(i));
            writer.newLine();
        }
        writer.close();
    }
}
