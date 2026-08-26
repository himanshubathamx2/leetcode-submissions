class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        for(int i=n/2; i>=0; i--){
            maxHeapify(nums, n, i);
        }

        for(int i=1; i<k; i++){
            nums[0] = nums[n-1];
            n--;
            maxHeapify(nums, n, 0);
        }
        return nums[0];
    }

     public static void maxHeapify(int[] nums, int n, int i) {
        int largest = i; // Initialize largest as root
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // Check if left child is larger than root
        if (left < n && nums[left] > nums[largest]) {
            largest = left;
        }

        // Check if right child is larger than largest so far
        if (right < n && nums[right] > nums[largest]) {
            largest = right;
        }

        // If largest is not root
        if (largest != i) {
            // Swap
            int temp = nums[i];
            nums[i] = nums[largest];
            nums[largest] = temp;

            // Recursively heapify the affected sub-tree
            maxHeapify(nums, n, largest);
        }
    }
}