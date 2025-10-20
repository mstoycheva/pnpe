public class ReverseArr {
    public static void main(String[] args) {
        int[] arrRev = {4, 7, 5, 10};
        for (int j : arrRev) {
            System.out.print(j + " ");
        }
        System.out.println();
        System.out.println("Reversed Array: ");
        for(int i = arrRev.length - 1; i >= 0; i--){
            System.out.print(arrRev[i] + " ");
        }
    }
}
