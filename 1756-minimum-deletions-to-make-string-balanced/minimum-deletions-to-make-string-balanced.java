class Solution {
    public int minimumDeletions(String s) {
    int n = s.length();
    int bcount = 0;
    int curr = 0;
    for(int i=0;i<n;i++){
        if(s.charAt(i) == 'b' ){
            bcount+=1;
        }
        else if(bcount > 0 && s.charAt(i)=='a'){
            curr = Math.min(curr+1,bcount);
        }
    }    
    return curr;
    }
}