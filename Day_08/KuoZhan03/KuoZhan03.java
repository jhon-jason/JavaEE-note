package Day_08.KuoZhan03;

public class KuoZhan03 {
    public static void main(String[] args) {
        int count = count(10);
        System.out.println(count);
    }
    public static int count(int a){
        if(a==1)
            return 1;
        return 2*(count(a-1)+1);
    }
}
