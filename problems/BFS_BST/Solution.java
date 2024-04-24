import java.util.Arrays;
import java.lang.StringBuilder;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        BST bst = new BST();
        Scanner sc = new Scanner(System.in);
        int[] nums = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        for (int i : nums) {
            bst.add(i);
        }
        
        System.out.println(bst.BFS());
    }
}

class BST {
    Node root;
    int size;

    public boolean isEmpty() {return this.size == 0;}

    public void add(int value) {
        Node node = new Node(value);

        if (this.isEmpty()) {
            this.root = node;
            this.size++;
            return;
        }

        this.size++;
        Node aux = this.root;
        while (aux != null) {
            if (aux.value > value) {
                if (aux.left == null) {
                    aux.left = node;
                    return;
                }
                aux = aux.left;
            } else {
                if (aux.right == null) {
                    aux.right = node;
                    return;
                }
                aux = aux.right;
            }
        }
    }

    public String BFS(){
        if(this.isEmpty()) return "";

        Queue<Node> q = new LinkedList<>();
        q.add(this.root);
        StringBuilder out = new StringBuilder();

        while (!(q.isEmpty())) {
            Node node = q.poll();
            out.append(node.value).append(" ");

            if (node.left != null) {
                q.add(node.left);
            }
            if (node.right != null) {
                q.add(node.right);
            }
        }

        return out.toString().trim();
    }
}

class Node {
    int value;
    Node left, right;

    public Node(int value) {
        this.value = value;
    }
}
