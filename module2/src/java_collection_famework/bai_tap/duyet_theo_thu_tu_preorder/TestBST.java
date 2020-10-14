package java_collection_famework.bai_tap.duyet_theo_thu_tu_preorder;

public class TestBST {
    public static void main(String[] args) {
        //create a BST
        BST<Integer> tree = new BST<>();
        tree.insert(60);
        tree.insert(55);
        tree.insert(45);
        tree.insert(57);
        tree.insert(59);
        tree.insert(100);
        tree.insert(67);
        tree.insert(107);
        tree.insert(101);
        //traverse tree
        System.out.println("Inorder (sorted): ");
        tree.preOrder();
        System.out.println("The number of nodes is: " + tree.getSize());
    }
}
