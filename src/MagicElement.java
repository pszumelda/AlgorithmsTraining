public class MagicElement {

    static int[] arr = new int[]{-5, -2, 0, 2, 4, 7, 9, 10, 11, 12, 15, 18};


    public static void main(String[] args) {
        //find index of array where array[index]==index in binary way
        int id = findMagicIndex(arr, 0, arr.length - 1);
        System.out.print(id);
    }

    public static int findMagicIndex(int[] arr, int l, int r) {
        if (l > r) return -1;
        int mid = (l + r) / 2;
        if (arr[mid] == mid) return mid;
        if (arr[mid] > mid) return findMagicIndex(arr, l, mid - 1);
        else return findMagicIndex(arr, mid + 1, r);
    }
}
