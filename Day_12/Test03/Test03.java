package Day_12.Test03;

public class Test03 {
    public static void main(String[] args) {
        decToHex(10,a->Integer.toHexString(a));
    }
    public static void decToHex(int num ,NumberToString nts){
        String convert = nts.convert(num);
        System.out.println(convert);
    }
}

@FunctionalInterface
interface NumberToString{
    public abstract String convert(int num);
}