class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        mergeSort(nums, 0, n-1);
        return nums;
    }

    public void mergeSort(int[] nums, int low, int high){
        if(low >= high)
            return;
        int mid = (low + high) / 2;
        mergeSort(nums, low, mid);
        mergeSort(nums, mid+1, high);
        merge(nums, low, high);
    }

    public void merge(int[] nums, int low, int high){
        int mid = (low + high) / 2;
        int left = low;
        int right = mid + 1;
        int[] tmp = new int[low + high + 1];
        int i = 0;
        while(left <= mid && right <= high){
            if(nums[left] <= nums[right]){
                tmp[i++] = nums[left];
                left++;
            }else{
                tmp[i++] = nums[right];
                right++;
            }
        }
        while(left <= mid){
            tmp[i++] = nums[left];
            left++;
        }

        while(right <= high){
            tmp[i++] = nums[right];
            right++;
        }

        for(int j=low; j <= high; j++){
            nums[j] = tmp[j-low];
        }
    }
}