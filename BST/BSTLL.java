import java.util.LinkedList;
import java.util.Scanner;

public class BSTLL {

    // Node class
    class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    private Node root;

    public BSTLL() {
        root = null;
    }

    // Insert
    public void insert(int data) {
        root = insert(root, data);
    }

    private Node insert(Node node, int data) {
        if (node == null)
            return new Node(data);

        if (data < node.data)
            node.left = insert(node.left, data);
        else if (data > node.data)
            node.right = insert(node.right, data);

        return node;
    }
    private void Display() {
        System.out.println("Displaying Binary Search Tree:");
        System.out.println("Pre-order Traversal: " + preOrder());
        System.out.println("Post-order Traversal: " + postOrder());
        System.out.println("In-order Traversal: " + inOrder());
    }

    
    // Pre-order traversal
    public LinkedList<Integer> preOrder() {
        LinkedList<Integer> result = new LinkedList<>();
        preOrder(root, result);
        return result;
    }
    
    private void preOrder(Node node, LinkedList<Integer> result) {
        if (node == null)
            return;
        result.add(node.data);
        preOrder(node.left, result);
        preOrder(node.right, result);
    }
    // In-order traversal
    public LinkedList<Integer> inOrder() {
        LinkedList<Integer> result = new LinkedList<>();
        inOrder(root, result);
        return result;
    }
     
    private void inOrder(Node node, LinkedList<Integer> result) {
        if (node == null)
            return;

        inOrder(node.left, result);
        result.add(node.data);
        inOrder(node.right, result);
    }

    // Post-order traversal
    public LinkedList<Integer> postOrder() {
        LinkedList<Integer> result = new LinkedList<>();
        postOrder(root, result);
        return result;
    }

    private void postOrder(Node node, LinkedList<Integer> result) {
        if (node == null)
            return;
        postOrder(node.left, result);
        postOrder(node.right, result);
        result.add(node.data);
    }


    // Delete
    public void delete(int data) {
        root = delete(root, data);
    }

    private Node delete(Node node, int data) {
        if (node == null)
            return null;

        if (data < node.data) {
            node.left = delete(node.left, data);
        } else if (data > node.data) {
            node.right = delete(node.right, data);
        } else {
            // Case 1: No child
            if (node.left == null && node.right == null)
                return null;

            // Case 2: One child
            if (node.left == null)
                return node.right;
            if (node.right == null)
                return node.left;

            // Case 3: Two children
            Node successor = minValueNode(node.right);
            node.data = successor.data;
            node.right = delete(node.right, successor.data);
        }
        return node;
    }

    private Node minValueNode(Node node) {
        while (node.left != null)
            node = node.left;
        return node;
    }

    // Main
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BSTLL bst = new BSTLL();
        int DATA, CHOICE;

        System.out.println("Binary Search Tree using Linked List");
        System.out.println("\n1. Insert Data\n2. Display \n3. Delete Data\n4. Exit");

        while (true) {
            System.out.print("Enter your choice: ");

            CHOICE = sc.nextInt();

            switch (CHOICE) {
                case 1:
                    System.out.print("Enter data to insert: ");
                    DATA = sc.nextInt();
                    bst.insert(DATA);
                    break;

                case 2:
                    System.out.println(" ============ Displaying Binary Search Tree ============\n" + bst.Display());
                    break;

                case 3:
                    System.out.print("Enter data to delete: ");
                    DATA = sc.nextInt();
                    bst.delete(DATA);
                    break;

                case 4:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}