package Arrays;

/**
 * @ClassName ArrayMain
 * @Author sensu
 * @Date 2019/10/2 18:14
 **/
public class ArrayMain {
    public static void main(String[] args) {
        Array<Integer> arr = new Array<>(10);
        for (int i = 0; i < 15; i++) {
            arr.addLast(i);
        }
        System.out.println(arr.toString());

    }
}