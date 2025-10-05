class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int n= flowers.length;
        int m = people.length;
        int []start = new int[n];
        int []end = new int[n];
        int i =0;
        for(int a[] : flowers){
            start[i] = a[0];
            end[i++] = a[1];
        }
        Arrays.sort(start);
        Arrays.sort(end);

        int arr[] = new int[m];
        int k = 0;

        for(int p : people){
            arr[k++] = ub(start, p) - lb(end, p);    
        }
        return arr;

    }

    public int ub(int []arr, int k){
        int start = 0;
        int end = arr.length;

        while(start < end){
            int mid = start + (end - start)/2;
            if(arr[mid] <= k)start = mid + 1;
            else end = mid;
        }
        return start;
    }
    public int lb(int []arr, int k){
        int start = 0;
        int end = arr.length;

        while(start < end){
            int mid = start + (end - start)/2;
            if(arr[mid] < k)start = mid + 1;
            else end = mid;
        }
        return start;
    }
}