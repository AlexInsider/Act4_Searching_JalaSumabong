import java.util.Scanner;

public class App {
    public static int[] SelectionSort(int arr[]){
        for(int i = 0; i < arr.length; i++){
		    int minValue = arr[0];
		    for(int j = 0; j < arr.length; j++){
		        if(arr[j] > arr[i]){
		            minValue = arr[j];
		            arr[j] = arr[i];
		            arr[i] = minValue;
		        }
		    }
		}
		
		return arr;
    }

    public static void main(String[] args) {
        Searching search = new Searching();
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Choose a searching algorithm to perform:\n1. Linear Search\n2. Binary Search\n3. Jump Search\n4. Exponential Search\n");

        System.out.print("Enter your choice(1-4): ");
        int choice = scanner.nextInt();

        System.out.print("Enter the number of elements: ");
        int num = scanner.nextInt();
        int arr[] = new int[num];

        System.out.println("Enter the elements: ");
        for (int i = 0; i < num; i++) {
            arr[i] = scanner.nextInt();
        }
        
        System.out.print("Enter the target value: ");
        int target = scanner.nextInt();
        
        int result = -1;
        int sorted[] = SelectionSort(arr);

        switch (choice) {
            case 1:
                result = search.LinearSearch(arr, target);
                break;
            case 2:
                result = search.BinarySearch(sorted, target);
                break;
            case 3:
                result = search.JumpSearch(sorted, target);
                break;
            case 4:
               result = search.ExponentialSearch(sorted, target);
                break;
            default:
                System.out.println("Invalid choice");
        }

        if (result != -1) {
            System.out.println("Search Result: Element is found at index " +result + ".");
        } else {
            System.out.println("Search Result: Element is not found.");
        }
        scanner.close();
    }
}