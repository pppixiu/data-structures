package Arrays;

/**
 * @ClassName Main
 * @Author sensu
 * @Date 2019/10/2 18:14
 **/
public class Main {
    public static void main(String[] args) {
        Array arr = new Array(20);
        for (int i = 0; i < 10; i++) {
            arr.addLast(i);
        }
        System.out.println(arr.toString());
    }
}
