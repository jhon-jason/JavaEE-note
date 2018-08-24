package Day_01.Test09;

public class Test09 {
    public static void main(String[] args) {
        String str="java";
        long start=System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            str+="java";
        }
        long end_1=System.currentTimeMillis();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100000; i++) {
            sb.append("java");

        }
        long end_2=System.currentTimeMillis();
        System.out.println("String---"+(end_1-start));
        System.out.println("StringBuilder---"+(end_2-end_1));
    }
}
