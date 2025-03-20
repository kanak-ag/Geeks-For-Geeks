//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine().trim());

        while (t-- > 0) {
            // Read the start times
            String[] startInput = reader.readLine().trim().split("\\s+");
            List<Integer> start = new ArrayList<>();
            for (String s : startInput) {
                start.add(Integer.parseInt(s));
            }

            // Read the end times
            String[] endInput = reader.readLine().trim().split("\\s+");
            List<Integer> end = new ArrayList<>();
            for (String s : endInput) {
                end.add(Integer.parseInt(s));
            }

            // Create solution object and call activitySelection
            Solution obj = new Solution();
            System.out.println(obj.activitySelection(start, end));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends



class Solution {
    public int activitySelection(List<Integer> start, List<Integer> end) {
       int ans=1;
       int n=start.size();
       Integer[] after_Sort=new Integer[n];
       for(int i=0;i<n;i++) after_Sort[i]=i;
       Arrays.sort(after_Sort,Comparator.comparingInt(i-> end.get(i)));
       int index=after_Sort[0];
       int time=end.get(index);
       for(int i=1;i<n;i++){
           int x=after_Sort[i];
           if(start.get(x)>time){
               ans++;
               time=end.get(x);
           }
       }
       return ans;
    }
}
