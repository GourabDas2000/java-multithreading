
public class Linklist{
    private Node head;
    private Node tail;
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public void append(int data){
        Node newnode = new Node(data);
        if(head == null){
           head = newnode;
           tail = newnode;
        }
        else{
             tail.next = newnode;
             tail = tail.next;
        }
    }
    public void traverse(){
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            temp = temp.next;
            if(temp!= null){
                System.out.print(" -> ");
            }
        }
    }
    public static void main(String[] args){
       Linklist l = new Linklist();
       l.append(1);
       l.append(2);
       l.append(3);
       l.traverse();
    }
}
