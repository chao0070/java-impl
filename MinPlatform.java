import java.util.*;

public class MinPlatform {

    static void minPlatformCount(int[] arr, int[] dep) {
        int len = arr.length;
        Arrays.sort(arr);
        Arrays.sort(dep);
        int i = 0, j = 0;
        int count = 0; int maxC = 0;
        while (i < len && j < len) {
            if (arr[i] <= dep[j]) {
                count++;
                i++;
            } else {
                count--;
                j++;
            }
            System.out.println(count);
            if (count > maxC) {
                maxC = count;
            }
        }
        System.out.println(maxC);
    }

    public static void main(String[] args) {
        int arr[] = {900, 940, 950, 1100, 1500, 1800};
        int dep[] = {910, 1200, 1120, 1130, 1900, 2000};
        minPlatformCount(arr, dep);
    }
}