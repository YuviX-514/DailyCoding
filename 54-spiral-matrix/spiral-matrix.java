class Solution {
    public List<Integer> spiralOrder(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        List<Integer> list = new ArrayList<>();
        int minr = 0;
        int minc = 0;
        int maxr = m-1;
        int maxc = n - 1;

        int total = 0;

        while(total < m*n){
            for(int i = minc;i<=maxc && total <m*n;i++){
                list.add(arr[minr][i]);
                total++;
            }
            minr++;
            
            for(int i = minr;i<=maxr && total <m*n;i++){
                list.add(arr[i][maxc]);
                total++;
            }
            maxc--;
            for(int i = maxc;i>=minc && total <m*n;i--){
                list.add(arr[maxr][i]);
                total++;
            }
            maxr--;
            for(int i = maxr;i >= minr && total <m*n;i--){
                list.add(arr[i][minc]);
                total++;
            }
            minc++;


        }
        return list;
    }
}