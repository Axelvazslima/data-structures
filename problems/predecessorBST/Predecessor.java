import java.util.*;
import java.lang.StringBuilder;

public class Predecessor{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BST bst = new BST();

        String[] nums = sc.nextLine().split("\\s+");
        for (int i = 0; i < nums.length; i++) {
            bst.add(Integer.parseInt(nums[i]));
        }
        System.out.println(bst.predecessor(Integer.parseInt(sc.nextLine())));
    }
}


class BST{
    Node root;

    public void add(int v){
        Node aux = this.root;
        Node newNode = new Node(v);

        if(this.root == null){
            this.root = newNode;
        }

        while(aux != null){
            if(aux.value < v){
                if (aux.right == null){
                    aux.right = newNode;
                    newNode.parent = aux;
                    return;
                }
                aux = aux.right;
            } else {
                if (aux.left == null){
                    aux.left = newNode;
                    newNode.parent = aux;
                    return;
                }
                aux = aux.left;
            }
        }
        aux = newNode;
    }

    public String predecessor(int v){
        Node node = this.search(v);
        
        StringBuilder out = new StringBuilder("[");
        Node aux = node;
        if (node != null && node.left != null){
            out.append(aux.value).append(", ");
            aux = node.left;
            while(aux != null){
                out.append(aux.value);
                aux = aux.right;
                if(aux != null) out.append(", ");
            }
        } else {
            while(aux != null){
                out.append(aux.value);
                if(aux.value < v){
                    break;
                }
                out.append(", ");
                aux = aux.parent;
            }
        }

        out.append("]");
        return out.toString();
    }

    private Node search(int v){
        Node node = this.root;
        
        while (node != null){
            if(node.value == v) return node;
            if(node.value > v) node = node.left;
            else node = node.right;
        }
        return node;
    }
}


class Node{
    int value;
    Node left;
    Node right;
    Node parent;

    public Node(int v){
        this.value = v;
    }
}
