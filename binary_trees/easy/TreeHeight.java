package binary_trees.easy;

public class TreeHeight {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.right = null;
            this.left = null;
        }
    }

    public static int height(Node root) { // TC = O(n)
        if (root == null) {
            return 0;
        }

        int lh = height(root.left);
        int rh = height(root.right);

        return Math.max(lh, rh) + 1;
    }

    public static int sumOfNodes(Node root) { // TC = O(n)
        if (root == null) {
            return 0;
        }

       int leftSum =  sumOfNodes(root.left);
       int rightSum =  sumOfNodes(root.right);

        return leftSum  + rightSum + root.data;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println("heigth : " + height(root));
        System.out.println(sumOfNodes(root));
    }
}
