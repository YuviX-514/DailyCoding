class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int i =0, j = n-1, ans = Integer.MIN_VALUE;

        while(i <= j){
            int area = (j - i)*Math.min(height[i], height[j]);
            ans = Math.max(ans, area);

            if(height[i] > height[j])j--;
            else if(height[i] < height[j])i++;
            else{
                i++;
                j--;
            }
        }
        return ans;
    }
}