class Solution {
    public int maxArea(int[] height) {
        int ans = Integer.MIN_VALUE;
        int i = 0; int j =height.length-1;
        while(i <= j){
            ans = Math.max(ans, (j-i)*Math.min(height[i], height[j]));

            if(height[i] < height[j])i++;
            else if(height[i] > height[j])j--;
            else{
                i++;
                j--;
            }
        }
        return ans;
    }
}