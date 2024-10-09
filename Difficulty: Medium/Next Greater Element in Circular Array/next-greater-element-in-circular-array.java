//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter ot = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    int n = Integer.parseInt(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    Solution ob = new Solution();
		    long[] res = ob.nextLargerElement(arr, n);
		    for (int i = 0; i < n; i++) 
		        ot.print(res[i] + " ");
		    ot.println();
		}
        ot.close();
	}
}



// } Driver Code Ends


// User Function Template for JAVA

class Solution{
    public static long[] nextLargerElement(long[] nums, int n) { 
        
        int index=0;
        long [] ans= new long [n];
        Stack<Long> stack=new Stack<>();
        for(int i=n-1;i>=0;i--){
            stack.push(nums[i]);
        }
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && stack.peek()<=nums[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                ans[index++]=-1;
            }
            else{
                ans[index++]=stack.peek();
            }
            stack.push(nums[i]);
        }
        return reverse(ans);
        
    }
    public static long [] reverse(long [] arr){
        int i=0;
        int j=arr.length-1;
        while(i<j){
            long temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
        return arr;
    } 
}