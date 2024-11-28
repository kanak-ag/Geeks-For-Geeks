//{ Driver Code Starts
// Initial template for JAVA

import java.util.Scanner;

class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t > 0) {
            String str = sc.nextLine();

            Solution obj = new Solution();
            int num = obj.myAtoi(str);
            System.out.println(num);
            System.out.println("~");
            t--;
        }
    }
}
// } Driver Code Ends


class Solution {
    public int myAtoi(String s) {
        String ans="";
        int i=0;
        boolean negative=false;
        while(s.charAt(i)==' '){
            i++;
        }
        if(s.charAt(i)=='-'){
            // ans="-";
            negative=true;
            i++;
        }
        for(;i<s.length();i++){
        if(Character.isDigit(s.charAt(i))){
            ans+=s.charAt(i);
        }
            else
            break;
        }
        // long res=
        if(ans=="")
        return 0;
        if(Long.parseLong(ans)>= Integer.MAX_VALUE){
            if(negative)
            return -2147483648;
            else
            return 2147483647;
        }
        if(negative)
        return -1*Integer.parseInt(ans);
        return Integer.parseInt(ans);
    }
}