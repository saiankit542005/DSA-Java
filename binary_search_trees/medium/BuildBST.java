package binary_search_trees.medium;

public class BuildBST {
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    public TreeNode insert(TreeNode root, int value) {
        if (root == null) {
            root = new TreeNode(value);
            return root;
        }
        if (root.data > value) {
            // left subtree
            root.left = insert(root.left, value);
        } else {
            // rigth subtree
            root.right = insert(root.right, value);
        }

        return root;
    }

    public void inorder(TreeNode root) {
        if (root == null)
            return;

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // =============== searchKey() method ===============
    public boolean searchKey(TreeNode root, int key) {
        if (root == null)
            return false;

        if (root.data == key)
            return true;

        if (root.data > key) {
            // left subtree
            return searchKey(root.left, key);
        } else {
            // right subtree
            return searchKey(root.right, key);
        }
    }

    public static void main(String[] args) {
        // int values[] = { 5, 1, 3, 4, 2, 7 };
        int values[] = { 2, 3, 5, 7, 8, 1, 6, 4, 9 };
        TreeNode root = null;

        BuildBST obj = new BuildBST();

        for (int i = 0; i < values.length; i++) {
            root = obj.insert(root, values[i]);
        }

        // In BST, inorder traversal give sorted order of the tree.
        System.out.println("==== Inorder Traversal ====");
        obj.inorder(root);
        System.out.println();

        System.out.println("====== searchKey() =====");
        if (obj.searchKey(root, 9)) {
            System.out.println("Key found!");
        } else {
            System.out.println("Key Not found!");
        }

    }
}