package Day_02.Test12;
/*
* 十二、编写一个泛型方法，接收一个任意引用类型的数组，并反转数组中的所有元素
 */
public class Test12 {
    public static void main(String[] args) {
        Integer [] arr={1,2,3,4,5,6,7,8,9};
        reverse(arr);
    }
    public static void reverse(Object [] arr){
        int pos=arr.length/2;
        for (int i = 0; i < pos; i++) {
            Object temp=arr[i];
            arr[i]=arr[arr.length-1-i];
            arr[arr.length-1-i]=temp;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+",");
        }
    }
}
