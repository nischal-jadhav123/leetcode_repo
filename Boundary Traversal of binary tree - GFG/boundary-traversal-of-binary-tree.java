//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the current node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the current node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the current node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root = buildTree(s);
            
            Solution T = new Solution();
            
            ArrayList <Integer> res = T.boundary(root);
            for (Integer num : res) System.out.print (num + " ");
            System.out.println();
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right; 
   
//     public Node(int d)  
//     { 
//         data = d; 
//         left = right = null; 
//     } 
// }

class Solution
{   public void traverseLeftBoundary(Node node,List<Integer> res){
        Node curr = node.left;
        while(curr != null){
            if(isLeaf(curr) == false) res.add(curr.data);
            if(curr.left != null) curr = curr.left;
            else curr = curr.right;
        }
    }
    public void traverseLeaf(Node root,List<Integer> res){
        if(isLeaf(root) == true){
            res.add(root.data);
            return;
        } 
        if(root.left != null) traverseLeaf(root.left,res);
        if(root.right!= null) traverseLeaf(root.right,res);
    }
    public void traverseRightBoundary(Node node,List<Integer> res){
        Node curr = node.right;
        List<Integer> temp = new ArrayList<>();
        while(curr != null){
            if(isLeaf(curr) == false) temp.add(curr.data);
            if(curr.right != null) curr = curr.right;
            else curr = curr.left;
        }
        // System.out.println("***** ");
        // System.out.println(temp);
        // System.out.println("***** ");
        for(int i = temp.size() - 1; i >= 0; i--){
            res.add(temp.get(i));
        }
    }
    public boolean isLeaf(Node node){
        if(node != null && node.left == null && node.right == null) return true;
        return false;
    }
	ArrayList <Integer> boundary(Node node)
	{
	    ArrayList<Integer> res = new ArrayList<>();
	   //  System.out.println((node.left != null) ? true : false);
	   // System.out.println(isLeaf(node));
	    if(isLeaf(node) == false) res.add(node.data);
	   // System.out.println(res);
	    traverseLeftBoundary(node,res);
	   // System.out.println(res);
	    traverseLeaf(node,res);
	   // System.out.println(res);
	    traverseRightBoundary(node,res);
	   // System.out.println(res);
	    return res;
	}
}
