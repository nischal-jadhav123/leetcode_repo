class Solution {
    public String reverseWords(String s) {
        String[] w = s.split(" ");
        Deque<String> st = new ArrayDeque<>();
        for(String p : w){
            if(p != "") st.push(p);
        }
        StringBuffer sb = new StringBuffer();
        while(!st.isEmpty()){
            sb.append(st.pop());
            if(st.size() != 0)
                sb.append(" ");
        }
        return sb.toString();
    }
}