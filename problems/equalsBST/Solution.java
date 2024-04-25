import java.util.*;
import java.lang.StringBuilder;

class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BST bst = new BST();
        BST otherBst = new BST();

        String[] nums = sc.nextLine().split("\\s+");
        for (int i = 0; i < nums.length; i++) {
            bst.add(Integer.parseInt(nums[i]));
        }

        String[] numsTwo = sc.nextLine().split("\\s+");
        for (int i = 0; i < numsTwo.length; i++) {
            otherBst.add(Integer.parseInt(numsTwo[i]));
        }

        System.out.println(bst.equals(otherBst));
    }
}

class BST{
    Node root;
    int size;

    public boolean isEmpty(){
        return this.size == 0;
    }

    public void add(int value){
        Node node = new Node(value);

        if (this.isEmpty()){
            this.root = node;
            this.size++;
            return;
        }

        Node aux = this.root;
        while(aux != null){
            if (aux.value > node.value){
                if (aux.left == null){
                    aux.left = node;
                    node.parent = aux;
                    this.size++;
                    return;
                }
                aux = aux.left;
            }
            else{
                if(aux.right == null){
                    aux.right = node;
                    node.parent = aux;
                    this.size++;
                    return;
                }
                aux = aux.right;
            }
        }
    }

    public boolean equals(BST other){
        if(this.isEmpty() && other.isEmpty()) return true;

        if(this.size != other.size) return false;

        Node aux = this.root;
        Node auxOther = other.root;

        return equals(aux, auxOther);
    }

    private boolean equals(Node thisBst, Node otherBst){
        if (thisBst == null && otherBst == null) return true;

        if (thisBst == null || otherBst == null) return false;
        if (thisBst.value != otherBst.value) return false;

        boolean left = equals(thisBst.left, otherBst.left);
        boolean right = equals(thisBst.right, otherBst.right);

        return left && right;
    }
}

class Node{
    int value;
    Node left, right, parent;

    public Node(int value){
        this.value = value;
    }
}
