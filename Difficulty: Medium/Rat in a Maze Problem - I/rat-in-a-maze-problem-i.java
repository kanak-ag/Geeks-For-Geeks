//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Number of test cases
        sc.nextLine();        // Consume the newline character

        while (t-- > 0) {
            String input = sc.nextLine();

            // Replace ][ with ],[
            input = input.replace("][", "],[");

            ArrayList<ArrayList<Integer>> mat = new ArrayList<>();
            String[] rows = input.split("],\\s*\\[");

            for (String row : rows) {
                row = row.replaceAll("[\\[\\]]", ""); // Remove any surrounding brackets
                ArrayList<Integer> intRow = new ArrayList<>();
                for (String num : row.split(",")) {
                    intRow.add(Integer.parseInt(num.trim()));
                }
                mat.add(intRow);
            }

            Solution obj = new Solution();
            ArrayList<String> result = obj.findPath(mat);

            if (result.isEmpty()) {
                System.out.println("[]");
            } else {
                for (String res : result) {
                    System.out.print(res + " ");
                }
                System.out.println();
            }
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to find all possible paths
    //DLRU
    ArrayList<String> ans=new ArrayList<>();
    
    public void calculate(ArrayList<ArrayList<Integer>> mat,int r,int c,String dir){
        int n=mat.size();
        if(r==n-1 && c==n-1){ans.add(dir); return;}
        if(r==n) return;
        if(c==n) return;
        
        if(r!=n-1 && mat.get(r+1).get(c)!=0){
            mat.get(r).set(c,0);
            calculate(mat,r+1,c,dir+"D");
            mat.get(r).set(c,1);
        }
        
        if(c!=0 && mat.get(r).get(c-1)!=0){
            mat.get(r).set(c,0);
            calculate(mat,r,c-1,dir+"L");
            mat.get(r).set(c,1);
        }
        
        if(c!=n-1 && mat.get(r).get(c+1)!=0){
            mat.get(r).set(c,0);
            calculate(mat,r,c+1,dir+"R");
            mat.get(r).set(c,1);
        }
        
        if(r!=0 && mat.get(r-1).get(c)!=0){
            mat.get(r).set(c,0);
            calculate(mat,r-1,c,dir+"U");
            mat.get(r).set(c,1);
        }
        
    }
    public ArrayList<String> findPath(ArrayList<ArrayList<Integer>> mat) {
        if(mat.get(mat.size()-1).get(mat.size()-1)==0) return ans;
        calculate(mat,0,0,"");
        return ans;
    }
}