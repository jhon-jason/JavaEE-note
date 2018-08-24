package Day_02.Test11;
/*
* 十一、编写一个泛型方法，实现任意引用类型数组指定位置元素交换
 */
public class Test11 {
    public static void main(String[] args) {
    Integer [] arr={1,2,3,4,5,6,7,8,9};
    Object [] arr1=change(arr,8,4);
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i]+",");
        }
    }
    public static Object [] change(Object [] arr,int a,int b){
        Object temp=arr [a];
        arr[a]=arr[b];
        arr[b]=temp;
        return arr;
    }
}
