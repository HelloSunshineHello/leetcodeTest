public class TestMaxArea11 {
    public static void main(String[] args) {
        int[] height = new int[]{1,2,4,3};
        maxArea(height);
    }


    //暴力法代码阅读性优化
    /*public int maxArea(int[] height) {
        int maxArea = 0;
        int len = height.length;
        if(len<2) return 0;
        for(int i=0;i<len-1;i++){
            for(int j=i+1;j<len;j++){
                maxArea= Math.max(maxArea,Math.min(height[i],height[j])*(j-i));
            }
        }
        return maxArea;
    }*/

    //暴力法
    public static int maxArea(int[] height) {
        int maxArea = 0;
        int len = height.length;
        if(len<2) return 0;
        int i=0;
        int j=len-1;
        for(int k=0;k<len-1;k++){
            for(int m=0;m<=k&&j>i+k;m++){
                int min = height[i+m] < height[j-k+m] ? height[i+m] : height[j-k+m];
                System.out.println(min);
                int tempArea = min*(j-i-k);
                System.out.println(tempArea);
                System.out.println("***********");
                if(tempArea > maxArea) maxArea= tempArea;
            }
        }
        return maxArea;
    }
}
