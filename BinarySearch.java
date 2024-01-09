public class BinarySearch {
    public static void main(String[] args) {
        System.out.println(findLowerBound(new int[] { 1, 2, 3, 3, 3, 3, 3 }, 4));
        System.out.println(findUpperBound(new int[] { 1, 2, 3, 4, 4, 4, 4 }, 4));
    }

    public static int findLowerBound(int[] nums, int target) {
        int index = -1;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] >= target) {
                right = mid - 1;
            }
        }
        index = left == nums.length ? -1 : left;
        return index;
    }

    public static int findUpperBound(int[] nums, int target) {
        int index = -1;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] <= target) {
                left = mid + 1;
            }
        }
        index = right < 0 ? -1 : right;
        return index;
    }
}
