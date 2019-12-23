package sima.classwork16_12;

public class Arrays {
    public static void main(String[] args){
        findMax();
    }


    public static void findMax(){
        int[] arr = {40, 23, 90, -2, -3, 7};
        int max = arr[0];
        for(int i =1; i< arr.length; i++){
            if(arr[i] > 0)
                max = arr[i];
        }
        System.out.println("The Maximum is " + max);
    }

    public static void circ(){
        int[] circ = {6,22, 5, 3, -6, -12};
        int[] circ2 = new int[6];
    }


    public static int findIndexOf(int[] arr, int val){
        return 1;
    }
}
