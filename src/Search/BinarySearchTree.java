package Search;

import edu.princeton.cs.introcs.StdOut;
import jdk.internal.org.objectweb.asm.tree.analysis.Value;
import jdk.internal.org.xml.sax.SAXException;
import sun.net.www.ParseUtil;

import java.security.Key;

/**
 * Created by Yasic on 2016/4/28.
 */
public class BinarySearchTree {
    private static Node root;
    private static int SIZE = 10;

    private static class Node {
        private int key;
        private String value;
        private Node left, right;
        private int total;

        public Node(int key, String value, int N){
            this.key = key;
            this.value = value;
            this.total = N;
        }
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

    public static String getNode(int key){
        return getNode(root, key);
    }

    private static String getNode(Node node, int key){
        if (node == null){
            return null;
        }
        if (node.key < key) {
            return getNode(node.right, key);
        }
        else if (node.key > key ){
            return getNode(node.left, key);
        }
        else {
            return node.value;
        }
    }

    public static int getMin(){
        return getMin(root).key;
    }

    private static Node getMin(Node node){
        if (node.left == null){
            return node;
        }
        return getMin(node.left);
    }

    public static int getMax(){
        return getMax(root).key;
    }

    private static Node getMax(Node node){
        if (node.right == null){
            return node;
        }
        return getMax(node.right);
    }

    public static void putNode(int key, String value){
        putNode(root, key, value);
    }

    private static Node putNode(Node node, int key, String value){
        if (node == null){
            return new Node(key, value, 1);
        }
        if (node.key < key){
            node.right = putNode(node.right, key, value);
        }
        else if (node.key > key){
            node.left = putNode(node.left, key, value);
        }
        else {
            node.value = value;
        }
        node.total = getSize(node.left) + getSize(node.right) + 1;
        return node;
    }

    public static int floor(int key){
        Node node = floor(root, key);
        if (node == null){
            return -1;
        }
        return node.key;
    }

    private static Node floor(Node node, int key){
        if (node == null){
            return null;
        }
        if (node.key > key){
            return floor(node.left, key);
        }
        if (node.key == key){
            return node;
        }
        Node temp = floor(node.right, key);
        if (temp != null){
            return temp;
        }
        else return node;
    }

    public static int ceiling(int key){
        Node node = ceiling(root, key);
        if (node == null){
            return -1;
        }
        else return node.key;
    }

    private static Node ceiling(Node node, int key){
        if (node == null){
         return null;
        }
        if (node.key < key){
            return ceiling(node.right, key);
        }
        if (node.key == key){
            return node;
        }
        Node temp = ceiling(node.left, key);
        if (temp != null){
            return temp;
        }
        return node;
    }

    public static int select(int target){
        if (select(root, target) == null){
            return -1;
        }
        return select(root, target).key;
    }

    private static Node select(Node node, int target) {
        if (node == null) {
            return null;
        }
        int size = getSize(node.left);
        if (size > target){
            return select(node.left, target);
        }
        else if (size < target){
            return select(node.right, target - 1 - size);
        }
        else return node;
    }

    public static int rank(int key){
        return rank(root, key);
    }

    private static int rank(Node node, int key){
        if (node == null){
            return 0;
        }
        if (node.key > key){
            return rank(node.left, key);
        }
        else if (node.key < key){
            return getSize(node.left) + 1 + rank(node.right, key);
        }
        else return getSize(node.left);
    }

    public static void main(String[] arg){
        root = new Node(0, "", 0);
        for (int i = 0; i < SIZE; i++){
            putNode(i, i + "");
        }
        StdOut.print(getSize()+"\n");
        StdOut.print(select(10));
    }
}
