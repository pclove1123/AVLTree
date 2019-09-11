public class Tree {
    Node root;
    public void add(Node node){
        if(root == null){
            root = node;
        }else {
            root.add(node);
        }
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }
}
