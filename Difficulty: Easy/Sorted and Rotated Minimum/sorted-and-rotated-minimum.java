//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());

        Solution ob = new Solution(); // Instantiate the Solution object once

        while (t-- > 0) {
            String line = scanner.nextLine();
            String[] elements = line.split(" ");
            int[] arr = new int[elements.length]; // Changed to int[]

            for (int i = 0; i < elements.length; i++) {
                arr[i] = Integer.parseInt(elements[i]);
            }

            System.out.println(ob.findMin(arr));
            System.out.println("~");
        }
        scanner.close();
    }
}

// } Driver Code Ends

class Solution {
    public int findMin(int[] arr) {
        int s = 0;
        int e = arr.length - 1;
        if (arr.length == 1) {
            return arr[0];
        }
        while (s < e) {
            int mid = s + (e - s) / 2;
            if (mid > 0 && arr[mid] < arr[mid - 1]) {
                return arr[mid];
            }

            if (mid < arr.length - 1 && arr[mid] > arr[mid + 1]) {
                return arr[mid + 1];
            }

            if (arr[mid] >= arr[s] && arr[mid] > arr[e]) {
                s = mid + 1; 
            } else {
                e = mid - 1; 
            }
        }

        return arr[s];
    }
}

