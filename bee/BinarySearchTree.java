package com.bee;


import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    //Class containing left
    //and right child of current node and key value
    //using List list Node, null
    class Node
    {
        int x;
        Node left, right;
        public Node(int item)
        {
            x = item;
            left = right = null;
        }
    }
    // declare Root of BST
    Node root;
    // Constructor
    BinarySearchTree() { root = null; }

    // This method mainly calls insertRec()
    void insert(int x)
    {
        root = insertRec(root, x);
    }
    /* A recursive function to
       insert a new key in BST */
    Node insertRec(Node root, int x)
    {
        /* If the tree is empty,
           return a new node */
        if (root == null)
        {
            root = new Node(x);
            return root;
        }
        /* Otherwise, recur down the tree */
        if (x < root.x)
            root.left = insertRec(root.left, x);
        else if (x > root.x)
            root.right = insertRec(root.right, x);
        /* return the (unchanged) node pointer */
        return root;
    }

    /* Given a binary tree, print its nodes according to the
          "bottom-up" postorder traversal. */
    void printPostorder(Node node)
    {
        if (node == null)
            return;
        // first recur on left subtree
        printPostorder(node.left);
        // then recur on right subtree
        printPostorder(node.right);
        // now deal with the node
        System.out.print(node.x + " ");
    }

    /* Given a binary tree, print its nodes in inorder*/
    void printInorder(Node node)
    {
        if (node == null)
            return;
        /* first recur on left child */
        printInorder(node.left);
        /* then print the data of node */
        System.out.print(node.x + " ");
        /* now recur on right child */
        printInorder(node.right);
    }
    /* Given a binary tree, print its nodes in preorder*/
    void printPreorder(Node node)
    {
        if (node == null)
            return;
        /* first print data of node */
        System.out.print(node.x + " ");
        /* then recur on left sutree */
        printPreorder(node.left);
        /* now recur on right subtree */
        printPreorder(node.right);
    }

    /*
        BFT = BFS = Breadth First Traversal (Search)
        traverse tree from the root to the leaf, from the left to the right
        BFT (BFS) = Breadth First Traversal (Search)
     */
    void BFT(){
        if(root != null){
            Queue <Node> Q = new LinkedList<Node>();
            Q.add(root);
            while (Q.isEmpty() == false){
                Node x = (Node) Q.poll();
                if (x.left != null)
                    Q.add(x.left);
                if (x.right != null)
                    Q.add(x.right);
                System.out.print(x.x + " ");
            }
        }
    }
    // Wrappers over above recursive functions
    void printPostorder() { printPostorder(root); }
    void printInorder() { printInorder(root); }
    void printPreorder() { printPreorder(root); }
    // declare Search function x frome BST
    boolean printSearch(int x)  {
        root = search(root, x);
        if (root!= null)
            return true;
        else
            return false;
    }
    //recursive insert function
    // A utility function to search a given key in BST
    public Node search(Node root, int x)
    {
        // Base Cases: root is null or key is present at root
        if (root==null || root.x==x)
            return root;
        // Key is greater than root's key
        if (root.x < x)
            return search(root.right, x);
        // x is smaller than root's key
        return search(root.left, x);
    }

    // This method mainly calls deleteRec()
    void deletex(int x) { root = deleteRec(root, x); }

    /* A recursive function to
      delete an existing x in BST
     */
    Node deleteRec(Node root, int x)
    {
        /* Base Case: If the tree is empty */
        if (root == null)
            return root;
        /* Otherwise, recur down the tree */
        if (x < root.x)
            root.left = deleteRec(root.left, x);
        else if (x > root.x)
            root.right = deleteRec(root.right, x);
        // if key is same as root's x, then This is the node to be deleted
        else {
            // node with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
            // node with two children: Get the inorder
            // successor (smallest in the right subtree)
            root.x = minValue(root.right);
            // Delete the inorder successor
            root.right = deleteRec(root.right, root.x);
        }

        return root;
    }
    // declare get minvale in root
    int minValue(Node root) {
        //initially minval = root
        int minv = root.x;
        //find minval
        while (root.left != null)
        {
            minv = root.left.x;
            root = root.left;
        }
        return minv;
    }

    public static void main(String[] args)
    {
        BinarySearchTree tree = new BinarySearchTree();

        /* Let us create following BST*/
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
        // print inorder traversal of the
        System.out.println("\nTraversal of Tree: ");
        System.out.println("Preorder traversal of binary tree is ");
        tree.printPreorder();
        System.out.println("\nInorder traversal of binary tree is ");
        tree.printInorder();
        System.out.println("\nPostorder traversal of binary tree is ");
        tree.printPostorder();
        System.out.println("\nBFT of binary tree is ");
        tree.BFT();
        //search a key in the BST
        boolean ret_val = tree.printSearch (50);
        System.out.println("\nSearch x = 50 in BST. found?:" + ret_val );
        System.out.println("\nInorder of tree before delete ");
        tree.printInorder();
        System.out.println("\nThe BST after Delete 20(leaf node):");
        tree.deletex(20);
        tree.printInorder();

    }
}
