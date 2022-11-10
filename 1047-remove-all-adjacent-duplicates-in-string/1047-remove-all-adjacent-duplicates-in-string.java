class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        st.push(s.charAt(0));
        for(int i=1;i<s.length();i++){
           
            if( !st.isEmpty() &&st.peek()==s.charAt(i)){
                st.pop();
                sb.deleteCharAt(sb.length()-1);
            }
            else{
                st.push(s.charAt(i));
                sb.append(s.charAt(i));
            }
        }
        
        return sb.toString();
    }
}