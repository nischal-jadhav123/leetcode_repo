class Solution {
    public String makeGood(String s) {
        Stack<Character> stack = new Stack<>();
        for (char currChar : s.toCharArray()) {
            if (!stack.isEmpty() && Math.abs(stack.lastElement() - currChar) == 32)
                stack.pop();
            else
               stack.add(currChar); 
        }
        StringBuilder ans = new StringBuilder();
        for (char currChar : stack) 
            ans.append(currChar);
        return ans.toString();
    }
}