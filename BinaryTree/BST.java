import java.util.*;

public class BST{
    class Node{
        int data;
        Node left,right;
        Node(int data){
            this.data = data;
            left = right = null;
        }    
    }

    Node root;

    BST(){
        root = null;
    }

    public void insert(int data){
        root = insertRec(root, data);
    }

    public Node insertRec (Node root, int data){
        if (root == null){
            root = new Node(data);
            return root;
        }
        else if (data < root.data){
            root.left = insertRec(root.left, data);
        }
        else if ( data > root.data){
            root.right = insertRec(root.right, data);
        }
        return root;
    }
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        BST tree = new BST();
        ll.add(50);
        ll.add(30);
        ll.add(20);
        ll.add(40);
        ll.add(70);
        ll.add(60);
        ll.add(80);

        for(int val : ll){
            tree.insert(val);
        }
        LinkedList<LinkedList<Integer>> traversal = new LinkedList<>();
        for(LinkedList<Integer> level : traversal){
            for(int val : level){
                System.out.println(val);
            }
            System.out.println();
        }

    }
}