package Aug4;

public class Solution605_FlowerBed3 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        int beds = flowerbed.length;

        for (int i = 0; n > 0 && i < beds; i++) {

            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == beds - 1 || flowerbed[i + 1] == 0)) {

                flowerbed[i] = 1;
                n--;

            }
        }

        return n <= 0;
    }

    public static void main(String args[]) {
        Solution605_FlowerBed3 f2 = new Solution605_FlowerBed3();
        int[] bed = { 0, 0, 1, 0, 0 };
        if (f2.canPlaceFlowers(bed, 1))
            System.out.println("Yes");
        else
            System.out.println("No");

    }
}