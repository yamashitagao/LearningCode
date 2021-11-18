package learning.algorithm;

import org.apache.poi.util.ArrayUtil;

import java.util.Arrays;
import java.util.PrimitiveIterator;

/**
 * @description
 * @author:Gjc
 * @time: 10:25
 * @date: 2021-11-18
 */



public class BubbleSort {
    private static int[] arrs = {11,6,5,2,7,1,9,3,8,4,22};
    public static int[] result1;
    public static int[] result2;
    // 11 6 5 2 7
    // 6 11 5 2 7 t=6 r=0
    // 6 5 11 2 7 t=5 r=0
    // 5 6 11 2 7

    public static void bubbleSortV1(){
        int[] arr =arrs;
        int temp ;
        for (int i = 0;i< arr.length;i++){
            for (int j = 0;j< arr.length-1;j++){
                if (arr[j]>arr[j+1]){
                   temp = arr[j+1];
                   arr[j+1] = arr[j];
                   arr[j] = temp;
                }
            }
        }
        result1 = arr;

    }
    /*
    * 空间占用大
    * 通过一次遍历取最大值放后面
    * 同时比较最小值
    * 最小值放在排头
    * */
    public static void bubbleSortv2(){
        int[] arr =arrs;
        int temp ;
        int r;
        int [] t;
        for (int i = 0;i< arr.length-1;i++){
            if (arr[i]>arr[i+1]){
                temp = arr[i+1];
                arr[i+1] = arr[i];
                arr[i] = temp;
                if (i>0 && temp < arr[0]){
                    int[] a = Arrays.copyOf(arr, i);
                    int[] b = Arrays.copyOfRange(arr, i+1, arr.length);
                    int[] c = new int[a.length+b.length+1];
                    c[0] =temp;
                    System.arraycopy(a,0,c,1,a.length);
                    System.arraycopy(b,0,c,a.length+1,b.length);
                    arr = c;

                }
            }
        }
        result2 = arr;
    }
    public static void main(String[] args) {
        long t = System.currentTimeMillis();
        for (int i= 0;i<10000000;i++){
            bubbleSortV1();
        }

        System.out.println("times:"+(System.currentTimeMillis()-t));
        t = System.currentTimeMillis();
        for (int i= 0;i<10000000;i++){
            bubbleSortv2();
        }
        System.out.println("times:"+(System.currentTimeMillis()-t));

        System.out.println(Arrays.toString(result1));
        System.out.println(Arrays.toString(result2));


    }
}
