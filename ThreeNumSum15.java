import java.util.*;

public class ThreeNumSum15 {

    public static void main(String[] args) {
        //int[] a = {-10, -10, -9, -8, -8, -6, -5, -5, -5, -4, -3, -2, -2, -2, -2, -1, -1, -1, 4, 6, 8, 8, 9};
        int[] a= {-1,0,1,2,-1,-4};
        Arrays.sort(a);
        for (int temp : a) {
            System.out.print("," + temp + ",");
        }
        threeSum(a);

    }

    public static List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if (len < 3 || nums == null) return list;
        //先排序
        Arrays.sort(nums);
        //System.out.println(nums);
        //在使用双指针
        /*if (nums[0] <= 0 && nums[len - 1] >= 0) { // 优化1: 整个数组同符号，则无解
            for (int i = 0; i < len - 2; ) {
                if (nums[i] > 0) break; // 优化2: 最左值为正数则一定无解
                int first = i + 1;
                int last = len - 1;
                do {
                    if (first >= last || nums[i] * nums[last] > 0) break;// 两人选相遇，或者三人同符号，则退出
                    int result = nums[i] + nums[first] + nums[last];
                    if (result == 0) { // 如果可以组队
                        list.add(new ArrayList<Integer>(Arrays.asList(nums[i], nums[first], nums[last])));
                    }
                    if (result < 0) { // 实力太弱，把菜鸟那边右移一位
                        while (first < last && nums[first] == nums[++first]) {
                        } // 如果相等就跳过
                    } else { // 实力太强，把大神那边右移一位
                        while (first < last && nums[last] == nums[--last]) {
                        }
                    }
                } while (first < last);
                while (i < len-1 && nums[i] == nums[++i]) {
                }
            }
        }*/
        /*if (nums[0] <= 0 || nums[len - 1] >= 0) {
            for (int i = 0; i < len - 2; ) {
                //System.out.println(nums[i]);
                if (nums[i] > 0) return list; // 第一个数大于0
                int first = i + 1;
                int last = len - 1;
                while (first < last) {
                    //if (nums[i] * nums[last] > 0) break; //第一个数和最后一个数同号
                    int res = nums[i] + nums[first] + nums[last];
                    if (res == 0) {
                        list.add(new ArrayList<Integer>(Arrays.asList(nums[i], nums[first], nums[last])));
                    }
                    if (res < 0) {
                        while (first < last && nums[first] == nums[first + 1]) first++;
                        first++;
                    } else {
                        while (first < last && nums[last] == nums[last - 1]) last--;
                        last--;
                    }

                }
                while (i < len - 3 && nums[i] == nums[i + 1]) i++;
                i++;
            }
        }*/
        for(int i = 0;i<len-2;i++){
            //if(nums[i]>0 || nums[len-1]<0) break; //首尾检查优化
            if(i>0 && nums[i]==nums[i+1]) continue;
            int l = i+1;
            int r = len-1;
            while(l<r){
                int res = nums[i]+nums[l]+nums[r];
                if(res==0){
                    list.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    while(l<r && nums[l]==nums[++l]);
                    while(l<r && nums[r]==nums[--r]);
                }
                if(res<0){
                    while(l<r && nums[l]==nums[++l]);  //左移的同时去重
                }
                if(res>0){
                    while(l<r && nums[r]==nums[--r]);  //右移的同时去重
                }
            }
        }
        System.out.println(list);
        return list;
    }



}
