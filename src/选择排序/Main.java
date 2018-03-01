package 选择排序;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int[] arr = new int[100];
        Random r = new Random();
        for(int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt();
        }
//        Arrays.sort(arr);
//        String s = arr.toString();
        long l = System.currentTimeMillis();
        quickSort(arr,0,arr.length-1);

        for (int i : arr) {
            System.out.println(i);
        }
//        xuanzepaixu(arr);
        long l1 = System.currentTimeMillis();
        System.out.println(l1-l);
//        for (int i : arr) {
//            System.out.println(i);
//        }
    }

    /*选择排序，就是拿第一个数和后面的数比较
    * 比较完成后，记录下最小的数 然后和当前索引的数替换*/

    /*选择排序*/
    public static void xuanzepaixu(int[]arr){
        /*遍历数组 范围是数组的倒数第二个 */
        for(int i=0; i < arr.length-1; i++){
            /*在循环中记录第一个数和索引*/
            int num=arr[i];
            int index=i;
            /*再循环拿第一个数和他之后的比较 （范围是数组的最后一个）*/
             for(int y = i+1; y < arr.length; y++){
//                 System.out.println(y);
                 /*如果num的值比后面的值大*/
                 if(num > arr[y]){
                     /*那么把小值赋给num*/
                     num=arr[y];
                     /*把小值索引赋给num的索引*/
                     index=y;
                 }
             }
             /*如果第一个值不是最小的*/
             if(index != i){
                 /*把小值的索引替换了num值得索引*/
                    swap(arr,i,index);
             }
        }
    }



    public static void swap(int[]arr,int x,int index){
        int temp=arr[x];
        arr[x]=arr[index];
        arr[index]=temp;
    }


    /*快速排序*/
    public static void quickSort(int[]arr,int left,int right){
        if(left>right){
            return;
        }

        int base = arr[left];

        int i=left;

        int j=right;

        while (i != j){
            while (arr[j] >= base && i<j){
                j--;
            }

            while (arr[i] <= base && i<j){
                i++;
            }

            if(i < j){
                //交换i 和 j 位置上的数
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i];
        arr[i] = arr[left];
        arr[left] = temp;

        quickSort(arr,left,i - 1);

        quickSort(arr,j + 1,right);

    }



    /*冒泡排序  就是比较相邻的两个数 每一次求出数组中的最值
    然后把最值放在最后的位置 然后再次比较此时就过滤掉最值的索引*/
    public static void maopao(int[]arr){
        for (int i = 0; i<arr.length-1; i++){

            for (int y = 0; y<arr.length-1-i; y++){
                if(arr[i]>arr[y+1]){
                    int temp=arr[y+1];
                    arr[y+1]=arr[i];
                    arr[i]=temp;
                }
            }


        }
    }


}
