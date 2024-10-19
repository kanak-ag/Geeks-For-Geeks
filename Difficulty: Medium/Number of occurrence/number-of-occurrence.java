//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().count(arr, n, x);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java



class Solution {
    int count(int[] arr, int n, int target) {
        int ans=-1;
        // int n=arr.length;
        int s=0;
        int e=n-1;
        int a=-1;
        while(s<=e){
            int m=s+(e-s)/2;
            if(arr[m]==target){
                a=m;
                e=m-1;
            }
            else if(arr[m]<target){
                s=m+1;
            }
            else if(arr[m]>target){
                e=m-1;
            }
        }
        if(a==-1){
            return 0;
        }
        ans=a;
        
        s=a;
        a=-1;
        e=n-1;
        while(s<=e){
            int m=s+(e-s)/2;
            if(arr[m]==target){
                a=m;
                s=m+1;
            }
            else if(arr[m]<target){
                s=m+1;
            }
            else if(arr[m]>target){
                e=m-1;
            }
        }
        
        return a-ans+1;

    }
}