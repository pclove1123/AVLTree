public class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    public int height() {
        return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
    }

    public void add(Node node) {
        if (node == null) {
            return;
        }
        if (node.value < this.value) {
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.add(node);
            }
        } else {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        }
        if (leftHeight() - rightHeight() >= 2) {
            //双旋转
            //如果左子树左边的高度小于左子树右边的高度
            if (left != null && left.leftHeight() < left.rightHeight()) {
                left.leftRotate();
                rightRotate();
                //但旋转
            } else {
                rightRotate();
            }

            //
        }
        if (leftHeight() - rightHeight() <= -2) {
            if (right != null && right.rightHeight() < right.leftHeight()) {
                right.rightRotate();
                leftRotate();
            } else {
                leftRotate();
            }

        }

    }

    private void rightRotate() {
        Node node = new Node(value);
        node.right = this.right;
        node.left = this.left.right;
        this.value = left.value;
        this.left = this.left.left;
        this.right = node;
    }

    private void leftRotate() {
        Node node = new Node(value);
        node.left = this.left;
        node.right = this.right.left;
        this.value = right.value;
        this.right = right.right;
        this.left = node;
    }


    public int leftHeight() {
        if (left == null) {
            return 0;
        }
        return left.height();
    }

    public int rightHeight() {
        if (right == null) {
            return 0;
        }
        return right.height();
    }

}
