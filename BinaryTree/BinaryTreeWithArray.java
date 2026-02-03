import java.util.Scanner;
public class BinaryTreeWithArray {
    static int[] tree;
    static int size;
    // Create binary tree
    static void createTree(Scanner sc) {
        System.out.print("Enter number of nodes: ");
        size = sc.nextInt();
        tree = new int[size];
        System.out.println("Enter elements (use -9 for no node):");
        for (int i = 0; i < size; i++) {
            tree[i] = sc.nextInt();
        }
    }
    // Level order display
    static void levelOrder() {
        System.out.println("Level Order Traversal:");
        for (int i = 0; i < size; i++) {
            if (tree[i] != -9)
                System.out.print(tree[i] + " ");
        }
        System.out.println();
    }
    // Inorder traversal
    static void inorder(int i) {
        if (i >= size || tree[i] == -9)
            return;
        inorder(2 * i + 1);
        System.out.print(tree[i] + " ");
        inorder(2 * i + 2);
    }
    // Preorder traversal
    static void preorder(int i) {
        if (i >= size || tree[i] == -9)
            return;
        System.out.print(tree[i] + " ");
        preorder(2 * i + 1);
        preorder(2 * i + 2);
    }
    // Postorder traversal
    static void postorder(int i) {
        if (i >= size || tree[i] == -9)
            return;
        postorder(2 * i + 1);
        postorder(2 * i + 2);
        System.out.print(tree[i] + " ");
    }
    static int countNodes(int i) {
        if (i >= size || tree[i] == -9)
            return 0;
        int TotalNodes = countNodes(2 * i + 1) + countNodes(2 * i + 2) + 1;
        return TotalNodes;
    }
    static int countLeafNodes(int i) {
        if (i >= size || tree[i] == -9)
            return 0;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if ((left >= size || tree[left] == -9) && (right >= size || tree[right] == -9))
            return 1;
        int count = countLeafNodes(left) + countLeafNodes(right);
        return count;
    }
    static int height(int i) {
        if (i >= size || tree[i] == -9)
            return 0;
        int left = height(2 * i + 1);
        int right = height(2 * i + 2);
        int CompleteHeight = Math.max(left, right) + 1;
        return CompleteHeight;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        System.out.println("\n========== MENU ==========\n1. Create Binary Tree\n2. Display Level Order\n3. Inorder Traversal\n4. Preorder Traversal\n5. Postorder Traversal\n6. Find Height of Tree\n7. Count Number of Nodes\n8. Count Number of Leaf Nodes\n9. Exit\n==========================");
        do {
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    createTree(sc);
                    break;
                case 2:
                    levelOrder();
                    break;
                case 3:
                    System.out.print("Inorder Traversal: ");
                    inorder(0);
                    System.out.println();
                    break;
                case 4:
                    System.out.print("Preorder Traversal: ");
                    preorder(0);
                    System.out.println();
                    break;
                case 5:
                    System.out.print("Postorder Traversal: ");
                    postorder(0);
                    System.out.println();
                    break;
                case 6:
                    System.out.println("Height of Tree: " + height(0));
                    break;
                case 7:
                    System.out.println("Total Nodes: " + countNodes(0));
                    break;
                case 8:
                    System.out.println("Leaf Nodes: " + countLeafNodes(0));
                    break;
                case 9:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 9);
        sc.close();
    }
}