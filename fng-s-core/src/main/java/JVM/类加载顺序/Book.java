package JVM.类加载顺序;

public class Book {

    static {
        System.out.println("书的静态代码块");
    }

    {
        System.out.println("书的普通代码块");
    }

    static Book book = new Book();

    static int amount = 112;

    int price = 110;

    Book() {
        System.out.println("书的构造方法");
        System.out.println("price=" + price + ",amount=" + amount);
    }

    public static void staticFunction() {
        System.out.println("书的静态方法" + ",amount=" + amount);
    }

    public static void main(String[] args) {
        staticFunction();
    }
}
