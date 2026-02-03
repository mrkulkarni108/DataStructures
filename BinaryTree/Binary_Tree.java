public class Binary_Tree {

    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    static void visit(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        visit(node.left);
        visit(node.right);
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        visit(root);
    }
}
