//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input_line1[] = read.readLine().trim().split("\\s+");
            int k = Integer.parseInt(input_line1[0]);
            int n = Integer.parseInt(input_line1[1]);
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[n];
            for(int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.minTime(arr,n,k));
        }
    }
}


// } Driver Code Ends


//User function Template for Java

 class Solution{
    static long minTime(int[] arr,int n,int k){
        long s=0;
        long e=0;
        
        for(int i:arr){
            e+=i;
            s=Math.max(s,i);
        }
        long ans=s;
        while(s<=e){
            long m=s+(e-s)/2;
            if(isvalid(arr,k,m)){
                ans=m;
                e=m-1;
            }
            else{
                s=m+1;
            }
        }
        return ans;
    }
    
    static boolean isvalid(int [] arr, int k, long mid){
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
}


