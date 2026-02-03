import java.util.LinkedList;
import java.util.Scanner;

public class bstwll {
    //structure of a Node
    class Node{
        int data;
        Node left, right, previous;
        Node(int data){
            this.data=data;
            left=right=null;
        }
    }
    private Node root;
    //Constructor to creation root node
    public bstwll(){
        root = null;
    }
    //insertion of Root Node
    public void insert(Node node, int data){
        root = insert(root,data);
    }

    private Node insert(Node node, int ParentData){
        if (node = null){
            return new Node(ParentData);            //Root initialised
        }
        if(ParentData > node.data){
            node.right=insert(node.right,ParentData);        //child node set to right after comparison with parent node as it is less than it...
        }
        else if(ParentData < node.data){
            node.left = insert(node.left, ParentData);        //child node set to left after comparison with parent node as it is greater than it...
        }
    }

    private LinkedList<Integer> Traverse(){
        LinkedList<Integer> TraversalList = new LinkedList<>();
        Traverse(root,TraverasalList);
        return TraversalList;
    }
    private void Traverse(Node ParentNode, TraversalList){
        if(ParentNode = Null){
            return;
        }
        Traverse(ParentNode.left,TraversalList);
        TraversalList.add(ParentNode.data);
        Traverse(ParentNode.right,TraversalList);
    }

    public static void main(){
        Scanner sc = new Scanner(System.in);
        bstwll bst = new bstwll();
        int choice,key;
        int i=0;
        System.out.println("Binary Seach Tree Insertion algorithm Execution");
        System.out.println("---------- Menu ----------\n1.Insert Data\n2. Display Inorder\n3.Exit");
        while(true){
            i++;
            System.out.print("Enter Your Choice: ");
            choice = sc.nextInt();

            switch(choice){
                case 1    :    System.out.print("Enter your Data for "+i+"st Element : ");
                               key = sc.nextInt();
                               bst.insert(key);
                               break;
                case 2    :    System.out.println("\n\nDisplaying Elements.....");
                               bst.Traverse();
                               break;
                case 3    :    System.out.println("Exiting.....");
                               return;
                default   :    System.out.prinln("Invalid Input");
                                break;
            }
            
        }
    }    
}

