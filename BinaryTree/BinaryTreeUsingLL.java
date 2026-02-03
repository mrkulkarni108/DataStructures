import java.util.*;

// Node structure
class TreeNode {
    int data;
    TreeNode left, right;

    TreeNode(int data) {
        this.data = data;
        left = right = null;
    }
}

public class BinaryTreeUsingLL {

    //Traversals

    void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    void preorder(TreeNode node) {
        if (node == null) return;
        System.out.print(node.data + " ");
        preorder(node.left);
        preorder(node.right);
    }

    void postorder(TreeNode node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data + " ");
    }

    //Height of Tree
    int height(TreeNode node) {
        if (node == null) return 0;
        int CompleteHeight = Math.max(height(node.left), height(node.right)) + 1;
        return CompleteHeight;
    }

    //Level Order
    void levelOrder(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            System.out.print(temp.data + " ");

            if (temp.left != null) queue.add(temp.left);
            if (temp.right != null) queue.add(temp.right);
        }
    }

    // Count Nodes
    int countNodes(TreeNode node) {
        if (node == null) return 0;
        int TotalNodes = countNodes(node.left) + countNodes(node.right) + 1;
        return TotalNodes;
    }

    //Count Leaf Nodes
    int countLeafNodes(TreeNode node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return 1;
        int TotalLeafNodes = countLeafNodes(node.left) + countLeafNodes(node.right);
        return TotalLeafNodes;
    }

    //Build Tree from LIST
    static TreeNode buildTreeFromList(Scanner sc) {
        System.out.println("Enter elements in level order (use -9 for no node):");
        sc.nextLine();

        String[] input = sc.nextLine().trim().split("\\s+");

        if (input.length == 0 || input[0].equals("-9"))
            return null;

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(input[0]));
        queue.add(root);

        int i = 1;

        while (!queue.isEmpty() && i < input.length) {
            TreeNode current = queue.poll();
            if (i < input.length && !input[i].equals("-9")) {
                current.left = new TreeNode(Integer.parseInt(input[i]));
                queue.add(current.left);
            }
            i++;
            if (i < input.length && !input[i].equals("-9")) {
                current.right = new TreeNode(Integer.parseInt(input[i]));
                queue.add(current.right);
            }
            i++;
        }
        return root;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BinaryTreeUsingLL tree = new BinaryTreeUsingLL();
        TreeNode root = null;

        int choice;
        System.out.println("\n========== MENU ==========\n1. Create Binary Tree (List Input)\n2. Display Level Order\n3. Inorder Traversal\n4. Preorder Traversal\n5. Postorder Traversal\n6. Find Height of Tree\n7. Count Number of Nodes\n8. Count Number of Leaf Nodes\n9. Exit\n==========================");
        do {
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    root = buildTreeFromList(sc);
                    System.out.println("Binary Tree created successfully.");
                    break;

                case 2:
                    tree.levelOrder(root);
                    System.out.println();
                    break;

                case 3:
                    System.out.print("Inorder: ");
                    tree.inorder(root);
                    System.out.println();
                    break;

                case 4:
                    System.out.print("Preorder: ");
                    tree.preorder(root);
                    System.out.println();
                    break;

                case 5:
                    System.out.print("Postorder: ");
                    tree.postorder(root);
                    System.out.println();
                    break;

                case 6:
                    System.out.println("Height of Tree: " + tree.height(root));
                    break;

                case 7:
                    System.out.println("Total Nodes: " + tree.countNodes(root));
                    break;

                case 8:
                    System.out.println("Leaf Nodes: " + tree.countLeafNodes(root));
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