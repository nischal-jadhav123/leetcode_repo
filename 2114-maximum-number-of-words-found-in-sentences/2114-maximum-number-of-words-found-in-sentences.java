class Solution {
    public int mostWordsFound(String[] sentences) {
        int max = 0;
        for(String s : sentences){
            String[] temp = s.split(" ");
            max = Math.max(max,temp.length);
        }
        return max;
    }
}