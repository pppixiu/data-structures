package Arrays;

/**
 * @ClassName ArrayStackMain
 * @Author sensu
 * @Date 2019/10/3 11:24
 **/
public class ArrayStackMain {
    public static void main(String[] args) {
        Stack<Integer> stack = new ArrayStack<>();

        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);
    }
}
