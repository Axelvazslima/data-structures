class BST{
    Node root;
    int size;

    public void add(int value){
        Node node = new Node(value);

        if (this.isEmpty()) {
            this.size++;
            this.root = node;
        }

        this.size++;
        Node aux = this.root;
        while(aux != null){
            if (aux.value > node.value) {
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

    public boolean isEmpty(){
        return this.size == 0;
    }

    public void remove(Node node){
        if (this.isEmpty()) return;

        this.size--;

        if (node.isLeaf()) {
            if (node.value == this.root.value) {
                this.root = null;
            } else {
                if (node.value > node.parent.value) {
                    node.parent.right = null;   
                } else {
                    node.parent.left = null;
                }
            }  
        }

        else if (node.hasOnlyLeft()) {
            if (node.value == this.root.value) {
                this.root = node.left;
                this.root.parent = null;
            } else {
                node.left.parent = node.parent;
                if (node.value > node.parent.value) {
                    node.parent.right = node.left;
                } else {
                    node.parent.left = node.left;
                }
            }
        }
        
        else if (node.hasOnlyRight()){
            if (node.value == this.root.value) {
                this.root = node.right;
                this.root.parent = null;
            } else {
                node.right.parent = node.parent;
                if (node.value > node.parent.value) {
                    node.parent.right = node.right;
                } else {
                    node.parent.left = node.right;
                }
            }   
        } else {
            Node sucessor = this.sucessor(node);
            node.value = sucessor.value;
            this.remove(sucessor);
        }
    }

    public Node sucessor(Node node){
        if (this.isEmpty()) return null;

        if (node.right != null) {
            return this.min(node.right);
        }
        
        Node aux = node;
        while (node.parent != null) {
            if (aux.value > node.value) return aux;
            aux = aux.parent;
        }
        return null;
    }

    public Node min(Node node){
        Node aux = node;
        while (aux.left != null) {
            aux = aux.left;
        }
        return aux;
    }

    public Node search(int value){
        if (this.isEmpty()) return null;

        Node aux = this.root;
        while (aux != null) {
            if (aux.value == value) return aux;
            else if (aux.value > value) {
                aux = aux.left;
            } else {
                aux = aux.right;
            }
        }
        return null;
    }

    public int countLeaves(){
        if (this.isEmpty()) return 0;

        return this.countLeaves(this.root);
    }

    public int countLeaves(Node node){
        if (node == null) return 0;
        if (node.isLeaf()) return 1;
        return this.countLeaves(node.left) + this.countLeaves(node.right);
    }

    public int countInnerNodes(){
        if (this.isEmpty()) return 0;

        return this.countInnerNodes(this.root);
    }

    public int countInnerNodes(Node node){
        if (node == null) return 0;
        if (node.isLeaf()) return 0;
        return 1 + this.countInnerNodes(node.left) + this.countInnerNodes(node.right);
    }

    public int countNodesWithOnlyOneChild(){
        if (this.isEmpty()) return 0;

        return this.countNodesWithOnlyOneChild(this.root);
    }

    public int countNodesWithOnlyOneChild(Node node){
        if (node == null) return 0;
        if (node.hasOnlyLeft()) return 1 + this.countNodesWithOnlyOneChild(node.left);
        if (node.hasOnlyRight()) return 1 + this.countNodesWithOnlyOneChild(node.right);

        return this.countNodesWithOnlyOneChild(node.left) + this.countNodesWithOnlyOneChild(node.right);
    }

    public int countFullNodes(){
        if (this.isEmpty()) return 0;

        return this.countFullNodes(this.root);
    }

    public int countFullNodes(Node node){
        if (node == null) return 0;
        
        if (node.isFull()) return 1 + this.countFullNodes(node.left) + this.countFullNodes(node.right);

        return this.countFullNodes(node.left) + this.countFullNodes(node.right);
    }
}

class Node{
    int value;
    Node left, right, parent;

    public Node(int value){
        this.value = value;
    }

    public boolean isLeaf(){
        return this.left == null && this.right == null;
    }

    public boolean hasOnlyLeft(){
        return this.left != null && this.right == null;
    }

    public boolean hasOnlyRight(){
        return this.right != null && this.left == null;
    }

    public boolean isFull(){
        return this.right != null && this.left != null;
    }
}