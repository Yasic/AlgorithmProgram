package GraphTheory;

/**
 * Created by Yasic on 2016/5/2.
 */
public class Queue {
    private Node first;
    private Node last;
    private int N;
    private class Node{
        int item;
        Node next;
    }

    public Queue(){

    }

    public boolean isEmpty(){
        return first == null;
    }

    private int getSize(){
        return N;
    }

    public void enqueue(int item){
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else oldLast.next = last;
        N++;
    }

    public int dequeue(){
        int item = first.item;
        first = first.next;
        if (isEmpty()) last = null;
        N--;
        return item;
    }
}
