class Solution {
    public boolean canPlaceFlowers(int[] arr, int f) {
        int n = arr.length;
        if(f == 0)return true;
        if(n == 1){
            if(arr[0] == 0 && f <= 1)return true;
            else if(arr[0] == 1 && f == 0)return true;
            else return false;
        }
        for(int i = 0;i<n;i++){
            if(i == 0 && arr[i] == 0 && arr[i+1] == 0){
                arr[i] = 1;
                f--;
            }
            
            else if(i == n-1 && arr[i] == 0 && arr[i-1] == 0){
                arr[i] = 1;
                f--;
            }
            else if(i > 0 && i < n-1 &&(arr[i-1] == 0 && arr[i] == 0 )&& (arr[i] == 0 && arr[i+1] == 0)){
                arr[i] = 1;
                f--;
            }

            if(f == 0)return true;
        }
        return false;
    }
}