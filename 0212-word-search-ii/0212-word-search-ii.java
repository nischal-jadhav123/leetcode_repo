class Solution {
    class Node{
        Node children[]=new Node[26];
        boolean eow=false;
        String word="";
        Node(){
            for(int i=0;i<26;i++){
                children[i]=null;
            }
        }
    }
    public void insert(String word){
        Node curr=root;
        for(int i=0;i<word.length();i++){
            int idx=word.charAt(i)-'a';
            if(curr.children[idx]==null){
                curr.children[idx]=new Node();
            }
            curr=curr.children[idx];
        }
        curr.eow=true;
        curr.word=word;
        
    }
    public  Node root=new Node();
    public List<String> findWords(char[][] board, String[] words) {
        List<String> list=new ArrayList<>();
        for(int k=0;k<words.length;k++){
            insert(words[k]); 
        }
          for(int i=0;i<board.length;i++){
              for(int j=0;j<board[0].length;j++){
                 search(board,i,j,list,root); 
              }
          }
        
        return list;
    }
    
     public void search(char[][]board,int i,int j,List<String> list,Node root){
         if(i<0 || j<0 || i>=board.length || j>=board[0].length){
            return;
        }
         char c1=board[i][j];
         int idx=c1-'a';
         if(c1=='$' || root.children[idx]==null){ 
             return;
         }
        root=root.children[idx];
        if(root.eow==true){
             list.add(root.word);
            root.eow=false;
        }
        board[i][j]='$';
        search(board,i+1,j,list,root);
        search(board,i,j+1,list,root);
        search(board,i-1,j,list,root);
        search(board,i,j-1,list,root);
        board[i][j]=c1;
    }
}