class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int x = 0;
        for(String i : operations){
            switch(i){
                case "X++":
                    ++x;
                    break;
                case "++X":
                    ++x;
                    break;
                case "X--":
                    --x;
                    break;
                case "--X":
                    --x;
                    break;
            }
        }
        return x;
    }
}