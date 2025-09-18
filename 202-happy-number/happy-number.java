class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = cycleCal(n);
        }
        //System.out.print(set);
        return n == 1;
    }
    private int cycleCal(int n){
        int sum = 0;
        while(n > 0){
            int digit = n % 10;
            n = n / 10;
            sum = sum + digit*digit;
        }
        return sum;
    }
}