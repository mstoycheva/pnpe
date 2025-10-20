public class ConcatArray {
    public static void main(String[] args) {
        int[] arr = {2, 8, 9, 3};
        int[] arr2 = {1, 4, 6, 5};
        int[] c = new int[arr.length + arr2.length];

        for(int i = 0; i < arr.length; i++){
            c[i] = arr[i];
        }
        int j = arr.length;
        for(int i = 0; i < arr2.length; i++){
            c[j] = arr2[i];
            j++;
        }
        for(int i = 0; i < c.length; i++) {
            System.out.print(c[i] + " ");
        }
    }
}
