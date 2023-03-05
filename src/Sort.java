public class Sort {
    int[] nums; //执行数组

    public void QuickSort(){
        if(nums == null || nums.length == 0){
            return;
        }

        QSFun(0, nums.length-1); //end应该是最后一个元素的下标
    }
    public void QSFun(int start, int end) {
        //递归返回条件是传入时左右指针重合或交错
        if(start >= end){
            return;
        }

        int pivot = nums[((start + end)/ 2)];
        int left = start;
        int right = end;

        while (left <= right) {
            while(left <= right && nums[left] < pivot){
                left++;
            }
            while(left <= right && nums[right] > pivot){
                right--;
            }
            //找到两个冲突项后，交换
            if(left <= right){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }

        QSFun(start, right);
        QSFun(left, end);
    }



    public void setNums(int[] nums){
        this.nums = nums;
    }

    public int[] getNums() {
        return nums;
    }
}
