package Search;

import edu.princeton.cs.introcs.StdOut;

/**
 * Created by Yasic on 2016/5/1.
 */
public class BalancedBinaryTree {
    private static boolean RED = true;
    private static boolean BLACK = false;
    private static Node root;
    private static int SIZE = 10;

    private static class Node{
        int key;
        int val;
        Node left, right;
        int total;
        boolean color;

        Node(int key, int val, int total, boolean color){
            this.key = key;
            this.val = val;
            this.total = total;
            this.color = color;
            this.left = null;
            this.right = null;
    }
    }

    private static boolean isRed(Node node){
        if (node == null){
            return false;
        }
        return node.color == RED;
    }

    public static int getSize(){
        return getSize(root);
    }

    private static int getSize(Node root){
        if (root == null){
            return 0;
        }
        else {
            return root.total;
        }
    }

    private static Node rotateLeft(Node node){
        Node temp = node.right;
        node.right = temp.left;
        temp.left = node;
        node.color = temp.color;
        temp.color = RED;
        temp.total = node.total;
        node.total = getSize(node.left) + getSize(node.right) + 1;
        return temp;
    }

    private static Node rotateRight(Node node){
        Node temp = node.left;
        node.left = temp.right;
        temp.right = node;
        node.color = RED;
        temp.color = node.color;
        temp.total = node.total;
        node.total = getSize(node.left) + getSize(node.right) + 1;
        return temp;
    }

    private static void flipColors(Node node){
        node.color = RED;
        node.left.color = node.right.color = BLACK;
    }

    public static void put(int key, int val){
        root = put(root, key, val);
        root.color = BLACK;
    }

    private static Node put(Node node, int key, int val){
        if (node == null){
            return new Node(key, val, 1, RED);
        }
        if (key < node.key){
            node.left = put(node.left, key, val);
        }
        else if (key > node.key){
            node.right = put(node.right, key, val);
        }
        else node.val = val;

        if (!isRed(node.left) && isRed(node.right)){
            node = rotateLeft(node);
        }
        if (isRed(node.left) && isRed(node.left.left)){
            node = rotateRight(node);
        }
        if (isRed(node.left) && isRed(node.right)){
            flipColors(node);
        }
        node.total = getSize(node.right) + getSize(node.left) + 1;
        return node;
    }

    public static int getNode(int key){
        return getNode(root, key);
    }

    private static int getNode(Node node, int key){
        if (node == null){
            return -1;
        }
        if (node.key < key) {
            return getNode(node.right, key);
        }
        else if (node.key > key ){
            return getNode(node.left, key);
        }
        else {
            return node.val;
        }
    }

    public static void main(String[] arg){
        for (int i = 0; i < SIZE; i++){
            put(i, i);
        }
        for (int i = 0; i < SIZE; i++){
            StdOut.print(getNode(i)+"\n");
        }
    }
}
