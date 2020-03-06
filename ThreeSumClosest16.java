import java.util.Arrays;

public class ThreeSumClosest16 {
    public static void main(String[] args) {
        int[] a= {1,2,4,8,16,32,64,128};
        threeSumClosest(a,82);
    }
    public static int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        int res =0;
        if(target<Integer.MIN_VALUE || target>Integer.MAX_VALUE) throw new IllegalArgumentException("target不合适");
        if(target>=0){
            res=Integer.MAX_VALUE;
        }else{
            res=Integer.MIN_VALUE;
        }

        Arrays.sort(nums); //先排序

        //暴力遍历法
        for(int i=0;i<len-2;i++){
            for(int j=i+1;j<len-1;j++){
                Boolean flag =true;  //添加一个终止标志，提前结束内循环
                for(int k=j+1;k<len && flag;k++){
                    //for(int k=j+1;k<len ;k++){
                    flag = false;
                    int sum = nums[i]+nums[j]+nums[k];
                    if(Math.abs(sum-target)<Math.abs(res-target)){
                        res=sum;
                        flag =true;
                    }
                }
            }
        }

        return res;
    }
}
