class  Node {
        int data;
        Node right;
        Node left;
        public Node(int data){
            this.data = data;
            this.right = null;
            this.left = null;
        }
    }

public class BinaryTree {
    Node root;
    public BinaryTree(){
        root = null;
    }
    public void append(int data){
        root = insertTreeNode(data, root);
    }
    private Node insertTreeNode(int data , Node temp){
       if(temp == null){
        return new Node(data);
       }
       if(temp.data > data){
            temp.left = insertTreeNode(data, temp.left);
       }
       else if (temp.data < data) {
            temp.right = insertTreeNode(data, temp.right);
       }
       return temp;
    }
    public void delete(int data){
        root = searchAndDelete( data,root);
        if(root == null){
            System.err.println("Tree is successfully deleted");
        }
        else{
            System.out.println("Aftere deletion");
            inorder(root);
        }
        
    }
    private Node searchAndDelete(int data, Node temp){
        if(temp.data == data){
           if(temp.left == null && temp.right == null){
            return null;
           }
           else if (temp.right == null) {
            Node successor = FindSuccessor(temp.left);
            successor.right = temp.right;
            temp.right = temp.left = null;
            return temp = successor;
           }
           else{
            Node predecessor = FindPredecessor(temp.right);
            predecessor.left = temp.left;
            temp.right = temp.left = null;
            return temp = predecessor;
           }
        }
        else if (data > temp.data) {
           temp.right = searchAndDelete(data, temp.right);
        }
        else{
            temp.left = searchAndDelete(data, temp.left);
        }
        return temp;
    }
    private Node FindSuccessor(Node temp){
        while (temp.right != null) {
            temp = temp.right;
        }
        return temp;
    }
    private Node FindPredecessor(Node temp){
        while (temp.left != null) {
            temp = temp.left;
        }
        return temp;
    }
    public void inorderTraverse(){
        inorder(root);
    }
    private void inorder(Node temp){
        if(temp!=null) {
            System.out.println(temp.data);
            // System.out.println(temp.left.data);
            // System.out.println(temp.right.data);
            inorder(temp.left);
            inorder(temp.right);
            return;
        }
    }
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.append(45);
        bt.append(40);
        bt.append(50);
        bt.append(30);
        bt.append(42);
        bt.append(20);
        bt.append(35);
        bt.append(41);
        bt.append(43);
        bt.inorderTraverse();
        bt.delete(30);
 

       
    }
}
