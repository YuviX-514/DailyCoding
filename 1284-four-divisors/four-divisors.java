class Solution {
    public int sumFourDivisors(int[] nums) {
        int sum = 0;
        for(int k : nums){
            sum += helper(k);
        }
        return sum ;
    }
    int helper(int n){
        List<Integer> l = new ArrayList<>();
        int sum = 0;
        int count = 0;
        boolean flag = false;
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                if (i * i == n) {l.add(i);count++;}
                else {l.add(i);l.add(n/i);count += 2;}

                if (count > 4) {
                    flag = true;
                    break;
                };
            }
        }
        
        if(count == 4) {
            for(int i : l)sum += i;
            return sum;
        }
        else return 0;
        
        
    }
}