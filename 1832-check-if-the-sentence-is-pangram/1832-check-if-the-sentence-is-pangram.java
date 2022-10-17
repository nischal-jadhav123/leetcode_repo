class Solution {
    public boolean checkIfPangram(String sentence) {
        int[] arr = new int[26];
        for(char c : sentence.toCharArray()){
            int val = (int) c;
            int index = val - 97;
            arr[index] = 1;
        }
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 0) return false;
        }
        return true;
    }
}