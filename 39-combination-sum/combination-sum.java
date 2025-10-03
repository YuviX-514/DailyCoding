class Solution {
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();

        helper(candidates, res, new ArrayList<>(), target, 0);
        return res;
    }
    public void helper(int[]c, List<List<Integer>> res, List<Integer> list, int t, int idx){
        if(t < 0)return ;
        if(t ==  0){
            res.add(new ArrayList<>(list));
            return;
        }
        
        for(int i = idx;i<c.length;i++){
            list.add(c[i]);
            helper(c, res, list, t-c[i], i);
            list.removeLast();
        }
    }

}