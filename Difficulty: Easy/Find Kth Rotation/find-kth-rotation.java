//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input1 = sc.nextLine();
            Scanner ss1 = new Scanner(input1);
            while (ss1.hasNextInt()) {
                arr.add(ss1.nextInt());
            }
            Solution ob = new Solution();
            int res = ob.findKRotation(arr);
            System.out.println(res);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int findKRotation(List<Integer> arr) {
        
        int peak=0;
        int s=0;
        int e=arr.size()-1;
        // if(arr.get)
        while(s<=e){
            int m=s+(e-s)/2;
            if(arr.get(m)>arr.get(m+1)){
                return (m+1);
            }
            if(arr.get(m)<arr.get(arr.size()-1)){
                e=m-1;
            }
            else{
                s=m+1;
            }
        }
        return peak;
    }
}