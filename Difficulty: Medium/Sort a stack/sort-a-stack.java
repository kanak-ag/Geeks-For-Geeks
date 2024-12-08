//{ Driver Code Starts
import java.util.*;
import java.util.Scanner;
import java.util.Stack;

class SortedStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            Stack<Integer> s = new Stack<>();
            int n = sc.nextInt();
            while (n-- > 0) s.push(sc.nextInt());
            GfG g = new GfG();
            Stack<Integer> a = g.sort(s);
            while (!a.empty()) {
                System.out.print(a.peek() + " ");
                a.pop();
            }
            System.out.println();
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


/*Complete the function below*/
class GfG {
    public Stack<Integer> sort(Stack<Integer> s) {
        sorting(s,s.size());
        return s;
        // add code here.
    }
    
    public void sorting(Stack<Integer> s,int size){
        if(size<=1){
            return;
        }
        
       
        int last=s.pop();
         sorting(s,size-1);
        insert(s,last,size-1);
    }
    
    public void insert(Stack<Integer> s,int element ,int size){
        if(size==0 || s.peek()<=element ){
            s.push(element);
            return;
        }
        int v=s.pop();
        insert(s,element,size-1);
        s.push(v);
    }
}