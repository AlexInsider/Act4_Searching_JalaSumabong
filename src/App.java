import java.util.Arrays;
import java.util.Scanner;

public class App {

    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target)
                return i;
        }
        return -1;
    }

    public static int binarySearch(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target)
                return mid;
            if (arr[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }

    public static int binarySearchInRange(int[] arr, int target, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target)
                return mid;
            if (arr[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }

    public static int jumpSearch(int[] arr, int target) {
        int length = arr.length;
        int step = (int) Math.floor(Math.sqrt(length));
        int prev = 0;

        while (prev < length && arr[Math.min(step, length) - 1] < target) {
            prev = step;
            step += (int) Math.floor(Math.sqrt(length));
            if (prev >= length)
                return -1;
        }

        for (int i = prev; i <= Math.min(step, length); i++) {
            if (arr[i] == target)
                return i;
        }
        return -1;
    }

    public static int exponentialSearch(int[] arr, int target) {
        if (arr.length == 0)
            return -1;
        if (arr[0] == target)
            return 0;

        int index = 1;
        while (index < arr.length && arr[index] <= target) {
            index *= 2;
        }

        int low = index / 2;
        int high = Math.min(index, arr.length - 1);

        return binarySearchInRange(arr, target, low, high);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Choose a searching algorithm to perform:");
        System.out.println("1. Linear Search");
        System.out.println("2. Binary Search");
        System.out.println("3. Jump Search");
        System.out.println("4. Exponential Search");

        System.out.println("Enter your choice(1-4): ");
        int choice = sc.nextInt();

        System.out.println("Enter the number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter the elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Enter the target elements");
        int target = sc.nextInt();

        if (choice >= 2 && choice <= 4) {
            Arrays.sort(arr);
            System.out.println("Sorted array: " + Arrays.toString(arr));
        }

        int index = -1;
        switch (choice) {
            case 1:
                index = linearSearch(arr, n);
                break;
            case 2:
                index = binarySearch(arr, n);
                break;
            case 3:
                index = jumpSearch(arr, n);
            case 4:
                index = exponentialSearch(arr, n);
                break;

            default:

                System.out.println("Invalid choice");
                return;

        }

        if (index != -1) {
            System.out.println("Case 1. Element" + n + "is found at index" + index + ".");
        } else {
            System.out.println("Case 2. Element" + n + "is not found in the array.");

        }
        sc.close();
    }
}
