package DynamicProgramming;

/**
 * Created by gyaneshwar on 26/02/2017.
 * 1 2 3 4 12 13 16 18
 */
public class MagicIndex {

    public int getMagicIndex(int[] arr) {
        return getMagicIndexRecursiveMethod(arr, 0, arr.length - 1);
    }

    private int getMagicIndexRecursiveMethod(int[] arr, int start, int end) {

        if (start > end || start < 0 || end >= arr.length)
            return -1;

        //get the mid element
        int mid = (start + end) / 2;

        if (arr[mid] == mid)
            return mid;

        else if (arr[mid] > mid) {
            return getMagicIndexRecursiveMethod(arr, start, mid - 1);
        } else
            return getMagicIndexRecursiveMethod(arr, mid + 1, end);

    }

    public static void main(String[] args) {
        MagicIndex magicIndex = new MagicIndex();
        int[] arr = {-1, 1, 2, 3, 4, 12, 13, 16, 18};
        System.out.println( magicIndex.getMagicIndex(arr));
    }

}
