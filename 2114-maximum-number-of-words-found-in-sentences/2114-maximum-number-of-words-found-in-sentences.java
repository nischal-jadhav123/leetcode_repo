class Solution {
    public int mostWordsFound(String[] sentences) {
        int max = 0;
        for(String s : sentences){
            String[] temp = s.split(" ");
            max = temp.length > max ? temp.length : max;
        }
        return max;
    }
}