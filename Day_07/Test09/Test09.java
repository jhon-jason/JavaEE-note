package Day_07.Test09;

public class Test09 {
    public static void main(String[] args) {
        invkeDirect(() -> {
                    System.out.println("导演拍电影啦");
                }
        );
    }

    private static void invkeDirect(Director director) {
        director.makeMovie();
    }
}


