class Solution {
    public int candy(int[] c) {
        int arr[] = new int[c.length];
        Arrays.fill(arr, 1);

        for(int i=1;i<arr.length;i++){
            if(c[i] > c[i-1])arr[i] = arr[i-1]+1;
        }
        for(int i=arr.length-2;i>=0;i--){
            if(c[i] > c[i+1] && arr[i] <= arr[i+1])arr[i] = arr[i+1]+1;
        }

        int count = 0;
        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
            count += arr[i];
        }
        return count;
    }
}