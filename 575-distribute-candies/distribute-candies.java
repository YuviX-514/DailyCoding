class Solution {
    public int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet<>();
        for(int c : candyType)set.add(c);

        int n = candyType.length;
        int cap = n/2;
        int t = set.size();

        return (t >= cap) ? cap : t;
    }
}