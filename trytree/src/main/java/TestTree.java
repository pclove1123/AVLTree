public class TestTree {
    public static void main(String[] args) {
        int[] arr = new int[]{8,9,5,6,4,7};
        Tree tree = new Tree();
        for(int i : arr){
            tree.add(new Node(i));
        }

        System.out.println(tree.root.height());
        System.out.println(tree.root.value);
    }
}
