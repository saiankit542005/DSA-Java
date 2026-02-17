package binary_trees.easy;

public class NodeSum {
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

    public static int sumOfNodes(Node root) { // TC = O(n)
        if (root == null) {
            return 0;
        }

        int leftSum = sumOfNodes(root.left);
        int rightSum = sumOfNodes(root.right);

        return leftSum + rightSum + root.data;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println("Total Sum of Nodes : "+sumOfNodes(root));
    }
}

/*

public static int nodesSum(Node root){
    if(root == null){
        return 0;
    }

    int leftSum = nodesSum(root.left);
    int rightSum = nodesSum(root.right);

    return leftSum + rightSum + root.value;
}
🎯 What This Function Does
It returns:

👉 Sum of all node values in the tree

🌳 Example Tree
Let’s use this tree:

        1
       / \
      2   3
     /
    4
   /
  5

Now we call :====>
nodesSum(root);  // root = 1

🧠 Core Logic :=============>

For every node :==>
Sum of tree =
Sum of left subtree
+ Sum of right subtree
+ Current node value
This is called Divide and Conquer.

🔥 Step-by-Step Working (Important)
We start from root (1).

✅ Step 1: nodesSum(1)
It waits for :==>
leftSum = nodesSum(2)
rightSum = nodesSum(3)
✅ Step 2: nodesSum(2)

It waits for :==>
leftSum = nodesSum(4)
rightSum = nodesSum(null)

✅ Step 3: nodesSum(4)
It waits for :==>
leftSum = nodesSum(5)
rightSum = nodesSum(null)

✅ Step 4: nodesSum(5)
It waits for :==>
leftSum = nodesSum(null) → 0
rightSum = nodesSum(null) → 0

So :==>
return 0 + 0 + 5 = 5
Now go back to node 4.

✅ Back to Node 4
We now have :==>
leftSum = 5
rightSum = 0

So :==>
return 5 + 0 + 4 = 9
Now go back to node 2.

✅ Back to Node 2
We now have :==>

leftSum = 9
rightSum = 0

So :==>
return 9 + 0 + 2 = 11
Now go back to node 1.

✅ Now solve Right Subtree
nodesSum(3)
Left → null → 0
Right → null → 0

So :==>
return 0 + 0 + 3 = 3
✅ Final Step (Node 1)
Now we have :==>

leftSum = 11
rightSum = 3

So :==>
return 11 + 3 + 1 = 15

🎯 Final Answer
Total Sum = 15
*/
