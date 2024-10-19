//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String s = br.readLine().trim();
            String[] S1 = s.split(" ");
            int n = Integer.parseInt(S1[0]);
            int m = Integer.parseInt(S1[1]);
            Solution ob = new Solution();
            int ans = ob.NthRoot(n, m);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int NthRoot(int n, int m)
    {
        // code here
        if(m==1)
        return 1;
        
        int ans=-1;
        int s=0,e=m/n;
        while(s<=e){
            int mid=s+(e-s)/2;
            int cal=(int)Math.pow(mid,n);
            if(cal==m){
                ans=mid;
                s=mid+1;
            }
            else if(cal>m){
                e=mid-1;
            }
            else{
                s=mid+1;
            }
        }
        return ans;
        
    }
}