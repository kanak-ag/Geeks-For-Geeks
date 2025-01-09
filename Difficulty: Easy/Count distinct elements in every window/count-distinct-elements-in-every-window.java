//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.HashMap;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            ArrayList<Integer> array = new ArrayList<>();

            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int k = Integer.parseInt(br.readLine());

            ArrayList<Integer> ans = new Solution().countDistinct(arr, k);

            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();

            t--;
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    ArrayList<Integer> countDistinct(int arr[], int k) {
        int n=arr.length;
        // int ans=0;
        ArrayList<Integer> ans=new ArrayList<>();
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<k-1;i++){
            hm.put(arr[i],hm.getOrDefault(arr[i],0)+1);
        }
        int l=0;int r=k-1;
        while(r<n){
            hm.put(arr[r],hm.getOrDefault(arr[r],0)+1);
            ans.add(hm.size());
            if(hm.get(arr[l])<=1){
                hm.remove(arr[l]);
            }
            else{
                hm.put(arr[l],hm.get(arr[l])-1);
            }
            r++;
            l++;
        }
        // code here
        return ans;
    }
}
