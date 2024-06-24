//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            
            int N=sc.nextInt();
            int K=sc.nextInt();
            ArrayList<Integer> Arr = new ArrayList<Integer>(N); 
  
            // Appending new elements at 
            // the end of the list 
            for (int i = 0; i < N; i++) {
                int x = sc.nextInt();
                Arr.add(x); 
            }

            Solution ob = new Solution();
            System.out.println(ob.maximumSumSubarray(K,Arr,N));
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    static long maximumSumSubarray(int K, ArrayList<Integer> Arr,int N){
        // code here
        // int max=0;
        // int subsum=0;
        // int i=0;
        // int k=0;
        // // int t=0;
        // while(i<Arr.size())
        // {
        //     if(k<K){
        //     subsum+=Arr.get(i);
        //     k++;
        //     if(max<subsum)
        //     max=subsum;
        //     i+=1;
        //     }
        //     else{
        //         k=0;
        //         subsum=0;
        //         Arr.remove(0);
        //         i=0;
                
        //     }
            
            
        // }
        // return max;
        
        
        
        // int sum=0;
        // int n=Arr.size();
        // for(int i=0 ; i<n-K+1 ; i++)
        // {
        //     int subsum=0;
            
        //     for(int j=i ; j<i+K ; j++)
        //     {
        //      subsum+=Arr.get(j);   
        //     }
        //     if(subsum>sum)
        //     {
        //         sum=subsum;
        //     }
        // }
        // return sum;
        
        
        
        long maxsum=0;
        long sum=0;
        for(int i=0;i<K;i++)
        sum+=Arr.get(i);
        
        if(sum>maxsum)
        {
            maxsum=sum;
        }
        int i=0;
        while((i+K) <N)
        {
            sum-=Arr.get(i);
            sum+=Arr.get(i+K);
            if(sum>maxsum)
        {
            maxsum=sum;
        }
        i++;
        }
        return maxsum;
    }
}