//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().inversionCount(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to count inversions in the array.
    
    static int merge(int[] nums,int s,int m,int e){
        int[]arr=new int[e-s+1];
        int i=s;
        int j=m+1;
        int ans=0;
        // while(i<=m){
        //     while(j<=e && nums[j]>nums[i]) j++;
        //     // if(j<=e && nums[j]<nums[i])
        //     ans+=e-j+1;
        //     i++;
        // }
        i=s;
        j=m+1;
        int k=0;
        while(i<=m && j<=e){
            if(nums[i]<=nums[j]){
                arr[k++]=nums[i++];
                // ans+=m-i+1;
            }
            else{
                ans+=m-i+1;
                arr[k++]=nums[j++];
                
            }
        }
        while(i<=m)  arr[k++]=nums[i++];
        while(j<=e)  arr[k++]=nums[j++];
        for(i=0;i<e-s+1;i++){
            nums[s+i]=arr[i];
        }
        return ans;
        
    }
    static int mergesort(int [] arr,int s,int e){
        if(s>=e) return 0;
        int m=(s+e)/2;
        int left=mergesort(arr,s,m);
        int right=mergesort(arr,m+1,e);
        int curr=merge(arr,s,m,e);
        return(left+right+curr);
    }
    static int inversionCount(int arr[]) {
        return(mergesort(arr,0,arr.length-1));
    }
}