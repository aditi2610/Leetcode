package Top100;

public class Solution42_RainingWater {

    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = height[left];
        int rightMax = height[right];
        int water = 0;
        /**
         * take 2 pointers left and right and 2 maxes, left and right max while(left
         * <right){ if(h[left]< h[right]) // this means there is a bigger block at the
         * right, so all I care about is if the current i < leftMax.. the maximum height
         * of water in that chunk can be leftMax and the actual water in the hole is
         * leftMax- h[currentElement] similarly if the left > right, that means, all I
         * have to do is.. check if an element smaller than rightMax exists, if it
         * exists... it means there is a hol e and you can pour water there.. if there
         * is none..
         * 
         * }
         */
        while (left < right) {

            if (height[left] < height[right]) {

                if (height[left] < leftMax)
                    water += leftMax - height[left];
                else {
                    leftMax = height[left];
                }
                left++;
            } else {

                if (height[right] < rightMax) {
                    water += rightMax - height[right];
                } else {
                    rightMax = height[right];
                }
                right--;
            }
        }

        // base cases

        return water;
    }

    public static void main(String[] args) {
        Solution42_RainingWater rain = new Solution42_RainingWater();
        // int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        int[] height = { 2, 1, 0, 0, 2 };
        System.out.println(rain.trap(height));
    }
}
