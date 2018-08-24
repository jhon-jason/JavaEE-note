package Day_01.Test10;
/*

public class Test10 {
    public static void main(String[] args) {
        String [] arr={"010","3223","666","7890987","123123","12345"};
        StringBuilder sb = new StringBuilder();
        int count=0;
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (arr[i].equals(sb.reverse().toString())){
                count++;
                sb.delete(0,sb.capacity()-1);
            }
        }
        System.out.println(count);
    }
}
*/

public class Test10 {
    public static void main(String[] args) {
        String [] arr={"010","3223","666","7890987","123123","12345"};
        StringBuilder sb = new StringBuilder();
        int count=0;
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (arr[i].equals(sb.reverse().toString())){
                count++;

                sb.delete(0,sb.length());
            }
        }
        System.out.println(count);
    }
}

