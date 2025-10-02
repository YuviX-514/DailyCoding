class Solution {
    public int maxBottlesDrunk(int k, int ex) {
        int d = k;
        int e = k;
        while( e >= ex){
            e = e- ex;
            ex++;
            d++;
            e++;
       }
        return d;
    }
}