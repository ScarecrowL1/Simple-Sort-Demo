public class Sort {

    public int[] sort(int[] nums){
        if(nums == null || nums.length == 0){
            return null;
        }

        //quickSort(0, nums.length-1, nums); //end应该是最后一个元素的下标

        int[] temp = new int[nums.length];
        mergeSort(0, nums.length - 1, nums, temp);
        return nums;
    }


    public void quickSort(int start, int end, int[] nums) {
        //递归返回条件是传入时左右指针重合或交错
        if(start >= end){
            return;
        }

        int pivot = nums[((start + end)/ 2)];
        int left = start;
        int right = end;

        while (left <= right) {
            //这两个while条件两边都是 == pivot的话也交换
            while(left <= right && nums[left] < pivot){
                left++;
            }
            while(left <= right && nums[right] > pivot){
                right--;
            }
            //此时 left > right 或者 nums[left] >= pivot 或者 num[right] <= pivot
            //找到两个冲突项后，交换
            if(left <= right){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }

        //此时left > right, 即left与right交错
        quickSort(start, right, nums);
        quickSort(left, end, nums);
    }

    /**
     * 归并排序
     *
     * @param start 开始
     * @param end   结束
     * @param nums  数组
     */
    public void mergeSort(int start, int end, int[] nums, int[] temp){
        if(start >= end){
            return;
        }

        int middle = (start + end) / 2;
        mergeSort(start, middle, nums, temp);
        mergeSort(middle + 1, end, nums, temp);
        merge(start, end, nums, temp);
    }

    public void merge(int start, int end, int[] nums, int[] temp){
        int middle = (start + end) / 2;
        int leftHalf = start;
        int rightHalf = middle + 1;
        int tempIndex = leftHalf;

        while(leftHalf <= middle && rightHalf <= end){  //while循环的&&条件，即有有一个不满足则退出循环，也就是说会有的没有遍历到
            if(nums[leftHalf] < nums[rightHalf]){
                temp[tempIndex] = nums[leftHalf];
                leftHalf++;
                tempIndex++;
            }
            else{
                temp[tempIndex] = nums[rightHalf];
                rightHalf++;
                tempIndex++;
            }
        }

        //以下两个while是将剩下的没有遍历到的有序数据放入temp
        while(leftHalf <= middle){
            temp[tempIndex++] = nums[leftHalf++];
        }

        while(rightHalf <= end){
            temp[tempIndex++] = nums[rightHalf++];
        }

        for(int i = start; i <= end; i++){
            nums[i] = temp[i];
        }
    }



}
