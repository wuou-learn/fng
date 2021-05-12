package JVM.类加载顺序;

import java.awt.print.Book;

/**
 * @author wuou
 * @version 1.0.0
 * @date 2021/2/25 下午2:27
 */
public class TestBook {

    public static void main(String[] args) {

        ClassLoader classLoader = Book.class.getClassLoader();
        
        
    }
}
