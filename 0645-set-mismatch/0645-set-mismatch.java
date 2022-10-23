class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        int [] arr = new int[nums.length+1];
        for(int i = 0; i < nums.length;i++){
            if(arr[nums[i]] == nums[i]){
                res[0] = nums[i];
            }else{
                arr[nums[i]] = nums[i];
            }
        }
        for(int i = 1; i < arr.length;i++){
            if(arr[i] != i) res[1] = i;
        }
        return res;
    }
}