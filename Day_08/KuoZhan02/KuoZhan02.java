package Day_08.KuoZhan02;

/*
 * 假设一对刚出生的小兔一个月后就能长成大兔，
 * 再过一个月就能生下一对小兔，并且此后每个月都生一对小兔，没有发生死亡，
 * 问：现有一对刚出生的兔子2年后(24个月)会有多少对兔子
 */
public class KuoZhan02 {
    public static void main(String[] args) {

        System.out.println(count(24));
    }
    public static long count(int a){
        if(a==1)
            return 1;
        return 3*count(a-1);
    }
}
