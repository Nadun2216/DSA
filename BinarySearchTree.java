class Node {
    int key;
    Node left, right;

    Node(int item) {
        key = item;
        left = null;
        right = null;
    }
}

public class BinarySearchTree {

    Node root;

    void insert(int key) {
        root = insertRec(root, key);
    }

    Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.key) {
            root.left = insertRec(root.left, key);
        } else if (key > root.key) {
            root.right = insertRec(root.right, key);
        }

        return root;
    }

    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.key + " ");
            inorder(root.right);
        }
    }

    boolean search(Node root, int key) {
        if (root == null)
            return false;

        if (root.key == key)
            return true;

        if (key < root.key)
            return search(root.left, key);
        else
            return search(root.right, key);
    }

    public static void main(String[] args) {

        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);
        tree.insert(60);
        tree.insert(80);

        System.out.println("Inorder Traversal:");
        tree.inorder(tree.root);

        System.out.println();

        System.out.println("Search 40: " + tree.search(tree.root, 40));
        System.out.println("Search 100: " + tree.search(tree.root, 100));
    }
}