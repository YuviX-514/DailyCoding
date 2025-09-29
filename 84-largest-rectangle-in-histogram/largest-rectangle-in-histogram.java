class Solution {
    public int largestRectangleArea(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int area = 0;

        for(int i = 0;i<n;i++){
            while(!st.isEmpty() && arr[i] < arr[st.peek()]){
                int r = i;
                int h = arr[st.pop()];

                if(st.isEmpty())area = Math.max(area, h*r);
                else area = Math.max(area, h*(r - st.peek()-1));
                
            }
            st.push(i);
        }

        while(!st.isEmpty()){    
            int r = arr.length;
            
            int h = arr[st.pop()];

            if(st.isEmpty())area = Math.max(area, h*r);
            else area = Math.max(area, h*(r - st.peek()-1));
        }    
        return area;
    }
}