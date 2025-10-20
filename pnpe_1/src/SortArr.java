public class SortArr {
    public static void main(String[] args) {
        int[] arrSort = {5, 8, 4, 1};
        boolean isSorted = true;
        for(int i = 0; i < arrSort.length; i++){
            if(arrSort[i] > arrSort[i + 1]){
                isSorted = false;
                break;
            }
        }
        if(isSorted){
            System.out.println("Sorted Array");
        }
        else{
            System.out.println("Unsorted Array");
        }
    }
}
