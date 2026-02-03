import java.util.*;

public class BinaryTree {
    LinkedList<Integer> ll = new LinkedList<>();
    public static void main(String[] args) {
        System.out.println("Hi");
        BinaryTree bt = new BinaryTree();
        bt.ll.add(5);
        bt.ll.add(1);
        bt.ll.add(2);
        bt.ll.add(3);
        bt.ll.add(4);
        System.out.println(bt.ll);
        bt.ll.removeLast();
        System.out.println(bt.ll);
        bt.ll.removeFirst();
        System.out.println(bt.ll);
        bt.ll.remove(1);
        System.out.println(bt.ll);
    }
}
