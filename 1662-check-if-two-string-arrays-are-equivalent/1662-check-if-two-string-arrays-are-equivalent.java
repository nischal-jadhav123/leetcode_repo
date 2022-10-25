class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuffer br1 = new StringBuffer();
        StringBuffer br2 = new StringBuffer();
        for(String word : word1){
            br1.append(word);
        }
        for(String word : word2){
            br2.append(word);
        }
        return (br1.toString().equals(br2.toString()));
    }
}