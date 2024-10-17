//{ Driver Code Starts
// Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            int m = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.findPages(n, a, m));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to find minimum number of pages.
    public static long findPages(int n, int[] arr, int m) {
        // Your code here
        if(m>n)
        return -1;
        
        long ans=arr[n-1];
        long s=arr[n-1];
        long e=0;
        for(int i:arr)
        e+=i;
        while(s<=e){
            long mid=(e+s)/2;
            if(isvalid(arr,m,mid)){
                ans=mid;
                e=mid-1;
            }
            else{
                s=mid+1;
            }
        }
        return ans;
        
    }
    public static boolean isvalid(int[] arr, int k, long mid){
        int c=1;
        int sum=0;
        for(int i:arr){
            sum+=i;
            if(sum>mid){
                c++;
                sum=i;
            }
            if(c>k){
                return false;
            }
        }
        
        return true;
    }
};